#include <stdio.h>
#include <math.h>

double calcularPi(int n) {
    double s = 0.0;
    for (int i = 0; i < n; i++) {
        if (i % 2 == 0) {
            s += 1.0 / pow((2.0 * i + 1), 3);
        } else {
            s -= 1.0 / pow((2.0 * i + 1), 3);
        }
    }
    return pow(s * 32, 1.0 / 3.0);
}

int main() {
    int n;
    printf("Digite o numero de termos da serie: ");
    scanf("%d", &n);
    
    double pi = calcularPi(n);
    printf("Valor aproximado de pi: %.5f\n", pi);
    return 0;
}
