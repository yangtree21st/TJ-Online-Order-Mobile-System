create table `product_info` (
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment 'product name',
    `product_price` decimal(8,2) not null comment 'unit price',
    `product_stock` int not null comment 'product stock',
    `product_description` varchar(64)  comment 'product description',
    `product_icon` varchar(512) comment 'product pics',
    `category_type` int not null comment 'product category number',
    `create_time` timestamp not null default current_timestamp comment 'create time',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment 'update time',
    primary key (`product_id`)

) comment'product info';

create table `product_category` (
    `category_id` int not null auto_increment,
    `category_name` varchar(64) not null comment 'category name',
    `category_type` int not null comment 'category type',
    `create_time` timestamp not null default current_timestamp comment 'creat time',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment 'update time',
    primary key (`category_id`),
    UNIQUE KEY `uqe_category_type` (`category_type`)
);


create table `order_master` (
    `order_id` varchar(32) not null,
    `buyer_name` varchar(32) not null comment 'buyer name',
    `buyer_phone` varchar(32) not null comment 'buyer phone number',
    `buyer_address` varchar(128) not null comment 'address of buyer',
    `buyer_openid` varchar(64) not null comment 'buyer wechat openid',
    `order_amount` decimal(8,2) not null comment 'amount of order price',
    `order_status` tinyint(3) not null default '0' comment 'order status, default is new order',
    `pay_status` tinyint(3) not null default '0' comment 'order status, default is not paid',
    `create_time` timestamp not null default current_timestamp comment 'creat time',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment 'update time',
    primary key (`order_id`),
    key `idx_buyer_openid` (`buyer_openid`)
);

create table `order_detail` (
    `detail_id` varchar(32) not null,
    `order_id` varchar(32) not null,
    `product_id` varchar(32) not null,
    `product_name` varchar(64) not null comment 'product_name',
    `product_price` decimal(8,2) not null comment 'product_price, the cents',
    `product_quantity` int not null comment 'product_quantity',
    `product_icon` varchar(512) comment 'product_icon',
    `create_time` timestamp not null default current_timestamp comment 'create_time',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment 'update_time',
    primary key (`detail_id`),
    key `idx_order_id` (`order_id`)
);

create table `seller_info` (
    `seller_id` varchar(32) not null,
    `username` varchar(32) not null,
    `password` varchar(32) not null,
    `openid` varchar(64) not null comment 'Wechat openid',
    `create_time` timestamp not null default current_timestamp comment 'create_time',
    `update_time` timestamp not null default current_timestamp on update current_timestamp comment 'update_time',
    primary key (`seller_id`)
) comment 'seller Information';



