# Jogo da Vida

## Descrição
Este "jogo" é na realidade um jogo sem jogador, o que quer dizer que sua evolução é determinada pelo seu estado inicial, não necessitando de nenhuma entrada de jogadores humanos. Ele é jogado em um conjunto de células quadradas que seguem ao infinito em todas as direções. Cada célula tem oito "vizinhos", que são as células adjacentes, incluindo as diagonais. Cada célula pode estar em dois estados: "viva" ou "morta". (Também são usados os termos "ligado" e "desligado".) O estado do tabuleiro evolui e se modifica em pequenas passagens de tempo. Os estados de todas as células em um instante são considerados para calcular o estado de todas as células no instante seguinte. Todas as células são atualizadas simultaneamente. As transições dependem apenas do número de vizinhos vivos (ver as regras).

##  Regras
- Toda célula morta com exatamente três vizinhos vivos torna-se viva (nascimento).
- Toda célula viva com menos de dois vizinhos vivos morre por isolamento.
- Toda célula viva com mais de três vizinhos vivos morre por superpopulação.
- Toda célula viva com dois ou três vizinhos vivos permanece viva.

As regras são aplicadas simultaneamente em todas as células para chegar ao estado da próxima geração.

## Objetivo
Crie o Jogo da Vida seguindo às regras descritas acima, vamos limitar-nos a apenas uma matriz de 15x15, com o Planador no canto inferior direito de forma que siga o caminho diagonal até o canto superior esquerdo.

Planador:

![alt text](image.png)

Faça com que o jogo seja apresentado no terminal, representando as células mortas com um espaço em branco e as vivas como 'C'. Como no exemplo abaixo.

```sh
| = = = = = = = = = = = = = = = |
|                               |
|                               |
|                               |
|                               |
|                               |
|                               |
|                               |
|                               |
|                               |
|                               |
|                               |
|                               |
|                         C C C |
|                         C     |
|                           C   |
| = = = = = = = = = = = = = = = |
```