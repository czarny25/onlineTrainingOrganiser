<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<script type="text/javascript">
	function onReady() {

		
		
		var b1 = document.getElementsByClassName('editTrainingButton');
		var b2 = document.getElementsByClassName("saveTrainingButton").disabled = true;
		
		//b2.setAttribute("disabled", true);
		
		if (b2.disabled === true) {
				
		} else {
			b1.disabled === false;	
		}
		
		
		
		
		
		
		//alert(document.getElementById("testText").innerHTML);

		var training = JSON.parse(document.getElementById("trainingReceived").innerHTML);

		//var exercises = training.exercises;

		//ListOfExercesesNames = JSON.parse(document.getElementById("exeNamesReceived").innerHTML);
		//defineVaraibles(ListOfExercesesNames);

		setExerciseNames();
		setExercises(training);
		setWeekDays(training);

		//alert("ListOfExercesesNames length " + ListOfExercesesNames.length);

		// test pobranego treningu
		//alert("Training " + training.trainingName);			
		//alert("Day week " + training.weekDay);
		//alert("User " + training.userName);

		/**
		for(var i = 0; i < exercises.length; i++ ){
			//alert(i + " is " + exercises[i].nameOfExercise);				
			var sets = exercises[i].sets;
			for(var j = 0; j < sets.length; j++ ){
				var set = sets[j];
				//alert("setNo" + set.setNo + ". reps:" + set.reps + " weight:" + set.weight);
			}				
		}						
		// koniec testu
		 **/
		/*
		for(var i = 0; i < exercises.length; i++){
			var exercise = exercises[i];
			//alert("in loop " )
			//alert("there is " + exercises[i].sets.length + " rows");
			presentExercise(i , exercise);
		};
		 */

		addExercise();

		//alert("Bye Martin ");
	}

	$(document).ready(onReady);

	function setExercises(training) {

		//alert("Set the Exercises ");

		var exercises = training.exercises;
		for (var i = 0; i < exercises.length; i++) {
			var exercise = exercises[i];
			presentExercise(i, exercise);
		};

		//alert("Exercise are set");
	}

	// this function creates select tag populated with days of the week options
	// and sets sets apropriate day selected according to training
	function setWeekDays(training) {

		//alert("Set the day ");	

		var trainName = document.getElementById("weekDay");

		//alert("The tag is " + trainName.nodeName);

		var ListOfWeekDays = [ "Monday", "Tuesday", "Wednesday", "Thursday",
				"Friday", "Saturday", "Sunday" ];

		for (var i = 0; i < ListOfWeekDays.length; i++) {

			var elemSeleList = document.createElement("option");
			var name = ListOfWeekDays[i];
			//alert("week day is now " + name);
			if ((training != null) && (name == training.weekDay)) {
				//alert("exercise is now " + exercise.nameOfExercise + " and name is " + name);
				elemSeleList.innerHTML = training.weekDay;
				elemSeleList.setAttribute("value", training.weekDay);
				elemSeleList.setAttribute("selected", "selected")
			} else {
				elemSeleList.innerHTML = name;
				elemSeleList.setAttribute("value", name);
			}
			trainName.appendChild(elemSeleList);
		}

		//alert("Day is set");	
	}

	function setExerciseNames() {

		//alert("Set the exercise names ");

		ListOfExercesesNames = JSON.parse(document.getElementById("exeNamesReceived").innerHTML);
		defineVaraibles(ListOfExercesesNames);

		//alert("Exercise names are set");
	}

	
	
	function saveTrainingToDatabases() {

		addExercise();
		
		var training = passTraining();
		var excercises = training.exercises;


		var myJSON = JSON.stringify(training);
			

		$.ajax({
			type : 'POST',
			url : "${pageContext.request.contextPath}/doUpdate",
			contentType : 'application/json; charset=utf-8',
			data : myJSON,
			dataType : "json",
			mimeType : 'application/json'

		});

		//addExercise();
		
		alert("...saved");
		//resetForm();
		window.parent.location = window.parent.location.href;
		//window.parent.location = window.parent.location.href;				
		//alert("Reloaded...");
		
		
		//window.location.href = "http://localhost:8080/trainings/showUsersTrainings";
		
		//window.parent.location = window.parent.location.href;
	}

	
	

	
	
	// this function send new Exercise Name to controller
	function saveNewExerciseNameToDatabases() {

		var exerciseName = document.getElementById("newExeName").value;

		
		
		alert("To add new exercise your current change will be saved - OK?    " + exerciseName); // test

		var myJSON = JSON.stringify(exerciseName);

		$.ajax({
			type : 'POST',
			url : "${pageContext.request.contextPath}/getNewExercise",
			data : myJSON,
			dataType : "json",
			mimeType : 'application/json'
		});

		//alert("New exercise...saved");

		saveTrainingToDatabases();

		//alert("Training...saved");

		//addExercise();

		//setExerciseNames();
		window.parent.location = window.parent.location.href;
		//addExercise();
		alert("Reloaded...");

		addExercise();

		//alert("Zmiana...");
	}
