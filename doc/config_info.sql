drop table if exists config_info;
/*==============================================================*/
/* Table: config_info                                           */
/*==============================================================*/
create table config_info
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
   display_order        int(11) default 0 comment '顺序号',
   version              int(11) default 0 comment '版本号',
   deleted              int(11) default 1 comment '状态',
   create_user_id       bigint(20) comment '创建人',
   create_user_name     varchar(30) comment '创建人姓名',
   create_time          datetime comment '创建时间',
   update_user_id       bigint(20) comment '修改人',
   update_user_name     varchar(30) comment '更新人姓名',
   update_time          datetime comment '修改时间',
   last_update          timestamp comment '最后更新时间',
   primary key (id)
);
alter table config_info comment '支付配置';