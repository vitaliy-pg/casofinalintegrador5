package Informaciongenetica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
public class BusquedaEnTexto {
    public static void main(String[] args) {
        String palabraBuscada = "ejemplo";
        System.out.println("Resultado de la búsqueda lineal: " + buscarLineal("archivo.txt", palabraBuscada));
        System.out.println("Resultado de la búsqueda binaria: " + buscarBinaria("archivo_ordenado.txt", palabraBuscada));
    }
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