</script>


<div class="wholeForm">
	
		<div class="trainingHeader container">
			<div class="trainingTitle row">
				<h1 class="col-xs-offset-0 col-xs-12 col-sm-offset-1 col-sm-10">
					Your <a><c:out value="${training.weekDay}"></c:out></a>'s Training
				</h1>
			</div>
			
			<div class="row" >
				
					<p id="updateHeader" style="display: block">
						
						<input id="trainingName"  class="form-control col-xs-offset-0 col-xs-12 col-sm-offset-1 col-sm-5"
							type="text" value="${training.trainingName}" /> 
						
						<select id="weekDay" class="form-control col-xs-offset-0 col-xs-8 col-sm-3" ></select>
						
						<button class="btnSet btn col-xs-4 col-sm-2" onclick="getTraining()">Set</button>
					</p>
				
				</div>
		
				<p class="row" id="displayHeader" style="display: none">
					
					<a  id="trainingNameDisplayed"  class="col-xs-offset-1 col-xs-10 col-sm-6">			
						<c:out value="${training.trainingName}"></c:out>
					</a> 
					
					<a id="weekDayDisplayed"	class="col-xs-offset-0 col-xs-6 col-md-3">
						<c:out value="${training.weekDay}"></c:out>
					</a>
					<button class="btnUpdate " onclick="getTraining()">Update</button>
				</p>
				
			</div>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div class="container">
			<div class="row" id="newExerciseNameInput">
				<input id="newExeName" class="form-control col-xs-offset-0 col-xs-12 col-sm-offset-1 col-sm-6" type="text" placeholder="Please enter exercise name" />
				<button class="btnNewExeName btn col-xs-offset-0 col-xs-12 col-sm-offset-0 col-sm-4" 
						onclick="saveNewExerciseNameToDatabases()">Add New Exercise Name
				</button>
			</div>
		</div>
	</sec:authorize>
	
		<div id="presentTable" class="container"></div>
	
		<div id="presentTraining" class="container"></div>
	
		<div class="container">
			<div class="row">
			
				<div class="editTraining col-xs-offset-0 col-xs-5" >
						<button class="editTrainingButton btn "
							onclick="addExercise();">Edit Training</button>
					</div>
				<div class="saveTraining col-xs-offset-0 col-xs-5"  >
						<button class="saveTrainingButton  btn"
							onclick="saveTrainingToDatabases()">Save Training</button>
				</div>
		
			</div>
		</div>
	
		<div class="container">
			<div class="goBackLink row">
				<sec:authorize access="isAuthenticated()">
					<p class="goBack col-xs-offset-1 col-xs-10">
						<a href="<c:url value='/showUsersTrainings'/>">Go back</a>
					</p>
				</sec:authorize>
			</div>
		</div>
	
	
		<p id="trainingReceived" style="display: none">
			<c:out value="${json}">	</c:out>
		</p>
		<p id="exeNamesReceived" style="display: none">
			<c:out value="${names}"></c:out>
		</p>
	
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/static/scripts/displayWorking.js"></script>
		<script type="text/javascript"
			src="${pageContext.request.contextPath}/static/scripts/changePos11.js"></script>
	
</div>


















