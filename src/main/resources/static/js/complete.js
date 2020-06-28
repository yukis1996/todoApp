function complete(element, taskId, doLike) {

	const token = document.querySelector("meta[name='_csrf']").attributes['content'].value;
	const header = document.querySelector(
		"meta[name='_csrf_header']").attributes['content'].value;
	const bgColor = document.getElementById(taskId);
	let url = doLike ? "/tasks/complete" : "/tasks/incomplete";
	fetch(url, {
		method: 'POST',
		headers: {
			"Content-Type": 'application/x-www-form-urlencoded',
			[header]: token
		},
		body: `taskId=${taskId}`
	}).then(
		response => {
			if (doLike) {
				element.style.display = 'none';
				element.previousElementSibling.style.display = '';
				bgColor.style.backgroundColor = 'gray';
			} else {
				element.style.display = 'none';
				element.nextElementSibling.style.display = '';
				bgColor.style.backgroundColor = '';
			}
		}
	);
}