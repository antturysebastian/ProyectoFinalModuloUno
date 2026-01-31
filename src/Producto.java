import java.util.Scanner;

public class Producto {

    public static Scanner sc = new Scanner(System.in);
    public static String nombre = "N/A";
    public static int cantidad = 0;
    public static double precioUnitario = 0.0;

    public static void main(String[] args) throws Exception {
        mostrarMenu();
    }

    /**
     * Método para mostrar el menú de opciones
     */
    public static void mostrarMenu() {
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

    public static double solicitarPrecio() {
        double precio;
        do {
            System.out.print("Ingrese un precio (Mayor a 0): ");
            precio = sc.nextDouble();
            if (!esPrecioValido(precio)) {
                System.out.println("Precio inválido. Debe ser mayor que 0");
            }
        } while (!esPrecioValido(precio));
        return precio;
    }

    public static int solicitarCantidad() {
        int cantidad;
        do {
            System.out.print("Ingrese la cantidad (0 o mayor): ");
            cantidad = sc.nextInt();
            if (!esCantidadValida(cantidad)) {
                System.out.println("Cantidad inválida. Debe ser 0 o mayor");
            }
        } while (!esCantidadValida(cantidad));
        return cantidad;
    }

    public static void mostrarProducto() {
        if (nombre.equals("N/A")) {
            System.out.println("No hay datos de producto registrados actualmente.");
        } else {
            System.out.println("Nombre del producto: " + nombre);
            System.out.println("Precio Unitario: " + precioUnitario);
            System.out.println("Cantidad: " + cantidad);
        }
    }

}
