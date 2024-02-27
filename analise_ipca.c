#include <stdio.h>
#include <string.h>

int main() {
    char data[10], menorData[10] = "", maiorData[10] = "";
    float ipca, menorIPCA = 99999, maiorIPCA = -99999, somaIPCA = 0;
    int contador = 0;
    
    printf("Insira a data e o valor do IPCA na mesma linha separados por um espaco. Digite '*' para terminar.\n");

    while (scanf("%s", data) && strcmp(data, "*") != 0) {
        scanf("%f", &ipca);
        somaIPCA += ipca;
        contador++;
        
        if (ipca < menorIPCA) {
            menorIPCA = ipca;
            strcpy(menorData, data);
        }
        
        if (ipca > maiorIPCA) {
            maiorIPCA = ipca;
            strcpy(maiorData, data);
        }
    }
    
    if (contador > 0) {
        printf("Menor IPCA: %.2f (%s)\n", menorIPCA, menorData);
        printf("Maior IPCA: %.2f (%s)\n", maiorIPCA, maiorData);
        printf("Media do IPCA: %.2f\n", somaIPCA / contador);
    } else {
        printf("Nenhum dado foi fornecido.\n");
    }
    
    return 0;
}
