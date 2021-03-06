

// list of exercises recived from database
var ListOfExercesesNames = [];


function defineVaraibles(ListOfExe){
	ListOfExercesesNames = ListOfExe;
	
	
//	tableNu++;
	
//	// test to remove
//	if(ListOfExercesesNames.undefined){
////		alert("ListOfExercesesNames length is undefined");
//	}else{
////		alert("ListOfExercesesNames length is defined" + ListOfExercesesNames.length);
//	}


}





function presentExercise(tableNum, exercise) {	
	
	var tableID = "";
	if(exercise != null){
		var num = tableNum++;
		tableID = "tab" + num;
	}else{
		tableID = "tab" + tableNum;
	}	
	
	//create table exercise
	var formTable = document.createElement("div"); 
	formTable.setAttribute("class", "row");
	
	var myTable = document.createElement("table");
	myTable.setAttribute("id", tableID);
	myTable.setAttribute("class", "tableExe col-sm-offset-1 col-sm-10");
	
	var exerciseNameRow = document.createElement("tr");

	
	var exerciseId = document.createElement("td");
	exerciseId.setAttribute("id", "prt1");
	if(exercise != null){
		exerciseId.innerHTML = tableNum + ". ";
	}else{
		exerciseId.innerHTML = tableNum + ". ";
	}	
	exerciseNameRow.appendChild(exerciseId);
	
	
	var exerciseName = document.createElement("td");
	exerciseName.setAttribute("colspan", "2");
	exerciseName.setAttribute("id", "prt2");	
	var exeName = document.createElement("select");
	exeName.setAttribute("class", "sel form-control");

	for ( var a = 0; a < ListOfExercesesNames.length; a++) {
		var elemSeleList = document.createElement("option");
		var name = ListOfExercesesNames[a];
		
		if((exercise != null) && (name == exercise.nameOfExercise) ){
			//alert("exercise is now " + exercise.nameOfExercise + " and name is " + name);
			elemSeleList.innerHTML = exercise.nameOfExercise;
			elemSeleList.setAttribute("value", exercise.nameOfExercise);
			elemSeleList.setAttribute("selected", "selected")
		}else{
			elemSeleList.innerHTML = name;
			elemSeleList.setAttribute("value", name);			
		}		
		exeName.appendChild(elemSeleList);
	}
	exerciseName.appendChild(exeName);
	exerciseNameRow.appendChild(exerciseName);

	
	
	var exerciseCancelButton = document.createElement("td");
	exerciseCancelButton.setAttribute("id", "prt3");
	var button = document.createElement("input");
	button.setAttribute("type", "button");
	button.setAttribute("id", "butR" + tableID);
	button.setAttribute("onclick", "remove(id)");
	button.setAttribute("value", "x");
	button.setAttribute("class", "Del btn");
	exerciseCancelButton.appendChild(button);
	exerciseNameRow.appendChild(exerciseCancelButton);

	
	
	
	var addExerciseButton = document.createElement("td");
	addExerciseButton.setAttribute("id", "prt4");
	var button2 = document.createElement("input");
	button2.setAttribute("type", "button");
	button2.setAttribute("id", "butA" + tableID);
	button2.setAttribute("onclick", "addExerciseInTheMiddle(id)");
	button2.setAttribute("value", "Add Exercise");
	button2.setAttribute("class", "Add btn");
	addExerciseButton.appendChild(button2);
	exerciseNameRow.appendChild(addExerciseButton);
	
	
//	// test
//	var idDisplay = document.createElement("td");	
//	var idD = document.createElement("a");
//	idD.innerHTML = tableID + ". ---- ";
//	idDisplay.appendChild(idD);
//	exerciseNameRow.appendChild(idDisplay);
//	// end of test	
	
	
	myTable.appendChild(exerciseNameRow);
	
	var setsExercise = [1];
	if(exercise != null){
		setsExercise = exercise.sets;		
	}	
	
	for(var i = 0; i < setsExercise.length; i++){
		var num = 1 + i;
		var set = setsExercise[i];
		createSetsRow(myTable, (tableNum + "" + num), set);
	}
	
	element = document.getElementById("presentTable");
	element.appendChild(myTable);	
}




