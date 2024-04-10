# MD5
MD5 é um dos mais populares algoritmos de criptografia, apesar de já ter sido explorado e exposto suas fraquezas,
há muita gente que ainda prefere utilizá-lo, na distribuição linux Manjaro por exemplo, é utilizado para verificar
e veracidade de um arquivo. Pois a entrada sempre gerará um HASH único, portanto se a entrada sempre for a mesma
o resultado também será idêntico, mas com uma simples mudança como um "." no lugar de uma "," já gera um hash completamente
diferente.

Crie um algoritmo de criptografia MD5.

## Exemplos:
## Entrada:
input¹:
```zh
Geraldo comprou 5 maçãs e saiu para pescar, usou maçãs como iscas, que doideira!
```
input²:
```zh
Geraldo comprou 5 maçãs e saiu para pescar, usou maçãs como iscas. que doideira!
```
input³:
```zh
Geraldo comprou 5 maçãs e saiu para pescar, usou maçãs como iscas, que doideira!
```

## Saída:
output¹:
```zh
d31899e6e4660936913b3b557a3ffc68
```

output²:
```zh
28329e9dc4bf177bd31e85bf5326217c
```

output³:
```zh
d31899e6e4660936913b3b557a3ffc68
```
