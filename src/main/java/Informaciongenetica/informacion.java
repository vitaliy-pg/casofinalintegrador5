package Informaciongenetica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class informacion {
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
        // Suponiendo que el archivo está ordenado alfabéticamente
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int inicio = 0;
            int fin = cantidadLineas(nombreArchivo) - 1;

            while (inicio <= fin) {
                int medio = inicio + (fin - inicio) / 2;
                linea = obtenerLinea(nombreArchivo, medio);
                int comparacion = palabra.compareTo(linea);
                if (comparacion == 0) {
                    return true;
                } else if (comparacion < 0) {
                    fin = medio - 1;
                } else {
                    inicio = medio + 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int cantidadLineas(String nombreArchivo) throws IOException {
        int lineas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            while (br.readLine() != null) {
                lineas++;
            }
        }
        return lineas;
    }
    public static String obtenerLinea(String nombreArchivo, int numeroLinea) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea = null;
            for (int i = 0; i <= numeroLinea; i++) {
                linea = br.readLine();
            }
            return linea;
        }
    }
    }