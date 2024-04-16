package MenuInteractivo.AnalisisNumerico;

public class HerramientasAnalisisNumerico {

    public static int sumatoria(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumatoria(n - 1);
    }

    public static String listarNumeros(int inicio, int fin) {
        StringBuilder sb = new StringBuilder();
        for (int i = inicio; i <= fin; i++) {
            sb.append(i).append('\n');
        }
        return sb.toString();
    }


    public static int calcularPotencia(int base, int exponente) {
        if (exponente < 0) {
            // Para manejar exponentes negativos, se podría lanzar una excepción o calcular la inversa.
            throw new IllegalArgumentException("El exponente no puede ser negativo.");
        }
        if (exponente == 0) {
            return 1;
        }
        return base * calcularPotencia(base, exponente - 1);
    }

    public static int encontrarMaximo(int[] datos, int indice) {
        if (datos == null || datos.length == 0) {
            // Manejar el caso de un array vacío o nulo.
            throw new IllegalArgumentException("El array no puede ser nulo o vacío.");
        }
        if (indice == datos.length - 1) {
            return datos[indice];
        }
        int maximoResto = encontrarMaximo(datos, indice + 1);
        return Math.max(datos[indice], maximoResto);
    }

}
