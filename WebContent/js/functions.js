function getElement(id) {
	return document.getElementById(id);
}

function validate() {
	if(checkUsername() && checkPass()) {
		return true;
	} else {
		return false;
	}
}

function checkUsername() {
	var name = getElement('form').username;
	if (name.value != "") {
		getElement('error').classList.add('is-hidden');
		name.classList.remove('is-danger');
		return true;
	} else {
		getElement('error').classList.remove('is-hidden');
		name.classList.add('is-danger');
		return false;
	}
}

function checkPass() {
	var pass = getElement('form').pass;
	if (pass.value != "") {
		getElement('errorPass').classList.add('is-hidden');
		pass.classList.remove('is-danger');
		return true;
	} else {
		getElement('errorPass').classList.remove('is-hidden');
		pass.classList.add('is-danger');
		return false;
	}
}