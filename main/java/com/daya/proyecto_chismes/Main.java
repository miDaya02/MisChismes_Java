package com.daya.proyecto_chismes;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Elemento elemento = new Elemento("default", "default", new Date(), true, Categoria.PERSONAL, Estatus.GUARDADO); // Crear un objeto de tipo Elemento
        boolean seguir = true;

        while (seguir) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar un nuevo chisme");
            System.out.println("2. Listar chismes");
            System.out.println("3. Actualizar un chisme");
            System.out.println("4. Eliminar un chisme");
            System.out.println("5. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer del scanner

            switch (opcion) {
                case 1:
                    MisChismes nuevoElemento = pedirDatos(scanner); // Pedir datos y crear un nuevo objeto
                    elemento.agregarElemento(nuevoElemento.getNombre(), nuevoElemento.getDescripcion(),
                            nuevoElemento.getFechaCreacion(), nuevoElemento.isFechaValida(),
                            nuevoElemento.getCategoria(), nuevoElemento.getEstado());
                    break;

                case 2:
                    List<Elemento> elementos = elemento.listarElementos(); // Listar los elementos
                    System.out.println("Lista de chismes:");
                    for (Elemento e : elementos) {
                        System.out.println(e); // Mostrar cada elemento
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el nombre del chisme a actualizar:");
                    String nombreElemento = scanner.nextLine();
                    System.out.println("Ingrese la nueva descripción:");
                    String nuevaDescripcion = scanner.nextLine();
                    System.out.println("Ingrese la nueva fecha de creación (YYYY-MM-DD):");
                    String nuevaFechaStr = scanner.nextLine();
                    Date nuevaFecha = parseFecha(nuevaFechaStr); // Método para convertir a Date
                    System.out.println("¿Es válida la fecha? (true/false):");
                    boolean nuevaFechaValida = scanner.nextBoolean();
                    scanner.nextLine(); // Limpiar el buffer
                    System.out.println("Ingrese la nueva categoría (ej. 'PERSONAL', 'FAMILIAR', 'LABORAL'.):");
                    Categoria nuevaCategoria = obtenerCategoriaValida(scanner);
                    System.out.println("Ingrese el nuevo estado (ej. 'GUARDADO', 'CONTADO'):");
                    Estatus nuevoEstado = obtenerEstatusValido(scanner);

                    // Actualizar el elemento
                    elemento.actualizarElemento(nombreElemento, nuevaDescripcion, nuevaFecha, nuevaFechaValida, nuevaCategoria, nuevoEstado);
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del chisme a eliminar");
                    String nombrem = scanner.nextLine();  // Usamos "nombrem" aquí

                    // Verifica si el nombre del chisme existe
                    boolean encontrado = false;
                    for (Elemento el : elemento.listarElementos()) {
                        if (el.getNombre().equalsIgnoreCase(nombrem)) {
                            elemento.eliminarElemento(nombrem);
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("No existe un chisme con ese nombre");
                    }
                    break;

                case 5:
                    seguir = false;
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }

    // Método para pedir los datos de un nuevo elemento
    private static MisChismes pedirDatos(Scanner scanner) {
        System.out.println("Ingrese el nombre del chisme:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la descripción del chisme:");
        String descripcion = scanner.nextLine();

        System.out.println("Ingrese la fecha de creación (YYYY-MM-DD):");
        String nuevaFechaCreacionStr = scanner.nextLine();
        Date nuevaFechaCreacion = parseFecha(nuevaFechaCreacionStr); // Convertir a Date

        System.out.println("¿La fecha es válida? (true/false):");
        boolean nuevaFechaValida = scanner.nextBoolean();
        scanner.nextLine(); // Limpiar el buffer

        System.out.println("Ingrese la nueva categoría (ej. 'PERSONAL', 'FAMILIAR', 'LABORAL'.):");
        Categoria nuevaCategoria = obtenerCategoriaValida(scanner);

        System.out.println("Ingrese el nuevo estado (ej. 'GUARDADO', 'CONTADO'):");
        Estatus nuevoEstado = obtenerEstatusValido(scanner);

        return new MisChismes(nombre, descripcion, nuevaFechaCreacion, nuevaFechaValida, nuevaCategoria, nuevoEstado);
    }

    // Método para convertir String a Date
    private static Date parseFecha(String fechaStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(fechaStr);
        } catch (ParseException e) {
            System.out.println("Fecha inválida. Se asignará la fecha actual.");
            return new Date();
        }
    }

    // Método para obtener categoría válida
    private static Categoria obtenerCategoriaValida(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().toUpperCase();
            try {
                return Categoria.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Categoría inválida. Intente nuevamente.");
            }
        }
    }

    // Método para obtener estatus válido
    private static Estatus obtenerEstatusValido(Scanner scanner) {
        while (true) {
            String input = scanner.nextLine().toUpperCase();
            try {
                return Estatus.valueOf(input);
            } catch (IllegalArgumentException e) {
                System.out.println("Estado inválido. Intente nuevamente.");
            }
        }
    }
}
