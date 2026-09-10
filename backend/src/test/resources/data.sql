-- Add data so the database has something to test against

-- 1st: Users
INSERT INTO `users` VALUES ('admin','$2a$10$tBTfzHzjmQVKza3VSa5lsOX6/iL93xPVLlLXYg2FhT6a.jb1o6VDq'),('user 1','$2a$10$tBTfzHzjmQVKza3VSa5lsOX6/iL93xPVLlLXYg2FhT6a.jb1o6VDq'),('user 2','$2a$10$tBTfzHzjmQVKza3VSa5lsOX6/iL93xPVLlLXYg2FhT6a.jb1o6VDq');

-- 2nd: Roles
INSERT INTO `roles` VALUES ('admin','ADMIN');

-- 3rd: Vehicles
INTO `vehicles` VALUES (1,'user 1','Honda','Civic',2018,0),(2,'user 1','Ford','F-150',2021,1),(3,'user 2','BMW','Classy',2026,0),(4,'user 2','Ferarri','F-1550',2021,1),(5,'user 1','Chevrolet','Impala',1978,0),(6,'user 2','GMC','Acadia',2016,1);

-- 4th: Service Records
INSERT INTO `service_records` VALUES (1,1,'Synthetic Oil Change','Jiffy Lube','Replaced engine oil and oil filter fluid checks completed.',45.00,62500,'2026-01-15',0),(2,1,'Front Brake Job','Brake Masters','Replaced front pads and turned rotors.',185.50,64200,'2026-04-20',0),(3,2,'Spark Plug Ingestion','Independent Repair','Routine engine tune up replacement.',120.00,NULL,'2026-06-10',1),(4,3,'Front Brake Job','Brake Masters','Replaced front pads and turned rotors.',185.50,64200,'2026-04-20',0),(5,4,'Spark Plug Ingestion','Independent Repair','Routine engine tune up replacement.',120.00,NULL,'2026-06-10',1),(6,5,'Synthetic Oil Change','Jiffy Lube','Replaced engine oil and oil filter fluid checks completed.',45.00,62500,'2026-01-15',0),(7,5,'Front Brake Job','Brake Masters','Replaced front pads and turned rotors.',185.50,64200,'2026-04-20',0),(8,6,'Spark Plug Ingestion','Independent Repair','Routine engine tune up replacement.',120.00,NULL,'2026-06-10',1);
