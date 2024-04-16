package MenuInteractivo.GestionInformacionCientífica;
import java.io.*;
import java.util.*;

public class OrganizadorDocumentos {

    public static void ordenarArchivo(String rutaArchivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
        ArrayList<String> lineas = new ArrayList<>();
        String linea;

        while ((linea = reader.readLine()) != null) {
            lineas.add(linea);
        }
        reader.close();

        Collections.sort(lineas);

        BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
        for (String lineaOrdenada : lineas) {
            writer.write(lineaOrdenada);
            writer.newLine();
        }
        writer.close();
    }

    public static boolean buscarEnDocumento(String path, String palabra) {
        try {
            BufferedReader reader = new BufferedReader
                    (new FileReader(path));
            String linea;
            int numeroLinea = 1;
            while ((linea = reader.readLine()) != null) {
                if (linea.contains(palabra)) {
                    System.out.println("Palabra encontrada en la línea " + numeroLinea + ": " + linea);
                }
                numeroLinea++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}