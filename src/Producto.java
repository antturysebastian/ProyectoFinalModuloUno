import java.util.Scanner;

public class Producto {

    public static Scanner sc = new Scanner(System.in);
    public static String nombre = "N/A";
    public static double precioUnitario = 0.0;
    public static int cantidad = 0;
    public static String estado = "N/A";

    public static void main(String[] args) throws Exception {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer
            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    mostrarProducto();
                    break;
                case 3:
                    System.out.printf("Valor Total en Inventario: $%.2f%n", calcularValorTotalInventario());
                    break;
                case 4:
                    mostrarResumen();
                    break;
                case 5:
                    limpiarDatos();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Hasta luego!");
                    sc.close();
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 0);
    }

    /**
     * Método para mostrar el menú de opciones
     */
    public static void mostrarMenu() {
        System.out.println("");
        var opciones = """
                --- Sistema de Gestión de Productos ---

                1. Registrar nuevo producto
                2. Mostrar información del producto actual
                3. Calcular valor total del inventario
                4. Mostrar resumen completo del producto
                5. Limpiar datos del producto actual
                0. Salir
                """;
        System.out.println(opciones);
        System.out.print("Ingrese su opción: ");
    }

    /**
     * Método para registrar un nuevo producto
     */
    public static void registrarProducto() {
        if (nombre.equals("N/A")) {
            leerProducto();
        } else {
            System.out.println("Ya hay un producto guardado. Desea sobreescribir? (s/n): ");
            String respuesta = sc.nextLine();
            if (respuesta.equalsIgnoreCase("s")) {
                leerProducto();
            } else {
                System.out.println("Operación cancelada. No se modificaron los datos.");
            }
        }
    }

    /**
     * Método para leer los datos del producto
     */
    public static void leerProducto() {
        System.out.print("Ingrese el nombre del producto: ");
        nombre = sc.nextLine();
        System.out.print("Ingrese el precio unitario: ");
        precioUnitario = solicitarPrecio();
        System.out.print("Ingrese la cantidad: ");
        cantidad = solicitarCantidad();
        sc.nextLine(); // Limpiar el buffer
    }

    public static boolean esPrecioValido(double precioUnitario) {
        return precioUnitario > 0;
    }

    public static boolean esCantidadValida(int cantidad) {
        return cantidad >= 0;
    }

    /**
     * Método para solicitar un precio válido
     */
    public static double solicitarPrecio() {
        double precio;
        do {
            System.out.print("(El precio debe ser mayor a 0): ");
            precio = sc.nextDouble();
            if (!esPrecioValido(precio)) {
                System.out.println("Precio inválido. Debe ser mayor que 0");
            }
        } while (!esPrecioValido(precio));
        return precio;
    }

    /**
     * Método para solicitar una cantidad válida
     */
    public static int solicitarCantidad() {
        int cantidad;
        do {
            System.out.print("(La cantidad debe ser 0 o mayor): ");
            cantidad = sc.nextInt();
            if (!esCantidadValida(cantidad)) {
                System.out.println("Cantidad inválida. Debe ser 0 o mayor");
            }
        } while (!esCantidadValida(cantidad));
        return cantidad;
    }

    /**
     * Método para mostrar la información del producto actual
     */
    public static void mostrarProducto() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente.");
        } else {
            System.out.println("Nombre del producto: " + nombre);
            System.out.println("Precio Unitario: $" + precioUnitario);
            System.out.println("Cantidad en Inventario: " + cantidad);
        }
    }

    /**
     * Método para calcular el valor total del inventario
     */
    public static double calcularValorTotalInventario() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente.");
            return -1;
        } else {
            return precioUnitario * cantidad;
        }
    }

    /**
     * Método para mostrar un resumen completo del producto
     */
    public static void mostrarResumen() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente.");
        } else {
            System.out.println("--- Resumen del Producto ---");
            mostrarProducto();
            System.out.printf("Valor Total en Inventario: $%.2f%n", calcularValorTotalInventario());
            System.out.println("Estado del Stock: " + setEstadoStock());
        }
    }

    /**
     * Método para determinar el estado del stock
     */
    public static String setEstadoStock() {
        if (cantidad < 5) {
            estado = "Stock bajo";
        } else if (cantidad >= 5 && cantidad <= 20) {
            estado = "Stock suficiente";
        } else {
            estado = "Stock alto";
        }
        return estado;
    }

    /**
     * Método para limpiar los datos del producto actual
     */
    public static void limpiarDatos() {
        nombre = "N/A";
        precioUnitario = 0.0;
        cantidad = 0;
        System.out.println("Los datos del producto actual han sido borrados exitosamente.");
    }

}
