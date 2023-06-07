document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('consultation-form');

    form.addEventListener('submit', function (event) {
        event.preventDefault();
        if (validateForm()) {
            // Handle form submission
            alert('Form submitted successfully!');
        } else {
            alert('Please fill in all required fields.');
        }
    });

    function validateForm() {
        const inputs = form.querySelectorAll('input[required], textarea[required], select[required]');
        for (const input of inputs) {
            if (input.value === '') {
                return false;
            }
        }
        return true;
    }
    
    
});