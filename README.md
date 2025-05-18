# 🥬 AkCosto Fruver 
>## Sistema de Inventario en Java
AkCosto Fruver es una aplicación de escritorio desarrollada en Java que permite gestionar de manera sencilla un inventario de productos para una frutería o tienda. Utiliza JOptionPane para proporcionar una interfaz gráfica básica de interacción con el usuario.

### 📌 Características principales

- Crear productos con nombre y cantidad.
- Consultar el inventario completo.
- Buscar productos por nombre.
- Editar la cantidad de productos existentes.
- Eliminar productos del inventario.
- Interfaz gráfica básica utilizando JOptionPane.

### 📋 Menú principal
Al ejecutar el programa, se muestra un menú con las siguientes opciones:

1. Ver lista de productos
2. Editar inventario de productos
3. Eliminar productos del inventario
4. Crear producto para el inventario
5. Buscar producto
6. Salir

### 📂 Descripción del código
#### Variables:
````
static ArrayList<String> inventoryProductName = new ArrayList<>();
static ArrayList<Integer> inventoryProductSizeUnit = new ArrayList<>();
````
Se usan dos listas paralelas para almacenar los nombres de productos y sus cantidades.

>## A continuación el código desmenuzado parte por parte
### 🧩 1. Importaciones
    import javax.swing.JOptionPane;
    import java.util.ArrayList;
    
>##### import javax.swing.JOptionPane; 
- Permite usar ventanas emergentes (input, mensajes). Muy útil para programas con interfaz gráfica básica.

>##### import java.util.ArrayList;
- Permite usar listas dinámicas que pueden crecer o reducirse durante la ejecución.

