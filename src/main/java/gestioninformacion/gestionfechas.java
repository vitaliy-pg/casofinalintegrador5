package gestioninformacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class gestionfechas {

    private List<LocalDate> fechas;

    public gestionfechas () {
        this.fechas = new ArrayList<>();
    }

    public void agregarFecha(LocalDate fecha) {
        if (!fechas.contains(fecha)) {
            fechas.add(fecha);
            Collections.sort(fechas);
        }
    }

    public boolean eliminarFecha(LocalDate fecha) {
        return fechas.remove(fecha);
    }

    public List<LocalDate> obtenerFechas() {
        return fechas;
    }
}