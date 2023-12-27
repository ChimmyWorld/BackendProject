function editComment(idx) {
	let commentRow = document.getElementById('commentRow_' + idx);
    let editForm = document.getElementById('editForm_' + idx);
	
	commentRow.style.display = 'none';
	editForm.style.display = 'block';
}

function saveComment(idx) {
    // 수정된 내용을 서버로 전송하고, 화면에 반영
    let commentRow = document.getElementById('commentRow_' + idx);
    let editForm = document.getElementById('editForm_' + idx);
    let commentContent = commentRow.querySelector('.commentContent');
    let editTextArea = editForm.querySelector('.editTextArea');
    let num = idx;

    let data = {
        	idx: num,
	        contents: editTextArea.value
	};
    
    console.log(data);
    
    // 서버에 수정된 내용 전송하는 로직
    fetch('replyedit', {
    	method: 'POST', 
    	headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    })
    .then(response => response.json())
    .then(data)

    // 화면에 수정된 내용 반영
    commentContent.textContent = editTextArea.value;
    commentRow.style.display = 'block';
	editForm.style.display = 'none';
}

function cancelEdit(idx) {
	let commentRow = document.getElementById('commentRow_' + idx);
    let editForm = document.getElementById('editForm_' + idx);
	
	commentRow.style.display = 'block';
	editForm.style.display = 'none';
}