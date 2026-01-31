public class Producto {
    public static void main(String[] args) throws Exception {
        mostrarMenu();
    }

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
}
