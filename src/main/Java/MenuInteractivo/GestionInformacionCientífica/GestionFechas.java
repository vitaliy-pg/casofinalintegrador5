package MenuInteractivo.GestionInformacionCientífica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionFechas {

    private List<LocalDate> fechas;

    public GestionFechas () {
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