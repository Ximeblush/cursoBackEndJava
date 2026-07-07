fetch("http://localhost:8080/clientes")
    .then(response => response.json())
    .then(data => conole.log(data))
    .catch(error => console.error("Error al obtener los datos:", error));