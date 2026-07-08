# TechLab E-commerce

Este sistema es una API REST desarrollada en Java con Spring Boot para gestionar productos, categorías, clientes y carritos de compra. Permite realizar operaciones de alta, consulta, actualización y eliminación sobre los distintos recursos, además de inicializar datos de ejemplo al arrancar la aplicación.

## Endpoints existentes

### Productos

- `GET /productos` — Lista todos los productos.
- `GET /productos/{id}` — Obtiene un producto por su ID.
- `POST /productos` — Crea un nuevo producto.
- `PUT /productos/{id}` — Actualiza un producto existente.
- `DELETE /productos/{id}` — Elimina un producto por su ID.
- `GET /productos/nombre/{nombre}` — Busca productos por nombre.
- `GET /productos/categoria/{categoria}` — Busca productos por categoría.

### Categorías

- `GET /categorias` — Lista todas las categorías.
- `GET /categorias/{id}` — Obtiene una categoría por su ID.
- `POST /categorias` — Crea una nueva categoría.
- `PUT /categorias/{id}` — Actualiza una categoría existente.
- `DELETE /categorias/{id}` — Elimina una categoría por su ID.

### Clientes

- `GET /clientes` — Lista todos los clientes.
- `GET /clientes/{id}` — Obtiene un cliente por su ID.
- `POST /clientes` — Crea un nuevo cliente.
- `PUT /clientes/{id}` — Actualiza un cliente existente.
- `DELETE /clientes/{id}` — Elimina un cliente por su ID.

### Carritos

- `GET /carritos` — Lista todos los carritos.
- `GET /carritos/{id}` — Obtiene un carrito por su ID.
- `POST /carritos` — Crea un nuevo carrito.
- `PUT /carritos/{id}` — Actualiza un carrito existente.
- `DELETE /carritos/{id}` — Elimina un carrito por su ID.

## Ejemplos de body para probar POST y PUT

### Producto

```json
{
  "cliente": {
    "id": 1,
    "dni": 12345678,
    "nombre": "Juan",
    "apellido": "Perez"
  },
  "producto": {
    "id": 1,
    "nombre": "Milanesa con papas fritas",
    "precio": 15000,
    "stock": 5
  },
  "cantidad": 2
}
```

### Categoría

```json
{
  "nombre": "Bebida",
  "descripcion": "Bebidas sin alcohol"
}
```

### Cliente

```json
{
  "dni": 12345678,
  "nombre": "Juan",
  "apellido": "Pérez"
}
```

### Carrito

```json
{
  "cliente": {
    "id": 1
  },
  "producto": {
    "id": 1
  },
  "cantidad": 2
}
```

## Tecnologías y herramientas utilizadas

- Java 17
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Lombok
- Jakarta Validation
- REST API
- Visual Studio Code
- Git / GitHub

## Requisitos

- Java JDK 17 o superior
- Maven
- MySQL en ejecución
- Un IDE como Visual Studio Code o IntelliJ IDEA

## Cómo ejecutar el proyecto

1. Asegurate de tener MySQL corriendo y una base llamada `ecommerce`.
2. Desde la raíz del proyecto, ejecutá:

```bash
./mvnw spring-boot:run
```

3. La API quedará disponible en:

```text
http://localhost:8080
```
