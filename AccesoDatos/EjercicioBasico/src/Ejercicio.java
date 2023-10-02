import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> numeros = new ArrayList<>();

        System.out.println("Introduzca numeros para añadir a un listado.");
        System.out.println("Si desea terminar introduzca un 0");
        System.out.println("---------------------------------");

        while (sc.hasNextInt()) {
            int num = sc.nextInt();
            if (num == 0) break;
            numeros.add(num);
        }

        System.out.println("La lista de números es: " + numeros.toString());
        System.out.println("El número mayor es: " + numeros.stream().mapToInt(num -> num).max().getAsInt() );
        System.out.println("El número menor es: " + numeros.stream().mapToInt(num -> num).min().getAsInt() );
    }
}