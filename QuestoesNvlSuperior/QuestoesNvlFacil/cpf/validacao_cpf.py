def validar_cpf(cpf):
    # Remover caracteres especiais do CPF
    cpf = ''.join(filter(str.isdigit, cpf))

    # Verificar se o CPF tem 11 dígitos
    if len(cpf) != 11:
        return False

    # Verificar se todos os dígitos são iguais
    if cpf == cpf[0] * 11:
        return False

    # Calcular o primeiro dígito verificador
    soma = 0
    peso = 10
    for i in range(9):
        soma += int(cpf[i]) * peso
        peso -= 1
    digito_1 = 11 - (soma % 11)
    if digito_1 > 9:
        digito_1 = 0

    # Verificar o primeiro dígito verificador
    if int(cpf[9]) != digito_1:
        return False

    # Calcular o segundo dígito verificador
    soma = 0
    peso = 11
    for i in range(10):
        soma += int(cpf[i]) * peso
        peso -= 1
    digito_2 = 11 - (soma % 11)
    if digito_2 > 9:
        digito_2 = 0

    # Verificar o segundo dígito verificador
    if int(cpf[10]) != digito_2:
        return False

    return True

# Exemplo de uso
cpf = input("Digite o CPF para validar (somente números): ")
if validar_cpf(cpf):
    print("CPF válido!")
else:
    print("CPF inválido!")
