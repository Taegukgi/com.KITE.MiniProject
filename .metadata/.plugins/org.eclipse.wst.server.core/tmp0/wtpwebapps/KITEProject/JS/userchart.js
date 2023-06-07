document.addEventListener('DOMContentLoaded', function() {
  const nameInput = document.querySelector('input[type="text"]');

  nameInput.addEventListener('input', function() {
      console.log('Name input value changed:', this.value);
  });
});