document.addEventListener("DOMContentLoaded", function () {
    const nombreInput = document.getElementById("nombre");
    const apellidosInput = document.getElementById("apellidos");
    const dniInput = document.getElementById("dni");
    const passwordInput = document.getElementById("password");
    const password2Input = document.getElementById("password2");

    function validarTexto(input, maxLength) {
        const regex = /^[a-zA-ZáéíóúÁÉÍÓÚñÑ\s]+$/;
        if (!regex.test(input.value) || input.value.length > maxLength) {
            input.setCustomValidity(`Máximo ${maxLength} caracteres, solo letras y espacios permitidos.`);
        } else {
            input.setCustomValidity("");
        }
    }

    function calcularLetraDNI(numero) {
        const letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras[numero % 23];
    }

    nombreInput.addEventListener("input", function () {
        validarTexto(nombreInput, 30);
    });

    apellidosInput.addEventListener("input", function () {
        validarTexto(apellidosInput, 60);
    });

    dniInput.addEventListener("input", function () {
        let valor = dniInput.value.replace(/[^0-9A-Z]/gi, "");
        if (valor.length > 9) {
            valor = valor.substring(0, 9);
        }
        if (valor.length === 8) {
            valor += calcularLetraDNI(parseInt(valor));
        }
        dniInput.value = valor;
    });

    function validarContrasenas() {
        if (passwordInput.value.length < 3) {
            passwordInput.setCustomValidity("La contraseña debe tener al menos 3 caracteres y debe coincidir");
        } else if (passwordInput.value !== password2Input.value) {
            password2Input.setCustomValidity("Las contraseñas no coinciden");
        } else {
            passwordInput.setCustomValidity("");
            password2Input.setCustomValidity("");
        }
    }

    passwordInput.addEventListener("input", validarContrasenas);
    password2Input.addEventListener("input", validarContrasenas);
});
