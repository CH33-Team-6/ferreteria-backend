// import { PRODUCTOS } from "./arrayProductos.js";

// const formularioProductos = document.getElementById("formularioProductos");
// Captura el cambio en el input de tipo file y actualiza el texto personalizado
document
  .getElementById("inputGroupFile02")
  .addEventListener("change", function () {
    var fileName = this.files[0].name;
    document.querySelector('label[for="inputGroupFile02"] span').innerText =
      fileName;
  });

const cargarImagen = document.getElementById("inputGroupFile02");
let cargarImagenvalue = cargarImagen.value;
let extension = cargarImagenvalue
  .substring(cargarImagenvalue.lastIndexOf(".") + 1)
  .toLowerCase();

const btnAgregar = document.getElementById("btnAgregar");
const productosAgregados = document.getElementById("productos-agregados");
const alertValidaciones = document.getElementById("invalid");
const inputNombre = document.getElementById("inputNombre");
const inputCategoria = document.getElementById("inputCategoria");
const inputId = document.getElementById("inputId");
console.log("inputId", inputId.value);
const inputDescripcion = document.getElementById("inputDescripcion");
const inputPrecio = document.getElementById("inputPrecio");

inputId.addEventListener("input", function (e) {
  e.preventDefault();

  // Obtén el valor actual del campo
  let valor = inputId.value;

  // Verificar si el valor no es vacío antes de aplicar la expresión regular
  if (valor !== "") {
    // Remover cualquier carácter que no sea un número
    let valorNumerico = valor.replace(/[^0-9]/g, "");

    // Verificar si el valor limpio es diferente al valor actual
    if (valor !== valorNumerico) {
      // Asignar el valor numérico al campo
      inputId.value = valorNumerico;
    }
  }
});

inputPrecio.addEventListener("input", function (e) {
  e.preventDefault();

  // Obtén el valor actual del campo
  let valor = inputPrecio.value;

  // Verificar si el valor no es vacío antes de aplicar la expresión regular
  if (valor !== "") {
    // Remover cualquier carácter que no sea un número
    let valorNumerico = valor.replace(/[^0-9]/g, "");

    // Verificar si el valor limpio es diferente al valor actual
    if (valor !== valorNumerico) {
      // Asignar el valor numérico al campo
      inputPrecio.value = valorNumerico;
    }
  }
});

