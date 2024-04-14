package bAnalisisnumerico;
import java.util.ArrayList;
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
}
