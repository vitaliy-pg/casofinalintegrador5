package Análisis;

import java.util.ArrayList;

public class AnalisisGenomico {

    // Ejercicio 7: Conteo de Genes
    public static int contarGenes ( String cadenaADN ) {
        int contador = 0;
        int inicio = cadenaADN.indexOf ( "ATG" );
        if (inicio != -1) {
            int fin = cadenaADN.indexOf ( "TAG", inicio + 3 );
            if (fin != -1 && (fin - inicio) % 3 == 0) {
                contador++;
                contador += contarGenes ( cadenaADN.substring ( fin + 3 ) );
            }
        }
        return contador;
    }

    public static ArrayList<String> calcularCombinacionesGeneticas ( String[] alelos, int longitud ) {
        ArrayList<String> combinaciones = new ArrayList<> ();
        generarCombinaciones ( alelos, "", longitud, combinaciones );
        return combinaciones;
    }

    private static void generarCombinaciones ( String[] alelos, String combinacionActual, int longitud, ArrayList<String> combinaciones ) {
        if (combinacionActual.length () == longitud) {
            combinaciones.add ( combinacionActual );
            return;
        }
        for (String alelo : alelos) {
            generarCombinaciones ( alelos, combinacionActual + alelo, longitud, combinaciones );
        }
    }
}
