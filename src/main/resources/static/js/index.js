
// if click on camrea buttons submit form to get new photos
const radioButtons = document.querySelectorAll('input[name="selectedCamera"]');
radioButtons.forEach(radioButton => {
  radioButton.addEventListener('change', () => {
    if (radioButton.checked) {
      document.getElementById('sendCameraName').submit();
    }
  });
});


// Select Camera button
const url = window.location.href;
const urlObj = new URL(url);
const params = new URLSearchParams(urlObj.search);
const paramValue = params.get('selectedCamera');
document.getElementById(paramValue).setAttribute('checked', 'checked');
