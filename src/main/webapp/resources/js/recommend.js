const rowInt = document.querySelector('.rowInt').dataset.idx;

function showPoint() {
    Promise.all([goodCount(), badCount()])
    .then(([goodResult, badResult]) => {
        // goodResult 및 badResult가 유효한 숫자인지 확인합니다
        const good = parseFloat(goodResult);
        const bad = parseFloat(badResult);

        // good과 bad가 모두 유효한 숫자인지 확인합니다
        if (!isNaN(good) && !isNaN(bad)) {
            countPoint.innerHTML = good - bad;
        } else {
            // good 또는 bad 중 하나가 NaN인 경우 처리합니다
            countPoint.innerHTML = "Error: 유효하지 않은 카운트";
        }
    })
    .catch(error => {
        console.error("카운트 검색 중 오류 발생:", error);
        countPoint.innerHTML = "Error: 카운트 검색 실패";
    });
};

function goodCount() {
	return fetch(url + 'goodCount?board_idx=' + rowInt + '&good=1', {method: 'GET'})
	.then(response => response.text())
};

function badCount() {
	return fetch(url + 'badCount?board_idx=' + rowInt + '&good=2', {method: 'GET'})
	.then(response => response.text())
};

const url = 'recommend/';
let countPoint = document.getElementsByClassName('recCount')[0];
let recommender = document.getElementsByName('writer')[0].value;
var isCheck = 0;

showPoint();

const recommendButton = document.querySelectorAll('.recommend button');

// Add a click event listener to the recommend button
recommendButton[0].addEventListener('click', () => {
	if(recommender === '') {
		alert('로그인 한 유저만 추천 기능을 사용할 수 있습니다');
	}
	else{
        // Check if the button has the 'good' class
        const isGood = recommendButton[0].classList.contains('good');
        
        // Set isChecked based on the class presence
        const isCheck = isGood ? 1 : 0;

        // Fetch API to send the POST request
        fetch(url + 'recommendGood', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                board_idx: rowInt,
                recommender: recommender,
                isCheck: isCheck,
            }),
        })
        .then(response => response.json())
        .then(newSessionValue => {
        	if(newSessionValue === 1) {
        		recommendButton[0].classList.add('good');
        	}
        	if(newSessionValue === 2) {
        		recommendButton[0].classList.remove('good');
        	}
            showPoint();
        })
	}
});

recommendButton[1].addEventListener('click', () => {
	if(recommender === '') {
		alert('로그인 한 유저만 추천 기능을 사용할 수 있습니다');
	}
	else{
        // Check if the button has the 'good' class
        const isGood = recommendButton[1].classList.contains('bad');
        
        // Set isChecked based on the class presence
        const isCheck = isGood ? 2 : 0;

        // Fetch API to send the POST request
        fetch(url + 'recommendBad', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                board_idx: rowInt,
                recommender: recommender,
                isCheck: isCheck,
            }),
        })
        .then(response => response.json())
        .then(newSessionValue => {
        	if(newSessionValue === 1) {
        		recommendButton[1].classList.add('bad');
        	}
        	if(newSessionValue === 2) {
        		recommendButton[1].classList.remove('bad');
        	}
            showPoint();
        })
	}
});