# Desenvolvimento de Algoritmo: Validação de CPF

## Objetivo:

- Desenvolver um algoritmo para validar o número de CPF (Cadastro de Pessoa Física) fornecido.

## Descrição:

- O CPF é um documento brasileiro que identifica de forma única cada pessoa física. Consiste em um número de 11 dígitos, onde os últimos dois dígitos são dígitos verificadores.
- A validação do CPF é realizada utilizando-se um algoritmo que verifica se os dígitos verificadores estão corretos de acordo com as regras definidas.

## Tarefa:

- Escreva uma função ou programa que, dado um número de CPF, determine se ele é válido ou não.

## Entrada:

- Uma string contendo o número de CPF, podendo estar formatado (com pontos e traços) ou não.

## Saída:

- Um valor booleano indicando se o CPF é válido (true) ou inválido (false).

## Exemplo de entrada:

- CPF = "529.982.247-25"

## Exemplo de saída:

- true

## Notas:

- Certifique-se de que o algoritmo lida corretamente com diferentes formas de entrada (com ou sem formatação).
- Comente seu código para facilitar a compreensão.
- Considere as regras de formação e validação do CPF conforme a legislação brasileira.

# Método de Validação

No CPF (primeiros 9 digitos), o primeiro DV (penúltimo digito) é obtido através do somatório
da multiplicação de cada digito do CPF por respectivamente 9, 8, 7, 6, 5, 4, 3, 2, 1 a partir do
dígito mais a direita. Do resultado desta soma é extraído o resto da divisão por 11, e este
será o primeiro DV. Caso o resto seja 10, o DV será 0.
Por exemplo, no CPF 111.222.333-\_\_, o primeiro DV será calculado da seguinte forma:

1 1 1 2 2 2 3 3 3 (CPF)
x x x x x x x x x
1 2 3 4 5 6 7 8 9 (Multiplicadores)
1 + 2 + 3 + 8 + 10 + 12 + 21 + 24 + 27 = 108 (Somatório das multiplicações)
108/11 = 9 com resto 9 (Divisão por 11)

Sendo assim, 9 (resto da divisão) é o primeiro DV. Portanto, já fica claro que o CPF
111.222.333-45 é INVÁLIDO, pois o primeiro DV informado foi 4, e através do cálculo vimos
que deveria ser 9.
O segundo DV (último digito) é calculado de maneira similar. É feito o somatório da
multiplicação de cada digito do CPF mais o primeiro DV (obtido anteriormente) por
respectivamente 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 a partir do dígito mais a direita. Do resultado também
é extraído o resto da divisão por 11.
Por exemplo, no CPF 111.222.333-9\_, o segundo DV será calculado da seguinte forma:

1 1 1 2 2 2 3 3 3 9 (CPF + primeiro DV)
x x x x x x x x x x
0 1 2 3 4 5 6 7 8 9 (Multiplicadores)
0 + 1 + 2 + 6 + 8 + 10 + 18 + 21 + 24 + 81 = 171 (Somatório das multiplicações)
171/11 = 15 com resto 6 (Divisão por 11)

Sendo assim, 6 é o segundo DV. Por isso, a única forma do CPF 111.222.333 ser válido é se
os dois dígitos DV forem 96. O CPF informado é inválido, já que os DVs informados foram 45.

## Notas

- Não é permitido uso de funções prontas da linguagem utilizada
