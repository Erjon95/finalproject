Description

This project is a simulation of a ticket marketplace. Ticket sellers can upload events to it, and ticket buyers can search for, and buy tickets to,  them.

I used Spring boot for the backend and HTML and CSS for the frontend. The view rendering engine is Thymeleaf.


Roles


There are three roles in this app. They are the ticketsellers, the ticket buyers and the admin. I did not develop the admin role. The ticketseller role, as well, does not have login functionality, and the logic is not fully developed. The ticket buyer role is fully developed.


Database


I used MariaDB for the database. It is called "ticketplatform" in this app. It consists of four tables: event, ticketbuyer, ticketseller, and ticket.

The event table stores the events that ticket sellers upload into the marketplace.

The ticket table stores the relationship between the ticket buyers and the tickets that they have purchased.

The ticketbuyer table stores the information of ticketbuyers.

The ticketseller table stores the information of the ticketsellers.

The database schema, as well as the insert statements that I used to test the app, can be found in the "ticketplatform.sql" file.

The password and username of the database are set to "" and "root" respectively, but they can be changed in the application.properties file.


Packaging


I have packaged the app as "WAR", because I deployed it to Tomcat. This property can be changed in the pom.xml file ("<packaging>war</packaging>").


Password encryption

If you use the data in the "ticketplatform.sql" file, all the passwords are "pass". The app uses Bcrypt with strength 4 to encrypt the passwords.
The encryption strength can be changed in the "WebSecurityConfigBuyer" file.


Running the app


The index page can be viewed at "localhost:8080/".  

To register a new buyer, visit localhost:8080/register-buyer. To edit the fields of a buyer, visit localhost:8080/edit-buyer after logging in, or click on
the "edit" button in the "user info" section of the "account" page.

To register a new seller, visit localhost:8080/register-seller.

To upload an event as a seller, visit localhost:8080/upload_event.
