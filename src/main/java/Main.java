
import java.util.ArrayList;
import Análisis.AnalisisGenomico;

import static Análisis.AnalisisGenomico.contarGenes;

public class Main {
    public static void main(String[] args) {
        String cadenaADN = "ATGATGATGTAG        "   ;
        int cantidadGenes = contarGenes(cadenaADN);
        System.out.println("Cantidad de genes en la cadena de ADN: " + cantidadGenes);
        String[] alelos = { "A", "T", "C", "G" };
        int longitud = 3;
        ArrayList<String> combinaciones = AnalisisGenomico.calcularCombinacionesGeneticas(alelos, longitud);
        System.out.println("Combinaciones genéticas de longitud " + longitud + ":");
        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }
}



