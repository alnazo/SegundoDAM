public class HiloFibonacci extends Thread {

    long n, num1 = 0, num2 = 1, sum;

    public HiloFibonacci(int n){
        this.n = n;
    }

    public void run() {
        for(int i = 1; i < n; i++){
            sum = num1 + num2;
            num1 = num2;
            num2 = sum;
        }
        System.out.println("La serie fibonnaci de N = " + n + " es: " + sum);
    }
}
