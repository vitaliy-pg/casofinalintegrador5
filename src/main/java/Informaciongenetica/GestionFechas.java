package Informaciongenetica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionFechas {
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