import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
public class Main {
    public static void main ( String[] args ) {
        // Ejemplo de cadena de ADN
        String cadenaADN = "ATGAGTAGCTAGATGGCTAG";

        // Conteo de Genes
        int cantidadGenes = contarGenes ( cadenaADN );
        System.out.println ( "Cantidad de genes en la cadena de ADN: " + cantidadGenes );

        // Cálculo de Combinaciones Genéticas
        String[] alelos = {"A", "T", "C", "G"};
        int longitud = 3;
        ArrayList<String> combinaciones = calcularCombinacionesGeneticas ( alelos, longitud );
        System.out.println ( "Combinaciones genéticas de longitud " + longitud + ":" );
        for (String combinacion : combinaciones) {
            System.out.println ( combinacion );
        }

        // Herramientas de Análisis Numérico
        // Ejercicio 1: Sumatoria de Números Naturales
        int n = 5;
        System.out.println ( "Suma de los primeros " + n + " números naturales: " + sumaNaturales ( n ) );

        // Ejercicio 2: Listado de Números en un Rango
        int inicio = 3;
        int fin = 7;
        System.out.println ( "Números en el rango [" + inicio + ", " + fin + "]: " + listarNumerosEnRango ( inicio, fin ) );

        // Ejercicio 3: Cálculo de Potencias
        int base = 2;
        int exponente = 5;
        System.out.println ( "Potencia de " + base + " elevado a " + exponente + ": " + calcularPotencia ( base, exponente ) );

        // Ejercicio 4: Encontrar Máximo en un Conjunto de Datos
        int[] datos = {3, 7, 2, 9, 5};
        System.out.println ( "Máximo valor en el conjunto de datos: " + encontrarMaximo ( datos ) );

        // Búsqueda Eficiente en Textos
        // Búsqueda Lineal
        try {
            int lineaEncontradaLineal = busquedaLineal ( "patrón", "archivo.txt" );
            System.out.println ( "Patrón encontrado en la línea " + lineaEncontradaLineal + " (búsqueda lineal)." );
        } catch (IOException e) {
            System.err.println ( "Error al buscar el patrón en el archivo: " + e.getMessage () );
        }

        // Búsqueda Binaria (requiere que el archivo esté ordenado)
        try {
            int lineaEncontradaBinaria = busquedaBinaria ( "patrón", "archivo_ordenado.txt" );
            System.out.println ( "Patrón encontrado en la línea " + lineaEncontradaBinaria + " (búsqueda binaria)." );
        } catch (IOException e) {
            System.err.println ( "Error al buscar el patrón en el archivo: " + e.getMessage () );
        }

        // Gestión de Información Científica
        // Ejercicio 9: Organización de Documentos (Orden alfabético de líneas en un archivo de texto)
        ordenarLineasDeArchivo ( "documento.txt" );
    }

    // Conteo de Genes
    public static int contarGenes ( String cadenaADN ) {
        return contarGenesRecursivo ( cadenaADN, 0, 0 );
    }

    private static int contarGenesRecursivo ( String cadenaADN, int index, int count ) {
        int startIndex = cadenaADN.indexOf ( "ATG", index );
        if (startIndex == -1) {
            return count;
        }

        int endIndex = cadenaADN.indexOf ( "TAG", startIndex + 3 );
        if (endIndex == -1 || (endIndex - startIndex) % 3 != 0) {
            return contarGenesRecursivo ( cadenaADN, startIndex + 1, count );
        }

        return contarGenesRecursivo ( cadenaADN, endIndex + 3, count + 1 );
    }

    // Cálculo de Combinaciones Genéticas
    public static ArrayList<String> calcularCombinacionesGeneticas ( String[] alelos, int longitud ) {
        ArrayList<String> combinaciones = new ArrayList<> ();
        generarCombinaciones ( alelos, "", longitud, combinaciones );
        return combinaciones;
    }

    private static void generarCombinaciones ( String[] alelos, String combinacionActual, int longitud, ArrayList<String> combinaciones ) {
        if (longitud == 0) {
            combinaciones.add ( combinacionActual );
            return;
        }

        for (String alelo : alelos) {
            generarCombinaciones ( alelos, combinacionActual + alelo, longitud - 1, combinaciones );
        }
    }

