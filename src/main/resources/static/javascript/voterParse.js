sendFile = () => {
	const file = document.getElementById('voter-file').files[0];
	
	const formData = new FormData();
	formData.append('myFile', file);
	
	fetch("/votemanager/parseVoter", {
		method: "POST",
		header: {},
		body: formData
	}).catch(error => {
		console.log(error);
	}).then(response => {
		
	});
}	