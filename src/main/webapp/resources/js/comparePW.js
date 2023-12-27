let pw = document.getElementsByName('jsfind')[0].value;
let expw = document.getElementsByClassName('expw')[0];

const url = 'pwCheck';

expw.onblur = () => {
	fetch(url + '?password=' + expw.value, {method: 'GET'})
	.then(response => response.text())
	.then(data => {
		console.log(data);
		
		if(pw == data) {
			h6[0].innerHTML = '';
		}
		else {
			h6[0].innerHTML = '등록한 패스워드와 일치하지 않습니다';
			h6[0].style.color = 'red';
			
			expw.value = '';
			expw.focus();
		}
	})
}