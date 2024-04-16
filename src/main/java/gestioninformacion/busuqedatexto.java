package gestioninformacion;



public class busuqedatexto {

    public static boolean busquedaLineal(String[] textos, String palabra) {
        for (String texto : textos) {
            if (texto.equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    public static boolean busquedaBinaria(String[] textos, String palabra) {
        int bajo = 0;
        int alto = textos.length - 1;

        while (bajo <= alto) {
            int medio = bajo + (alto - bajo) / 2;
            int resultado = palabra.compareTo(textos[medio]);

            if (resultado == 0) return true;
            if (resultado > 0) bajo = medio + 1;
            else alto = medio - 1;
        }
        return false;
    }
}