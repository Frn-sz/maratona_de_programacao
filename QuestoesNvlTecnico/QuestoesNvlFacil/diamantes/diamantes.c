#include <stdio.h>

void diamantes(int n) {
    if (n % 2 == 0) {
        // Se n for par, aumente em 1 para garantir que o diamante seja simétrico
        n++;
    }

    // Desenha a parte superior do diamante
    for (int i = 0; i < n / 2 + 1; i++) {
        for (int j = 0; j < n / 2 - i; j++) {
            printf(" ");
        }
        for (int j = 0; j < 2 * i + 1; j++) {
            printf("*");
        }
        printf("\n");
    }

    // Desenha a parte inferior do diamante
    for (int i = n / 2 - 1; i >= 0; i--) {
        for (int j = 0; j < n / 2 - i; j++) {
            printf(" ");
        }
        for (int j = 0; j < 2 * i + 1; j++) {
            printf("*");
        }
        printf("\n");
    }
}

int main() {
    diamantes(5);
    return 0;
}
