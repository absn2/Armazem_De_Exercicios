.data
	string: .asciiz "HardWAREeuAmoESSACADEIRA"
	zero: .word 0	
.text
	la $t0, string

toLowerCase: #inicia as checagens
	lb $t2, 0($t0)
	beqz $t2, bubblesort #ve se a string acabou
	li $t1,'A' 
	bge $t2, $t1, isUpperCase #ve se a letra é maior ou igual a A
	j beforeend #se nao for, vai pro beforeend
	
isUpperCase: #segunda checagem
	li $t1, 'Z' 
	ble $t2, $t1, tomin #ve se é menor que Z
	li $t1, 'a' 
	blt $t2,$t1,beforeend #se nao for menor que Z, verifica se Ã© uma letra minuscula
	li $t1, 'z'
	bgt $t2,$t1,beforeend
	
continue:
	add $t0, $t0, 1 #passar para o prox elemento do array
	addi $t8, $t8, 1
	j toLowerCase #volta pro loop


tomin:
	addi $t2, $t2, 32 #passa para minuscula
	sb $t2, ($t0)    # store it in the string  
	j continue

beforeend: #verificou que não é uma letra
	addi $v1,$v1,1
	j end2 #envia pro final sem printar
	
	
bubblesort: #bubblesort
	sub $t9,$t8,1 # n-1

	for1: #primeiro for com i
		beq $t6,$t9,end #verifica se é igual a n-1
		lw $t7,zero #reseta y
		la $t0, string
		la $t1, string
		addi $t1,$t1,1 #para pegar o prox depois de string[y]	
	for2: #com y
		beq $t7,$t9, somaum #se y for igual a n-1, ele para e soma um em i (t6)
		lb $t3, ($t0) #array[y]
		lb $t4, ($t1) #array[y+1]
		bgt $t3, $t4,swap 
		addi $t0,$t0,1 #pega o prox elemento
		addi $t1,$t1,1 #pega o dps do prox
		addi $t7,$t7,1 #adiciona 1 em y
		j for2
	 
	swap: #faz o swap entre 2 elementos do array
		lb $t2, 0($t0) 
		lb $t5, 0($t1)
		sb $t2, 0($t1)
		sb $t5, 0($t0)
		addi $t0,$t0,1
		addi $t1,$t1,1
		addi $t7,$t7,1
		j for2
		
	somaum:
		addi $t6,$t6,1
		j for1
	


end: #printa a string
	li $v0,4
	la $a0,string
	syscall

end2: #nao faz nada (caso tenha um caractere diferente de letra)
