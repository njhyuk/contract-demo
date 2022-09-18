INSERT INTO "PRODUCTS"
SET `NAME`              = '여행자 보험',
    `MIN_CONTRACT_TERM` = 1,
    `MAX_CONTRACT_TERM` = 3,
    `CREATED_AT`        = NOW();

INSERT INTO "GUARANTEES"
SET `PRODUCT_NO`       = 1,
    `NAME`             = '상해치료비',
    `GUARANTEE_AMOUNT` = 1000000,
    `BASE_AMOUNT`      = 100,
    `CREATED_AT`       = NOW();

INSERT INTO "GUARANTEES"
SET `PRODUCT_NO`       = 1,
    `NAME`             = '항공기 지연도착 시 보상금',
    `GUARANTEE_AMOUNT` = 500000,
    `BASE_AMOUNT`      = 100,
    `CREATED_AT`       = NOW();

INSERT INTO "PRODUCTS"
SET `NAME`              = '휴대폰 보험',
    `MIN_CONTRACT_TERM` = 1,
    `MAX_CONTRACT_TERM` = 12,
    `CREATED_AT`        = NOW();

INSERT INTO "GUARANTEES"
SET `PRODUCT_NO`       = 2,
    `NAME`             = '부분손실',
    `GUARANTEE_AMOUNT` = 750000,
    `BASE_AMOUNT`      = 38,
    `CREATED_AT`       = NOW();

INSERT INTO "GUARANTEES"
SET `PRODUCT_NO`       = 2,
    `NAME`             = '전체손실',
    `GUARANTEE_AMOUNT` = 1570000,
    `BASE_AMOUNT`      = 40,
    `CREATED_AT`       = NOW();

INSERT INTO "CONTRACTS"
SET `NO`   = 1,
    `PRODUCT_NO`= 1,
    `PRODUCT_NAME`= '항공기 지연도착 시 보상금',
    `CONTRACT_TERM`= 11,
    `STARTED_AT`= '2022-02-13 00:00:00',
    `ENDED_AT`= '2022-03-13 00:00:00',
    `CONTRACT_AMOUNT`= 100,
    `STATUS`= 0,
    `CREATED_AT`= '2022-02-13 00:00:00',
    `UPDATED_AT`= '2022-02-13 00:00:00';

INSERT INTO "CONTRACT_ITEMS"
SET `ID` = 1,
 `CONTRACT_NO`= 100,
 `PRODUCT_NO`= 1,
 `GUARANTEE_NO`= 1,
 `GUARANTEE_NAME`= '항공기 지연도착 시 보상금',
 `GUARANTEE_AMOUNT`= 500000,
 `BASE_AMOUNT`= 100,
 `CREATED_AT`= '2022-02-13 00:00:00',
 `UPDATED_AT`= '2022-02-13 00:00:00';
