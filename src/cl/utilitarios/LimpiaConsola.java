package cl.utilitarios;

public class LimpiaConsola {
    public static void main(String[] args) {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        catch (Exception e) {
            /*No hacer nada*/
        }
        /*Introduce tu código desde aquí*/
    }
    public static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
