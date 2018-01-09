

var numId = 0; // represent index of rows
			
			// this will create form 
			function createElements(){			
				
				numId++; // index of rows
			
				var para = document.createElement("tr");
				para.setAttribute("id", numId);
				
				var node = document.createElement("td");
				para.appendChild(node);				
				
				var nodeReps = document.createElement("td");
				var reps = document.createElement("input");
				reps.setAttribute("type","text");
				reps.setAttribute("value","reps");
				nodeReps.appendChild(reps);			
				para.appendChild(nodeReps);
				
				var nodeWeight = document.createElement("td");
				var weight = document.createElement("input");
				weight.setAttribute("type","text");
				weight.setAttribute("value","weight");
				nodeWeight.appendChild(weight);			
				para.appendChild(nodeWeight);
				
				var nodeButton = document.createElement("td");
				var button = document.createElement("input");
				button.setAttribute("type","button");
				button.setAttribute("id", numId);
				button.setAttribute("onclick", "removeRow(id)");
				button.setAttribute("value","x");
				nodeButton.appendChild(button);				
				para.appendChild(nodeButton);
		
				var element = document.getElementById("mainTable");
				element.appendChild(para);
				
				addNumId();
			}
			
			// this function will keep nums in the right order
			function addNumId(){
				var table = document.getElementsByTagName('table')[0];			
					rows = table.getElementsByTagName('tr');			
					text = 'textContent' in document ? 'textContent' : 'innerText';			
					
					for (var i = 0; i < rows.length; i++){							
						rows[i].children[0][text] = (i + 1 + ".  ");
					}
			}
			// this function will remove selected row
			function removeRow(id){
			
				// clicked row has been identify
				var elem = document.getElementById(id);
					elem.parentNode.removeChild(elem); // removed from DOM
				
				//shift the numbers one down
				addNumId();
			}
			
			
			
			
			
			
			
			
			
			