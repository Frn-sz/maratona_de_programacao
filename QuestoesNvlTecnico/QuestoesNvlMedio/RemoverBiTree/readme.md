## Remover BiTree

As árvores estão diariamente presentes em nossos sistemas, de uma forma ou de outra, sendo no banco de dados ou nos gerenciamento de arquivos.
uma das primeiras que aprendemos a fazer é a árvore binaria. Sua funcionalidade é bastante simples de entender, se o valor inserido for maior
que o do nó pai, ele cai para a direita desse nó, se for menor, para esquerda, se não houver valor a ser comparado com a entrada. Ele assume a
posição. Assim ficando todos os maiores valores à direita da árvore e os menores à esquerda.

Sua missão é criar a funcionalidade de remover um nó dessa árvore, considerando-a de tipo inteiro.
Para uma remover um item da árvore, deve-se prestar atenção em algumas situações.

 1. Se o nó a ser removido não tiver nenhum filho. Apenas remova aquele nó e faça o nó pai reconhecer a remoção.
 2. Se o nó tiver N filhos à esquerda. Pegar o seu precessor, colocá-lo no lugar desse nó, fazendo o nó pai reconhecer o precessor como filho e o precessor reconhecer o nó pai como pai e remover o nó.
 3. Se o nó tiver N filhos à direita. Pegar o seu sucecessor, colocá-lo no lugar desse nó, fazendo o nó pai reconhecer o precessor como filho e o precessor reconhecer o nó pai como pai e remover o nó.
 4. Se o nó tiver N filhos em ambos os lados. Pegar seu precessor, fazê-lo reconhecer o filho à direita do nó a ser removido como filho dele. Fazer o nó à direita reconhecer o precessor como pai, posteriormente o pai reconhecer seu novo filho e remover o nó desejado.

Caso esteja removendo a raiz, o nó substituto não terá pai e nem pai para reconhecê-lo. No demais, cairá em um dos quatro casos.

## Obs.: Implemente apenas a função de remover nós.

Exemplo de nó:
````c
typedef struct no{
    no* pai;
    no* direita;
    no* esquerda;
    int valor;
} no;
````