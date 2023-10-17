import java.io.IOException;

public class CancelacionProceso {

    public static void main(String[] args) {

        try {
            ProcessBuilder pb = new ProcessBuilder("notepad.exe");
            Process process = pb.start();

            System.out.println("Proceso iniciado");
            Thread.sleep(5000);

            if (process.isAlive()){
                System.out.println("Proceso vivo");

                ProcessBuilder taskkill = new ProcessBuilder("taskkill", "/F", "/IM", "notepad.exe");
                Process pro = taskkill.start();
                pro.waitFor();

            } else {
                System.out.println("Proceso cerrado manualmente");
            }

            System.out.println("Proceso terminado");

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

}
