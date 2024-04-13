const form = document.forms.namedItem("fileinfo");
form.addEventListener(
  "submit",
  (event) => {
    const output = document.querySelector("#output");
    const formData = new FormData(form);

    formData.append("CustomField", "This is some extra data");

    const request = new XMLHttpRequest();
    request.open("POST", "http://192.168.2.85:7501/shaft/api/servlet/esapi-servlet", false);
    request.onload = (progress) => {
      output.innerHTML =
        request.status === 200
          ? "Uploaded!"
          : `Error ${request.status} occurred when trying to upload your file.<br />`;
    };

    request.send(formData);
    event.preventDefault();
  },
  false
);


