import java.util.Scanner;

public class jogos_educativos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Total de jogos vendidos no mês:");
        int jogosVendidos = scanner.nextInt();
        
        double precoJogo = 19.90;
        double totalVendas = jogosVendidos * precoJogo;
        int bonusVendas = jogosVendidos / 15;
        double valorBonus = totalVendas * 0.08 * bonusVendas;
        double salario = totalVendas * 0.5 + valorBonus;
        
        System.out.printf("Valor total das vendas: %.2f\nBônus: %.2f\nSalário: %.2f\n", totalVendas, valorBonus, salario);
    }
}
