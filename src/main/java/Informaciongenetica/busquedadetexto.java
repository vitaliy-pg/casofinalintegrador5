package Informaciongenetica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class busquedadetexto {

    // Búsqueda lineal
    public static int busquedaLineal(String palabra, String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int lineaActual = 0;
            while ((linea = br.readLine()) != null) {
                lineaActual++;
                if (linea.contains(palabra)) {
                    return lineaActual;
                }
            }
        }
        return -1;
    }

    // Búsqueda binaria
    public static int busquedaBinaria(String palabra, String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            int inicio = 0;
            int fin = contarLineas(archivo) - 1;
            while (inicio <= fin) {
                int medio = inicio + (fin - inicio) / 2;
                String linea = obtenerLinea(medio, archivo);
                int comparacion = palabra.compareTo(linea);
                if (comparacion < 0) {
                    fin = medio - 1;
                } else if (comparacion > 0) {
                    inicio = medio + 1;
                } else {
                    return medio + 1; // Se suma 1 porque los índices de las líneas comienzan desde 1
                }
            }
        }
        return -1;
    }

    // Método auxiliar para contar las líneas de un archivo
    private static int contarLineas(String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            int lineas = 0;
            while (br.readLine() != null) {
                lineas++;
            }
            return lineas;
        }
    }

    // Método auxiliar para obtener una línea específica de un archivo
    private static String obtenerLinea(int numeroLinea, String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            int contador = 0;
            String linea;
            while ((linea = br.readLine()) != null) {
                contador++;
                if (contador == numeroLinea) {
                    return linea;
                }
            }
        }
        return null;
    }
}