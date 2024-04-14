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