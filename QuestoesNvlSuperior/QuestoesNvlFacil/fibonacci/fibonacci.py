def fibonacci(n):
    sequencia_fibonacci = [0, 1]
    if n <= 2:
        return sequencia_fibonacci[:n]
    else:
        for i in range(2, n):
            proximo_termo = sequencia_fibonacci[-1] + sequencia_fibonacci[-2]
            sequencia_fibonacci.append(proximo_termo)
        return sequencia_fibonacci

# Exemplo de uso
n = int(input("Digite o número de termos da sequência de Fibonacci que você deseja gerar: "))
sequencia_fibonacci = fibonacci(n)
print("Os primeiros", n, "termos da sequência de Fibonacci são:", sequencia_fibonacci)
