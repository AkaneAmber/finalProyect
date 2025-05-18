import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    static ArrayList<String> inventoryProductName = new ArrayList<>();
    static ArrayList<Integer> inventoryProductSizeUnit = new ArrayList<>();

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

    public static void DeleteProduct() {
        if (!inventoryProductName.isEmpty()) {
            String deleteProductName = JOptionPane.showInputDialog("Ingrese el nombre del producto a eliminar");
            int index = inventoryProductName.indexOf(deleteProductName);
            if (index != -1) {
                inventoryProductName.remove(index); // eliminamos por índice para asegurar sincronía
                inventoryProductSizeUnit.remove(index);
            } else {
                JOptionPane.showMessageDialog(null, "Producto no encontrado en el inventario.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay productos para eliminar.");
        }
    }

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

    public static void CreateProduct() {
        String newProduct = JOptionPane.showInputDialog("Ingrese el nombre del nuevo producto.");
        int sizeNewProduct = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del nuevo producto"));
        if (!inventoryProductName.contains(newProduct)) {
            inventoryProductName.add(newProduct);
            inventoryProductSizeUnit.add(sizeNewProduct);
        }
    }

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

    public static void main(String[] args) {
        int userOption;
        boolean exitOption = false;
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
                    case 1:
                        ReadProduct();
                        break;
                    case 2:
                        EditProduct();
                        break;
                    case 3:
                        DeleteProduct();
                        break;
                    case 4:
                        CreateProduct();
                        break;
                    case 5:
                        SearchProduct();
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "¡Gracias por usar AkCosto Fruver!");
                        exitOption = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida. Por favor seleccione una opción del 1 al 6.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error: Por favor ingrese un número válido.");
                userOption = 0;
            }
        } while (!exitOption);
    }
}