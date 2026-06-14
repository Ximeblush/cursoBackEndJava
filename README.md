# TechLab E-commerce

Proyecto Java de consola para practicar los conceptos principales de programacion orientada a objetos aplicados a un sistema simple de gestion de productos.

La aplicacion principal permite administrar un catalogo basico de productos desde un menu interactivo por consola.

## Funcionalidades actuales

- Carga inicial de productos de ejemplo.
- Alta de nuevos productos con nombre, precio y stock.
- Listado de productos disponibles.
- Busqueda de productos por id o por nombre.
- Eliminacion de productos por id con confirmacion.
- Menu de opciones por consola.

Las opciones de creacion y listado de pedidos aparecen en el menu, pero todavia estan pendientes de implementacion.

## Estructura principal

```text
src/
|-- Main.java
`-- com/
    `-- techlab/
        `-- ecommerce/
            |-- model/
            |   |-- Producto.java
            |   |-- Categoria.java
            |   |-- Alimento.java
            |   `-- Bebida.java
            |-- service/
            |   `-- ProductoService.java
            `-- ui/
                `-- MenuProducto.java
```

## Clases principales

- `Producto`: modelo base con id, nombre, categoria, precio y stock.
- `Categoria`: representa la categoria de un producto con nombre y descripcion.
- `Alimento`: extension de `Producto` que agrega cantidad de comensales.
- `Bebida`: extension de `Producto` que agrega tamanio.
- `MenuProducto`: punto de entrada funcional del sistema por consola.
- `ProductoService`: base para separar la logica de productos en una capa de servicio.

## Requisitos

- Java JDK 17 o superior recomendado.
- Visual Studio Code con Extension Pack for Java, o cualquier IDE compatible con Java.

No se requieren dependencias externas para ejecutar la aplicacion actual.

## Como ejecutar

Desde la raiz del proyecto, compilar las clases principales:

```powershell
javac -d bin src\com\techlab\ecommerce\model\*.java src\com\techlab\ecommerce\ui\MenuProducto.java
```

Luego ejecutar el menu:

```powershell
java -cp bin com.techlab.ecommerce.ui.MenuProducto
```

Tambien se puede ejecutar desde Visual Studio Code abriendo `MenuProducto.java` y usando la opcion **Run Java**.

## Estado del proyecto

El proyecto se encuentra en desarrollo y funciona como practica de backend con Java. Actualmente la persistencia es en memoria mediante una lista de productos, por lo que los datos agregados o eliminados se pierden al cerrar la aplicacion.

Proximos pasos sugeridos:

- Mover la logica del menu hacia `ProductoService`.
- Implementar actualizacion de productos.
- Implementar pedidos.
- Agregar validaciones para precio, stock y entradas del usuario.
- Incorporar persistencia en archivos o base de datos.
