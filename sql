
drop table restoraunt_info
drop table menu

create table restoraunt_info(id serial,
	                         name varchar(200) not null,
				 has_delivery boolean not null,
				 link_to_site varchar(200),
				 count_of_employers int,
				 is_alcohol_allowed boolean,
				 has_summer_platform boolean,
				 time_of_work varchar(20),
				 CONSTRAINT pk PRIMARY KEY (id))							)

insert into restoraunt_info(name,has_delivery,link_to_site,count_of_employers,
							 is_alcohol_allowed,has_summer_platform ,time_of_work)
values('Весёлый бородач',true,'http://borodach.com',30,true,true,'8.00-20.00')


create table menu(id serial,
		 id_restoraunt int not null references restoraunt_info(id),
		 name varchar(150) not null,
		 price numeric(15,2) not null,
		 weight numeric(15,2),
		 time_of_cooking numeric(15,2))


insert into menu(id_restoraunt,
		 name,
		 price,
		 weight,
		 time_of_cooking)
values(1,'Пиво светлое',40,0.5,2),
      (1,'Пиво тёмное',40,0.5,2),
      (1,'Стейк',150,1,10)
				 
update menu
   set price = 70
 where id = 2 

delete from menu where id = 1

select * from restoraunt_info 							 
select * from menu

select t1.name,
       t2.*
  from restoraunt_info as t1
  join menu as t2 on t2.id_restoraunt = t1.id
