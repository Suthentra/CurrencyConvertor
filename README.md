# CurrencyConvertor
A simple web-based Currency Converter application built using Java Servlets, MySQL, and JDBC. This app allows users to convert currency values between different currencies and stores the conversion history in a database. Users can also view, update, and delete conversion records through a user-friendly interface.

Procedure
. Install tomcat https://tomcat.apache.org/download-90.cgi
. Install postman https://www.postman.com/downloads/
. Install mySQL https://cdn.mysql.com//Downloads/MySQLInstaller/mysql-installer-community-8.0.41.0.msi 
. Install JDBC Connector
. Install visual studio
. Install XAMPP or WAMPP

. Start the tomcat server by double clicking the startup
. Go to the browser and type "http://localhost:8090" to see if your tomcat server is running or not.
. To change the port go to Tomcat 9.0/conf/server.html and you can change the port

.Create your project inside the webapps folder(in my case webapps/currencycon)

CurrencyConverterApp/
├── index.html
│ 
├── WEB-INF/
│       ├── web.xml
│       ├── lib/
│       │   └── mysql-connector-java-8.0.xx.jar
│       └── classes/
│           └── com/tce/it/
|               └── CurrencyServlet.java 
│               └── CurrencyServlet.class

this is the structure.

. Enable the mysql server from XAMPP and go to mysql workbench and create the db and table

1)CREATE DATABASE currencydb;

2)USE currencydb;
3) CREATE TABLE conversions (
  id INT AUTO_INCREMENT PRIMARY KEY,
  from_currency VARCHAR(10),
  to_currency VARCHAR(10),
  amount DECIMAL(10, 2),
  result DECIMAL(10, 2),
  date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

4) SELECT * FROM conversions;

. Whenever the changes are done in the java code stop and reload your application in the Tomcat Web Application Manager.



