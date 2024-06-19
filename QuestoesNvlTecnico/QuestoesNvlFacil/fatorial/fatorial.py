def fatorial(n):
    if n < 0:
        raise ValueError("O número deve ser um inteiro não negativo.")
    if n == 0 or n == 1:
        return 1
    resultado = 1
    for i in range(2, n + 1):
        resultado *= i
    return resultado

# Exemplo de uso da função
numero = 5
print(f"O fatorial de {numero} é {fatorial(numero)}")
