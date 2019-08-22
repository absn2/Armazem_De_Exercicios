import math

def fatorial(any):
    if any == 0 or any == 1:
        return 1
    else:
        return any * fatorial(any-1)

def combinatoria(usuarios,quantAtivos):
    x = fatorial(usuarios)
    y = fatorial(usuarios-quantAtivos)
    z = fatorial(quantAtivos)
    result = x / (z*y)
    return result

def probabilidade (prob, quant):
    prob = math.pow(prob, quant)
    return prob

def distBinomial(sucess, fail, usuarios, quantAtivos):
    permutation = combinatoria(usuarios, quantAtivos)
    return permutation*sucess*fail

def main():
    result = 0
    print("Insira a totalidade de usuarios da rede:")
    usuarios = int(input())
    print("Quantos usuarios no maximo podem estar conectados na rede ao mesmo tempo:")
    quantAtivos = int(input())
    aux = quantAtivos
    print("Probabilidade de um usuario estar ativo na rede:")
    probSucess= float(input())
    probFail = 1 - probSucess
    print("---CALCULANDO---")
    for i in range (usuarios-quantAtivos):
        aux += 1
        sucess = probabilidade(probSucess, aux)
        fail = probabilidade(probFail, usuarios - aux)
        result += distBinomial(sucess, fail, usuarios, aux)
    print("Probabilidade ter mais que %d usuarios ativos na rede é de aprox %.4f, ou seja "
          "%.2f porcentos." % (quantAtivos,result,result*100))

if __name__ == "__main__":
    main()