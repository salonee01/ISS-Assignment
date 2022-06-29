USE northwind;

-- Select column example
SELECT ContactName, City FROM Customers;

-- SELECT * Example
SELECT * FROM Customers;

-- SELECT Example Without DISTINCT
SELECT Country FROM Customers;

-- SELECT DISTINCT Examples
SELECT DISTINCT Country FROM Customers; 
SELECT COUNT(DISTINCT Country) FROM Customers;

-- WHERE Clause Example
SELECT * FROM Customers
WHERE Country='Mexico';

SELECT * FROM Orders
WHERE ShipVia=1;

SELECT * FROM Orders
WHERE Freight >=50;

-- AND Example
SELECT * FROM Customers
WHERE Country='Germany' AND City='Berlin';

-- OR Example
SELECT * FROM Customers
WHERE City='Barcelona' OR City='Madrid';

-- NOT Example
SELECT ProductName FROM Products
WHERE NOT Discontinued='1';

-- Combination of AND and NOT
SELECT * FROM Orders
WHERE NOT ShipCountry='France' AND Freight<200;

-- Order By Example
-- Order the shipments by size of freight in descending order
SELECT * FROM Orders
ORDER BY Freight DESC LIMIT 25;

-- Product units in stock with unit prices
SELECT * FROM Products
WHERE NOT Discontinued=1
ORDER BY UnitPrice ASC, UnitsInStock DESC;

-- INSERT INTO Example
INSERT INTO Customers (CustomerID, CompanyName, ContactName, ContactTitle, Address, City, Region, PostalCode, Country, Phone, Fax)
VALUES('LETSU', 'Let''s Stop N Shop', 'Jaime Yorres', 'Owner', '87 Polk St. Suite 5', 'San Francisco', 'CA', '94117', 'USA', '(415) 555-5938', NULL);


-- NULL VALUES
SELECT ContactName, Address
FROM Customers
WHERE Address IS NOT NULL;

-- Select all records from the Customers where the PostalCode column is empty.
SELECT * FROM Customers
WHERE PostalCode IS NULL;

-- Restart sale of products in stock
UPDATE Products
SET Discontinued=0
WHERE UnitsInStock>0;

-- Delete Example
DELETE FROM `Order Details` 
WHERE OrderID = 10248 AND ProductID=11;

-- Select top example ( select top 10 shipments based on freight in belgium)
SELECT * FROM Orders
WHERE ShipCountry = 'Belgium'
ORDER BY Freight DESC LIMIT 10;

-- Min example (find price of cheapest product)
SELECT MIN(UnitPrice) AS SmallestPrice
FROM Products;

-- Max example find price of most expensive product
SELECT MAX(UnitPrice) AS LargestPrice
FROM Products;

-- Count - Find total number of products
SELECT COUNT(ProductID)
FROM Products;

-- Avg() - Find average price of a product
SELECT AVG(UnitPrice)
FROM Products;

-- Find total quantity ordered
SELECT SUM(Quantity)
FROM `Order Details`;

-- Find number of products which have a price of 18
SELECT COUNT(*)
FROM Products
WHERE UnitPrice = 18;

-- SELECT all customers whose name starts with s
SELECT * FROM Customers
WHERE ContactName LIKE 's%';

-- Wildcard example
-- Find product names containing the phrase 'choco'
SELECT * FROM Products
WHERE ProductName LIKE '%choco%';

-- selects all customers with a ContactName that have "r" in the second position:
SELECT * FROM Customers
WHERE ContactName LIKE '_r%';

-- selects all customers with a ContactName that starts with "a" and are at least 3 characters in length:
SELECT * FROM Customers
WHERE ContactName LIKE 'a__%';

-- selects all customers with a ContactName that starts with "a" and ends with "o":
SELECT * FROM Customers
WHERE ContactName LIKE 'a%o';

-- selects all customers with a ContactName that does NOT start with "a":
SELECT * FROM Customers
WHERE ContactName NOT LIKE 'a%';

-- Select all records where the value of the City column starts with the letter "T".
SELECT * FROM Customers
WHERE City LIKE 't%';

-- selects all customers with a City starting with "ber":
SELECT * FROM Customers
WHERE City LIKE 'ber%';

-- selects all customers with a City containing the pattern "es"
SELECT * FROM Customers
WHERE City LIKE '%es%';

-- selects all customers with a City starting with any character, followed by "ondon":
SELECT * FROM Customers
WHERE City LIKE '_ondon';

-- selects all customers that are located in "Germany", "France" or "UK":
SELECT * FROM Customers
WHERE Country IN ('Germany', 'France', 'UK');

-- selects all products with a price between 10 and 20:
SELECT * FROM Products
WHERE UnitPrice BETWEEN 10 AND 20;

-- selects all products with a price between 10 and 20. In addition; do not show products with a CategoryID of 1,2, or 3:
SELECT * FROM Products
WHERE UnitPrice BETWEEN 10 AND 20
AND CategoryID NOT IN (1,2,3);