    // Herramientas de Análisis Numérico
    // Ejercicio 1: Sumatoria de Números Naturales
    public static int sumaNaturales ( int n ) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaNaturales ( n - 1 );
        }
    }

    // Ejercicio 2: Listado de Números en un Rango
    public static List<Integer> listarNumerosEnRango ( int inicio, int fin ) {
        List<Integer> numeros = new ArrayList<> ();
        listarNumerosEnRangoRecursivo ( inicio, fin, numeros );
        return numeros;
    }

    private static void listarNumerosEnRangoRecursivo ( int inicio, int fin, List<Integer> numeros ) {
        if (inicio > fin) {
            return;
        }
        numeros.add ( inicio );
        listarNumerosEnRangoRecursivo ( inicio + 1, fin, numeros );
    }

    // Ejercicio 3: Cálculo de Potencias
    public static int calcularPotencia ( int base, int exponente ) {
        if (exponente == 0) {
            return 1;
        } else {
            return base * calcularPotencia ( base, exponente - 1 );
        }
    }

    // Ejercicio 4: Encontrar Máximo en un Conjunto de Datos
    public static int encontrarMaximo ( int[] numeros ) {
        return encontrarMaximoRecursivo ( numeros, 0, numeros.length - 1 );
    }

    private static int encontrarMaximoRecursivo ( int[] numeros, int inicio, int fin ) {
        if (inicio == fin) {
            return numeros[inicio];
        }
        int medio = (inicio + fin) / 2;
        int max1 = encontrarMaximoRecursivo ( numeros, inicio, medio );
        int max2 = encontrarMaximoRecursivo ( numeros, medio + 1, fin );
        return Math.max ( max1, max2 );
    }

    // Gestión de Información Científica
    // Ejercicio 9: Organización de Documentos (Orden alfabético de líneas en un archivo de texto)
    public static void ordenarLineasDeArchivo ( String nombreArchivo ) {
        List<String> lineas = new ArrayList<> ();
        try (BufferedReader br = new BufferedReader ( new FileReader ( nombreArchivo ) )) {
            String linea;
            while ((linea = br.readLine ()) != null) {
                lineas.add ( linea );
            }
        } catch (IOException e) {
            e.printStackTrace ();
            return;
        }

        Collections.sort ( lineas );

        try (BufferedWriter bw = new BufferedWriter ( new FileWriter ( "documento_ordenado.txt" ) )) {
            for (String linea : lineas) {
                bw.write ( linea );
                bw.newLine ();
            }
            System.out.println ( "Se ha ordenado el archivo correctamente." );
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    // Búsqueda Eficiente en Textos
    // Búsqueda Lineal
    public static int busquedaLineal ( String palabra, String archivo ) throws IOException {
        try (BufferedReader br = new BufferedReader ( new FileReader ( archivo ) )) {
            String linea;
            int lineaActual = 0;
            while ((linea = br.readLine ()) != null) {
                lineaActual++;
                if (linea.contains ( palabra )) {
                    return lineaActual;
                }
            }
            return -1;
        }
    }

    // Búsqueda Binaria
    public static int busquedaBinaria ( String palabra, String archivo ) throws IOException {
        try (BufferedReader br = new BufferedReader ( new FileReader ( archivo ) )) {
            List<String> lineas = new ArrayList<> ();
            String linea;
            while ((linea = br.readLine ()) != null) {
                lineas.add ( linea );
            }
            Collections.sort ( lineas );

            int inicio = 0;
            int fin = lineas.size () - 1;
            while (inicio <= fin) {
                int medio = inicio + (fin - inicio) / 2;
                String lineaMedio = lineas.get ( medio );
                int comparacion = palabra.compareTo ( lineaMedio );
                if (comparacion < 0) {
                    fin = medio - 1;
                } else if (comparacion > 0) {
                    inicio = medio + 1;
                } else {
                    return medio + 1; // Se suma 1 porque los índices de las líneas comienzan desde 1
                }
            }
            return -1;
        }


    }
    static class GestionFechas {
        public GestionFechas() {
            List<LocalDate> fechas = new ArrayList<>();
            fechas.add(LocalDate.of(2024, 4, 1));
            fechas.add(LocalDate.of(2023, 12, 15));
            fechas.add(LocalDate.of(2024, 2, 28));

            System.out.println("\nFechas sin ordenar:");
            for (LocalDate fecha : fechas) {
                System.out.println(fecha);
            }

            ordenarFechas(fechas);

            System.out.println("\nFechas ordenadas:");
            for (LocalDate fecha : fechas) {
                System.out.println(fecha);
            }
        }

        public static void ordenarFechas(List<LocalDate> fechas) {
            Collections.sort(fechas);
        }
    }

}





