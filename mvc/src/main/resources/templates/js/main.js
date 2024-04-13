(function ($) {

	"use strict";
	document.getElementById("uploadFile").addEventListener("click", function (event) {

		event.preventDefault();

		var radioButtons = document.getElementsByName("radioGroup");
		var key;

		radioButtons.forEach(element => {
			if (element.checked) {
				key = element
			}
		});

		// var formData = new FormData();
		// var fileInput = document.querySelector('input[type="file"]');
		var fileInput = document.getElementById('file');

		const file = fileInput.files[0];

		if (file) {
			convertFileToBase64(file);
		}

		// formData.append(key, fileInput.files[0], "file.java");


	});

}


)(jQuery);

function convertFileToBase64(file) {
	const reader = new FileReader();
	const fileName = file.name;

	reader.onloadend = function () {
		const base64File = reader.result;
		makeAPICall(base64File, fileName);
	};

	reader.readAsDataURL(file);
}


function makeAPICall(base64File, fileName) {
	const requestBody = {
		key: base64File,
		fileName: fileName
	};

	let options = {
		method: 'POST',
		headers: {
			"Access-Control-Allow-Headers": "Origin",
			"Content-Type": "application/json",
			"Access-Control-Allow-Headers": "Authorization",
			'Authorization': 'Basic YWRtaW46YWRtaW4=',
			"Origin": "http://127.0.0.1:5500"	
		},

		body: JSON.stringify(requestBody),
		credentials: "include"
	}

	fetch("http://192.168.2.204:7501/shaft/api/servlet/esapi-servlet", options)
		.then(response => response.json())
		.then(data => {
			window.alert("you will be redirected to the download page. Click ok.");
			window.location.href = data.statusUrl;
		})
		.catch(error => {
			console.error(error);
		});
}
