# Ordenações de somas.

É lhe dado uma sequência de numeros (um array) que contém alguns numeros positivos e também zeros.

### Objetivo: 
Seu objetivo consiste em ordenar as partes do array divididas em zero de acordo com suas respectivas somas, sendo em ordem crescente:

* Demonstração:
__Exemplo: [3,2,1,0,5,6,4,0,1,5,3,0]__
__Partes e somas: [3,2,1,0] = 6, [5,6,4,0] = 15, [1,5,3,0] = 9__\
__Ordenação: [3,2,1,0], [1,5,3,0], [5,6,4,0]__

### Observações: 
*  Cada parte é separada por zero e terminará em zero (0).

## Exemplos de entrada e saida:

```
1° entrada -> sortSequence([3,2,1,0,5,6,4,0,1,5,3,0,4,2,8,0]); 
1° saida -> [3,2,1,0,1,5,3,0,4,2,8,0,5,6,4,0];
---
2° entrada -> sortSequence([3,2,1,0,5,6,4,0,1,5,3,0,2,2,2,0]); 
2° saida -> [3,2,1,0,2,2,2,0,1,5,3,0,5,6,4,0];
---
3° entrada -> sortSequence([2,2,2,0,5,6,4,0,1,5,3,0,3,2,1,0]); 
3° saida -> [2,2,2,0,3,2,1,0,1,5,3,0,5,6,4,0];
```

