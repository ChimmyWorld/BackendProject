let nick = document.getElementsByName('nick')[0];

nick.onblur = () => {
	fetch(url + 'Nick?nick=' + nick.value, {method: 'GET'})
	.then(response => response.json())
	.then(data => {
		if(data.nick != null) {
			h6[3].innerHTML = '이미 사용되고 있는 닉네임입니다.';
			h6[3].style.color = 'red';
			
			nick.value = '';
			nick.focus();
		}
		else {
			h6[3].innerHTML = '';
		}
	})
}