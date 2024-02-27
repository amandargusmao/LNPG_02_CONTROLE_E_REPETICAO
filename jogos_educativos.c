#include <stdio.h>

int main() {
    int jogosVendidos;
    printf("Total de jogos vendidos no mes:\n");
    scanf("%d", &jogosVendidos);
    
    double precoJogo = 19.90;
    double totalVendas = jogosVendidos * precoJogo;
    int bonusVendas = jogosVendidos / 15;
    double valorBonus = totalVendas * 0.08 * bonusVendas;
    double salario = totalVendas * 0.5 + valorBonus;
    
    printf("Valor total das vendas: %.2f\nBonus: %.2f\nSalario: %.2f\n", totalVendas, valorBonus, salario);
    
    return 0;
}
