let userid = document.getElementsByName('userid')[0];
const url = 'signUp/exist';

userid.onblur = () => {
	fetch(url + 'Id?userid=' + userid.value, {method: 'GET'})
	.then(response => response.json())
	.then(data => {
		if(data.userid != null) {
			h6[0].innerHTML = '이미 사용되고 있는 아이디입니다.';
			h6[0].style.color = 'red';
			
			userid.value = '';
			userid.focus();
		}
		else {
			h6[0].innerHTML = '';
		}
	})
}