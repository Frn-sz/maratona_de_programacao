#AVL
No mundo da programação as árvores são utilizadas em muitas partes de um software e de um sistema operacional,
desde simples ordenação de dados para serem buscados até estrutura de diretórios. Uma árvore bastante conhecida
é a árvore de busca binária, onde A contém apenas n=2 sendo n >= r ou n <= r, todo n >= r cai para a direita e
todo n <= r cai para a esquerda de r. Assim, quando um valor for buscado, a complexidade da busca será no pior 
caso log(n), mas quando se tem muitos valores maiores que r, ela deixa de ser eficiente, pois há muitos nós de 
um lado e não de outros, perdendo o sentido de usá-la, pois ficará equivalente a uma lista encadeada, tornando
seu pior caso de busca em O(n).

Diante deste problema foi desenvolvida a AVL, que é uma árvore binária de busca auto-balanceável, isto é, independente
da quantidade de itens adicionado à ela, sempre sua altura será de h <= 1 iy h >= -1. Para a AVL ser auto-balanceável,
ela deve se re-organizar de acordo com a necessidade na insersão de um novo nó.

Crie um programa que gere uma AVL de inteiros e receba até 7 insersões pela entrada de dados
padrão do sistema operacional e imprima-a na tela em pré-ordem.

Em caso de entrada inválida, deve-se retornar uma mensagem de erro.

## Exemplo de entrada:
input¹: 5 7 8 9 1 10 3


## Exemplo de saída:
Output¹: 1 3 5 7 8 9 10

