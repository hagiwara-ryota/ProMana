document.getElementById('add-form-btn').addEventListener('click', function() {
	// Clone the existing form
	const existingForm = document.getElementById('form-block');
	const clonedForm = existingForm.cloneNode(true);

	// Clear values in the cloned form
	clonedForm.querySelectorAll('input').forEach(function(input) {
		input.value = '';
	});

	// Add delete button to the cloned form
	const deleteButton = document.createElement('button');
	deleteButton.type = 'button';
	deleteButton.classList.add('btn', 'btn-danger', 'ml-2');
	deleteButton.textContent = '削除';
	deleteButton.addEventListener('click', function() {
		// Remove the cloned form when the delete button is clicked
		clonedForm.parentNode.removeChild(clonedForm);
	});

	// Append the delete button to the cloned form
	clonedForm.appendChild(deleteButton);

	// Append the cloned form below the existing form
	document.querySelector('.container').appendChild(clonedForm);
});