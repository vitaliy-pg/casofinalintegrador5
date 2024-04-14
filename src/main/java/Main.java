
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Análisis.AnalisisGenomico;
import Informaciongenetica.organizaciondocumentos;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String cadenaADN = "ATGATGATGTAG        ";
        int cantidadGenes = contarGenes(cadenaADN);
        System.out.println("Cantidad de genes en la cadena de ADN: " + cantidadGenes);
        String[] alelos = {"A", "T", "C", "G"};
        int longitud = 3;
        ArrayList<String> combinaciones = AnalisisGenomico.calcularCombinacionesGeneticas(alelos, longitud);
        System.out.println("Combinaciones genéticas de longitud " + longitud + ":");
        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }

        // Gestion de Fechas
        GestionFechas gestionFechas = new GestionFechas();
    }

    public static int contarGenes(String cadenaADN) {
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

class FuncionesNumericas {
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

class GestionFechas {
    public GestionFechas () {
        List<LocalDate> fechas = new ArrayList<> ();
        fechas.add ( LocalDate.of ( 2024, 4, 1 ) );
        fechas.add ( LocalDate.of ( 2023, 12, 15 ) );
        fechas.add ( LocalDate.of ( 2024, 2, 28 ) );

        System.out.println ( "\nFechas sin ordenar:" );
        for (LocalDate fecha : fechas) {
            System.out.println ( fecha );
        }

        ordenarFechas ( fechas );

        System.out.println ( "\nFechas ordenadas:" );
        for (LocalDate fecha : fechas) {
            System.out.println ( fecha );
        }
    }

    public static void ordenarFechas ( List<LocalDate> fechas ) {
        Collections.sort ( fechas );
    }
    public class busquedadetexto {

        // Búsqueda lineal
        public static int busquedaLineal(String palabra, String archivo) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                int lineaActual = 0;
                while ((linea = br.readLine()) != null) {
                    lineaActual++;
                    if (linea.contains(palabra)) {
                        return lineaActual;
                    }
                }
            }
            return -1;
        }

        // Búsqueda binaria
        public static int busquedaBinaria(String palabra, String archivo) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                int inicio = 0;
                int fin = contarLineas(archivo) - 1;
                while (inicio <= fin) {
                    int medio = inicio + (fin - inicio) / 2;
                    String linea = obtenerLinea(medio, archivo);
                    int comparacion = palabra.compareTo(linea);
                    if (comparacion < 0) {
                        fin = medio - 1;
                    } else if (comparacion > 0) {
                        inicio = medio + 1;
                    } else {
                        return medio + 1; // Se suma 1 porque los índices de las líneas comienzan desde 1
                    }
                }
            }
            return -1;
        }

        // Método auxiliar para contar las líneas de un archivo
        private static int contarLineas(String archivo) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                int lineas = 0;
                while (br.readLine() != null) {
                    lineas++;
                }
                return lineas;
            }
        }

        // Método auxiliar para obtener una línea específica de un archivo
        private static String obtenerLinea(int numeroLinea, String archivo) throws IOException {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                int contador = 0;
                String linea;
                while ((linea = br.readLine()) != null) {
                    contador++;
                    if (contador == numeroLinea) {
                        return linea;
                    }
                }
            }
            return null;
        }
    }
}

