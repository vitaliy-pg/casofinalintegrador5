
import MenuInteractivo.AnalisisGenomico.GeneCounter;
import MenuInteractivo.AnalisisGenomico.GeneticCombinations;
import MenuInteractivo.AnalisisNumerico.HerramientasAnalisisNumerico;
import MenuInteractivo.GestionInformacionCientífica.BusquedaTexto;
import MenuInteractivo.GestionInformacionCientífica.GestionFechas;
import MenuInteractivo.GestionInformacionCientífica.OrganizadorDocumentos;
import MenuInteractivo.Optimizacion.QuickSortOptimizado;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Menú Interactivo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new FlowLayout());
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        JButton analisisGenomicoButton = new JButton("Análisis Genómico");
        panel.add(analisisGenomicoButton);
        analisisGenomicoButton.addActionListener(e -> handleAnalisisGenomico());

        JButton herramientasCientificasButton = new JButton("Herramientas Análisis Numérico");
        panel.add(herramientasCientificasButton);
        herramientasCientificasButton.addActionListener(e -> handleHerramientasAnalisisNumerico());

        JButton gestorInformacionButton = new JButton("Gestor de Información Científica");
        panel.add(gestorInformacionButton);
        gestorInformacionButton.addActionListener(e -> handleGestorInformacionCientifica());

        JButton quickSortButton = new JButton("QuickSort Optimizado");
        panel.add(quickSortButton);
        quickSortButton.addActionListener(e -> handleQuickSortOptimizado());
    }

    private static void handleAnalisisGenomico() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Análisis Genómico");
        dialog.setLayout(new FlowLayout());
        dialog.setSize(300, 200);

        JButton contarGenesButton = new JButton("Contar Genes");
        dialog.add(contarGenesButton);
        contarGenesButton.addActionListener(e -> {
            String adn = JOptionPane.showInputDialog("Introduce la secuencia de ADN:");
            int count = GeneCounter.contarGenes(adn);
            JOptionPane.showMessageDialog(null, "Número de genes encontrados: " + count);
        });

        JButton generarCombinacionesButton = new JButton("Generar Combinaciones");
        dialog.add(generarCombinacionesButton);
        generarCombinacionesButton.addActionListener(e -> {
            String genesStr = JOptionPane.showInputDialog("Introduce los genes separados por comas:");
            List<String> genes = Arrays.asList(genesStr.split(","));
            List<List<String>> combinaciones = GeneticCombinations.generarCombinaciones(genes);
            JOptionPane.showMessageDialog(null, "Combinaciones generadas: " + combinaciones);
        });

        dialog.pack();
        dialog.setVisible(true);
    }
    private static void handleHerramientasAnalisisNumerico() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Herramientas de Análisis Numérico");
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(0, 1));

        JButton btnSumatoria = new JButton("Sumatoria");
        btnSumatoria.addActionListener(e -> performSumatoria());
        dialog.add(btnSumatoria);

        JButton btnListarNumeros = new JButton("Listar Números");
        btnListarNumeros.addActionListener(e -> performListarNumeros());
        dialog.add(btnListarNumeros);

        JButton btnCalcularPotencia = new JButton("Calcular Potencia");
        btnCalcularPotencia.addActionListener(e -> performCalcularPotencia());
        dialog.add(btnCalcularPotencia);

        JButton btnEncontrarMaximo = new JButton("Encontrar Máximo");
        btnEncontrarMaximo.addActionListener(e -> performEncontrarMaximo());
        dialog.add(btnEncontrarMaximo);

        dialog.pack();
        dialog.setVisible(true);
    }

    // Métodos para realizar cada acción
    private static void performSumatoria() {
        String input = JOptionPane.showInputDialog("Introduce un número para la sumatoria:");
        try {
            int n = Integer.parseInt(input);
            int resultado = HerramientasAnalisisNumerico.sumatoria(n);
            JOptionPane.showMessageDialog(null, "La sumatoria de " + n + " es: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Por favor, introduce un número válido.");
        }
    }

    private static void performListarNumeros() {
        // La implementación asume que listarNumeros devuelve un String
        int inicio = Integer.parseInt(JOptionPane.showInputDialog("Número inicial:"));
        int fin = Integer.parseInt(JOptionPane.showInputDialog("Número final:"));
        JOptionPane.showMessageDialog(null, "Números listados:\n" + HerramientasAnalisisNumerico.listarNumeros(inicio, fin));
    }

    private static void performCalcularPotencia() {
        int base = Integer.parseInt(JOptionPane.showInputDialog("Base:"));
        int exponente = Integer.parseInt(JOptionPane.showInputDialog("Exponente:"));
        JOptionPane.showMessageDialog(null, "Resultado: " + HerramientasAnalisisNumerico.calcularPotencia(base, exponente));
    }

    private static void performEncontrarMaximo() {
        // Asume que encontrarMaximo ahora no requiere el índice inicial y devuelve el máximo directamente
        String[] datosStr = JOptionPane.showInputDialog("Introduce números separados por comas:").split(",");
        int[] datos = Arrays.stream(datosStr).mapToInt(Integer::parseInt).toArray();
        JOptionPane.showMessageDialog(null, "El máximo es: " + HerramientasAnalisisNumerico.encontrarMaximo(datos, 0));
    }
    private static void handleGestorInformacionCientifica() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Gestor de Información Científica");
        dialog.setLayout(new GridLayout(0, 1));
        dialog.setSize(350, 400);

        JButton ordenarDocumentoButton = new JButton("Ordenar Documento");
        dialog.add(ordenarDocumentoButton);
        ordenarDocumentoButton.addActionListener(e -> ordenarDocumento());

        JButton buscarEnDocumentoButton = new JButton("Buscar en Documento");
        dialog.add(buscarEnDocumentoButton);
        buscarEnDocumentoButton.addActionListener(e -> buscarEnDocumento());

        JButton btnBusquedaLineal = new JButton("Búsqueda Lineal en Documento");
        dialog.add(btnBusquedaLineal);
        btnBusquedaLineal.addActionListener(e -> buscarLinealEnDocumento());

        JButton btnBusquedaBinaria = new JButton("Búsqueda Binaria en Documento");
        dialog.add(btnBusquedaBinaria);
        btnBusquedaBinaria.addActionListener(e -> buscarBinariaEnDocumento());

        JButton gestorFechasButton = new JButton("Gestor de Fechas");
        dialog.add(gestorFechasButton);
        gestorFechasButton.addActionListener(e -> handleGestorFechas());

        dialog.pack();
        dialog.setVisible(true);
    }

    private static void ordenarDocumento() {
        String path = JOptionPane.showInputDialog("Ruta del documento a ordenar:");
        try {
            OrganizadorDocumentos.ordenarArchivo(path);
            JOptionPane.showMessageDialog(null, "Documento ordenado con éxito.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al ordenar el documento: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void buscarEnDocumento() {
        String path = JOptionPane.showInputDialog("Ruta del documento para buscar:");
        String palabra = JOptionPane.showInputDialog("Palabra a buscar:");
        boolean encontrado = OrganizadorDocumentos.buscarEnDocumento(path, palabra);
        JOptionPane.showMessageDialog(null, encontrado ? "Palabra encontrada" : "Palabra no encontrada");
    }
    private static void buscarLinealEnDocumento() {
        try {
            String path = JOptionPane.showInputDialog("Ruta del documento:");
            String palabra = JOptionPane.showInputDialog("Palabra a buscar:");
            List<String> lineas = Files.readAllLines(Paths.get(path));
            boolean encontrado = BusquedaTexto.busquedaLineal(lineas.toArray(new String[0]), palabra);
            JOptionPane.showMessageDialog(null, "Búsqueda Lineal: Palabra " + (encontrado ? "encontrada" : "no encontrada"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
        }
    }

    private static void buscarBinariaEnDocumento() {
        try {
            String path = JOptionPane.showInputDialog("Ruta del documento ordenado:");
            String palabra = JOptionPane.showInputDialog("Palabra a buscar:");
            List<String> lineas = Files.readAllLines(Paths.get(path));
            Collections.sort(lineas); // Asegurar que esté ordenado para la búsqueda binaria
            boolean encontrado = BusquedaTexto.busquedaBinaria(lineas.toArray(new String[0]), palabra);
            JOptionPane.showMessageDialog(null, "Búsqueda Binaria: Palabra " + (encontrado ? "encontrada" : "no encontrada"));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo.");
        }
    }
    private static void handleGestorFechas() {
        GestionFechas gestionFechas = new GestionFechas();
        JDialog dialog = new JDialog();
        dialog.setTitle("Gestor de Fechas");
        dialog.setLayout(new GridLayout(0, 1));
        dialog.setSize(350, 200);

        JButton agregarFechaButton = new JButton("Agregar Fecha");
        dialog.add(agregarFechaButton);
        agregarFechaButton.addActionListener(e -> {
            String fechaStr = JOptionPane.showInputDialog("Introduce una fecha (formato AAAA-MM-DD):");
            try {
                LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
                gestionFechas.agregarFecha(fecha);
                JOptionPane.showMessageDialog(null, "Fecha agregada.");
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha no válido.");
            }
        });

        JButton eliminarFechaButton = new JButton("Eliminar Fecha");
        dialog.add(eliminarFechaButton);
        eliminarFechaButton.addActionListener(e -> {
            String fechaStr = JOptionPane.showInputDialog("Introduce la fecha a eliminar (formato AAAA-MM-DD):");
            try {
                LocalDate fecha = LocalDate.parse(fechaStr, DateTimeFormatter.ISO_LOCAL_DATE);
                if (gestionFechas.eliminarFecha(fecha)) {
                    JOptionPane.showMessageDialog(null, "Fecha eliminada.");
                } else {
                    JOptionPane.showMessageDialog(null, "La fecha no se encontró.");
                }
            } catch (DateTimeParseException ex) {
                JOptionPane.showMessageDialog(null, "Formato de fecha no válido.");
            }
        });

        JButton listarFechasButton = new JButton("Listar Fechas");
        dialog.add(listarFechasButton);
        listarFechasButton.addActionListener(e -> {
            List<LocalDate> fechas = gestionFechas.obtenerFechas();
            StringBuilder fechasStr = new StringBuilder("Fechas:\n");
            for (LocalDate fecha : fechas) {
                fechasStr.append(fecha.toString()).append("\n");
            }
            JOptionPane.showMessageDialog(null, fechasStr.toString());
        });

        dialog.pack();
        dialog.setVisible(true);
    }
    private static void handleQuickSortOptimizado() {
        String input = JOptionPane.showInputDialog("Introduce los números separados por comas:");
        if (input != null && !input.isEmpty()) {
            try {
                int[] datos = Arrays.stream(input.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();
                QuickSortOptimizado.quickSort(datos, 0, datos.length - 1);
                JOptionPane.showMessageDialog(null, "Datos ordenados: " + Arrays.toString(datos));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, introduce solo números separados por comas.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}