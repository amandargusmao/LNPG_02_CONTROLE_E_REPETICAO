import java.util.Scanner;

public class analise_ipca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data, menorData = "", maiorData = "";
        float ipca, menorIPCA = Float.MAX_VALUE, maiorIPCA = Float.MIN_VALUE, somaIPCA = 0;
        int contador = 0;

        System.out.println("Insira a data e o valor do IPCA na mesma linha separados por um espaço. Digite '*' para terminar.");

        while (scanner.hasNext()) {
            data = scanner.next();
            if (data.equals("*")) break;
            ipca = scanner.nextFloat();
            somaIPCA += ipca;
            contador++;

            if (ipca < menorIPCA) {
                menorIPCA = ipca;
                menorData = data;
            }

            if (ipca > maiorIPCA) {
                maiorIPCA = ipca;
                maiorData = data;
            }
        }

        if (contador > 0) {
            System.out.printf("Menor IPCA: %.2f (%s)\n", menorIPCA, menorData);
            System.out.printf("Maior IPCA: %.2f (%s)\n", maiorIPCA, maiorData);
            System.out.printf("Média do IPCA: %.2f\n", somaIPCA / contador);
        } else {
            System.out.println("Nenhum dado foi fornecido.");
        }

        scanner.close();
    }
}
