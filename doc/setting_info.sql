drop table if exists setting_info;
/*==============================================================*/
/* Table: setting_info                                          */
/*==============================================================*/
create table setting_info
(
   id                   bigint(20) not null auto_increment,
   pay_notify_url       varchar(30),
   refund_notify_url    varchar(30),
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
alter table setting_info comment '系统配置';