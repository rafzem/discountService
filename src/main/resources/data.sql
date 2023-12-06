insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, '0c457dae-f96f-4641-a0a0-6b33c23beacd', 'Buty',100);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, 'be9f7d7e-fb9b-40af-b7fd-b994af874313', 'Kurtki',45.5);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, '63a77866-9218-4341-be80-529ebb9622af', 'Samochod',120.5);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, '1dfbeace-f03e-4b34-85af-9794e2947b07', 'Choinka',50);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, '32e864d6-65a7-4a27-9a06-d0ac878ec99f', 'Bombka',5);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, '7d54c0dd-a3be-428c-9d65-b90ad774dc9f', 'Mikołaj',125);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, 'cc2bb3b4-671d-40ee-afeb-c744fe7283a2', 'Renifer',75.2);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, '09738d3d-fa5b-4c5c-b7a2-d1a109d65157', 'Skrzat',25.3);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, '97c9d617-6d32-4b9a-a76a-cb1d2f2f6c10', 'Cukierki',3);
insert into PRODUCT(id,uuid,name,base_price) values( NEXT VALUE FOR PRODUCT_SEQ, 'f746a36f-09d3-49b9-a392-8dc29ade3f97', 'Czekolada',7);

insert into DISCOUNT_GROUP(id,name) values (NEXT VALUE FOR DISCOUNT_GROUP_SEQ, 'Odzież');
insert into DISCOUNT_GROUP(id,name) values (NEXT VALUE FOR DISCOUNT_GROUP_SEQ, 'Produkty Świąteczne');
insert into DISCOUNT_GROUP(id,name) values (NEXT VALUE FOR DISCOUNT_GROUP_SEQ, 'Słodycze');
insert into DISCOUNT_GROUP(id,name) values (NEXT VALUE FOR DISCOUNT_GROUP_SEQ, 'Pojazdy mechaniczne');

insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 1,1);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 2,1);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 3,4);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 4,2);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 5,2);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 6,2);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 7,2);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 8,2);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 9,3);
insert into PRODUCT_DISCOUNT_GROUP_ASSOCIATION (id, product_id,discount_group_id) values (NEXT VALUE FOR PRODUCT_DISCOUNT_GROUP_ASSOCIATION_SEQ, 10,3);


insert into DISCOUNT( id,discount_group_id,type,discount_value) values(NEXT VALUE FOR DISCOUNT_SEQ,4,'percentage',5);
