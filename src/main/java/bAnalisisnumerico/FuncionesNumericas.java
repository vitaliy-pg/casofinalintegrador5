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
}
