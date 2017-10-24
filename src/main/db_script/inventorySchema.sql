 
 -- SQL Schema For Inventory -- 
 
CREATE TABLE `Country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Country_Name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

CREATE TABLE `Office` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Contact_No` varchar(255) DEFAULT NULL,
  `Location` varchar(255) NOT NULL,
  `Office_Name` varchar(255) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_2pd9jncipp5hu9rdbprnorgex` (`country_id`),
  CONSTRAINT `FK_2pd9jncipp5hu9rdbprnorgex` FOREIGN KEY (`country_id`) REFERENCES `Country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

CREATE TABLE `Warehouse` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Avl_Qty` int(11) DEFAULT NULL,
  `Contact_No` varchar(255) DEFAULT NULL,
  `In_Transit` int(11) DEFAULT NULL,
  `Location` varchar(255) NOT NULL,
  `MOQ` int(11) DEFAULT NULL,
  `QPB` int(11) DEFAULT NULL,
  `Re_Order_Point` int(11) DEFAULT NULL,
  `Warehouse_Name` varchar(255) NOT NULL,
  `country_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_fs43orhnxebqyu3covatieiap` (`country_id`),
  CONSTRAINT `FK_fs43orhnxebqyu3covatieiap` FOREIGN KEY (`country_id`) REFERENCES `Country` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `Office_Warehouse` (
  `Office_id` int(11) NOT NULL,
  `Warehouse_id` int(11) NOT NULL,
  KEY `FK_f8ta6ifot9015kxshj6dymfsg` (`Warehouse_id`),
  KEY `FK_hahm8q2j7ltf3slof99v640rw` (`Office_id`),
  CONSTRAINT `FK_f8ta6ifot9015kxshj6dymfsg` FOREIGN KEY (`Warehouse_id`) REFERENCES `Warehouse` (`id`),
  CONSTRAINT `FK_hahm8q2j7ltf3slof99v640rw` FOREIGN KEY (`Office_id`) REFERENCES `Office` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `Product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Brand` varchar(255) NOT NULL,
  `In_Stock` int(11) DEFAULT NULL,
  `Product_Name` varchar(255) NOT NULL,
  `Product_Type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `Size` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Product_Size` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

 CREATE TABLE `product_size` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `product_id` int(11) NOT NULL,
   `size_id` int(11) NOT NULL,
   `in_stock` int(11) DEFAULT NULL,
   `Avail_Qty` int(11) DEFAULT NULL,
   `In_Transit` int(11) DEFAULT NULL,
   `MOQ` int(11) DEFAULT NULL,
   `QPB` int(11) DEFAULT NULL,
   `Re_Order_Point` int(11) DEFAULT NULL,
   PRIMARY KEY (`id`),
   KEY `product_id_idx` (`product_id`),
   KEY `size_id_idx` (`size_id`),
   CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `Product` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
   CONSTRAINT `size_id` FOREIGN KEY (`size_id`) REFERENCES `Size` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `created` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` tinyint(1) NOT NULL,
  `father_name` varchar(255) DEFAULT NULL,
  `guestUser` tinyint(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `religion` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(65) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bjxn5ii7v7ygwx39et0wawu0q` (`role`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  KEY `FK_5q4rc4fh1on6567qk69uesvyf` (`role_id`),
  KEY `FK_g1uebn6mqk9qiaw45vnacmyo2` (`user_id`),
  CONSTRAINT `FK_5q4rc4fh1on6567qk69uesvyf` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `FK_g1uebn6mqk9qiaw45vnacmyo2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `warehouse_product_size` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_id` int(11) NOT NULL,
  `product_size_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `warehouse_id_idx` (`warehouse_id`),
  KEY `product_size_id_idx` (`product_size_id`),
  CONSTRAINT `product_size_id` FOREIGN KEY (`product_size_id`) REFERENCES `product_size` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `warehouse_id` FOREIGN KEY (`warehouse_id`) REFERENCES `Warehouse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
