create table restoraunt_info(id serial,
	                         r_name varchar(200) not null,
							 delivery char(1) not null,
							 link_to_site varchar(200),
							 count_of_employers int,
							 alco char(1),
							 summer_platform char(1),
							 time_of_work varchar(20),
							 CONSTRAINT pk PRIMARY KEY (id))							)

insert into restoraunt_info(r_name,delivery,link_to_site,count_of_employers,
							 alco,summer_platform ,time_of_work)
values('Весёлый бородач','y','http://borodach.com',30,'y','y','8.00-20.00')


create table menu(id serial,
				   id_restoraunt int not null references restoraunt_info(id),
				    m_name varchar(150) not null,
				    m_price numeric(15,2) not null,
				    weight numeric(15,2),
				    time_of_cooking numeric(15,2)
				  )


insert into menu(id_restoraunt,
				  m_name,
				  m_price,
				  weight,
				  time_of_cooking)
values(1,'Пиво светлое',40,0.5,2),
      (1,'Пиво тёмное',40,0.5,2),
      (1,'Стейк',150,1,10)
				 
update menu
   set m_price = 70
 where id = 2 

delete from menu where id = 1

select * from restoraunt_info 							 
select * from menu

select t1.r_name,
       t2.*
  from restoraunt_info as t1
  join menu as t2 on t2.id_restoraunt = t1.id
