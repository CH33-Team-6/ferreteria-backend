

window.addEventListener("load", async function (event) {
  let items = [];

  async function getData() {
    try {
      const response = await fetch("http://localhost:8080/api/productos/");
      const result = await response.json();
      console.log(result);
      return result;
    } catch (error) {
      console.log("error", error);
      throw error; // Re-lanzar el error para que se maneje en el ámbito externo si es necesario
    }
  }

  async function fetchData() {
    try {
      items = await getData();
      items.forEach((product) => {
        addItem(product);
      });
    } catch (error) {
      // Manejar el error si es necesario
      console.error("Error fetching data:", error);
    }
  }

  fetchData();
}); //fetch

function addItem(item) {
  const itemHTML = `<div class="card" style="width: 18rem; object-fit:contain; height:100%; padding:1rem; margin-bottom: 12px; border-radius: 50px;"onmouseover="this.style.backgroundColor='#D9D9D9'"onmouseout="this.style.backgroundColor='transparent'"> 
         <img src= " ${item.image}  " class="card-img-top" alt="image">
         <div class="card-body" style="text-align:center; "> 
             <h5 class="card-title" style="color:#C10F19;">$${item.price}.00</h5>
            <p class="card-text">${item.nombre}</p>
              <a href="#" class="btn" style="background-color:#3135A0; color:#fff">Agregar al carrito</a>
          </div>
      </div>
      <br/>`;
  const itemsContainer = document.getElementById("list-items");
  itemsContainer.innerHTML += itemHTML;
};
