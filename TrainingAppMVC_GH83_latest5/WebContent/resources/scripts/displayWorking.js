


// this is new training object to use
var training = {
	trainingName : "",
	weekDay : "",
	exercises : []
}




// this function displays and sets training name and weekday header 
function getTraining() {

	//alert("entering getTraining()");
	
	
	
	var z = document.getElementById('newExerciseNameInput');
	var y = document.getElementById('displayHeader');
	if (y.style.display === 'none') {
		y.style.display = 'block';		
	} else {
		y.style.display = 'none';		
	}
	var x = document.getElementById('updateHeader');
	if (x.style.display === 'block') {
		x.style.display = 'none';
		//z.style.display = 'none';
		//b1.setAttribute("disabled", true);
		//b2.setAttribute("disabled", false);
	} else {
		x.style.display = 'block';
		//z.style.display = 'block';
		
	}

	// setting training name
	training.trainingName = document.getElementById("trainingName").value;
	training.weekDay = document.getElementById("weekDay").value;
	
	//alert("trainingName value is " + training.trainingName);
	
	//alert("weekDay value is " + training.weekDay);
	
	// displaying training name
	document.getElementById("trainingNameDisplayed").innerHTML = training.trainingName;
	document.getElementById("weekDayDisplayed").innerHTML =  training.weekDay;
	document.getElementsByClassName("trainingTitle").innerHTML = ": " + training.weekDay;
	
	
}







// this method create object training
function addExercise() {
	
	//alert(" jestem is ");
	
	training.exercises = [];
	var divs = document.getElementById("presentTable");

	var tables = divs.getElementsByTagName('TABLE');

	for (var i = 0; i < tables.length; i++) {

		var rows = tables[i].getElementsByTagName('TR');
		var tabs = rows[0].getElementsByTagName('TD');

		//alert(" jestem is 2 ");//

		var exercise = {
			nameOfExercise : "",
			sets : []
		}

		exercise.nameOfExercise = tabs[1].firstChild.value;
		
		exeName = exercise.nameOfExercise;
		
		//alert(" nameOfExercise is " + exeName);
		
		var exeSets = exercise.sets;
		for (var j = 1; j < rows.length; j++) {

			var set = {};
			var items = rows[j].getElementsByTagName('td');
			var sN = items[0].innerHTML;

			set.setNo = parseFloat(items[0].innerHTML);			

			set.reps = parseFloat(items[1].firstChild.value);
			set.weight = parseFloat(items[2].firstChild.value);

			exeSets.push(cloneMessage(set));
		}
		training.exercises.push(exercise);

		exeName = "";
		exeSets = null;

		
	}
	//		
	display(); // test
	getTraining();
	
	// saveTrainingToDatabase();

}










//function ensure not adding inherited props
function cloneMessage(set) {
	var clone = {};
	for ( var key in set) {
		if (set.hasOwnProperty(key)) 
			clone[key] = set[key];
	}
	return clone;
}














// this method is only for displaying gathered data on the web // for testing
function display() {

	
	
	var x = document.getElementById('presentTable');
	if (x.style.display === 'none') {
		x.style.display = 'block';
		
	} else {
		x.style.display = 'none';		
	}

	var y = document.getElementById('presentTraining');
	if (y.style.display === 'block') {
		y.style.display = 'none';
	} else {
		y.style.display = 'block';
	}

	var train = document.getElementById("presentTraining");

	// reset table
	while (train.firstChild) {
		train.removeChild(train.firstChild);
	};

	var exes = training.exercises;
	var num = exes.length;

	
	var trainTablePresented = document.createElement("div");
	trainTablePresented.setAttribute("class", "row");
	
	
	
	for (var j = 0; j < num; j++) {
	
		//var exeNameHeader = document.createElement("p");
		
		
		
		var exeNameData = document.createElement("p");
		exeNameData.setAttribute("class", "col-xs-offset-1 col-xs-10");
		exeNameData.innerHTML = exes[j].nameOfExercise;
		
	
		trainTablePresented.appendChild(exeNameData);
	
		e = exes[j];
		
		var exeSetTable = document.createElement("table");
		exeSetTable.setAttribute("class", "col-xs-offset-1 col-xs-10");
		
		
		
		for (var i = 0; i < e.sets.length; i++) {
			
			
			
			var exeSetRow = document.createElement("tr");
			
			var exeSetNoData = document.createElement("td");		
			
			exeSetNoData.setAttribute("style", "text-align: left");
		
			exeSetNoData.innerHTML = e.sets[i].setNo + ".";
			exeSetRow.appendChild(exeSetNoData);
			
			var exeRepData = document.createElement("td");
			//exeRepData.setAttribute("width", "28%");
			exeRepData.innerHTML = e.sets[i].reps;
			exeSetRow.appendChild(exeRepData);
		
			var exeWeigthData = document.createElement("td");
			
			exeWeigthData.innerHTML = e.sets[i].weight;
			exeSetRow.appendChild(exeWeigthData);
			
			exeSetTable.appendChild(exeSetRow);
		}
	
		trainTablePresented.appendChild(exeSetTable);
		train.appendChild(trainTablePresented);
		
	}
	
	
	

	
//	for (var j = 0; j < num; j++) {
//
//		var exeName = document.createElement("p");
//		exeName.innerHTML = exes[j].nameOfExercise;
//		
//		//alert("exeName " + exes[j].nameOfExercise);
//		
//		train.appendChild(exeName);
//
//		e = exes[j];
////		n = e.sets.length;
//
//		list = document.createElement("ol");
//		train.appendChild(list);
//
//		for (var i = 0; i < e.sets.length; i++) {
//			linia = document.createElement("li");
//			linia.innerHTML = e.sets[i].reps + ",   " + e.sets[i].weight;
//			list.appendChild(linia);
//		}
//	}
//	// alert("training has " + training.exercises.length + " exercises");

	
	
}












var passTraining = function() {

	// alert("test dziala nowy");
	// alert("training 1 is  " + training.trainingName);
	 //alert("training 1 has " + training.exercises.length + " exercises");

	var train = training;
	// resetForm();
	// display(train); // test

	return train;

}













function resetForm() {

	// reset training object
	training.trainingName = "";
	training.weekDay = "";
	training.exercises = [];

	// reset form
	var myNode = document.getElementById("presentTable");	
	while (myNode.firstChild) {
		myNode.removeChild(myNode.firstChild);
	}
	
	// reset form
	var myNode = document.getElementById("presentTraining");
	while (myNode.firstChild) {
		myNode.removeChild(myNode.firstChild);
	}
	
}





