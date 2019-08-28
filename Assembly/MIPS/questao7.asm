.data
	a: .word 0
	b: .word 4
.text

	
	.globl main
	
	main:

		lw $a0,a
		lw $a1,b
		

		jal fn #function's caller
		j Exit
	
	.globl fn
	
	fn: #essa funcao checa se a>b se a maior que b bota 1 em $v1 senao chama a funcao func
		beq $a0,$a1 RetornaA #se a==b faz $v1 = a
		slt $t1,$a1,$a0
		beq $t1,1,RetornaUm
		j func
		jr $ra
		RetornaUm:
			addi $v1,$zero,1
			jr $ra
		RetornaA:
			add $v1,$zero,$a0
			jr $ra
		
	func:	
		addi $sp,$sp,-12
		sw $ra, 8($sp) #salva endereço de retorno na pilha
		sw $a0, 4($sp) #salva argumento na pilha
		sw $a1, 0($sp) #salva argumento na pilha
		bne $a0,$a1, Aux
		jr $ra
		
	Aux: 	addi $a1,$a1,-1
		jal func
		lw $ra, 8($sp) #pega end da pilha
		lw $a0, 4($sp) #pega arg da pilha
		lw $a1, 0($sp)	#pega arg da pilha
		
		addi $sp,$sp,12 #sobe na pilha para alcançar informacoes armazenadas anteriormente
		add $v1,$v1,$a1
		Fim:	jr $ra
		
	
	Exit: