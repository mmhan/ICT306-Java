a) Brief Description of the Problem
---

The problem of this question is mainly to create the form and to validate the input before submission.

The creation of form is easy enough since the action ur is given as http://www.it.murdoch.edu.au/cgi-bin/reply.pl with no particular field 'name' specified. 

The validation of form requires three types of validation
 - to check whether the field is empty or not
 - to check whether the given date of birth is valid
 - to check whether the email is valid
 
 
b) Description of solution approach including structured design/pseudo-code for the Javascript specific code.
---

For starter, I used part of the HTML5 boilerplate to start off (html5boilerplate.com). In order to make sure that the date is validly entered by the user, I created some generators to generate drop-down options for date selection. The generators generate the <options> tags for the drop-down using the <body> tag's onload event.


I have used the regular convention of naming the fields as "data[<Model>][<fieldname>]" and id as camel-cased "<model><FieldName>".

After that I have created the validation functions using modular structure. 

HTML
-----
	Body - onload => Question1.init()
		- Form - onsubmit => Question1.validate.all() 
	
Javascript
-----
	Question
		- init
		- form
		- validate
			- all 
				- should validate all the fields using methods in this obj
				- return true if all is valid
				- return false if one of the field is invalid and show error
			- isValidDate
				- try to create a JS Date object using selected date.
				- if valid return true, not valid, return false
			- isNotEmpty 
				- return true or false
			- isEmail
				- validate using regex.
				- return true or false
		- generateDays
			- generate days options
		- generateMonths
			- generate months options
		- generateYears
			- generate years options
		
c) Proof of testing and sample results
---

The testing is done on several levels,
	
	- testing the generators and HTML
		- All I needed was to open the page in browser and visually confirm that the generators produce expected results.
	- testing the validation functions
		- isValidDate
			- by inputting the following (date - expected - result)
				- 1, Jan, 2010 - true - true
				- 30, Feb, 2010 - false - false
				- 28, Feb, 2010 - true - true
				- 29, Feb, 2008 - true - true
		- isNotEmpty
			- by inputting the following (input - expected - result)
				- nothing - false - false,
				- ' ' - false - false
				- 'abc' - true - true
		- isEmail
			- by inputting the following (input - expected - result)
				- abc - false - false
				- abc@ - false - false
				- abc@asdf - false - false
				- abc@asdf.co - true - true
			
			
			