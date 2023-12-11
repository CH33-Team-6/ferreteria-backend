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
      console.log(result);
      sessionStorage.setItem("accessToken", result.accessToken);
      showAlert("success", `Bienvenido ${body.email}`);

      // Redirige después de mostrar la alerta
      setTimeout(function () {
        window.location.href = "./index.html";
      }, 3000);
    })
    .catch((error) => {
      console.log("error", error);
      showAlert("danger", "Usuario y/o contraseña incorrectos");
    });
  // const myHeaders = new Headers();
  // myHeaders.append("Content-Type", "application/json");

  // async function getData() {
  //   let raw = JSON.stringify({
  //     email: emailElement.value,
  //     password: contraseñaElement.value,
  //   });

  //   try {
  //     const response = await fetch("http://localhost:8080/api/login/", {
  //       method: "POST",
  //       headers: myHeaders,
  //       body: raw,
  //       redirect: "follow",
  //     });
  //     const result = await response.json();
  //     console.log(result);
  //     return result;
  //   } catch (error) {
  //     console.log("error", error);
  //     throw error; // Re-lanzar el error para que se maneje en el ámbito externo si es necesario
  // }
  // }
  // getData();
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

//   showAlert("success", `Bienvenido ${validUser.nombre}`);
//   localStorage.setItem("login_success", JSON.stringify(validUser));
//   localStorage.setItem("sesionActiva", "true");
//   localStorage.setItem("userName", validUser.nombre);

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
