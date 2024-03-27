def verificar_cartas(cartas):
    naipes = set()
    valores = set()
    
    # Verifica se há cartas duplicadas
    for carta in cartas:
        if carta[:-1] in valores and carta[-1] in naipes:
            return False
        valores.add(carta[:-1])
        naipes.add(carta[-1])
    
    return True

def valor_para_int(valor):
    if valor.isdigit():
        return int(valor)
    elif valor == 'J':
        return 11
    elif valor == 'Q':
        return 12
    elif valor == 'K':
        return 13
    elif valor == 'A':
        return 14
    else:
        return None

def verificar_combinacao(cartas):
    if not verificar_cartas(cartas):
        return "Error: Combinação inválida de cartas. Tente novamente..."

    valores = sorted([carta[:-1] for carta in cartas], key=valor_para_int)
    naipes = [carta[-1] for carta in cartas]

    # Verifica Royal flush
    if valores == ['10', 'J', 'Q', 'K', 'A'] and len(set(naipes)) == 1:
        return "Royal flush!"
    
    # Verifica Straight flush
    if all(valor_para_int(valores[i]) - valor_para_int(valores[i-1]) == 1 for i in range(1, 5)) and len(set(naipes)) == 1:
        return "Straight flush!"
    
    # Verifica Quadra
    for valor in valores:
        if valores.count(valor) == 4:
            return "Quadra!"
    
    # Verifica Full House
    if len(set(valores)) == 2 and (valores.count(valores[0]) == 3 or valores.count(valores[0]) == 2):
        return "Full House!"
    
    # Verifica Flush
    if len(set(naipes)) == 1:
        return "Flush!"
    
    # Verifica Sequência
    if all(valor_para_int(valores[i]) - valor_para_int(valores[i-1]) == 1 for i in range(1, 5)):
        return "Sequência!"
    
    # Verifica Trinca
    for valor in valores:
        if valores.count(valor) == 3:
            return "Trinca!"
    
    # Verifica Dois Pares
    pares = 0
    for valor in set(valores):
        if valores.count(valor) == 2:
            pares += 1
    if pares == 2:
        return "Dois Pares!"
    
    # Verifica Par
    if any(valores.count(valor) == 2 for valor in set(valores)):
        return "Par!"
    
    # Se nenhuma combinação acima for encontrada
    return "Carta Alta!"

# Testando com exemplos de entrada
inputs = [
    ["10C", "JC", "QC", "KC", "AC"],
    ["10C", "KL", "QO", "QP", "QC"],
    ["11C", "KC", "QO", "QP", "QC"],
    ["10C", "JC", "QC", "KC", "AC"],
    ["10C", "JC", "QC", "KC", "AC"],
    ["10C", "JC", "QC", "KC", "AC"],
    ["10C", "10E", "10P", "KC", "KO"],
]

for i, entrada in enumerate(inputs):
    print(f"output{i + 1}:")
    print(verificar_combinacao(entrada))
    print()
