drop table Comment;
drop table Imgs;
drop table Review;
drop table Restaurant;
drop table Users;

create table Users(
    username varchar (20),
    password varchar (30),
    firstName varchar(20),
    lastName varchar(50),
    Primary Key(username)
);
create table Restaurant(
    res_id numeric(10),
    username varchar (20),
    resName varchar (200),
    resType varchar(50),
    resAdd varchar(100),
    road varchar(50),
    province varchar(30),
    resTel varchar(50),
    resTime varchar(12), 
    Primary key(res_id),
    Foreign Key (username) References Users(username)   
);
create table Review(
    review_id numeric (10),
    username varchar (20),
    res_id numeric(10),
    topicReview varchar(100),
    contentReview varchar (500),
    taste numeric (1),
    clean numeric (1),
    service numeric (1),
    look numeric (1),
    worth numeric (1),
    reviewDate date,
--      reviewDate varchar(10),
    Primary Key (review_id),
    Foreign Key (res_id) References Restaurant(res_id),
    Foreign Key (username) References Users(username)
);

create table Imgs(
    img_id numeric (10),
    imgUrl varchar (200),    
    review_id numeric (10),
    Primary Key (img_id),
    Foreign Key (review_id) References Review(review_id)
);
create table Comment(
    comment_id numeric (10),
    contentComm varchar (500),
    username varchar (20),
    review_id numeric(10),
    Primary Key (comment_id),
    Foreign Key (username) References Users(username),
    Foreign Key (review_id) References Review(review_id)
);

INSERT INTO Users(username,password,firstName,lastName) VALUES ('tanapat128','admin','Tanapat','Choochot');
INSERT INTO Users(username,password,firstName,lastName) VALUES ('nattakit126','admin','Nattakit','Sriyod');
INSERT INTO Users(username,password,firstName,lastName) VALUES ('songwit141','admin','Songwit','Buddee');

-- res_id numeric(10),
--     username varchar (20),
--     resName varchar (200),
--     resType varchar(50),
--     resAdd varchar(100),
--     road varchar(50),
--     province varchar(30),
--     resTel varchar(50),
--     resTime varchar(12), 
-- Review.reviewRes(reId,user,resId,top,con,taste,clean,service,look,worth);
INSERT INTO Restaurant VALUES (1,'tanapat128','เจ๊จิ๋ม','ตามสั่ง','ข้างมหาลัยเทคโนฯ','พุทธบูชา','กรุงเทพฯ','088-451-5663','8.00 - 19.00');			
INSERT INTO Restaurant VALUES (2,'tanapat128','Bar-B-Q Plaza','บุฟเฟ่ต์','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4227','11:00-21:00');			
INSERT INTO Restaurant VALUES (3,'songwit141','Shabushi','บุฟเฟ่ต์','Central Rama II','พระราม 2','กรุงเทพฯ','02-8724483','11:00-21:00');			
INSERT INTO Restaurant VALUES (4,'songwit141','Signature Steak Loft','ภัตตาคาร','Central Rama II','พระราม 2','กรุงเทพฯ','095-208-0135','11:00-21:00');			
INSERT INTO Restaurant VALUES (5,'songwit141','Farm Design','เบเกอรี','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4512','11:00-21:00');			
INSERT INTO Restaurant VALUES (6,'songwit141','Amor','เบเกอรี','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4144','11:00-21:00');			
INSERT INTO Restaurant VALUES (7,'songwit141','ZEN','ภัตตาคาร','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4188','11:00-21:00');			
INSERT INTO Restaurant VALUES (8,'songwit141','Bonchon','ภัตตาคาร','Central Rama II','พระราม 2','กรุงเทพฯ','02-416-9668','11:00-21:00');			
INSERT INTO Restaurant VALUES (9,'songwit141','Sushi Boy','ภัตตาคาร','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4119','11:00-21:00');			
INSERT INTO Restaurant VALUES (10,'songwit141','S&P','ภัตตาคาร','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4343','11:00-21:00');			
INSERT INTO Restaurant VALUES (11,'songwit141','Starbucks','กาแฟ/ชา','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4271','11:00-21:00');			
INSERT INTO Restaurant VALUES (12,'songwit141','Cold Stone Creamery','ขนมหวาน','Central Rama II','พระราม 2','กรุงเทพฯ','082-548-0028','11:00-21:00');			
INSERT INTO Restaurant VALUES (13,'nattakit126','Santa fe Steak House','ภัตตาคาร','Central Rama II','พระราม 2','กรุงเทพฯ','02 872 4428','11:00-21:00');			
INSERT INTO Restaurant VALUES (14,'nattakit126','ขนมจีนบางกอก','ภัตตาคาร','Central Rama II','พระราม 2','กรุงเทพฯ','02 872 4139','11:00-21:00');			
INSERT INTO Restaurant VALUES (15,'nattakit126','Mr.Bun','เบเกอรี','Central Rama II','พระราม 2','กรุงเทพฯ','02-834-6000','11:00-21:00');			
INSERT INTO Restaurant VALUES (16,'nattakit126','AKA','บุฟเฟ่ต์','Central Rama II','พระราม 2','กรุงเทพฯ','02-673-5597','11:00-21:00');			
INSERT INTO Restaurant VALUES (17,'nattakit126','Hot Pot Buffet','บุฟเฟ่ต์','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4138','11:00-21:00');			
INSERT INTO Restaurant VALUES (18,'nattakit126','MK Restaurant','บุฟเฟ่ต์','Central Rama II','พระราม 2','กรุงเทพฯ','02-872-4138','11:00-21:00');			
INSERT INTO Restaurant VALUES (19,'nattakit126','Daidomon','บุฟเฟ่ต์','Central Rama II','พระราม 2','กรุงเทพฯ','02 872 4138','11:00-21:00');			
INSERT INTO Restaurant VALUES (20,'nattakit126','Tenjo Sushi & Yakiniku','บุฟเฟ่ต์','The Bright Rama II','พระราม 2','กรุงเทพฯ','02-007-5366','11:00-21:00');			


INSERT INTO Review VALUES (1,'tanapat128',1,'Not Bad','I think it''s so dilicious',5,4,4,3,2,'2014-08-01');