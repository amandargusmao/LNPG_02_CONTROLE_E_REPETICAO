#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char nome[101];
    int nota;
} Participante;

int compara(const void *a, const void *b) {
    return strcmp(((Participante *)a)->nome, ((Participante *)b)->nome);
}

int main() {
    int gabarito[10], i, nota, nParticipantes = 0, acertos;
    Participante participantes[100];
    char nome[101];
    int maiorNota = -1, menorNota = 11;
    int acimaDaMetade = 0;

    printf("Informe o gabarito da prova, digitando 10 inteiros (1-5) separados por espacos:\n");
    for (i = 0; i < 10; i++) {
        scanf("%d", &gabarito[i]);
    }

    printf("Digite o nome do participante e suas 10 respostas (1-5), separadas por espacos. Digite '*' para encerrar:\n");
    while (scanf("%s", nome) == 1 && strcmp(nome, "*") != 0) {
        acertos = 0;
        for (i = 0; i < 10; i++) {
            scanf("%d", &nota);
            if (nota == gabarito[i]) acertos++;
        }
        strcpy(participantes[nParticipantes].nome, nome);
        participantes[nParticipantes].nota = acertos;
        if (acertos > maiorNota) maiorNota = acertos;
        if (acertos < menorNota) menorNota = acertos;
        if (acertos > 5) acimaDaMetade++;
        nParticipantes++;
    }

    qsort(participantes, nParticipantes, sizeof(Participante), compara);

    printf("\nParticipantes e suas notas em ordem alfabetica:\n");
    for (i = 0; i < nParticipantes; i++) {
        printf("%s %d\n", participantes[i].nome, participantes[i].nota);
    }

    printf("\nMaior pontuacao: %d\n", maiorNota);
    for (i = 0; i < nParticipantes; i++) {
        if (participantes[i].nota == maiorNota) {
            printf("%s\n", participantes[i].nome);
        }
    }

    printf("\nMenor pontuacao: %d\n", menorNota);
    for (i = 0; i < nParticipantes; i++) {
        if (participantes[i].nota == menorNota) {
            printf("%s\n", participantes[i].nome);
        }
    }

    double percentual = (double)acimaDaMetade / nParticipantes * 100;
    printf("\nPercentual com mais da metade das questoes certas: %.1f%%\n", percentual);

    return 0;
}
