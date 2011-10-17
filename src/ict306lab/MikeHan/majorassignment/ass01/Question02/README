VideoRental CLI application
================================

Author: Myat Min Han (Mike)
Date : 17th October 2010

Requirements/Specification
--------------------------------

This program is a command line interface (CLI) program that is designed and created to assist with administration jobs of the video rental manager to allow keeping track of inventory and transactions. 

Assumptions
------------

* Since it's assumed to be used by the manager of the video rental shop on the shop's terminal, there's no logging in involved as of this moment. (also due to the fact that the requirements never specified this.)
* The current CLI system also doesn't support removing or updating titles, customers and titles though the classes themselves already have support for those.
* All the data are stored in memory as of this moment and saving the data can be easily achived by serializing `VideoModel catalog` and `CustomerModel customers` properties of the VideoRental object.
* Currenlty no memory optimization has been done, and no stress test has been performed to ensure the program's speedy performance on the scale of hundred titles and hundred customers.

User Guide
------------
I have used the method that Mr. Sabari has instructed us to use to implement the packaging. The convention used will allow easy importing of the java files into your project. 

After importing, user just need to run the file VideoRental.java to start the program in netbeans.

Once you run the program the program is instructive enough to be able understand.

Structure/Design
-------------
I have used the Model View Controller design in conjunction with polymorphism to design the program. 

I have also chosen test-driven approach to get my hands dirty with writing JUnit test cases. As somebody who's used to the agile methodology, I am quite keen to hit the ground running and start the coding process as soon as possible. Thus by choosing the test-driven approach I can start with a rough design, improve it further and further along the development to create a complete program. 

The design of the objects in run-time shall look like this.

 * VideoRental
 * VideoRentalController
	* VideoModel
		* VideoTitle
		* VideoCopy
	* CustomerModel
		* Customer
		* CreditCustomer
 * Cli
 
The main reason for choosing MVC is that I could seperate the business logic, the view logic and the transaction logics instead of putting it all together in one file which makes it harder to control/maintain and make sense.

