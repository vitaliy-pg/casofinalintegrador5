
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
    public class FuncionesNumericas {
        public static int sumaNaturales(int n) {
            if (n == 0) {
                return 0;
            } else {
                return n + sumaNaturales(n - 1);
            }
        }
        public static ArrayList<Integer> listarNumerosEnRango(int inicio, int fin) {
            ArrayList<Integer> numeros = new ArrayList<>();
            listarNumerosEnRangoRecursivo(inicio, fin, numeros);
            return numeros;
        }

        private static void listarNumerosEnRangoRecursivo(int inicio, int fin, ArrayList<Integer> numeros) {
            if (inicio > fin) {
                return;
            }
            numeros.add(inicio);
            listarNumerosEnRangoRecursivo(inicio + 1, fin, numeros);
        }
        public static int calcularPotencia(int base, int exponente) {
            if (exponente == 0) {
                return 1;
            } else {
                return base * calcularPotencia(base, exponente - 1);
            }
        }

        public static int encontrarMaximo(int[] numeros) {
            return encontrarMaximoRecursivo(numeros, 0, numeros.length - 1);
        }

        private static int encontrarMaximoRecursivo(int[] numeros, int inicio, int fin) {
            if (inicio == fin) {
                return numeros[inicio];
            }
            int medio = (inicio + fin) / 2;
            int max1 = encontrarMaximoRecursivo(numeros, inicio, medio);
            int max2 = encontrarMaximoRecursivo(numeros, medio + 1, fin);
            return Math.max(max1, max2);
        }
    }

}



