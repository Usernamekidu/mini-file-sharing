$(document).ready(function () {
    // Get the modal
    var modal_log = document.getElementById('login_form');
    var modal_reg = document.getElementById('register_form');

    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target == modal_log || event.target == modal_reg) {
            modal_log.style.display = "none";
            modal_reg.style.display = "none";
        }
    };
});