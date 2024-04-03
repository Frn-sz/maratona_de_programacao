# Ordenações divididas por zero.

É lhe dado uma sequência de numeros (um array) que contém alguns numeros positivos e também zeros.

Exemplo para entendimento: [3,2,1,0,5,6,4,0,1,5,3,0,4,2,8,0]

### Objetivo: 
Seu objetivo consiste em dois detalhes ou melhor, duas ordenações:

* Ordenar os numeros das partes do array terminadas em zero (0) em ordem crescente.\
__(Parte não ordenada: [3,2,1,0], [5,6,4,0] ...__\
__(Parte ordenada: [1,2,3,0], [4,5,6,0] ...__

* Ordenar as partes de acordo com a soma de todos os seus números de sua parte em ordem crescente.\

### Observações: 
*  As partes sempre terminarão em zero (0), ou seja, o numero zero (0) não muda de posição, sem a necessidade de ordena-lo, como foi exemplificado no primeiro objetivo.

## Exemplos de entrada e saida:

```
1° entrada -> sortSequence([3,2,1,0,5,6,4,0,1,5,3,0,4,2,8,0]); 
1° saida -> [1,2,3,0,1,3,5,0,2,4,8,0,4,5,6,0];
---
2° entrada -> sortSequence([3,2,1,0,5,6,4,0,1,5,3,0,2,2,2,0]); 
2° saida -> [1,2,3,0,2,2,2,0,1,3,5,0,4,5,6,0];
---
3° entrada -> sortSequence([2,2,2,0,5,6,4,0,1,5,3,0,3,2,1,0]); 
3° saida -> [2,2,2,0,1,2,3,0,1,3,5,0,4,5,6,0];
```

