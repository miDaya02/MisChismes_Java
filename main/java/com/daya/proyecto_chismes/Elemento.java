/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.daya.proyecto_chismes;

import java.text.ParseException;
import java.util.ArrayList;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Elemento extends MisChismes { 

    public Elemento(String nombre, String descripcion, Date fechaCreacion, boolean fechaValida, Categoria categoria, Estatus estado) {
        super(nombre, descripcion, fechaCreacion, fechaValida, categoria, estado); // Llamada al constructor de la clase padre
    }

    public List<Elemento> elementos = new ArrayList<>();

    public void agregarElemento(String nombre, String descripcion, Date fechaCreacion, boolean fechaValida, Categoria categoria, Estatus estado) {
        Elemento nuevoElemento = new Elemento(nombre, descripcion, fechaCreacion, fechaValida, categoria, estado);
        elementos.add(nuevoElemento);
        System.out.println("Elemento agregado: " + nuevoElemento);
    }

    public List<Elemento> listarElementos() {
        return elementos;
    }

    public void actualizarElemento(String nombre, String nuevaDescripcion, Date nuevaFechaCreacion, boolean nuevaFechaValida, Categoria nuevaCategoria, Estatus nuevoEstado) {
        for (Elemento elemento : elementos) {
            if (elemento.getNombre().equalsIgnoreCase(nombre)) {
                elemento.setDescripcion(nuevaDescripcion);
                elemento.setFechaCreacion(nuevaFechaCreacion);
                elemento.setFechaValida(nuevaFechaValida);
                elemento.setCategoria(nuevaCategoria);
                elemento.setEstado(nuevoEstado);
                return;
            }else {
                System.out.println("Elemento con nombre '" + nombre + "' no encontrado.");
            }
        }
    }
    public void eliminarElemento(String nombre) {
        boolean eliminado = elementos.removeIf(elemento -> elemento.getNombre().equalsIgnoreCase(nombre));
        if (eliminado) {
            System.out.println("Elemento con nombre '" + nombre + "' eliminado.");
        } else {
            System.out.println("Elemento con nombre '" + nombre + "' no encontrado.");
        }
    }
    
    public static MisChismes pedirDatos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del chisme:");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese la descripción del chisme:");
        String descripcion = sc.nextLine();

        System.out.println("Ingrese la fecha de creación (YYYY-MM-DD):");
        String nuevaFechaCreacionStr = sc.nextLine();
        
        // Convertir la fecha de tipo String a Date
        Date nuevaFechaCreacion = parseFecha(nuevaFechaCreacionStr);
        
        System.out.println("¿La fecha es válida? (true/false):");
        boolean nuevaFechaValida = sc.nextBoolean();
        sc.nextLine();
        
        System.out.println("Ingrese la nueva categoría (ej. 'GUARDADA', 'CONTADA'):");
        Categoria nuevaCategoria = Categoria.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Ingrese el nuevo estado (ej. 'PERSONAL', 'FAMILIAR', 'LABORAL'):");
        Estatus nuevoEstado = Estatus.valueOf(sc.nextLine().toUpperCase());

        return new MisChismes(nombre, descripcion, nuevaFechaCreacion, nuevaFechaValida, nuevaCategoria, nuevoEstado);
        
        
    }
    private static Date parseFecha(String fechaStr) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            return sdf.parse(fechaStr);  
        } catch (ParseException e) {
            System.out.println("Fecha inválida. Se asignará la fecha actual.");
            return new Date(); 
        }
    }
}

