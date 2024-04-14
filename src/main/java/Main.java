
import java.util.ArrayList;
import Análisis.AnalisisGenomico;
import bAnalisisnumerico.FuncionesNumericas;

import static Análisis.AnalisisGenomico.contarGenes;

public class Main {
    public static void main(String[] args) {
        String cadenaADN = "ATGATGATGTAG        ";
        int cantidadGenes = contarGenes ( cadenaADN );
        System.out.println ( "Cantidad de genes en la cadena de ADN: " + cantidadGenes );
        String[] alelos = {"A", "T", "C", "G"};
        int longitud = 3;
        ArrayList<String> combinaciones = AnalisisGenomico.calcularCombinacionesGeneticas ( alelos, longitud );
        System.out.println ( "Combinaciones genéticas de longitud " + longitud + ":" );
        for (String combinacion : combinaciones) {
            System.out.println ( combinacion );
        }
    }

    public static int contarGenes ( String cadenaADN ) {
        int n = 5;
        System.out.println("Suma de los primeros " + n + " números naturales: " + FuncionesNumericas.sumaNaturales(n));

        int inicio = 3;
        int fin = 7;
        ArrayList<Integer> numerosEnRango = FuncionesNumericas.listarNumerosEnRango(inicio, fin);
        System.out.println("Números en el rango [" + inicio + ", " + fin + "]: " + numerosEnRango);

        int base = 2;
        int exponente = 5;
        System.out.println("Potencia de " + base + " elevado a " + exponente + ": " + FuncionesNumericas.calcularPotencia(base, exponente));

        int[] datos = {3, 7, 2, 9, 5};
        System.out.println("Máximo valor en el conjunto de datos: " + FuncionesNumericas.encontrarMaximo(datos));
        return n;
    }

}



