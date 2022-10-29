CREATE TABLE `payment_card`
(
    `idx`            bigint(20) NOT NULL,
    `card_company`   varchar(255) NOT NULL,
    `card_number`    varchar(255) NOT NULL,
    `created_at`     datetime     NOT NULL,
    `payment_amount` bigint(20) NOT NULL,
    `payment_date`   datetime     NOT NULL,
    `store_name`     varchar(255) NOT NULL,
    `user`           varchar(255) NOT NULL,
    PRIMARY KEY (`idx`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;