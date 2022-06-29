DELIMITER $$
DROP PROCEDURE IF EXISTS SelectAllCustomers $$
CREATE PROCEDURE SelectAllCustomers()
BEGIN
SELECT * FROM Customers;
END  $$
DELIMITER ;
-- CALL SelectAllCustomers;