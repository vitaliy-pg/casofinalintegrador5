package MenuInteractivo.AnalisisGenomico;

import java.util.ArrayList;
import java.util.List;

public class GeneticCombinations {
    public static List<List<String>> generarCombinaciones(List<String> genes) {
        if (genes == null || genes.isEmpty()) {
            return new ArrayList<>();
        }
        List<List<String>> todasCombinaciones = new ArrayList<>();
        generarCombinacionesRecursivo(genes, new ArrayList<>(), todasCombinaciones, 0);
        return todasCombinaciones;
    }

    private static void generarCombinacionesRecursivo(List<String> genes, List<String> actual, List<List<String>> todasCombinaciones, int start) {
        todasCombinaciones.add(new ArrayList<>(actual));
        for (int i = start; i < genes.size(); i++) {
            actual.add(genes.get(i));
            generarCombinacionesRecursivo(genes, actual, todasCombinaciones, i + 1);
            actual.remove(actual.size() - 1);
        }
    }
}