btnAgregar.addEventListener("click", function (event) {
  let isValid = true;
  event.preventDefault();
  // let datos = []; //nullish coalescing operator
  // if (localStorage.getItem("datos")) {
  //   datos = JSON.parse(localStorage.getItem("datos"));
  // }
  alertValidaciones.style.display = "none";
  alertValidaciones.style.color = "";
  cargarImagen.style.border = "";
  inputNombre.style.border = "";
  inputCategoria.style.border = "";
  inputId.style.border = "";
  inputDescripcion.style.border = "";
  inputPrecio.style.border = "";

  if (cargarImagen.files.length === 0) {
    alertValidaciones.innerHTML =
      "Todos los campos deben de estar llenos. Por favor seleccione una imágen de tipo jpg, jpeg o png.";
    alertValidaciones.style.display = "block";
    cargarImagen.style.border = "solid thin red";
    alertValidaciones.style.color = "red";
    isValid = false;
  } //cargarImagen

  if (inputNombre.value.length < 5) {
    alertValidaciones.innerHTML =
      "Todos los campos deben de estar llenos, el nombre es importante para localizar el artículo asegúrese de colocarlo adecuadamente.";
    alertValidaciones.innerHTML = "Por favor agregue un nombre válido";
    alertValidaciones.style.display = "block";
    inputNombre.style.border = "solid thin red";
    alertValidaciones.style.color = "red";
    isValid = false;
  } //inputNombre

  if (inputCategoria.value === "") {
    alertValidaciones.innerHTML =
      "Todos los campos deben de estar llenos, seleccione la categoría a la que pertenece el artículo.";
    alertValidaciones.innerHTML = "Seleccione una categoría";
    alertValidaciones.style.display = "block";
    inputCategoria.style.border = "solid thin red";
    alertValidaciones.style.color = "red";
    isValid = false;
  } //inputCategoria

  if (inputId.value.length < 3) {
    alertValidaciones.innerHTML =
      "Todos los campos deben de estar llenos, verifique que el ID sea el adecuado.";
    alertValidaciones.style.display = "block";
    inputId.style.border = "solid thin red";
    alertValidaciones.style.color = "red";
    isValid = false;
  } //inputId

  if (inputDescripcion.value.length < 10) {
    alertValidaciones.innerHTML =
      "Todos los campos deben de estar llenos, asegúrese de llenar la descripción correctamente.";
    alertValidaciones.style.display = "block";
    inputDescripcion.style.border = "solid thin red";
    alertValidaciones.style.color = "red";
    isValid = false;
  } //inputDescripcion

  if (inputPrecio.value.length < 1) {
    alertValidaciones.innerHTML =
      "Todos los campos deben de estar llenos, asegúrese de que el precio en pesos corresponde al artículo y no agregue .00 ni signo de pesos.";
    alertValidaciones.style.display = "block";
    inputPrecio.style.border = "solid thin red";
    alertValidaciones.style.color = "red";
    isValid = false;
  } //inputDescripcion
  // agregar imagen a imgBB

  let img = "";
  if (cargarImagen.files.length > 0 && isValid === true) {
    const file = cargarImagen.files[0];
    const formData = new FormData();
    formData.append("image", file);

    fetch(
      "https://api.imgbb.com/1/upload?key=1d621c661bda048835063260b6cd5344",
      {
        method: "POST",
        body: formData,
      }
    )
      .then((response) => response.json())
      .then((data) => {
        if (data.success) {
          // Muestra la imagen subida
          img = data.data.url;

          // const pahtml = `<p> Id: ${inputId.value} </p>
          // <p> Nombre: ${inputNombre.value} </p>
          // <p> Precio: ${inputPrecio.value} </p>
          // <p> Categoria: ${inputCategoria.value} </p>
          // <p> Descripción: ${inputDescripcion.value} </p>
          // <p> Imágen: ${img} </p>`

          const body = {
            // id: inputId.value,
            nombre: inputNombre.value,
            imagen: img,
            precio: inputPrecio.value,
            descripcion: inputDescripcion.value,
            // categoria: inputCategoria.value,
            cantidad: 10,
          };

          // datos.push(elemento);
          // localStorage.setItem("datos", JSON.stringify(datos));
          const accessToken = sessionStorage.getItem("accessToken");

          if (!accessToken) {
            window.location.href = "./login.html";
          }

          fetch("https://preciojusto.onrender.com/api/productos/", {
            method: "POST",
            headers: {
              "Content-Type": "application/json",
              Authorization: `Bearer ${accessToken}`,
            },
            body: JSON.stringify(body),
          })
            .then((response) => response.json())
            .then((result) => {
              console.log(result);
              alert("Producto agregado con éxito");
              // limpiar campos
              inputId.value = "";
              inputNombre.value = "";
              inputPrecio.value = "";
              inputCategoria.value = "";
              inputDescripcion.value = "";
            })
            .catch((error) => {
              console.log("Error al guardar producto:", error);
            });

          // productosAgregados.insertAdjacentHTML("beforeend", pahtml)
        } else {
          console.error("Error al subir la imagen:", data.error.message);
        }
      })
      .catch((error) => console.error("Error en la solicitud:", error));
  } else {
    console.error("Por favor, selecciona una imagen.");
  }
}); //addEventListener

window.addEventListener("load", function (event) {
  // if (localStorage.getItem("datos") !== null){
  //   datos = JSON.parse(localStorage.getItem("datos"));
  //   datos.forEach((r) => {
  //   // r de registro
  //   let pahtml = `<p> Id: ${r.id} </p>
  //   <p> Nombre: ${r.nombre} </p>
  //   <p> Precio: ${r.precio} </p>
  //   <p> Categoria: ${r.categoria} </p>
  //   <p> Descripción: ${r.descripcion} </p>
  //   <p> Imágen: ${r.img} </p>`
  // });//forEach
  // }//datos!=null
  // if (localStorage.getItem("datos") === null) {
  //   console.log("datos");
  //   localStorage.setItem("datos", JSON.stringify(PRODUCTOS));
  // } //datos=null
}); //load event
