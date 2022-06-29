
	function validateForm() {
  var name = document.forms["signupform"]["fullname"].value;
  var email = document.forms["signupform"]["email"].value;
  var password = document.signupform.password.value;
  var cpassword = document.signupform.cpassword.value; 
  if (name="" || email == "" || password == "" || cpassword == "") {
    alert("Fields can't be empty!");
    return false;
  }
  else if (password != cpassword){
  	alert("Passwords do not match");
  	return false;
  }
}