function createSetsRow(myTable, tableNum, set) {
	
	//alert("tableNum " + tableNum);	
	
	var numId = parseInt(tableNum.substring(1, 2));	
	//alert("numId is " + numId);	
	var numExe = "exe" + tableNum;	
	//alert("numExe is " + numExe);
	
	
	// new set row is created
	var row = document.createElement("tr");
	row.setAttribute("id", numExe);
	
	
	// Id column
	var setNo = document.createElement("td");
	setNo.setAttribute("id", "prt7");
	setNo.innerHTML = "" + numId + ".";
	row.appendChild(setNo);
	
	
	// reps column
	var nodeReps = document.createElement("td");
	nodeReps.setAttribute("id", "prt6");
	var reps = document.createElement("select");
	reps.setAttribute("class", "form-control");
	
	for ( var a = 0; a < 50; a++) {
		var elemSeleList = document.createElement("option");
		
		if((set != null) && (a == set.reps) ){
			//alert("reps is now " + set.reps + " and a is " + a);
			elemSeleList.innerHTML = set.reps;
			elemSeleList.setAttribute("value", a);
			elemSeleList.setAttribute("selected", "selected")
		}else{
			elemSeleList.innerHTML = a;
			elemSeleList.setAttribute("value", a);			
		}		
		reps.appendChild(elemSeleList);
	}
	nodeReps.appendChild(reps);
	row.appendChild(nodeReps);
	
	
	// weight column
	var nodeWeight = document.createElement("td");
	nodeWeight.setAttribute("id", "prt5");
	var weight = document.createElement("select");	
	weight.setAttribute("class", "form-control");
	for ( var a = 0; a < 50; a += 1.25) {		
		var elemSeleList = document.createElement("option");		
		
		if((set != null) && (a == set.weight) ){
			//alert("weight is now " + set.weight + " and a is " + a);
			elemSeleList.innerHTML = set.weight;
			elemSeleList.setAttribute("value", a);
			elemSeleList.setAttribute("selected", "selected")
		}else{
			elemSeleList.innerHTML = a;
			elemSeleList.setAttribute("value", a);			
		}	
		weight.appendChild(elemSeleList);
	}
	nodeWeight.appendChild(weight);
	row.appendChild(nodeWeight);
	
	
	// button remove column
	var nodeButton = document.createElement("td");
	nodeButton.setAttribute("id", "prt3");
	var button = document.createElement("input");
	button.setAttribute("type", "button");
	button.setAttribute("id", numExe);
	button.setAttribute("onclick", "remove(id)");
	button.setAttribute("value", "x");
	button.setAttribute("class", "Del btn");
	nodeButton.appendChild(button);
	row.appendChild(nodeButton);

	
	// button add column
	var addSetButton = document.createElement("td");
	addSetButton.setAttribute("id", "prt4");
	var button2 = document.createElement("input");
	button2.setAttribute("type", "button");
	button2.setAttribute("id", numExe);
	button2.setAttribute("onclick", "createRow(id)");
	button2.setAttribute("value", "Add Set");
	button2.setAttribute("class", "Add btn");
	addSetButton.appendChild(button2);
	row.appendChild(addSetButton);

	
//	// id for testing
//	var idDisplay = document.createElement("td");
//	var idD = document.createElement("a");
//	idD.innerHTML = numExe + ". ---- ";
//	idDisplay.appendChild(idD);
//	row.appendChild(idDisplay);
//	// end of test
	
	// whole row is appended
	myTable.appendChild(row);
};
















