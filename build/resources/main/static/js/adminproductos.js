
function crearProducto() {
    const nombre = document.getElementById('nombre').value;
    const precio = document.getElementById('precio').value;
    const categoria = document.getElementById('categoria').value;
    const descripcion = document.getElementById('descripcion').value;
    const codigo = document.getElementById('codigo').value;

    const producto = {
        "nombre": nombre,
        "precio": parseFloat(precio), 
        "categoria": categoria,
        "descripcion": descripcion,
        "codigo": codigo
    };//producto

    localStorage.setItem("productoCreado", JSON.stringify(producto));// productoCreado es el nombre con el que se guarda el objeto producto
}//crearProducto