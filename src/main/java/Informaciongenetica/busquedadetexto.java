package Informaciongenetica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BusquedaEnTexto {
    public static boolean buscarLineal(String nombreArchivo, String palabra) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.contains(palabra)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean buscarBinaria(String nombreArchivo, String palabra) {
        // Implementación de la búsqueda binaria
        return false;
    }
}