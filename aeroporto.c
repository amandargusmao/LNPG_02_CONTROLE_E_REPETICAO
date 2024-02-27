#include <stdio.h>
#include <string.h>

int main() {
    int N;
    char rg[20], dataRG[11], passagem[20], dataPassagem[11], assento[5];
    
    printf("Informe a quantidade de passageiros: ");
    scanf("%d", &N);
    
    for(int i = 0; i < N; i++) {
        printf("\nPassageiro %d\n", i+1);
        printf("RG (Digite 'RG' ou 'Nao possui'): ");
        scanf("%s", rg);
        if(strcmp(rg, "Nao possui") == 0) {
            printf("A saida eh nessa direcao.\n");
            continue;
        }
        
        printf("Data de nascimento no RG (DD/MM/AAAA): ");
        scanf("%s", dataRG);
        
        printf("Passagem (Digite 'Passagem' ou 'Nao possui'): ");
        scanf("%s", passagem);
        if(strcmp(passagem, "Nao possui") == 0) {
            printf("A recepcao eh nessa direcao.\n");
            continue;
        }
        
        printf("Data de nascimento na Passagem (DD/MM/AAAA): ");
        scanf("%s", dataPassagem);
        
        if(strcmp(dataRG, dataPassagem) != 0) {
            printf("190\n");
            continue;
        }
        
        printf("Assento (Formato A12): ");
        scanf("%s", assento);
        
        printf("O seu assento eh %s. Tenha um otimo dia.\n", assento);
    }
    
    return 0;
}
