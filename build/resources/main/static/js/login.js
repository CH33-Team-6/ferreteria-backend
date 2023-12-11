const btnEnviar = document.querySelector("#btnEnviar");

btnEnviar.addEventListener("click", function (event) {
  event.preventDefault();
  const emailElement = document.getElementById("exampleInputEmail1");
  const contraseñaElement = document.getElementById("exampleInputPassword1");
  // const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];

  const body = {
    email: emailElement.value,
    password: contraseñaElement.value,
  };

  fetch("https://preciojusto.onrender.com/api/login/", {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(body),
  })
    .then((response) => response.json())
    .then((result) => {
      sessionStorage.setItem("accessToken", result.accessToken);
      sessionStorage.setItem("username", body.email)
      showAlert("success", `Bienvenido ${body.email.split("@")}`);

      // Redirige después de mostrar la alerta
      setTimeout(function () {
        window.location.href = "./index.html";
      }, 2000);
    })
    .catch((error) => {
      console.log("error", error);
      showAlert("danger", "Usuario y/o contraseña incorrectos");
    });

});

//   const validUser = result.find(
//     (user) =>
//       user.usuario === emailElement.value &&
//       user.contraseña === contraseñaElement.value
//   );

//   if (!validUser) {
//     showAlert("danger", "Usuario y/o contraseña incorrectos");
//     return;
//   }

//showAlert("success", `Bienvenido ${validUser.nombre}`);
//localStorage.setItem("login_success", JSON.stringify(validUser));
//localStorage.setItem("sesionActiva", "true");
//localStorage.setItem("userName", validUser.nombre);

//   // Redirige después de mostrar la alerta
//   setTimeout(function () {
//     window.location.href = "./index.html";
//   }, 3000);

function showAlert(type, message) {
  const alertContainer = document.getElementById("alertContainer");
  const alertElement = document.createElement("div");
  alertElement.classList.add("alert", `alert-${type}`, "mt-3");
  alertElement.textContent = message;
  alertContainer.innerHTML = "";
  alertContainer.appendChild(alertElement);
}
