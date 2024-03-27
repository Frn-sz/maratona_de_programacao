# Combinações do poker
No poker a mesa rotaciona em sentido horário, 
as cartas seguem a ordem de 2, 3, 4, 5, 6, 7, 8, 9, 10, j, q, k, a.
E são 4 naipes, fazendo assim 52 cartas únicas. 

A ordem das mãos mais fortes são consecutivamente:
    -   Royal flush     = [10O, JO,  QO, KO, AO ];
    -   Straight Flus   = [AO,  KO,  QO, JO, 10O];
    -   Quadra          = [7E,  AP,  AE, AO, AC ];
    -   Full House      = [10P, 10C, KP, KO, KE ];
    -   Flush           = [QC,  10C, 9C, 7C, 4C ];
    -   Sequência       = [2O,  3P,  4C, 5E, 6P ];
    -   Trinca          = [KP,  KO,  KC, 4C, 7O ];
    -   Dois Pares      = [5O,  3P,  3E, 9O, 9C ];
    -   Par             = [3C,  6P,  8O, AP, AC ];
    -   Carta Alta      = [KP,  JC,  10C,2O, 5P ].

Faça um programa que receba como entrada um conjunto de 5 cartas e 
devolva qual a combinação feita. Caso receba entrada inválida, este
deve escrever o seguinte erro:

```sh
Error: Combinação inválida de cartas. Tente novamente...
```

Após, encerrrar o programa.

## Exemplo de entrada:
Input¹: [10C,JC,QC,KC,AC]

Input²: [10C,KL,QO,QP,QC]

Input³: [11C,KC,QO,QP,QC]

Input⁴: 10C,JC,QC,KC,AC

Input⁵: [10C,JC,QC,KC,AC

Input⁶: 10C,JC,QC,KC,AC]

## Exemplo de saída:
output¹:
```sh
Royal flush!
```

output²:
```sh
Error: Combinação inválida de cartas. Tente novamente...
```

output³:
```sh
Error: Combinação inválida de cartas. Tente novamente...
```

output⁴:
```sh
Royal flush!
```

output⁵:
```sh
Royal flush!
```

output⁶:
```sh
Royal flush!
```