package analisisgenetico;

public class counter {
    public static int contarGenes(String adn) {
        if (adn == null || adn.isEmpty()) {
            return 0;
        }
        return contarGenesRecursivo(adn, 0);
    }

    private static int contarGenesRecursivo(String adn, int index) {
        int inicioGen = adn.indexOf("ATG", index);
        if (inicioGen == -1) {
            return 0;
        } else {
            return 1 + contarGenesRecursivo(adn, inicioGen + 3);
        }
    }
}