Using MVC structure, I have created Model classes for Videos and Customers, controller functions and view functions. (c and v functions from VideoRentalController.
 
By means of the static Cli (Command Line helper) class, I have created a helper class with functions that allows me to display command line menus easily and neatly.

Using the model classes in the VideoRentalController, I am able to control the two seperate data sources of VideoModel and CustomerModel. I can also make advanced properties and methods privacy by seperating all the logic. However, it resulted as more objects to code and more code to write for me.

At the end of the day, I have created a unit-tested code (with more than 90% coverage) that can be developed futher. And easily maintainable.


Limitations
---------------
Currently the association between VideoTitle and VideoRental is only one way which is not so convenient. It was due to the result of careless mistake of forgetting that java passes objects by reference. This can be improved further and could make the program a lot faster in many part of the VideoModel.

Listings
---------------


Testing
---------------
As I mentioned earlier, using the test driven development approach, I start out by writing a test code for the a fuction that I am going to implement. I then continue to create the function that fulfils the requirements of the function. 

Using this approach all the codes are fully tested using JUnit and the test codes are also attached in the same folder as the source codes.

Below is a sample of the program runned on the IDE for integration testing.

run:
	=============================================================
	Welcome to ABC Video Rental
	=============================================================
	Press enter to continue

	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 7
	You chose - Import Test Data
	Are you sure you want to import test data?
	This will clear all the data you may have created.	 y/n
	> y
	Importing Test data now.
	Imported 6 customers.
	Imported 2 titles, and a total of 5 copies.
	Press enter to continue

	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 1
	You chose - List all titles
	All titles are listed below. 
	Please enter the number that belongs to the title to see the details.
	Title Name <id> (Available Number of Copies) 

	============================================
	 [1] Horrible Bosses (0)
	 [2] Green Lantern (2)

				Or enter -1 to return to previous menu.
	> 1
	You chose - Horrible Bosses (0)
	======================================
	Video Title Info
	======================================
	Name:		Horrible Bosses
	Cost:		2.0
	Rental Days:	1

	Press enter to continue

	All titles are listed below. 
	Please enter the number that belongs to the title to see the details.
	Title Name <id> (Available Number of Copies) 

	============================================
	 [1] Horrible Bosses (0)
	 [2] Green Lantern (2)

				Or enter -1 to return to previous menu.
	> 2
	You chose - Green Lantern (2)
	======================================
	Video Title Info
	======================================
	Name:		Green Lantern
	Cost:		3.0
	Rental Days:	1

	Press enter to continue

	All titles are listed below. 
	Please enter the number that belongs to the title to see the details.
	Title Name <id> (Available Number of Copies) 

	============================================
	 [1] Horrible Bosses (0)
	 [2] Green Lantern (2)

				Or enter -1 to return to previous menu.
	> -1
	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 2
	You chose - Add New Title
	Please enter the name of the new title.
				Or enter "back" to return to previous menu.
	> Fringe
	Please enter the cost of the title per day.(In decimal number)
				Or enter -1 to return to previous menu.
	> 2.0
	Please enter the number of days the title is allowed to be rented.
				Or enter -1 to return to previous menu.
	> 3
	Please enter the number of copies to add to catalog
				Or enter -1 to return to previous menu.
	> 5
	New title: 'Fringe' is successfully created.
	Press enter to continue

	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 3
	You chose - List all customers
	All existing customers are listed below. 
	Please enter the number that belongs to the customer to see the details.

	============================================
	 [1] John
	 [2] Cindy
	 [3] Mark
	 [4] Marcus
	 [5] Mary
	 [6] Gary

				Or enter -1 to return to previous menu.
	> 1
	You chose - John
	==================================
	Customer Info
	==================================
	ID:			1
	Name:			John
	Address:		101 Main Street
	Max Allowed:		3
	Rented Videos:		1
		===Rented Videos==========
		Horrible Bosses - 2.0 - 1 - 1

	Press enter to continue

	All existing customers are listed below. 
	Please enter the number that belongs to the customer to see the details.

	============================================
	 [1] John
	 [2] Cindy
	 [3] Mark
	 [4] Marcus
	 [5] Mary
	 [6] Gary

				Or enter -1 to return to previous menu.
	> 6
	You chose - Gary
	==================================
	Customer Info
	==================================
	ID:			6
	Name:			Gary
	Address:		42 Filthy Rich Avenue
	Max Allowed:		8
	Rented Videos:		1
		===Rented Videos==========
		Green Lantern - 3.0 - 1 - 3
	CC:			9123
	Balance:		2.0

	Press enter to continue

	All existing customers are listed below. 
	Please enter the number that belongs to the customer to see the details.

	============================================
	 [1] John
	 [2] Cindy
	 [3] Mark
	 [4] Marcus
	 [5] Mary
	 [6] Gary

				Or enter -1 to return to previous menu.
	> -1
	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 4
	You chose - Add New Customer
	Please enter name
				Or enter "back" to return to previous menu.
	> Mike
	Please enter address
				Or enter "back" to return to previous menu.
	> 1 Infinite Loop
	Please enter max allowed rentals.
				Or enter -1 to return to previous menu.
	> 3
	Please enter CreditCard Number
	Or 'na' without quotes to set up as normal customer.

				Or enter "back" to return to previous menu.
	> na
	Customer successfully saved.
	Press enter to continue

	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 3
	You chose - List all customers
	All existing customers are listed below. 
	Please enter the number that belongs to the customer to see the details.

	============================================
	 [1] John
	 [2] Cindy
	 [3] Mark
	 [4] Marcus
	 [5] Mary
	 [6] Gary
	 [7] Mike

				Or enter -1 to return to previous menu.
	> 7
	You chose - Mike
	==================================
	Customer Info
	==================================
	ID:			7
	Name:			Mike
	Address:		1 Infinite Loop
	Max Allowed:		3
	Rented Videos:		0

	Press enter to continue

	All existing customers are listed below. 
	Please enter the number that belongs to the customer to see the details.

	============================================
	 [1] John
	 [2] Cindy
	 [3] Mark
	 [4] Marcus
	 [5] Mary
	 [6] Gary
	 [7] Mike

				Or enter -1 to return to previous menu.
	> -1
	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 5
	You chose - Rent Video
	Select Customer
	============================================
	 [1] John
	 [2] Cindy
	 [3] Mark
	 [4] Marcus
	 [5] Mary
	 [6] Gary
	 [7] Mike

				Or enter -1 to return to previous menu.
	> 7
	You chose - Mike
	Select Title to rent
	============================================
	 [1] Horrible Bosses (0)
	 [2] Green Lantern (2)
	 [3] Fringe (5)

				Or enter -1 to return to previous menu.
	> 3
	You chose - Fringe (5)
	The customer has rented the title.
	Mike shall return the copy in 3 day(s)
	Press enter to continue

	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 6
	You chose - Return Video
	Select Customer
	============================================
	 [1] John
	 [2] Gary
	 [3] Mike

				Or enter -1 to return to previous menu.
	> 2
	You chose - Gary
	Select the copie to return.
	Title - (cost)
	============================================
	 [1] Green Lantern (3.0)

				Or enter -1 to return to previous menu.
	> 1
	You chose - Green Lantern (3.0)
	Video successfully returned.
	Press enter to continue

	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> 3
	You chose - List all customers
	All existing customers are listed below. 
	Please enter the number that belongs to the customer to see the details.

	============================================
	 [1] John
	 [2] Cindy
	 [3] Mark
	 [4] Marcus
	 [5] Mary
	 [6] Gary
	 [7] Mike

				Or enter -1 to return to previous menu.
	> 6
	You chose - Gary
	==================================
	Customer Info
	==================================
	ID:			6
	Name:			Gary
	Address:		42 Filthy Rich Avenue
	Max Allowed:		8
	Rented Videos:		0
	CC:			9123
	Balance:		5.0

	Press enter to continue

	All existing customers are listed below. 
	Please enter the number that belongs to the customer to see the details.

	============================================
	 [1] John
	 [2] Cindy
	 [3] Mark
	 [4] Marcus
	 [5] Mary
	 [6] Gary
	 [7] Mike

				Or enter -1 to return to previous menu.
	> -1
	Please choose an action.
	 [1] List all titles
	 [2] Add New Title
	 [3] List all customers
	 [4] Add New Customer
	 [5] Rent Video
	 [6] Return Video
	 [7] Import Test Data

				Or enter -1 to exit the program.
	> -1
BUILD SUCCESSFUL (total time: 3 minutes 1 second)