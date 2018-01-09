
var tableNu = 0;

function createForm() {
//	tableNu++;
	presentExercise(1);
}

function presentExercise(tableNum) {

	alert("tableNum " + tableNum);

	var tableID = "tab" + tableNum;

	var myTable = document.createElement("table");
	myTable.setAttribute("id", tableID);

	var exerciseNameRow = document.createElement("tr");

	var exerciseId = document.createElement("td");
	exerciseId.innerHTML = tableNum + ". ";
	exerciseNameRow.appendChild(exerciseId);

	var exerciseName = document.createElement("td");
	exerciseName.innerHTML = "exercise name " + tableNum;
	exerciseName.setAttribute("colspan", "2");
	exerciseNameRow.appendChild(exerciseName);

	var exerciseCancelButton = document.createElement("td");
	var button = document.createElement("input");
	button.setAttribute("type", "button");
	button.setAttribute("id", "butR" + tableID);
	button.setAttribute("onclick", "remove(id)");
	button.setAttribute("value", "x");
	exerciseCancelButton.appendChild(button);
	exerciseNameRow.appendChild(exerciseCancelButton);

	var addExerciseButton = document.createElement("td");
	var button2 = document.createElement("input");
	button2.setAttribute("type", "button");
	button2.setAttribute("id", "butA" + tableID);
	button2.setAttribute("onclick", "addExerciseInTheMiddle(id)");
	button2.setAttribute("value", "Add Exercise");
	addExerciseButton.appendChild(button2);
	exerciseNameRow.appendChild(addExerciseButton);

	var idDisplay = document.createElement("td");
	var idD = document.createElement("a");
	idD.innerHTML = tableID + ". ---- ";
	idDisplay.appendChild(idD);
	exerciseNameRow.appendChild(idDisplay);

	myTable.appendChild(exerciseNameRow);

	// tableNum = tableNum + "" + 1;
	createElements(myTable, (tableNum + "" + 1));

	element = document.getElementById("presentTable");
	element.appendChild(myTable);

};

