DROP TABLE IF EXISTS products;
CREATE TABLE products
(
    id                int          NOT NULL AUTO_INCREMENT COMMENT '상품번호',
    name              varchar(200) NOT NULL COMMENT '상품명',
    min_contract_term int          NOT NULL COMMENT '최소 계약 기간',
    max_contract_term int          NOT NULL COMMENT '최대 계약 기간',
    created_at        datetime DEFAULT NULL COMMENT '생성일',
    updated_at        datetime DEFAULT NULL COMMENT '수정일',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS guarantees;
CREATE TABLE guarantees
(
    id               int          NOT NULL AUTO_INCREMENT COMMENT '담보번호',
    product_no       int          NOT NULL COMMENT '상품번호',
    name             varchar(200) NOT NULL COMMENT '담보명',
    guarantee_amount int          NOT NULL COMMENT '가입금액',
    base_amount      int          NOT NULL COMMENT '기준금액',
    created_at       datetime DEFAULT NULL COMMENT '생성일',
    updated_at       datetime DEFAULT NULL COMMENT '수정일',
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS contracts;
create table contracts
(
    no              int            NOT NULL AUTO_INCREMENT COMMENT '계약번호',
    product_no      int            NOT NULL COMMENT '상품번호',
    product_name    varchar(200)   NOT NULL COMMENT '상품명',
    contract_term   int            NOT NULL COMMENT '계약기간',
    started_at      datetime       NOT NULL COMMENT '보험 시작일',
    ended_at        datetime       NOT NULL COMMENT '보험 종료일',
    contract_amount decimal(15, 2) NOT NULL COMMENT '총 보험료',
    status          int            NOT NULL DEFAULT 0 COMMENT '계약 상태',
    created_at      datetime                DEFAULT NULL COMMENT '생성일',
    updated_at      datetime                DEFAULT NULL COMMENT '수정일',
    PRIMARY KEY (no)
);

DROP TABLE IF EXISTS contract_items;
CREATE TABLE contract_items
(
    id               int          NOT NULL AUTO_INCREMENT COMMENT '계약아이템 번호',
    contract_no      int          NOT NULL COMMENT '계약번호',
    product_no       int          NOT NULL COMMENT '상품번호',
    guarantee_no     int          NOT NULL COMMENT '담보번호',
    guarantee_name   varchar(200) NOT NULL COMMENT '담보명',
    guarantee_amount int          NOT NULL COMMENT '가입금액',
    base_amount      int          NOT NULL COMMENT '기준금액',
    created_at       datetime DEFAULT NULL COMMENT '생성일',
    updated_at       datetime DEFAULT NULL COMMENT '수정일',
    PRIMARY KEY (id)
);
