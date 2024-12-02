let userUID = localStorage.getItem('userUID');
if (userUID != null) {
    document.getElementById("userUID").value = userUID;
} else {
    localStorage.setItem('userUID', document.getElementById("userUID").value);
}

// default Camera selection  
const url = window.location.href;
const urlObj = new URL(url);
const params = new URLSearchParams(urlObj.search);
const paramValue = params.get('selectedCamera') || "FHAZ";



// Send photos request if select option changes
const photoReqForm = document.getElementById('photoReq');
const selectElement = document.getElementById('selectedCameraSelect');
const selectedCameraInput = document.getElementById('selectedCamera');
selectElement.addEventListener('change', function() {
    selectedCameraInput.value = selectElement.value;
    photoReqForm.submit()
});




// Check for Enter press for sol input field
const inputField = document.getElementById('sol');
inputField.addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        event.preventDefault();
        photoReqForm.submit();
    }
});

        // document.addEventListener('DOMContentLoaded', function() {
            
        //     document.addEventListener('click', function(event) {
        //       if (!inputField.contains(event.relatedTarget)){
        //           photoReqForm.submit();
        //         }
        //     });
        // });

