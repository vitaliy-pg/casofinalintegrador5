package Informaciongenetica;

import java.io.*;
import java.util.*;

public class organizaciondocumentos {
    public static void main(String[] args) {
        ordenarLineas("documento.txt");
    }

    public static void ordenarLineas(String nombreArchivo) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(lineas);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("documento_ordenado.txt"))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
