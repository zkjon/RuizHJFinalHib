function comprobarCorreo() {

    fetch('AjaxController', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `email=${document.getElementById('email').value}&accion=comprobarCorreo`
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                showAlert('Correo disponible', true);
                document.getElementById("submit").classList.remove("disabled");
            } else {
                showAlert('Correo no disponible', false);
                document.getElementById("submit").classList.add("disabled");
            }
        })
        .catch(error => console.error('Error:', error));
}
function showAlert(message, isSuccess) {
    let alertContainer = document.getElementById("alert-container");
    alertContainer.innerHTML = "";
    let alertElement = document.createElement("div");

    if (isSuccess) {
        alertElement.classList.add("alert", "alert-success");
    } else {
        alertElement.classList.add("alert", "alert-danger");
    }
    alertElement.role = "alert";
    alertElement.innerHTML = message;

    alertContainer.appendChild(alertElement);

    setTimeout(function() {
        alertElement.classList.add("fade");
        function hide() {
            alertElement.classList.add("hide");
            alertContainer.innerHTML = "";
        }
    }, 5000);
}