function addExerciseInTheMiddle(numMid) {

	alert("button pressed id is " + numMid);

	// // extract parent node
	var tIA = document.getElementById(numMid);

	// alert("tIA " + tIA.nodeName);
	var tDA = tIA.parentNode;
	// alert("tDA " + tDA.nodeName);
	var tRA = tDA.parentNode;
	alert("tRA " + tRA.firstChild.innerHTML);
	var tBA = tRA.parentNode;
	alert("this button belongs to  tabId  " + tBA.id);
	var parent = tBA.parentNode;
	alert("tDiv " + parent.id);

	// tDiv.firstChild;

	var tabId = 1 + parseInt(tBA.id.substring(3, 5));

	alert("Next table to be added is tab" + tabId);

	alert("next tabId is " + tabId); // test to remove

	// var testTag = document.getElementById("tab" + tabId);//

	var previousTagId = tabId - 1;
	var previousTag = document.getElementById("tab" + previousTagId);

	// var parent = previousTag.parentNode;

	// alert("previousTag is " + previousTag.id); // test to remove

	var elements = parent.getElementsByTagName("TABLE");
	// alert("there is " + elements.length + " tables"); // test to remove

	var length = elements.length;
	var agrToRemove = parseInt(length) - parseInt(previousTagId);

	alert(" length " + parseInt(length) + " - previousTagId "
			+ parseInt(previousTagId) + "there is " + agrToRemove
			+ " argument to  remove");

	var currentTab = tabId;

	if (length > previousTagId) {

		// alert("we are in the loop");
		var exercises = [];

		// remove selected elements from the DOM and put them into array
		for ( var i = previousTagId; i < length; i++) {

			var testTag = document.getElementById("tab" + tabId);

			if (testTag != undefined) {
				alert("jest tab " + tabId); // test to remove
				var temp = testTag;

				alert("push tab " + tabId); // test to remove
				exercises.push(temp);

				alert("remove " + tabId); // test to remove
				testTag.parentNode.removeChild(testTag);

			}
			tabId++;
			// alert("i is " + i + " and tabId " + tabId + " and currentTab is "
			// + currentTab); // test to remove
		}
		// add new exercise into selected place
		presentExercise(currentTab);

		alert("exercises.length to add back is " + exercises.length); // test
		// to
		// remove

		// bring back elements stored in the array and amend them accordingly
		for ( var i = 0; i < exercises.length; i++) {

			var temp = exercises[i];

			var nextTabId = i + 1 + parseInt(currentTab);
			temp.setAttribute("id", "tab" + nextTabId);
			alert("set new Id " + nextTabId);

			var row = temp.firstChild;
			var datas = row.getElementsByTagName("TD");
			//			 
			// alert("row has " + datas.length );
			//			 
			var label1 = datas[0];
			label1.innerHTML = nextTabId + ". -* ";

			var buttonR = datas[2];
			buttonR.firstChild.setAttribute("id", "butR" + "tab" + nextTabId);

			var buttonA = datas[3];
			buttonA.firstChild.setAttribute("id", "butA" + "tab" + nextTabId);

			var label2 = datas[4];
			label2.firstChild.innerHTML = " tab" + nextTabId + ". ---- ";

			// alert("label1 " + label1.innerHTML + " and buttonR " +
			// buttonR.firstChild.id +
			// " and buttonAdd " + buttonA.firstChild.id + " and label2 " +
			// label2.firstChild.innerHTML);

			// row = temp.firstChild;
			// data = row.childNodes;
			//			 
			// alert("label1 " + data[0].innerHTML + " and buttonR " +
			// data[2].firstChild.id +
			// " and buttonAdd " + data[3].firstChild.id + " and label2 " +
			// data[4].firstChild.innerHTML);
			//			 
			//			 

			//			 
			// alert("exercise Im adding now is " + "tab" + nextTabId );
			// alert("add exercise " + exercises[i].id );

			parent.appendChild(temp);

			// full check

			// var tabAdded = document.getElementById("tab" + nextTabId);
			// row1 = tabAdded.firstChild;
			// data1 = row1.childNodes;
			//			 
			//			 
			// var label1 = data1[0];
			// label1.innerHTML = nextTabId + ". -* ";
			//			 
			// var buttonR = data1[2];
			// buttonR.setAttribute("id", "butR" + "tab" + nextTabId);
			//			 
			// var buttonAdd = data1[3];
			// buttonAdd.setAttribute("id","butA" + "tab" + nextTabId);
			//			 
			// var label2 = data1[4];
			// label2.innerHTML = "tab" + nextTabId + ". ---- ";
			//			 

			var tabAddedCheck = document.getElementById("tab" + nextTabId);
			row2 = tabAddedCheck.firstChild;
			data2 = row2.childNodes;

			//			 
			alert("tab added label1 " + data2[0].innerHTML + " and buttonR "
					+ data2[2].firstChild.id + " and buttonAdd "
					+ data2[3].firstChild.id + " and label2 "
					+ data2[4].firstChild.innerHTML);
			//			 

			// alert("exercise added " + tabAddedCheck.id);
			// alert("exercise added a tag is " + label2.innerHTML);

		}

		alert("exercises array to length " + exercises.length);

	} else {
		alert("jest tylko " + length + " tables");
		presentExercise(tabId);
	}

}

function remove(id) {

	alert("remove " + id); // test to remove

	alert(" id length is " + id.length); // test to remove

	// tableNu = id.substring(3,5) ;

	alert("after num is " + tableNu); // test to remove

	var elementToRemove = document.getElementById(id);

	var ns = "";

	if (id.length == 8) {

		alert("remove table");

		// // extract parent node
		var tIA = document.getElementById(id);

		// alert("tIA " + tIA.nodeName);
		var tDA = tIA.parentNode;
		// alert("tDA " + tDA.nodeName);
		var tRA = tDA.parentNode;
		alert("tRA " + tRA.firstChild.innerHTML);

		elementToRemove = tRA.parentNode;
		alert("elementToRemove " + elementToRemove.id);

		// var parent = tBA.parentNode;
		// alert("tDiv " + parent.id);

		if (elementToRemove.nextSibling == null) {
			ns = elementToRemove;
			alert("no next sibling " + ns.id); // test to remove

		} else {
			ns = elementToRemove.nextSibling;
			alert("next sibling " + ns.id); // test to remove
		}

		elementToRemove.parentNode.removeChild(elementToRemove);

	} else {

		alert("remove row"); // test to remove
		elementToRemove = document.getElementById(id);

		if (elementToRemove.nextSibling == null) {
			ns = elementToRemove;
			alert("no next sibling " + ns.id); // test to remove

		} else {
			ns = elementToRemove.nextSibling;
			alert("next sibling " + ns.id); // test to remove
		}
		elementToRemove.parentNode.removeChild(elementToRemove); // removed
																	// from DOM
	}

	tableNu--;
	var nsid = ns.id;

	alert("removed nsid is " + nsid);
	adt(nsid);

}

