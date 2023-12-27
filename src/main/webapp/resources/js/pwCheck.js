let pwd1 = document.getElementsByClassName('pwd1')[0];
let pwd2 = document.getElementsByClassName('pwd2')[0];

let h6 = document.getElementsByTagName('h6');

pwd2.onblur = () => {
	if(pwd1.value != pwd2.value) {
		h6[2].innerHTML = '입력값이 일치하지 않습니다';
		h6[2].style.color = 'red';
		
		pwd1.focus();
		pwd2.value = '';
	}
	else {
		h6[2].innerHTML = '';
	}
}