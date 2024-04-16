package optimizacion;

public class quickshort {

    private static int hacerParticion(int[] datos, int primerElemento, int ultimoElemento) {
        int indiceMedio = primerElemento + (ultimoElemento - primerElemento) / 2;
        int pivote = medianaDeTres(datos, primerElemento, indiceMedio, ultimoElemento);

        int i = primerElemento - 1;
        int j = ultimoElemento + 1;
        while (true) {
            do {
                i++;
            } while (datos[i] < pivote);
            do {
                j--;
            } while (datos[j] > pivote);
            if (i >= j) {
                return j;
            }
            intercambiar(datos, i, j);
        }
    }

    private static int medianaDeTres(int[] datos, int primerElemento, int indiceMedio, int ultimoElemento) {
        if (datos[ultimoElemento] < datos[primerElemento]) {
            intercambiar(datos, primerElemento, ultimoElemento);
        }
        if (datos[indiceMedio] < datos[primerElemento]) {
            intercambiar(datos, indiceMedio, primerElemento);
        }
        if (datos[ultimoElemento] < datos[indiceMedio]) {
            intercambiar(datos, ultimoElemento, indiceMedio);
        }
        intercambiar(datos, indiceMedio, ultimoElemento - 1);
        return datos[ultimoElemento - 1];
    }

    private static void intercambiar(int[] datos, int i, int j) {
        int temp = datos[i];
        datos[i] = datos[j];
        datos[j] = temp;
    }

    public static void quickSort(int[] datos, int primerElemento, int ultimoElemento) {
        if (primerElemento < ultimoElemento) {
            int indicePivote = hacerParticion(datos, primerElemento, ultimoElemento);
            quickSort(datos, primerElemento, indicePivote);
            quickSort(datos, indicePivote + 1, ultimoElemento);
        }
    }
}