function addExerciseInTheMiddle(numMid) {
	
	var tIA = document.getElementById(numMid);

	var tDA = tIA.parentNode;
	var tRA = tDA.parentNode;
	var tBA = tRA.parentNode;
	var parent = tBA.parentNode;

	var tabId = 1 + parseInt(tBA.id.substring(3, 5));

	var tabToChange = "tab"+tabId;
	
	//alert("new id is " + tabId + " and tabToChange " + tabToChange);
	
	var previousTagId = tabId - 1;
//	var previousTag = document.getElementById("tab" + previousTagId);
	
	var elements = parent.getElementsByTagName("TABLE");

	var length = elements.length;
//	var agrToRemove = parseInt(length) - parseInt(previousTagId);

	var currentTab = tabId;

	
	if (length > previousTagId) {

		//alert("wstawiam w srodku " + tabId);
		
		var exercises = [];

		for ( var i = previousTagId; i < length; i++) {

			var testTag = document.getElementById("tab" + tabId);

			if (testTag != undefined) {
				var temp = testTag;
				exercises.push(temp);
				testTag.parentNode.removeChild(testTag);
			}
			tabId++;
		}
		
		presentExercise(currentTab);

		for ( var i = 0; i < exercises.length; i++) {

			var temp = exercises[i];

			var nextTabId = i + 1 + parseInt(currentTab);
			temp.setAttribute("id", "tab" + nextTabId);

			var row = temp.firstChild;
			var datas = row.getElementsByTagName("TD");
			var label1 = datas[0];
			label1.innerHTML = nextTabId + ". ";

			var buttonR = datas[2];
			buttonR.firstChild.setAttribute("id", "butR" + "tab" + nextTabId);

			var buttonA = datas[3];
			buttonA.firstChild.setAttribute("id", "butA" + "tab" + nextTabId);

//			var label2 = datas[4];
//			label2.firstChild.innerHTML = " tab" + nextTabId + ".......";

			parent.appendChild(temp);

			var tabAddedCheck = document.getElementById("tab" + nextTabId);
			row2 = tabAddedCheck.firstChild;
			data2 = row2.childNodes;
		}
	} else {		
		presentExercise(tabId);
	}	
	adt(tabToChange);
}






function remove(id) {

	var elementToRemove = document.getElementById(id);
	var ns = "";
	
	//extracting from DOM exercise to remove
	if (id.length == 8) {
		var tIA = document.getElementById(id);
		var tDA = tIA.parentNode;
		var tRA = tDA.parentNode;
		elementToRemove = tRA.parentNode;

		// jesli to ostatni element to usuwamy
		if (elementToRemove.nextSibling == null) {
			ns = elementToRemove;
		} else {
			ns = elementToRemove.nextSibling;
		}
		// removing exercise
		elementToRemove.parentNode.removeChild(elementToRemove);
	
	} else {
		elementToRemove = document.getElementById(id);
		if (elementToRemove.nextSibling == null) {
			ns = elementToRemove;
		} else {
			ns = elementToRemove.nextSibling;
		}
		elementToRemove.parentNode.removeChild(elementToRemove);
	}		
	var nsid = ns.id;	
	var r = "r";		
	adt(nsid, r);
}





function createRow(id) {

	//	var numId = 0;
	//alert("clicked id is " + id);
	
	var rowId = parseInt((id.substring(3, 5)).substring(1, 2));
	var tId = (id.substring(3, 5)).substring(0, 1);
	
	//alert("table id is " + tId + " and rowId " + rowId);
	
	var nextRowId  = rowId + 1;
	
//	nextRowId = tId + "" + nextRowId;

	// // extract parent node
	var tIA = document.getElementById(id);
	var myTable = tIA.parentNode;

	var setsRows = myTable.getElementsByTagName("TR");
	var length = setsRows.length - 1;

	//alert("there is " + length + " sets");	
	//var tableNum = parseInt((myTable.id).substring(3, 5));
	//nextRowId = tableNum + "" + nextRowId;

	var currentTab =  tId + nextRowId;

	//alert("next id is " + nextRowId);
	
	if (length > rowId) {

		//alert("wstawiam W srodku " + nextRowId);
		
		var sets = [];
		
		var testTag = null;
		
		for ( var i = rowId; i < length; i++) {
			
			//alert("in loop " + i);
			
			testTag = document.getElementById("exe" + tId + nextRowId);
			
			var datas = testTag.getElementsByTagName("TD");
			
			//alert(i + " testTag id is " + datas[0].innerHTML);
			
			
			if (testTag != undefined) {
				
				var temp = testTag;
				
				sets.push(temp);
				
				//alert("zachowuje " + temp);
				
				testTag.parentNode.removeChild(testTag);
				
				temp = null;
				
				nextRowId++;
			
			}else{
				//alert("new nextRowId is unddefined");
			}
			
			
//			nextRowId++;
			
			//alert("new nextRowId is " + nextRowId);
		}
		
		//alert("xachowane");
		
		//alert("currentTab is " + currentTab);
		
		createSetsRow(myTable, currentTab);

		//alert("dalej");
		
		
		for ( var i = 0; i < sets.length; i++) {

			var temp = sets[i];
			var nextTabId = i + 1 + parseInt(currentTab);
			temp.setAttribute("id", "exe" + nextTabId);
			var datas = temp.getElementsByTagName("TD");
			var num = "" + nextTabId;
			datas[0].innerHTML = "" + num.substring(1, 2);
			datas[3].firstChild.setAttribute("id", "exe" + nextTabId);
			//datas[4].firstChild.setAttribute("id", "exe" + nextTabId);
			myTable.appendChild(temp);
		}

	} else {
		//alert("wstawiam na koncu " + myTable + " ang " + currentTab);
		createSetsRow(myTable, currentTab);
		//alert("wstawilem na koncu " + currentTab);
	}
	
	adt(id);
};











