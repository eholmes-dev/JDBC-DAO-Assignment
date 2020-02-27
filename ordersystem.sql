/* Check whether the database already exists */
IF EXISTS(SELECT 1 FROM master.dbo.sysdatabases 
		  WHERE name = 'ordersystem')
BEGIN
DROP DATABASE [ordersystem]
print '' print '*** Dropping Database ordersystem'
END
GO

print '' print '*** Creating Database ordersystem'
GO

CREATE DATABASE [ordersystem]
GO

print '' print '*** Using Database ordersystem'
GO

USE [ordersystem]
GO

-- Create the Tables

print '' print '*** Creating table [OrderRecord]'
GO
-- drop table
DROP TABLE IF EXISTS OrderRecord;
-- Creating table OrderRecord
CREATE TABLE OrderRecord(
	order_id INT NOT NULL,
	order_number	INT	NOT NULL		
,	order_date	DATE	NOT NULL		
,	vendor_id	INT	NOT NULL		

, CONSTRAINT PK_order_id PRIMARY KEY (order_id)
 )
;

---- Insert data into table
--INSERT INTO OrderRecord (order_number, order_date, vendor_id) 
--VALUES ('0', '2019-11-12', 105);  

print '' print '*** Creating stored procedure [sp_inser_into_orderrecord]'
GO
GO
-- Sproc to insert into OrderRecord
DROP PROCEDURE IF EXISTS sp_insert_into_orderrecord;
GO

CREATE PROCEDURE sp_insert_into_orderrecord 
(
	@p_order_id INT
,	@p_order_number	INT
,	@p_order_date	DATE
,	@p_vendor_id	INT
)
AS
BEGIN
INSERT INTO OrderRecord
(
	order_id
,	order_number
,	order_date
,	vendor_id
)
VALUES
	(
	@p_order_id
,	@p_order_number	
,	@p_order_date	
,	@p_vendor_id	
)
END
GO

print '' print '*** Creating stored procedure [sp_get_all_orderrecord_items]'

GO
-- Sproc to get all OrderRecorditems
DROP PROCEDURE IF EXISTS sp_get_all_orderrecord_items;
GO

GO
CREATE PROCEDURE sp_get_all_orderrecord_items
AS
BEGIN
SELECT 
	order_id
,	order_number
,	order_date
,	vendor_id
FROM OrderRecord
;
END
GO

print '' print '*** Creating stored procedure [sp_update_orderrecordItems]'
GO
GO
-- Sproc to update a OrderRecord record
DROP PROCEDURE IF EXISTS sp_update_orderrecordItems;
GO

GO
CREATE PROCEDURE sp_update_orderrecordItems
(	
	@p_order_id INT
,	@p_order_number	INT
,	@p_order_date	DATE
,	@p_vendor_id	INT

)
AS
BEGIN
	UPDATE OrderRecord
	SET
	order_number = @p_order_number
,	order_date = @p_order_date
,	vendor_id = @p_vendor_id
WHERE order_id = @p_order_id;
END
GO

print '' print '*** Creating stored procedure [sp_delete_from_orderrecord]'
GO
GO
-- Sproc to Delete from OrderRecord
DROP PROCEDURE IF EXISTS sp_delete_from_orderrecord;
GO

GO
CREATE PROCEDURE sp_delete_fromorderrecord
(
	@p_order_id	INT
)
AS
BEGIN
DELETE FROM OrderRecord
WHERE 	order_id = @p_order_id;
END
GO


--GO
--DROP USER IF EXISTS DAOUser;
--CREATE USER DAOUser IDENTIFIED BY "new_password";
--GRANT ALL ON ordersystem.*  TO DAOUser;
--GO
