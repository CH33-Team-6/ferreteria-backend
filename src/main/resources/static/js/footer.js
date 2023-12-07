const footer = document.getElementById("footer");
footer.insertAdjacentHTML(
  "afterbegin",
  `
    <div class="cardfooter"> 
      <h4 class="card-title">Nuestras Sucursales</h4><hr>
      <p class="card-text">San Antonio 503,<br> 67275 Juárez, N.L.</p>
      <p class="card-text">Higueras 100, <br>Residencial Los Huertos,<br> 67265 Juárez, N.L.</p>
    </div>
    <div class="cardfooter">
      <h4 class="card-title">Atención a clientes</h4><hr>
      <p class="card-text">Lunes a Viernes:</br> 8:00a.m.-8:00p.m.<br>
        Sábado:</br> 8:00p.m.-5:00p.m.</p>
    </div>
    <div class="cardfooter" id="redes-sociales">
  <h4 class="card-title redes-links">Redes Sociales</h4><hr>
  <div class="social-icons">
    <a href="contacto.html"target="_blank">
    <i class="fa-regular fa-envelope fa-xl redes-link" style="color: #ffffff;"></i>
    </a>
    <a href="https://www.facebook.com/materialesdeconstruccionelpreciojusto/?locale=es_LA"target="_blank">
    <i class="fa-brands fa-facebook fa-xl redes-link" style="color: #ffffff;"></i>
    </a>
    <a href="https://maps.app.goo.gl/uH5wSGNaLeERkgdw7"target="_blank">
    <i class="fa-solid fa-location-dot redes-link" style="color:#ffffff;"></i>
    </a>
  </div>
</div>
    `
);
