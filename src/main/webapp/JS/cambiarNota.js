function cambiarNota(event, alumnoId, moduloId) {
    const nuevaNota = event.target.value;

    fetch('AjaxController', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded',
        },
        body: `alumnoId=${alumnoId}&moduloId=${moduloId}&nuevaNota=${nuevaNota}&accion=modificarNota`
    })
        .then(response => response.json())
        .then(data => {
            if (data.success) {
                showAlert('Nota modificada con éxito', true);
            } else {
                showAlert('Hubo un problema al modificar la nota', false);
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
        alertElement.classList.add("hide");
    }, 5000);
}