Description

The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

Reimbursement Types Employees must select the type of reimbursement as: LODGING, TRAVEL, FOOD, or OTHER.

Please read ERS_Requirements.pdf for detailed information about the project.

Technologies Used

-Frontend : Html, CSS, Javascript

-Backend : Java, Maven, Servlet, JDBC, Tomcat

Database : PostgreSQL


Features

-Employee can log into the system.View all submitted request in the past.Create new reimbursment request.
-Finance Manager can log in into the system. View All submitted request.
-Finance Manager can filter request based on status :Approved, Pending or Denied.
-Finance Manager can Approve or reject the request


Getting Started

-Clone the project into your desired folder using below command in gitbash.
-git clone https://github.com/2011Canada/project-1-raviraj845.git
-Create Postgres database using the script provided in script.sql file.
-Enter the data into the table. Script to enter the data in table is also provided in script.sql file.
-Import project in Eclipse or Spring Tool Suite(IDE) and install Tomcat server on your system.


Usage
-From the IDE, right click on the project and Select Run As > Run on Server.
-Open the web browser and type "http://localhost:8080/projectservlet/login.html" in the address bar. It will open Login page.
-If you enter the username and password for employee, it will open the Employee Screen.
-On the employee screen , it will show All past request.It also has a button to create new request.
-Click on create new request button, it will open a form to submit a new request. fill out the form and click on submit to submit the request.


-Entering username and password for manager will open a manager's screen.
-It will show All the requests submitted by employees. Manager can filter the request based on a status from the selecter.
-Manager can approve or deny the request by pressing the button and it will update the status accordingly.
