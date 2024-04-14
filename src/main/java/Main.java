import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú:");
            System.out.println("1. Conteo de Genes");
            System.out.println("2. Cálculo de Combinaciones Genéticas");
            System.out.println("3. Herramientas de Análisis Numérico");
            System.out.println("4. Búsqueda Eficiente en Textos");
            System.out.println("5. Gestión de Información Científica");
            System.out.println("6. Ejercicio 5: Mejora de Algoritmos - QuickSort");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    contarGenes();
                    break;
                case 2:
                    calcularCombinacionesGeneticas();
                    break;
                case 3:
                    herramientasAnalisisNumerico();
                    break;
                case 4:
                    busquedaEficienteEnTextos();
                    break;
                case 5:
                    gestionInformacionCientifica();
                    break;
                case 6:
                    ejercicioQuickSort();
                    break;
                case 7:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
            }
        }
    }

    // Conteo de Genes
    public static void contarGenes() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cadena de ADN:");
        String cadenaADN = scanner.nextLine();
        int cantidadGenes = contarGenesRecursivo(cadenaADN, 0, 0);
        System.out.println("Cantidad de genes en la cadena de ADN: " + cantidadGenes);
    }

    private static int contarGenesRecursivo(String cadenaADN, int index, int count) {
        int startIndex = cadenaADN.indexOf("ATG", index);
        if (startIndex == -1) {
            return count;
        }

        int endIndex = cadenaADN.indexOf("TAG", startIndex + 3);
        if (endIndex == -1 || (endIndex - startIndex) % 3 != 0) {
            return contarGenesRecursivo(cadenaADN, startIndex + 1, count);
        }

        return contarGenesRecursivo(cadenaADN, endIndex + 3, count + 1);
    }

    // Cálculo de Combinaciones Genéticas
    public static void calcularCombinacionesGeneticas() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la longitud de las combinaciones genéticas:");
        int longitud = scanner.nextInt();
        String[] alelos = {"A", "T", "C", "G"};
        ArrayList<String> combinaciones = new ArrayList<>();
        generarCombinaciones(alelos, "", longitud, combinaciones);
        System.out.println("Combinaciones genéticas de longitud " + longitud + ":");
        for (String combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }

    private static void generarCombinaciones(String[] alelos, String combinacionActual, int longitud, ArrayList<String> combinaciones) {
        if (longitud == 0) {
            combinaciones.add(combinacionActual);
            return;
        }

        for (String alelo : alelos) {
            generarCombinaciones(alelos, combinacionActual + alelo, longitud - 1, combinaciones);
        }
    }

    // Herramientas de Análisis Numérico
    public static void herramientasAnalisisNumerico() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Herramientas de Análisis Numérico:");
        System.out.println("1. Sumatoria de Números Naturales");
        System.out.println("2. Listado de Números en un Rango");
        System.out.println("3. Cálculo de Potencias");
        System.out.println("4. Encontrar Máximo en un Conjunto de Datos");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Ingrese el valor de N para la suma de los primeros N números naturales:");
                int n = scanner.nextInt();
                int suma = sumaNaturales(n);
                System.out.println("Suma de los primeros " + n + " números naturales: " + suma);
                break;
            case 2:
                System.out.println("Ingrese el inicio del rango:");
                int inicio = scanner.nextInt();
                System.out.println("Ingrese el fin del rango:");
                int fin = scanner.nextInt();
                List<Integer> numerosEnRango = listarNumerosEnRango(inicio, fin);
                System.out.println("Números en el rango [" + inicio + ", " + fin + "]: " + numerosEnRango);
                break;
            case 3:
                System.out.println("Ingrese la base:");
                int base = scanner.nextInt();
                System.out.println("Ingrese el exponente:");
                int exponente = scanner.nextInt();
                int potencia = calcularPotencia(base, exponente);
                System.out.println("Potencia de " + base + " elevado a " + exponente + ": " + potencia);
                break;
            case 4:
                System.out.println("Ingrese la cantidad de elementos en el conjunto de datos:");
                int cantidadDatos = scanner.nextInt();
                int[] datos = new int[cantidadDatos];
                System.out.println("Ingrese los elementos del conjunto de datos:");
                for (int i = 0; i < cantidadDatos; i++) {
                    datos[i] = scanner.nextInt();
                }
                int maximo = encontrarMaximo(datos);
                System.out.println("Máximo valor en el conjunto de datos: " + maximo);
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }
    }

    public static int sumaNaturales(int n) {
        if (n == 0) {
            return 0;
        } else {
            return n + sumaNaturales(n - 1);
        }
    }

    public static List<Integer> listarNumerosEnRango(int inicio, int fin) {
        List<Integer> numeros = new ArrayList<>();
        listarNumerosEnRangoRecursivo(inicio, fin, numeros);
        return numeros;
    }

    private static void listarNumerosEnRangoRecursivo(int inicio, int fin, List<Integer> numeros) {
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

    // Búsqueda Eficiente en Textos
    public static void busquedaEficienteEnTextos() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la palabra a buscar:");
        String palabra = scanner.nextLine();
        System.out.println("Ingrese el nombre del archivo:");
        String archivo = scanner.nextLine();

        try {
            int lineaEncontrada = busquedaBinaria(palabra, archivo);
            if (lineaEncontrada != -1) {
                System.out.println("La palabra '" + palabra + "' se encontró en la línea " + lineaEncontrada + " del archivo.");
            } else {
                System.out.println("La palabra '" + palabra + "' no se encontró en el archivo.");
            }
        } catch (IOException e) {
            System.out.println("Error al buscar la palabra en el archivo.");
            e.printStackTrace();
        }
    }

    public static int busquedaBinaria(String palabra, String archivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            List<String> lineas = new ArrayList<>();
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            Collections.sort(lineas);

            int inicio = 0;
            int fin = lineas.size() - 1;
            while (inicio <= fin) {
                int medio = inicio + (fin - inicio) / 2;
                String lineaMedio = lineas.get(medio);
                int comparacion = palabra.compareTo(lineaMedio);
                if (comparacion < 0) {
                    fin = medio - 1;
                } else if (comparacion > 0) {
                    inicio = medio + 1;
                } else {
                    return medio + 1;
                }
            }
            return -1;
        }
    }

    // Gestión de Información Científica
    public static void gestionInformacionCientifica() {
        // Implementación de Gestión de Información Científica
        System.out.println("Implementación de Gestión de Información Científica");
    }

    // Ejercicio 5: Mejora de Algoritmos - QuickSort
    public static void ejercicioQuickSort() {
        // Implementación de QuickSort
        int[] arr = {5, 3, 8, 4, 2, 7, 1};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("Array ordenado:");
        imprimirArray(arr);
    }

    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            int indicePivote = particion(arr, inicio, fin);
            quickSort(arr, inicio, indicePivote - 1);
            quickSort(arr, indicePivote + 1, fin);
        }
    }

    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }

    // Método auxiliar para imprimir un array
    public static void imprimirArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
