function movePage(url){
		location.href= url;
}


voteStatus = (index, voteStateCd, voteSeq) =>{
	alert("투표를 시작하시겠습니까?");
	
	const formData = new FormData();
	formData.append("voteSeq",voteSeq);
	
	if(voteStateCd == "02"){
		formData.append("code", "04");
		
		fetch("/votemanager/statusCode", {
			method: "POST",
			header: {},
			body: formData
		}).then(response => {
			location.reload();
		}).catch(error => {
			console.log(error);
		});
	}
	
}

document.addEventListener('DOMContentLoaded', () => {
	const voteBtnTitle = document.querySelector('#voteBtnTitle');
	
	const voteBtn = document.querySelector('#voteBtn');
	
	if(voteBtnTitle.innerText == "02") {
		voteBtnTitle.innerText = "투표 시작 전";
	}else if(voteBtnTitle.innerText == "04"){
		voteBtnTitle.innerText = " 투표 진행 중";
	}
	
	if(voteBtn.innerText == "이용신청서 승인 완료"){
		voteBtn.innerText = "투표 시작";
	}
	
});