// this function will keep id numbers in the right order
function adt(id , r) {
	
	var n = 0;		
	var tableNu = parseInt(id.substring(3, 4)); // test to remove
	
	// here we get all elements from this div
	var idNode = document.getElementById(id);
	//alert("idNode is " + idNode.nodeName);
	var idTag = idNode.nodeName;
	var div = idNode.parentNode;
	var elements = div.getElementsByTagName(idTag);
	
	if(r == "r"){
		tableNu--;
	}
	var i = tableNu;
	if( i > 0){
		i--;
	}
	
	if (idTag == "TABLE") {		
		
		for ( i; i < elements.length; i++) {

			//alert("in the loop with " + i);
			var elem = elements[i];
			

			n = parseInt(i) + 1;

			
			elem.setAttribute("id", "tab" + n);

			var row = elem.firstChild;
			var datas = row.getElementsByTagName("TD");

			//alert(" datas is  " + datas.length);
			
			var label1 = datas[0];
			//alert(" label1 is  " + n);
			
			label1.innerHTML = n + "-";
			
			
			var buttonR = datas[2];
			buttonR.firstChild.setAttribute("id", "butR" + "tab" + n);
			
			//alert(" still in the loop with 3 " + n);
			
			var buttonA = datas[3];
			buttonA.firstChild.setAttribute("id", "butA" + "tab" + n);
			
			
//			var label2 = datas[4];
//			label2.firstChild.innerHTML = " tab" + n + ".......";

			//alert(" still in the loop with 4 " + i);
			
			var rows = elem.getElementsByTagName("TR");

			
			
			//alert("there is sets " + rows.length + " in this exercise");
			
			
			
			for(var j = 1; j < rows.length; j++ ){
				//alert("set id: " + rows[j].firstChild.innerHTML);
				
				var exeId = n + "" + j;
				
				//alert("new exeId " + exeId);
				
				var sets = rows[j];
				// setting proper id num on display
				var data1 = sets.getElementsByTagName("TD");
				//alert("set has  " + data1.length + " elements");
				
				
				sets.setAttribute("id", "exe" + exeId);//			
				data1[0].innerHTML = "" + j + "$";
				data1[3].firstChild.setAttribute("id", "exe" + exeId);
				data1[4].firstChild.setAttribute("id", "exe" + exeId);
//				data1[5].firstChild.innerHTML = "exe" + exeId + ". ^^^^ ";
			}
			
			//alert("end with set " + n);
			
		}

	} else if (idTag == "TR") {
		
		for ( var i = 1; i < elements.length; i++) {
			var elem = elements[i];
			var tabId = (id.substring(3, 5)).substring(0, 1);

			// setting proper id num on display
			var datas = elem.getElementsByTagName("TD");

			elem.setAttribute("id", "exe" + tabId + i);//			
			datas[0].innerHTML = "" + i + "";
			datas[3].firstChild.setAttribute("id", "exe" + tabId + i);
			datas[4].firstChild.setAttribute("id", "exe" + tabId + i);
			//datas[5].firstChild.innerHTML = "exe" + tabId + i + ". **** ";
		}
	}
}






