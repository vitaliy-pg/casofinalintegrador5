package Informaciongenetica;

import java.time.LocalDate;
import java.util.*;

public class gestiondefechas {
    public static void main(String[] args) {
        List<LocalDate> fechas = new ArrayList<>();
        fechas.add(LocalDate.of(2024, 4, 1));
        fechas.add(LocalDate.of(2023, 12, 15));
        fechas.add(LocalDate.of(2024, 2, 28));

        System.out.println("Fechas sin ordenar:");
        for (LocalDate fecha : fechas) {
            System.out.println(fecha);
        }

        Collections.sort(fechas);

        System.out.println("\nFechas ordenadas:");
        for (LocalDate fecha : fechas) {
            System.out.println(fecha);
        }
    }
}