-- selects all products with a ProductName between Carnarvon Tigers and Mozzarella di Giovanni:
SELECT * FROM Products
WHERE ProductName BETWEEN 'Carnarvon Tigers' AND 'Mozzarella di Giovanni'
ORDER BY ProductName;

-- selects all orders with an OrderDate between '01-July-1996' and '31-July-1996':
SELECT * FROM Orders
WHERE OrderDate BETWEEN '1996-07-01' AND '1996-07-31';

-- Alias for Columns Examples
SELECT CustomerID AS ID, ContactName AS Customer
FROM Customers;

-- Alias for Tables Example
SELECT o.OrderID, o.OrderDate, c.ContactName
FROM Customers AS c, Orders AS o
WHERE c.CustomerID=o.CustomerID;

-- Join Example
SELECT Orders.OrderID, Customers.ContactName, Orders.OrderDate
FROM Orders
INNER JOIN Customers ON Orders.CustomerID=Customers.CustomerID;

-- Inner join example
SELECT Orders.OrderID, Customers.ContactName, Shippers.CompanyName
FROM ((Orders
INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID)
INNER JOIN Shippers ON Orders.ShipVia = Shippers.ShipperID);

-- Left Join select all customers, and any orders they might have:
SELECT Customers.ContactName, Orders.OrderID
FROM Customers
LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID
ORDER BY Customers.ContactName;

-- Right Join all employees, and any orders they might have placed:
SELECT Orders.OrderID, Employees.LastName, Employees.FirstName
FROM Orders
RIGHT JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID
ORDER BY Orders.OrderID;

-- Self Join matches customers that are from the same city:
SELECT A.ContactName AS ContactName1, B.ContactName AS ContactName2, A.City
FROM Customers A, Customers B
WHERE A.CustomerID <> B.CustomerID
AND A.City = B.City
ORDER BY A.City;

-- Union returns the cities (only distinct values) from both the "Customers" and the "Suppliers" table:
SELECT City FROM Customers
UNION
SELECT City FROM Suppliers
ORDER BY City;

-- Select into example
DROP TABLE IF EXISTS CustomersGermany;
CREATE TABLE `CustomersGermany` (
    `CustomerID` VARCHAR(5) NOT NULL,
    `CompanyName` VARCHAR(40) NOT NULL,
    `ContactName` VARCHAR(30),
    `ContactTitle` VARCHAR(30),
    `Address` VARCHAR(60),
    `City` VARCHAR(15),
    `Region` VARCHAR(15),
    `PostalCode` VARCHAR(10),
    `Country` VARCHAR(15),
    `Phone` VARCHAR(24),
    `Fax` VARCHAR(24),
    CONSTRAINT `PK_Customers` PRIMARY KEY (`CustomerID`)
);

INSERT INTO CustomersGermany
SELECT * FROM Customers
WHERE Country = 'Germany';

-- Group By lists the number of customers in each country:
SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country;

-- GROUP BY With JOIN Example lists the number of orders sent by each shipper:
SELECT Shippers.CompanyName, COUNT(Orders.OrderID) AS NumberOfOrders FROM Orders
LEFT JOIN Shippers ON Orders.ShipVia = Shippers.ShipperID
GROUP BY CompanyName;

-- SQL HAVING Examples lists the number of customers in each country, sorted high to low (Only include countries with more than 5 customers):
SELECT COUNT(CustomerID), Country
FROM Customers
GROUP BY Country
HAVING COUNT(CustomerID) > 5
ORDER BY COUNT(CustomerID) DESC;

-- lists the employees that have registered more than 10 orders:
SELECT Employees.LastName, COUNT(Orders.OrderID) AS NumberOfOrders
FROM (Orders
INNER JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID)
GROUP BY LastName
HAVING COUNT(Orders.OrderID) > 10;

-- SQL EXISTS Examples returns TRUE and lists the suppliers with a product price less than 20:
SELECT CompanyName
FROM Suppliers
WHERE EXISTS (SELECT ProductName FROM Products WHERE Products.SupplierID = Suppliers.supplierID AND UnitPrice < 20);

-- SQL ANY Examples lists the ProductName if it finds ANY records in the OrderDetails table has Quantity equal to 10 (this will return TRUE because the Quantity column has some values of 10):
SELECT ProductName
FROM Products
WHERE ProductID = ANY
  (SELECT ProductID
  FROM `Order Details`
  WHERE Quantity = 10);
  
-- lists the ProductName if ALL the records in the OrderDetails table has Quantity equal to 10.
SELECT ProductName
FROM Products
WHERE ProductID = ALL
  (SELECT ProductID
  FROM `Order Details`
  WHERE Quantity = 10);

-- SQL CASE Examples goes through conditions and returns a value when the first condition is met:
SELECT OrderID, Quantity,
CASE
    WHEN Quantity > 30 THEN 'The quantity is greater than 30'
    WHEN Quantity = 30 THEN 'The quantity is 30'
    ELSE 'The quantity is under 30'
END AS QuantityText
FROM `Order Details`;

