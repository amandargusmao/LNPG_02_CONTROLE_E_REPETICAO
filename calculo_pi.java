import java.util.Scanner;

public class calculo_pi {
    
    public static double calcularPi(int n) {
        double s = 0.0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                s += 1.0 / Math.pow((2.0 * i + 1), 3);
            } else {
                s -= 1.0 / Math.pow((2.0 * i + 1), 3);
            }
        }
        return Math.pow(s * 32, 1.0 / 3.0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o número de termos da série: ");
        int n = scanner.nextInt();
        
        double pi = calcularPi(n);
        System.out.printf("Valor aproximado de pi: %.5f\n", pi);
    }
}

