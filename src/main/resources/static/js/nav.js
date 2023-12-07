const navbar = document.querySelector("#nav");

const container = document.createElement("div");
const a = document.createElement("a");
const ul = document.createElement("ul");
const li = document.createElement("li");

container.className = "container-fluid";
navbar.appendChild(container);

li.className = "nav-item";
a.className = "navbar-brand";
a.href = "./index.html";
a.insertAdjacentHTML(
  "beforeend",
  `<img src="./assets/img/precio_justo.png" alt="logo precio justo" width= "250rem" height= "150rem">`
);
container.appendChild(a);

container.insertAdjacentHTML(
  "beforeend",
  `<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
<span class="navbar-toggler-icon"></span>
</button>`
);

const div2 = document.createElement("div");
div2.className = "collapse navbar-collapse";
div2.id = "navbarSupportedContent";
container.appendChild(div2);
div2.appendChild(ul);
ul.className = "navbar-nav me-auto mb-2 mb-lg-0";

ul.insertAdjacentHTML(
  "afterbegin",
  `<li class="nav-item dropdown" >
<a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
 Productos
</a> <!--Comienza menú de productos--> 
<ul class="dropdown-menu" style="text-align: center;">
<li><a class="dropdown-item" href="./productos.html">Ver ferreteria</a></li>
    </ul>`
);
ul.insertAdjacentHTML(
  "beforeend",
  `<li class="nav-item">
    <a class="nav-link" aria-current="page" href="./nuestraHistoria.html">Nuestra Historia</a>
</li>`
);
ul.insertAdjacentHTML(
  "beforeend",
  ` <li class="nav-item" >
<a class="nav-link" href="./contacto.html">Contacto</a>
</li>`
);
ul.insertAdjacentHTML(
  "beforeend",
  `<li class="nav-item" >
    <a class="nav-link" aria-current="page" href="./nosotras.html">Equipo de desarrollo</a>
</li>`
);
div2.insertAdjacentHTML(
  "beforeend",
  `   
<div class="icon-nav" id="sale-icon">
<a href="#" class="nav-link"><i class="fa-solid fa-cart-shopping fa-flip-horizontal fa-lg" style="color: #3135a0;"></i></a>
</div>
<div class="icon-nav" id="user-icon">
<a href="./registrodeusuarios.html" class="nav-link"><i class="fa-regular fa-circle-user fa-lg" style="color: #3135A0;"></i></a>
</div>
</div>`
);

/*Sesión activa mensaje*/
document.addEventListener("DOMContentLoaded", function () {
  const sesionActiva = localStorage.getItem("sesionActiva");
  const [userName] = localStorage.getItem("userName").split(" ");

  if (sesionActiva) {
    // Si hay una sesión activa, muestra el mensaje en el navbar
    const sesionActivaDiv = document.createElement("div");
    sesionActivaDiv.className = "dropdown dropdown-sesion sesion-activa";
    sesionActivaDiv.innerHTML =
      ("beforeend",
      `
      <a class="btn dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
        Hola, ${userName}!
      </a>

  <ul class="dropdown-menu" style="min-width:3rem">
    <li><button class="dropdown-item" href="#" id="btn-sesion">Cerrar sesión</button></li>
  </ul>
    `);

    navbar.appendChild(sesionActivaDiv);

    const iconoLogin = document.getElementById("user-icon");
    iconoLogin.style.display = "none";
    const cerrarSesionBtn = document.getElementById("btn-sesion");

    cerrarSesionBtn.addEventListener("click", function (e) {
      e.preventDefault();
      localStorage.removeItem("sesionActiva");
      window.location.href = "./login.html";
    });
  }
});
