/* Author: Mike Myat Min Han

*/
var Question1 = {
	/**
	 * Will initiate this page.
	 *
	 **/
	init : function(e){
		//generate a list of options for DOB
		document.getElementById('userBirthdayDay').innerHTML = this.form.generateDays();
		document.getElementById('userBirthdayMonth').innerHTML = this.form.generateMonths();
		document.getElementById('userBirthdayYear').innerHTML = this.form.generateYears();
	},
	form:{
		validate:{
			/***
			 * Will validate the given form according to the specs below
			 * @return 		true if all fields are valid and false otherwise
			 *
			 * name  			must not be empty
			 * email			must not be empty and must be a valid format
			 * birthday			must be a valid date
			 * fav_continent	must not be empty
			 * 
			 **/
			all: function(form){
				var me = this;
				var validation= {
					name: me.isNotEmpty(form['data[User][name]']),
					email: me.isNotEmpty(form['data[User][email]']) && me.isEmail(form['data[User][email]']),
					birthday: me.isValidDate({
						day:form['data[User][birthday][day]'],
						month: form['data[User][birthday][month]'],
						year: form['data[User][birthday][year]']
					}),
					fav_continent: me.isNotEmpty(form['data[User][fav_continent]'])
				};
				var labels = {
					name : "Name",
					email : "Email",
					birthday: "Birthday",
					fav_continent: "Favorite contient"
				}
				var errorsList = []
				for (var i in validation){
					if(!validation[i]) errorsList.push(labels[i]);
				}
				if(errorsList.length){
					alert("Please input the following fields with valid values\n- " + errorsList.join("\n- "));
					return false;
				}
				return true;
			},
			/***
			 * will do a basic check of creating the date in JS object and checking for validity 
			 * @params		it expects {day: element, month: element, year: element} json object as arg
			 * @return		true if valid, false if invalid
			 **/
			isValidDate: function(els){
				var date =new Date(
					parseInt(els.year.value),
					parseInt(els.month.value - 1), //cos it expects month as 0-11
					parseInt(els.day.value)
				);
				return (
					els.year.value == date.getFullYear() && els.month.value == date.getMonth() + 1 && els.day.value == date.getDate()
				);
			},
			/***
			 * will check the value of given element
			 * @return		true if not empty, false if empty
			 **/
			isNotEmpty: function(element){
				return (element.value != '')
			},
			/***
			 * will check the value of given element to see if it's email or not.
			 * @return		true if valid, false if invalid
			 **/
			isEmail: function(element){
				var email = element.value;
				return (email.search(/^[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i) != -1);
			}
		},
		/**
		 * Will generate a number of days for select options
		 **/
		generateDays: function(){
			var days = "";
			for (var i = 1; i < 32; i++){
				days += ("<option value='" + i + "'>" + i + "</option>");
			}
			return days;
		},
		/**
		 * Will generate a number of months for select options
		 **/
		generateMonths : function(){
			var months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "Novemeber", "Decemeber"];
			var monthsStr = '';
			for (var i in months){
				monthsStr += ("<option value='" + (parseInt(i) + 1) + "'>" + months[i] + "</option>");
			}
			return monthsStr;
		},
		/**
		 * Will generate a number of years for select options
		 **/
		generateYears : function(){
			var currentYear = new Date().getFullYear();
			var years = '';
			for (var i = 1; i < 100; i++){
				years += ("<option value='" + (currentYear - i) + "'>" + (currentYear - i) + "</option>");
			}
			return years;
		}
	}
};