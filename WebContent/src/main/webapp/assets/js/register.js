/**
 * 
 */

function validateform() {
	var username = document.forms["Menu"]["username"];
	var email = document.forms["Menu"]["email"];
	var password = document.forms["Menu"]["password"];
	var repassword = document.forms["Menu"]["repassword"]
	var err = document.getElementById("err");
	var mess = "";
	//Kiểm tra thông tin
	if (username.value == "" || email.value == "" || password.value == "" || repassword.value == "") {
		mess = "Vui long nhap day du thong tin";
		err.innerHTML = mess;
		if(username.value == ""){
			username.style.borderColor = "red";
		}else {
			username.style.borderColor ="lightgray";
		}
		if(email.value == ""){
			email.style.borderColor = "red";
		}else {
			email.style.borderColor ="lightgray";
		}
		if(password.value == ""){
			password.style.borderColor = "red";
		}else {
			password.style.borderColor ="lightgray";
		}
		if(repassword.value == ""){
			repassword.style.borderColor = "red";
		}else {
			repassword.style.borderColor ="lightgray";
		}
		
		return false;
	}
	else if (password.value != repassword.value) {
		repassword.style.borderColor = "red";
		mess = "Mat khau khong trung khop";
		err.innerHTML = mess;
		return false;
	}
}
