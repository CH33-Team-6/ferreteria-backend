const inputNombre = document.getElementById('Name'); //nombre
const inputAsunto = document.getElementById('Asunto'); //asunto
const inputEmail = document.getElementById('email');
const inputNumber = document.querySelector('#Number');
const inputText = document.querySelector('#Mensaje');
const btnEnviar = document.getElementById('btnEnviar'); //botón de enviar
const btnLimpiar = document.getElementById('btnLimpiar');

const validarNombre = document.getElementById('invalid-name');
const validarAsunto = document.getElementById('invalid-subject');
const validarEmail = document.getElementById('invalid-email');
const validarNumber = document.getElementById('invalid-number');
const validarText = document.getElementById('invalid-number');

const PHONE_DIGITS = 10;
const MIN_DIGITS = 3;
const MAX_DIGITS = 100;
const MIN_MENSAJE = 1;

function isNumber(value) {
  if (value.length !== PHONE_DIGITS || isNaN(value)) {
    return false;
  } //if length
  return true;
} //validar número de telefóno

function numerosConsecutivos() {
  let reget = /^(?!(\d)\1{4})/;
  if (!reget.test(inputNumber.value)) {
    alert('El número no puede tener los dígitos consecutivos');
    return false;
  } else {
    return true;
  }
}

inputNumber.addEventListener('input', function (e) {
  let valor = inputNumber.value;
  valor = valor.replace(/[^0-9]/g, '');
  inputNumber.value = valor;
}); // permitir solamente numeros en el campo número.

btnEnviar.addEventListener('click', function (event) {
  let isValid = true;

  const isInputNumber = isNumber(inputNumber.value);
  event.preventDefault();

  inputNombre.style.border = '';
  inputAsunto.style.border = '';
  validarAsunto.style.display = 'none';
  validarNombre.style.display = 'none';

  if (inputAsunto.value.length < MIN_DIGITS) {
    validarAsunto.innerHTML = 'El campo <strong>Asunto</strong> es requerido.';
    validarAsunto.style.display = 'block';
    validarAsunto.style.color = 'red';
    inputAsunto.style.border = 'solid thin red';
    isValid = false;
  } //inputAsunto
  if (inputNombre.value.length < MIN_DIGITS) {
    validarNombre.innerHTML = 'El campo <strong>Nombre</strong> es requerido.';
    validarNombre.style.display = 'block';
    validarNombre.style.color = 'red';
    inputNombre.style.border = 'solid thin red';
    isValid = false;
  } // inputNombre<3
  if (inputEmail.value.length < MIN_DIGITS) {
    validarEmail.innerHTML = 'El campo <strong>Correo</strong> es requerido.';
    validarEmail.style.display = 'block';
    validarEmail.style.color = 'red';
    inputEmail.style.border = 'solid thin red';
    isValid = false;
  } //inputEmail
  if (!isInputNumber || !numerosConsecutivos()) {
    validarNumber.innerHTML = 'El campo <strong>Número</strong> es requerido.';
    validarNumber.style.display = 'block';
    validarNumber.style.color = 'red';
    inputNumber.style.border = 'solid thin red';
    isValid = false;
  } //inputNumber
  if (inputText.value.length < MIN_MENSAJE) {
    validarText.innerHTML = 'El campo <strong>Teléfono</strong> es requerido.';
    validarText.style.display = 'block';
    validarText.style.color = 'red';
    inputText.style.border = 'solid thin red';
    isValid = false;
  } //inputMensaje

  //cambiar luego el correo de to_name: ferreteria.elpreciojusto@gmail.com
  if (isValid === true && isInputNumber) {
    emailjs.send('service_pft62sp', 'template_4eazygj', {
      to_name: 'liliasalazarjst@gmail.com',
      from_name: inputNombre.value,
      message: `
        Número de teléfono: ${inputNumber.value}.\n
        ${inputText.value}`,
      reply_to: inputEmail.value,
    });
    // console.log({
    //         "to_name": "liliasalazarjst@gmail.com",
    //         "from_name": inputNombre.value,
    //         "message": `
    //         Número de teléfono: ${inputNumber.value}.\n
    //         ${inputText.value}`,
    //         "reply_to": inputEmail.value,
    //         })
    document.getElementById('alerta-enviado').style.display = 'block';
    setTimeout(function() {
      document.getElementById('alerta-enviado').style.display = 'none';
    }, 5000);
    clearForm();
  }
});

btnLimpiar.addEventListener('click', function (event) {
  event.preventDefault();

  clearForm();
}); //btnLimpiar

function clearForm() {
  validarAsunto.style.display = 'none';
  validarNumber.style.display = 'none';
  validarEmail.style.display = 'none';
  validarNombre.style.display = 'none';
  inputNombre.style.border = '';
  inputAsunto.style.border = '';
  inputNumber.style.border = '';
  inputEmail.style.border = '';
  inputText.style.border = '';
  inputNombre.value = '';
  inputNumber.value = '';
  inputEmail.value = '';
  inputAsunto.value = '';
  inputText.value = '';
}