-- NULL Functions
SELECT ProductName, UnitPrice * (UnitsInStock + IFNULL(UnitsOnOrder, 0))
FROM Products;

SELECT ProductName, UnitPrice * (UnitsInStock + COALESCE(UnitsOnOrder, 0))
FROM Products;

-- Stored procedure to select all customers
DELIMITER $$
DROP PROCEDURE IF EXISTS SelectAllCustomers $$
CREATE PROCEDURE SelectAllCustomers()
BEGIN
SELECT * FROM Customers;
END  $$
DELIMITER ;
CALL SelectAllCustomers;

-- Create database
-- CREATE DATABASE IF NOT EXISTS northwind;

-- Drop database
-- DROP DATABASE IF EXISTS northwind;

-- Create table
-- CREATE TABLE `Categories` (
--     `CategoryID` INTEGER NOT NULL AUTO_INCREMENT,
--     `CategoryName` VARCHAR(15) NOT NULL,
--     `Description` MEDIUMTEXT,
--     `Picture` LONGBLOB,
--     CONSTRAINT `PK_Categories` PRIMARY KEY (`CategoryID`)
-- );

-- Drop table
-- DROP TABLE Shippers;

-- Truncate table
-- TRUNCATE TABLE Products;

-- Alter table
ALTER TABLE Customers
ADD Email varchar(255);

ALTER TABLE Customers
DROP COLUMN Email;

-- ALTER TABLE `Employees` ADD CONSTRAINT `FK_Employees_Employees` 
--     FOREIGN KEY (`ReportsTo`) REFERENCES `Employees` (`EmployeeID`);

-- Constraints
-- ALTER TABLE `Order Details` ADD CONSTRAINT `FK_Order_Details_Orders` 
--     FOREIGN KEY (`OrderID`) REFERENCES `Orders` (`OrderID`);
    
-- NOT NULL
DROP TABLE IF EXISTS `EmployeeTerritories`;
CREATE TABLE `EmployeeTerritories` (
    `EmployeeID` INTEGER NOT NULL,
    `TerritoryID` VARCHAR(20) NOT NULL,
    CONSTRAINT `PK_EmployeeTerritories` PRIMARY KEY (`EmployeeID`, `TerritoryID`)
);

-- Unique
DROP TABLE IF EXISTS Persons;
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    UNIQUE (ID)
);

-- Primary key
-- CREATE TABLE `Employees` (
--     `EmployeeID` INTEGER NOT NULL AUTO_INCREMENT,
--     `LastName` VARCHAR(20) NOT NULL,
--     `FirstName` VARCHAR(10) NOT NULL,
--     `Title` VARCHAR(30),
--     `TitleOfCourtesy` VARCHAR(25),
--     `BirthDate` DATETIME,
--     `HireDate` DATETIME,
--     `Address` VARCHAR(60),
--     `City` VARCHAR(15),
--     `Region` VARCHAR(15),
--     `PostalCode` VARCHAR(10),
--     `Country` VARCHAR(15),
--     `HomePhone` VARCHAR(24),
--     `Extension` VARCHAR(4),
--     `Photo` LONGBLOB,
--     `Notes` MEDIUMTEXT NOT NULL,
--     `ReportsTo` INTEGER,
--     `PhotoPath` VARCHAR(255),
--      `Salary` FLOAT,
--     CONSTRAINT `PK_Employees` PRIMARY KEY (`EmployeeID`)
-- );

-- Foreign Key
-- ALTER TABLE `CustomerCustomerDemo` ADD CONSTRAINT `FK_CustomerCustomerDemo` 
--     FOREIGN KEY (`CustomerTypeID`) REFERENCES `CustomerDemographics` (`CustomerTypeID`);
    
-- Check
DROP TABLE IF EXISTS Persons;
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    City varchar(255),
    CONSTRAINT CHK_Person CHECK (Age>=18 AND City='Sandnes')
);

-- Default value
DROP TABLE IF EXISTS Persons;
CREATE TABLE Persons (
    ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    City varchar(255) DEFAULT 'Sandnes'
);

-- Index
-- CREATE INDEX `City` ON `Customers` (`City`);

-- Autoincrement
DROP TABLE IF EXISTS Persons;
CREATE TABLE Persons (
    Personid int NOT NULL AUTO_INCREMENT,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    PRIMARY KEY (Personid)
);

-- Dates
SELECT * FROM Orders 
WHERE OrderDate='1996-07-04 00:00:00';

-- Views
DROP VIEW IF EXISTS `Alphabetical list of products`;
CREATE VIEW `Alphabetical list of products`
AS
SELECT Products.*, 
       Categories.CategoryName
FROM Categories 
   INNER JOIN Products ON Categories.CategoryID = Products.CategoryID
WHERE (((Products.Discontinued)=0));

DROP VIEW IF EXISTS `Products Above Average Price`;
CREATE VIEW `Products Above Average Price` AS
SELECT ProductName, UnitPrice
FROM Products
WHERE UnitPrice > (SELECT AVG(UnitPrice) FROM Products);

-- Injection
SELECT * FROM Products WHERE ProductID = 105 OR 1=1;