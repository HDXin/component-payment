drop table if exists t_config;

/*==============================================================*/
/* Table: t_config                                              */
/*==============================================================*/
create table t_config
(
   id                   bigint(20) not null auto_increment comment '主键',
   project_name         varchar(60) comment '项目名称',
   payment_type         varchar(30) comment '支付类型',
   content              varchar(3000) comment '支付配置拓展字段',
   appid                varchar(60) comment 'appid',
   appsecret            varchar(100) comment 'appsecret',
   mch_id               varchar(30) comment '商户号',
   notify_url           varchar(300) comment '回调地址',
   trade_type           varchar(30) comment '支付方式',
   payment_key          varchar(300) comment '支付密钥',
   token                varchar(300) comment 'token',
   primary key (id)
);
alter table t_config comment '支付配置';
