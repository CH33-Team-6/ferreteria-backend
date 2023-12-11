const nombreElement = document.getElementById("formGroupExampleInput");
const telefonoElement = document.getElementById("formGroupExampleInput2");
const emailElement = document.getElementById("exampleInputEmail1");
const contraseñaElement = document.getElementById("exampleInputPassword1");
const conContraseñaElement = document.getElementById("exampleInputPassword2");
const btnRegistrarElement = document.getElementById("examenpleBtnAgregar");
const alertValidaciones = document.getElementById("alertValidaciones");
const alertElement = document.getElementById("alert-red"); // Cambié el nombre de la variable
let usuarios = [];
alertElement.style.display = "none";

btnRegistrarElement.addEventListener("click", function (event) {
  event.preventDefault();
  let errores = [];
  let isValid = true;

  nombreElement.style.border = "";
  telefonoElement.style.border = "";
  emailElement.style.border = "";
  contraseñaElement.style.border = "";
  conContraseñaElement.style.border = "";

  if (nombreElement.value.length < 10) {
    errores.push("Por favor coloca tu nombre completo.");
    nombreElement.style.border = "solid thin red";
    isValid = false;
    nombreElement.style.border = "solid thin red";
  }

  if (!telefonoElement.value) {
    errores.push("El campo teléfono es requerido o está mal escrito.");
    telefonoElement.style.border = "solid thin red";
    isValid = false;
  }

  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  if (!emailRegex.test(emailElement.value)) {
    errores.push("El campo email es requerido o tiene un formato inadecuado.");
    emailElement.style.border = "solid thin red";
    isValid = false;
  }

  if (contraseñaElement.value.length < 6) {
    errores.push("La contraseña debe tener al menos 6 caracteres.");
    contraseñaElement.style.border = "solid thin red";
    isValid = false;
  }

  if (contraseñaElement.value !== conContraseñaElement.value) {
    alertElement.style.display = "block";
    alert("Las contraseñas no coinciden.");
    isValid = false;
  }
  if (errores.length > 0) {
    alertElement.style.display = "none";
    alertValidaciones.innerHTML = ""; // Limpiar mensajes anteriores

    for (let error of errores) {
      alertValidaciones.insertAdjacentHTML("beforeend", `<div>${error}</div>`);
    }
  }
  const body = {
    nombre: nombreElement.value,
    telefono: telefonoElement.value,
    email: emailElement.value,
    password: conContraseñaElement.value,
  };
  if (isValid) {
    fetch("https://preciojusto.onrender.com/api/usuarios/", {
      method: "POST",
      body: JSON.stringify(body),
    })
      .then((response) => response.json())
      .then((result) => {
        console.log(result);
        document.getElementById("alerta-enviado").style.display = "block";
        setTimeout(function () {
          document.getElementById("alerta-enviado").style.display = "none";
          window.location.href = "./login.html";
        }, 2000);
        nombreElement.value = "";
        telefonoElement.value = "";
        emailElement.value = "";
        conContraseñaElement.value = "";
        contraseñaElement.value = "";
      })
      .catch((error) => console.log("error", error));
    // usuarios.push(elemento);
    // localStorage.setItem("usuarios", JSON.stringify(usuarios));
  }
}); //btnRegistrar.addEventListener
