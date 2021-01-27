btnChange = (seq) => {	
	let approveBtn = document.getElementById("approveBtn");
	let disapproveBtn = document.getElementById("disapproveBtn");
	let sendResultBtn = document.getElementById("sendResultBtn");
	
	if(seq == 1){
		approveBtn.style.backgroundColor = "red";
		disapproveBtn.style.backgroundColor = "";
		sendResultBtn.value = "찬성";
		
	}else if(seq == 2){
		disapproveBtn.style.backgroundColor = "red";
		approveBtn.style.backgroundColor = "";
		sendResultBtn.value = "반대";
	}
}