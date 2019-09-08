.data
	UserMsg: .asciiz "insira um valor: " # nao mexer, a propria interface do MARS vai pedir para vc inserir um valor do teclado.
	RetornoFibo: .asciiz "Retorno de Fibonacci: "

.text

	# Printe a mensagem de Input
	li $v0, 4
	la $a0, UserMsg
	syscall
	# Pega o inteiro do input do usuario
	li $v0,5
	syscall	
	
	# $a0 vai ser meu argumento com o numero
	add $a0, $zero, $v0 # passa o valor de $v0 para $a0
	jal Fibo
	
	move $a1, $v0 # salve o retorno em a1

	
	j printFibo

printFibo:
	# Printe a mensagem de Output
	li $v0, 4
	la $a0, RetornoFibo
	syscall
	
	# Printe o retorno de Fibo
	li $v0, 1
	move $a0, $a1
	syscall
	
	
	# Exit
	li $v0, 10
	syscall
	

Fibo:
	#ELSE:
	
	addi $sp, $sp, -12 # pega 2 lugares na pilha
	sw $s0, 4($sp) # salva na pilha o valor
	sw $s1, 0($sp) # salva na pilha o valor
	sw $ra, 8($sp) # salva o retorno na pilha
	
	move $s0, $a0 # passa $a0 para $s0
	
	li $v0, 1 # coloca o valor 1 em $v0
	ble $s0, 0x2, MenorIgualAUm # se for <= 2
	addi $a0, $s0, -1 # Num - 1
        jal Fibo
	
	
	move $s1, $v0  # passa $a0 para $s1
	addi $a0, $s0, -2 # Num - 2
	jal Fibo
	
	
	add $v0, $s1, $v0 # passe o retorno para $v0
	
	

MenorIgualAUm:
	lw $ra, 8($sp)
	lw $s0, 4($sp)
	lw $s1, 0($sp)
	addi $sp, $sp, 12
	jr $ra
	
	#add $s7, $zero, $a0 # passa o valor de $a0 pra o retorno
	#j printFibo
	


	
