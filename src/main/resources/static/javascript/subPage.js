myFunction = (index) => {

		let subPage = document.getElementById("subPage");
			
		let subPageContext = document.getElementById("subPage_" + index);
		let detailButton = document.getElementById("appDetail_" + index);
		
		
		if (subPage.style.display === "none") {
			subPage.style.display = "block";
			subPageContext.style.display = "block";
			detailButton.style.backgroundColor = "#027BE4";
		} else {
			subPage.style.display = "none";
			subPageContext.style.display = "none";
			detailButton.style.backgroundColor = "white";
		}
}

changeStatus = (index, voteStateCd) => {

	alert(index + " || " + voteStateCd);
	
	let statusText = document.getElementById("statusText_" + index);
	
	if(voteStateCd == "01"){
		statusText.innerHTML = "접수";
	}else{
		statusText.innerHTML = "dsfd";
	}
}

mymy = () =>{
	alert('sdfds');
}