function createElements(myTable, tableNum) {

	alert("tableNum " + tableNum);

	var numId = parseInt(tableNum.substring(1, 2));

	alert("numId " + numId);

	numId; // index of rows

	var numExe = "exe" + tableNum;

	alert("numExe " + numExe);

	var row = document.createElement("tr");
	row.setAttribute("id", numExe);

	// Id column
	var nodeId = document.createElement("td");
	nodeId.innerHTML = "......." + numId + ". ";
	row.appendChild(nodeId);

	// reps column
	var nodeReps = document.createElement("td");
	var reps = document.createElement("select");

	for ( var a = 0; a < 50; a++) {
		var elemSeleList = document.createElement("option");
		elemSeleList.innerHTML = a;
		elemSeleList.setAttribute("value", a);
		reps.appendChild(elemSeleList);
	}
	nodeReps.appendChild(reps);
	row.appendChild(nodeReps);

	// weight column
	var nodeWeight = document.createElement("td");
	var weight = document.createElement("select");

	for ( var a = 0; a < 50; a += 1.25) {
		var elemSeleList = document.createElement("option");
		elemSeleList.innerHTML = a;
		elemSeleList.setAttribute("value", a);
		weight.appendChild(elemSeleList);
	}
	nodeWeight.appendChild(weight);
	row.appendChild(nodeWeight);

	// button column
	var nodeButton = document.createElement("td");
	var button = document.createElement("input");
	button.setAttribute("type", "button");
	button.setAttribute("id", numExe);
	button.setAttribute("onclick", "remove(id)");
	button.setAttribute("value", "x");
	nodeButton.appendChild(button);
	row.appendChild(nodeButton);

	var addSetButton = document.createElement("td");
	var button2 = document.createElement("input");
	button2.setAttribute("type", "button");
	button2.setAttribute("id", numExe);
	button2.setAttribute("onclick", "createRow(id)");
	button2.setAttribute("value", "Add Set");
	addSetButton.appendChild(button2);
	row.appendChild(addSetButton);

	myTable.appendChild(row);
	// }
};


function createRow(id) {

	var numId = 0;

	alert("button pressed id is " + id);

	var rowId = (id.substring(3, 5)).substring(1, 2);
	alert("row num  " + rowId);

	var nextRowId = 1 + parseInt(rowId);

	alert("nextRowId num  " + nextRowId);

	// // extract parent node
	var tIA = document.getElementById(id);

	alert("tIA " + tIA.nodeName);
	var myTable = tIA.parentNode;

	var setsRows = myTable.getElementsByTagName("TR");
	var length = setsRows.length - 1;
	alert("there is " + length + " sets");

	var tableNum = parseInt((myTable.id).substring(3, 5));

	nextRowId = tableNum + "" + nextRowId;
	
	var currentTab = nextRowId;
	
	if (length > rowId) {

		
		alert("kreuje ze srodka ");
		var sets = [];
		for ( var i = rowId; i < length; i++) {
			
			var testTag = document.getElementById("exe" + nextRowId);
	
			if (testTag != undefined) {
				alert("jest exe " + nextRowId); // test to remove
				var temp = testTag;
	
				alert("push tab " + nextRowId); // test to remove
				sets.push(temp);
	
				alert("remove " + nextRowId); // test to remove
				testTag.parentNode.removeChild(testTag);
	
			}
			
			nextRowId++;
		}
		
		createElements(myTable, currentTab);
		
		
		for ( var i = 0; i < sets.length; i++) {
			
			var temp = sets[i];

			var nextTabId = i + 1 + parseInt(currentTab) ;
			
			alert("  huj i==  nextTabId -- " + nextTabId);
			
			alert(" stary row id " + temp.id);
			
			temp.setAttribute("id", "exe" + nextTabId);
			
			alert("set new Id " +  "exe" + nextTabId);

						 
			var datas = temp.getElementsByTagName("TD");

			

//			alert(" nowy row id " + "exe" + tabId + i);
			
			alert(" corrected row id " + temp.id);

			alert("datas " + datas.length);

			var num = "" + nextTabId;
			
			alert(num.substring(1, 2));
			
			datas[0].innerHTML = "..****" + num.substring(1, 2) + ". ";

			datas[3].firstChild.setAttribute("id", "exe" + nextTabId);

			datas[4].firstChild.setAttribute("id", "exe" + nextTabId);
			
			myTable.appendChild(temp);
		}
		
		
	
	} else {


		alert("kreuje z konca ");
//		alert("tDA " + tDA.nodeName);
		// var tRA = tDA.parentNode;
		// alert("tRA " + tRA.firstChild.innerHTML);
		// var tBA = tRA.parentNode;
		alert("this button belongs to  tabId  " + myTable.id);
		// var parent = tDA.parentNode;
		// alert("tDiv " + parent.id);

		// tDiv.firstChild;

		

		alert("Next row to be added is exe" + nextRowId);

		createElements(myTable, nextRowId);

		alert("Row created");
	}

	

};

