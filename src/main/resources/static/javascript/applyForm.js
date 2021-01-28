window.addEventListener('load',function(){
	document.getElementById('main-form').addEventListener("submit", handleFormSubmit);
});

async function handleFormSubmit(event) {
	event.preventDefault();
	const form = event.currentTarget;
	const url = form.action;	
	try {
		const formData = new FormData(form);
		const responseData = await postFormDataAsJson({ url, formData });
		console.log({ responseData });
		
		alert(`아이디는 : ${responseData.managerId}\n 비번 : ${responseData.managerPw}\n 로그인하여 마이페이지에서 신청서 현황을 확인하세요.`);
		
		location.href="/";
	} catch (error) {
		console.error(error);
	}
}

async function postFormDataAsJson({ url, formData }) {
	const plainFormData = Object.fromEntries(formData.entries());
	const formDataJsonString = JSON.stringify(plainFormData);
	const fetchOptions = {
		method: "POST",
		headers: {
			"Content-Type": "application/json",
			Accept: "application/json",
		},
		body: formDataJsonString,
	};
	const response = await fetch(url, fetchOptions);
	if (!response.ok) {
		const errorMessage = await response.text();
		throw new Error(errorMessage);
	}
	
	return response.json();
}