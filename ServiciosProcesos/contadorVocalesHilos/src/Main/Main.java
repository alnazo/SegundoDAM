package Main;

import contadores.*;

public class Main {
    public static String frase = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris ultrices vel est sed dictum. Fusce ac malesuada augue. Vestibulum sed dolor purus. Etiam dictum dui eget dapibus gravida. Integer massa libero, interdum sed volutpat viverra, lobortis et neque. Aliquam ut lectus pulvinar, commodo ipsum nec, sollicitudin lorem. Cras in tellus ante. Morbi eu mauris et ligula elementum pellentesque vel ut lorem. Nunc quis arcu sed elit dapibus tincidunt. Curabitur ac metus mattis, volutpat nulla non, venenatis magna. Integer accumsan ultricies velit, in congue turpis tempus id. Praesent placerat, nibh vel pulvinar molestie, erat ligula consequat odio, in volutpat risus ipsum id diam.\n" +
            "\n" +
            "Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Ut congue maximus nibh, dictum condimentum turpis pharetra quis. Mauris justo arcu, venenatis ac ultrices vitae, laoreet sollicitudin ligula. Sed rhoncus, erat ac rutrum fermentum, dui tortor congue arcu, vel suscipit orci ipsum in sapien. Sed sit amet ante in neque euismod gravida eu ut nulla. Donec aliquet nisl vel ligula interdum rutrum et sed est. In erat nulla, pretium vel consequat et, facilisis non sem. In lobortis at arcu ut mollis. Nunc bibendum justo ac pellentesque hendrerit.\n" +
            "\n" +
            "Fusce interdum tellus et tortor volutpat sollicitudin. Phasellus odio lectus, tempus rutrum dolor et, tristique posuere nunc. Proin pulvinar venenatis diam, vel posuere urna malesuada eget. Vivamus vitae mi nunc. Donec et dapibus leo, quis vehicula lacus. Ut in elit turpis. In quis feugiat tortor, eu viverra felis. Pellentesque sit amet nulla massa. Aenean congue, mauris sed efficitur porttitor, est sapien sagittis sapien, at cursus tortor justo non odio. Vestibulum eget tortor eget risus lacinia pharetra. Etiam sagittis magna nibh, at mattis dui laoreet tristique.\n" +
            "\n" +
            "Nullam finibus laoreet libero a convallis. In iaculis risus erat, a pulvinar nisi rutrum id. Maecenas ut nisl at neque scelerisque bibendum. Nulla cursus, risus nec consectetur auctor, eros nulla sollicitudin leo, et rhoncus eros nulla vel tortor. In vel bibendum magna. Curabitur nulla dui, placerat eget odio id, feugiat convallis ligula. Donec libero leo, lobortis nec odio nec, ultricies euismod diam. Vestibulum sed lorem nec lorem maximus aliquet. Vivamus pretium consequat elementum.\n" +
            "\n" +
            "Pellentesque quis mi risus. Curabitur consectetur felis dictum arcu auctor, ac vulputate lectus condimentum. Quisque sed venenatis leo. Etiam lacinia in nulla ac bibendum. Aenean pharetra dapibus dictum. Vestibulum leo arcu, cursus at massa eu, iaculis pellentesque magna. Morbi vel vulputate lacus, eget porttitor purus. Ut vitae convallis ipsum. Donec rutrum mauris mauris, quis vestibulum dolor consequat ut. Morbi ex leo, consequat at nisl quis, sollicitudin euismod ipsum. Integer metus nisl, tempus ac cursus vestibulum, pellentesque vel lectus.";
    public static int contadorTotal = 0;

    public static void main(String[] args) {

        Thread hiloVocalA = new Thread(new ContadorVocalA(frase));
        Thread hiloVocalE = new Thread(new ContadorVocalE(frase));
        Thread hiloVocalI = new Thread(new ContadorVocalI(frase));
        Thread hiloVocalO = new Thread(new ContadorVocalO(frase));
        Thread hiloVocalU = new Thread(new ContadorVocalU(frase));

        hiloVocalA.start();
        hiloVocalE.start();
        hiloVocalI.start();
        hiloVocalO.start();
        hiloVocalU.start();
        try {
            Thread.sleep(500);
            System.out.println("Contador total: " + contadorTotal);
        } catch (InterruptedException e){}
    }

}
