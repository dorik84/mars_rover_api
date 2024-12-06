// let userId = localStorage.getItem('userId');
// if (userId == null || userId == '') {
//     localStorage.setItem('userId', document.getElementById("userId").value);
// } else {
//     document.getElementById("userId").value = userId;
// }

// document.getElementById("rememberMe").addEventListener('change', (event)=>{
//     if(!event.target.checked) {
//         localStorage.removeItem('userId')
//     }else {
//         localStorage.setItem('userId', document.getElementById("userId").value);
//     }
// })

// default Camera selection  
const url = window.location.href;
const urlObj = new URL(url);
const params = new URLSearchParams(urlObj.search);
const paramValue = params.get('selectedCamera') || "FHAZ";

// On Submit ui logic
const submitBtn = document.getElementById("submitButton");
const enableLoadingSpinner = () => {
    submitBtn.innerHTML=`<span class="spinner-border spinner-border-sm" aria-hidden="true"></span>`;
    submitBtn.innerHTML+=`<span role="status">Loading...</span>`
}

// Send request if select option changes
const photoReqForm = document.getElementById('photoReq');
const selectElement = document.getElementById('selectedCameraSelect');
const selectedCameraInput = document.getElementById('selectedCamera');
selectElement.addEventListener('change', function() {
    selectedCameraInput.value = selectElement.value;
    photoReqForm.submit();
    enableLoadingSpinner();
});




// Check for Enter press for sol input field
const inputField = document.getElementById('sol');
inputField.addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        event.preventDefault();
        photoReqForm.submit();
        enableLoadingSpinner();
    }
});



submitBtn.addEventListener('click',()=>{
    enableLoadingSpinner();
});