function createRowInTheMiddle(id) {

	// extract row id
	var tIA = document.getElementById(id);
	var myTable = tIA.parentNode;

	var sets = myTable.getElementsByTagName("TR");

	alert("there is " + myTable.length + " sets");
}

function testId() {

	var elements = document.getElementsByTagName("TABLE");

	for ( var j = 0; j < elements.length; j++) {

		var table = elements[j];
		var row = table.firstChild;
		var data = row.childNodes;

		alert("test element id " + elements[j].id + " label1 "
				+ data[0].innerHTML + " and buttonR " + data[2].firstChild.id
				+ " and buttonAdd " + data[3].firstChild.id + " and label2 "
				+ data[4].firstChild.innerHTML);

	}

}



// this function will keep id numbers in the right order
function adt(id) {

	alert("oto " + id.substring(3, 5)); // test to remove

	tableNu = id.substring(3, 5); // test to remove

	// here we get all elements from this div
	var idNode = document.getElementById(id);
	var idTag = idNode.nodeName;
	var div = idNode.parentNode;
	var elements = div.getElementsByTagName(idTag);

	alert("tableNum " + tableNu + " there is " + elements.length
			+ " tables and tagName " + idTag); // test to remove
	// alert("jestem " + (idTag == "TABLE") + " TEGO");

	if (idTag == "TABLE") {

		// alert("jestem NOWY");

		for ( var i = 0; i < elements.length; i++) {

			alert("i " + i);

			// if(i > tableNum){

			var elem = elements[i];

			var nextTabId = i + 1;

			// alert(i + "jestem " + elem.id); //test to remove

			var nextElem = elements[i + 1];

			// alert(i + 1 + "jestem NOWY" + nextElem); //test to remove
			nextElem = elem;

			var n = i + 1;

			elem.setAttribute("id", "tab" + n);

			var row = elem.firstChild;
			var datas = row.getElementsByTagName("TD");

			var label1 = datas[0];
			label1.innerHTML = nextTabId + ". -** ";

			var buttonR = datas[2];
			buttonR.firstChild.setAttribute("id", "butR" + "tab" + nextTabId);

			var buttonA = datas[3];
			buttonA.firstChild.setAttribute("id", "butA" + "tab" + nextTabId);

			var label2 = datas[4];
			label2.firstChild.innerHTML = " tab" + nextTabId + ". **** ";

			// alert("after num is " + tableNu + " a elem " + elem.id);

		}

	} else if (idTag == "TR") {
		for ( var i = 1; i < elements.length; i++) {
			var elem = elements[i];
			// alert("id row " + elem.nodeName); //test to remove
			var tabId = (id.substring(3, 5)).substring(0, 1);
			// setting proper id num on display
			var datas = elem.getElementsByTagName("TD");

			alert(" stary row id " + elem.id);

			alert(" nowy row id " + "exe" + tabId + i);
			elem.setAttribute("id", "exe" + tabId + i);
			alert(" corrected row id " + elem.id);

			alert("datas " + datas.length);

			datas[0].innerHTML = "..****" + i + ". ";

			datas[3].firstChild.setAttribute("id", "exe" + tabId + i);

			datas[4].firstChild.setAttribute("id", "exe" + tabId + i);

			// row.innerHTML = "..****" + i + ". ";

		}
	}
	// tableNum = elements + 1;

}
