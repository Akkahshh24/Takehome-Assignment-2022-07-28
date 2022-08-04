CREATE DATABASE productmanagement;
USE productmanagement;

CREATE TABLE productcategory (
	categoryid BIGINT PRIMARY KEY,
    categoryname VARCHAR(255)
);	

CREATE TABLE product (
	id BIGINT PRIMARY KEY AUTO_INCREMENT,
    sku VARCHAR(255),
    name VARCHAR(255),
    description TEXT,
    unitprice DECIMAL(13, 2),
    imageurl VARCHAR(255),
    unitsinstock INT,
    datecreated DATETIME,
    lastupdated DATETIME,
    categoryid BIGINT,
    FOREIGN KEY (categoryid) REFERENCES productcategory(categoryid)
); 

DESC productcategory;
DESC product;

INSERT INTO 
	productcategory
VALUES
	(1, "Food & Beverages"), 
    (2, "Electronics"),
    (3, "Fashion");
    
INSERT INTO 
	product
VALUES
	(101, "KYH749376", "Nescafe Coffee", "Coffee to get a move on", 25, "https://m.media-amazon.com/images/I/71PiszDkulL._SX522_.jpg", 500, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP,1),
	(102, "HYE6385J3", "Logitech Wireless Mouse", "Mouse for desktop/laptop", 499, "https://images-eu.ssl-images-amazon.com/images/I/31ROHZJMEUL._SX300_SY300_QL70_FMwebp_.jpg", 300, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 2),
	(103, "7365FKDI3", "Adidas Shoes", "Sports footwear for a healthy lifestyle", 4990, "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/8012a88ae5804985800bae3001041997_9366/Quickflow_M_Blue_EY2945_01_standard.jpg", 200, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, 3);
    
ALTER TABLE product AUTO_INCREMENT 104;

SELECT * FROM productcategory;
SELECT * FROM product;