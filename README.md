#🥬AkCosto Fruver
##Sistema de Inventario en Java
AkCosto Fruver es una aplicación de escritorio desarrollada en Java que permite gestionar de manera sencilla un inventario de productos para una frutería o tienda. Utiliza JOptionPane para proporcionar una interfaz gráfica básica de interacción con el usuario.

###📌 Características principales

- Crear productos con nombre y cantidad.
- Consultar el inventario completo.
- Buscar productos por nombre.
- Editar la cantidad de productos existentes.
- Eliminar productos del inventario.
- Interfaz gráfica básica utilizando JOptionPane.

###📋 Menú principal
Al ejecutar el programa, se muestra un menú con las siguientes opciones:

**1. **Ver lista de productos
**2. **Editar inventario de productos
**3. **Eliminar productos del inventario
**4. **Crear producto para el inventario
**5.** Buscar producto
**6.** Salir

###📂 Descripción del código
####Variables:
````
static ArrayList<String> inventoryProductName = new ArrayList<>();
static ArrayList<Integer> inventoryProductSizeUnit = new ArrayList<>();
````
Se usan dos listas paralelas para almacenar los nombres de productos y sus cantidades.

####Métodos:
#####Método ReadProduct()
    public static void ReadProduct() {
Lee y muestra todos los productos disponibles en el inventario. Si está vacío, informa al usuario.
#####Método DeleteProduct()
    public static void DeleteProduct() {
Solicita al usuario el nombre del producto a eliminar. Si existe, elimina tanto su nombre como su cantidad de las listas.
#####Método EditProduct()
    public static void EditProduct() {
Permite editar la cantidad de un producto ya existente. Verifica que el producto exista y que el nuevo valor sea numérico y no negativo.
#####Método CreateProduct()
    public static void CreateProduct() {
Solicita el nombre y la cantidad de un nuevo producto y lo agrega al inventario si aún no existe.
#####Método SearchProduct()
    public static void SearchProduct() {
Busca un producto por su nombre y muestra su cantidad si está en el inventario.
#####Método main()
    public static void main(String[] args) {
Muestra el menú de opciones y llama a las funciones correspondientes según la elección del usuario. Utiliza un bucle do-while para mantener activo el programa hasta que se seleccione la opción de salir.

###💾 Función del Código
