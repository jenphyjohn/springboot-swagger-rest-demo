create table Goods (
  GoodsId 			varchar(32) 		not null,
  GoodsCode 		varchar(128)     default '',
  GoodsName 		varchar(256) 	default '',
  GoodsType 		int(4) 			default 0,
  Disabled			char(1) 		default '0',
  CreateTime 	    datetime,
  primary key (GoodsId)
) engine=innodb auto_increment=200 default charset=utf8;