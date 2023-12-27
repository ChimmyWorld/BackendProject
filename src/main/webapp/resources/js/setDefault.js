 let button = document.getElementsByClassName('setDefault')[0]
	  let img = document.getElementsByTagName('img')[0]
	  let idx = document.getElementsByName('idx')[0].value
	  const url = '/project/myPage/info/' + idx
		  
	  button.onclick = () => {
			let data = {
					idx: idx
			};
			
			fetch(url, {
				method: 'PATCH',
				headers: {
					'Content-Type': 'application/json'
				},
				body: JSON.stringify(data)
			})
			.then(response => response.json())
			.then(data => {
				console.log(data);
				
				// row값이 1으로 반환되면 profile 태그를 
				// default.jpg'로 변경
				if (data === 1) {
					img.src = '/project/profileImg/default.jpg'
				}
			})
			
	  }