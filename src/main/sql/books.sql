create table books(
  Id varchar(32) not null,
  Name varchar(32) default '',
  Price int(4) default '0',
  Category varchar(32) default '',
  primary key (id)
)engine=innodb auto_increment=200 default charset=utf8;