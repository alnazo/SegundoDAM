import java.io.IOException;

public class CancelacionProceso {

    public static void main(String[] args) {
        boolean notepad = false; //Cambiar a false para abrir Paint

        ProcessBuilder pb;
        Process process;

        try {
            if (notepad) {
                pb = new ProcessBuilder("notepad.exe");
            } else {
                pb = new ProcessBuilder("mspaint.exe");
            }

            process = pb.start();

            System.out.println("Proceso iniciado");
            Thread.sleep(5000);

            if (process.isAlive()){
                System.out.println("Proceso vivo");
                if (notepad){
                    ProcessBuilder taskkill = new ProcessBuilder("taskkill", "/F", "/IM", "notepad.exe");
                    Process pro = taskkill.start();
                    pro.waitFor();
                } else {
                    process.destroy();
                }
            } else {
                System.out.println("Proceso cerrado manualmente");
            }

            System.out.println("Proceso terminado");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
