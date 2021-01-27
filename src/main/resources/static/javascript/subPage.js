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

changeStatus = (index, voteStateCd, voteSeq) => {

	alert(index + " || " + voteStateCd + "||" + voteSeq + "승인하시겠습니까?");
	
	let statusText = document.getElementById("statusText_" + index);
	let buttonShow = document.getElementById("appApprove_" + index);
	
	const formData = new FormData();
	formData.append("voteSeq", voteSeq);
	formData.append("code", "02");
	
	
	if(voteStateCd == "01"){
		statusText.innerHTML = "이용신청서 승인 완료";
		
		fetch("/sysadmin/statusCode", {
			method: "POST",
			header: {},
			body: formData
		}).then(response => {
			location.reload();
		}).catch(error => {
			console.log(error);
		});
		
		buttonShow.style.display = "none";
		
	}else{
		statusText.innerHTML = "dsfd";
	}
}

mymy = () =>{
	alert('sdfds');
}



