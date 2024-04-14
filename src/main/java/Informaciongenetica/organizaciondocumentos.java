package Informaciongenetica;

import java.io.*;
import java.util.*;

public class organizaciondocumentos {
    public static void ordenarLineas(String nombreArchivoEntrada, String nombreArchivoSalida) {
        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivoEntrada))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(lineas);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nombreArchivoSalida))) {
            for (String linea : lineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