### 🧩 2. Clase principal
    public class Main {
- Esta es la clase principal donde se agrupan todos los métodos y el main.

### 🧩 3. Listas globales
```java
static ArrayList<String> inventoryProductName = new ArrayList<>();
static ArrayList<Integer> inventoryProductSizeUnit = new ArrayList<>();
```
>##### inventoryProductName
- Almacena los nombres de los productos (como "Manzana", "Banano").
>##### inventoryProductSizeUnit
- Almacena las cantidades correspondientes a cada producto.

>### Ambas listas están sincronizadas por índice. Ejemplo: índice 0 en ambas representa el mismo producto.

### 🧩 4. Método ReadProduct()
    public static void ReadProduct() {
- Lee y muestra todos los productos disponibles en el inventario. Si está vacío, informa al usuario.
```java
public static void ReadProduct() {
    if (inventoryProductName.isEmpty()) {
        JOptionPane.showMessageDialog(null, "AkCosto Fruver\nProductos disponibles en el inventario: 0");
    } else {
        String mensaje = "AkCosto Fruver - Inventario\n\n";
        for (int i = 0; i < inventoryProductName.size(); i++) {
            mensaje += "Producto: " + inventoryProductName.get(i) + "  Cantidad: " + inventoryProductSizeUnit.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
```
- Si no hay productos (isEmpty()), muestra que hay 0 productos.
- Si hay productos, recorre la lista y muestra todos los productos con su cantidad.

### 🧩 5. Método DeleteProduct()
    public static void DeleteProduct() {
- Solicita al usuario el nombre del producto a eliminar. Si existe, elimina tanto su nombre como su cantidad de las listas.
```java
public static void DeleteProduct() {
    if (!inventoryProductName.isEmpty()) {
        String deleteProductName = JOptionPane.showInputDialog("Ingrese el nombre del producto a eliminar");
        int index = inventoryProductName.indexOf(deleteProductName);
        if (index != -1) {
            inventoryProductName.remove(index);
            inventoryProductSizeUnit.remove(index);
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "No hay productos para eliminar.");
    }
}
```
1. Primero verifica que el inventario no esté vacío.
2. Luego pide el nombre del producto a eliminar.
3. Busca el índice del producto con indexOf().
4. Si lo encuentra (index != -1), elimina en ambas listas ese índice.

### 🧩 6. Método EditProduct()
    public static void EditProduct() {
- Permite editar la cantidad de un producto ya existente. Verifica que el producto exista y que el nuevo valor sea numérico y no negativo.
```java
public static void EditProduct() {
    if(!inventoryProductName.isEmpty()){
        String editProductName = JOptionPane.showInputDialog("Ingrese el nombre del Producto a editar");

        if (inventoryProductName.contains(editProductName)) {
            String input = JOptionPane.showInputDialog("Ingrese el nuevo valor del producto a Actualizar");

            try {
                int sizeInventoryProduct = Integer.parseInt(input);
                if (sizeInventoryProduct < 0) {
                    JOptionPane.showMessageDialog(null, "La cantidad no puede ser negativa.");
                    return;
                }
                int index = inventoryProductName.indexOf(editProductName);
                inventoryProductSizeUnit.set(index, sizeInventoryProduct);
                JOptionPane.showMessageDialog(null, "Producto \"" + editProductName + "\" actualizado correctamente.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor ingrese un número válido.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "No hay productos para editar.");
    }
}
```
1. Verifica que el inventario no esté vacío.
2. Pide el nombre del producto que quieres editar.
3. Si lo encuentra, pide la nueva cantidad.
4. Valida que no sea negativa y que sea un número (try-catch).
5. Luego actualiza el valor en la lista de cantidades usando set(index, nuevoValor).

### 🧩 7. Método CreateProduct()
    public static void CreateProduct() {
- Solicita el nombre y la cantidad de un nuevo producto y lo agrega al inventario si aún no existe.
```java
public static void CreateProduct() {
    String newProduct = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto.");
    int sizeNewProduct = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del nuevo producto"));
    if (!inventoryProductName.contains(newProduct)) {
        inventoryProductName.add(newProduct);
        inventoryProductSizeUnit.add(sizeNewProduct);
    }
}
```
- Pide nombre y cantidad del nuevo producto.
- Si no existe ya en el inventario, lo añade a ambas listas.

### 🧩 8. Método SearchProduct()
    public static void SearchProduct() {
- Busca un producto por su nombre y muestra su cantidad si está en el inventario.
```java
public static void SearchProduct() {
    if (!inventoryProductName.isEmpty()) {
        String searchName = JOptionPane.showInputDialog("Ingrese el nombre del producto a buscar");
        int index = inventoryProductName.indexOf(searchName);
        if (index != -1) {
            JOptionPane.showMessageDialog(null,
                    "Producto encontrado:\n" +
                            "Nombre: " + inventoryProductName.get(index) + "\n" +
                            "Cantidad: " + inventoryProductSizeUnit.get(index));
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "El inventario está vacío.");
    }
}
```
- Si el inventario no está vacío, pide el nombre del producto.
- Si lo encuentra, muestra nombre y cantidad.
- Si no, informa que no fue encontrado.

### 🧩 9. Método main()
    public static void main(String[] args) {
- Muestra el menú de opciones y llama a las funciones correspondientes según la elección del usuario. Utiliza un bucle do-while para mantener activo el programa hasta que se seleccione la opción de salir.
```java
public static void main(String[] args) {
    int userOption;

    do {
        try {
            String input = JOptionPane.showInputDialog(null,
                    "AkCosto Fruver \n" +
                            "Menu de Opciones\n" +
                            "1. Ver lista de productos\n" +
                            "2. Editar inventario de productos\n" +
                            "3. Eliminar productos del inventario\n" +
                            "4. Crear producto para el inventario\n" +
                            "5. Buscar producto\n" +
                            "6. Salir");
            userOption = Integer.parseInt(input);

            switch (userOption) {
                case 1: ReadProduct(); break;
                case 2: EditProduct(); break;
                case 3: DeleteProduct(); break;
                case 4: CreateProduct(); break;
                case 5: SearchProduct(); break;
                case 6:
                    JOptionPane.showMessageDialog(null, "¡Gracias por usar AkCosto Fruver!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Por favor seleccione una opción del 1 al 6.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: Por favor ingrese un número válido.");
            userOption = 0;
        }
    } while (userOption != 6);
}
```
- Menú principal del programa.
- Muestra opciones y llama a los métodos según lo que elija el usuario.
- Usa try-catch para evitar que errores de entrada numérica detengan el programa.
