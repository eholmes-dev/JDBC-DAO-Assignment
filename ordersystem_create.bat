echo off

rem batch file to run a script to create a db
rem 9/5/2019

sqlcmd -S localhost -E -i ordersystem.sql
rem sqlcmd -S localhost\mssqlserver -E -i ordersystem.sql
rem sqlcmd -S localhost\sqlexpress -E -i ordersystem.sql

ECHO .
ECHO if no error messages appear DB was created
PAUSE