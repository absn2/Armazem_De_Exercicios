# QUESTAO 6

#INICILIZA UM ARRAY ARBITRARIO (OS 2 ARRAYS MESMO TAMANHO)
.data
array: .word 3, 1, 2, 10, 11, 120, 13, 17, 19, 23

arrayPrimos: .word 0,0,0,0,0,0,0,0,0,0,0,0,0

.text
la $t0, array
la $t8, arrayPrimos # cria indice que adiciona num outro array

# CRIA O INIDICE DO INDEX DO ARRAY EM $t2
addi $t1, $zero, 0
addi $s0, $zero, 2
add $s5, $t1, $t0 # $s5, endBase + 4i



IteraNoArray:
	# $t3 PORTA O VALOR DE UM ELEMENTO DO ARRAY
	lw $t2,0($s5)
	
	jal IsPrime
	
	addi $a0, $zero, 1 # $a0 contem 1 para verificar se o numero eh primo
	beq $v0, $a0, ColocaNoArray # se ele for primo coloca ele no array
	
VoltaAqui:
	# INCREMENTA SEGUNDO INDICE EM 4
	addi $s5, $s5, 4
	
	# VERIFICA SE O ARRAY ACABOU
	addi $a3, $zero, 40
	sub $s7, $s5, $t0 # se o end. atual do array - end. base = 40 (ja andou 10 casas), acaba o programa
	beq $s7, $a3, Exit # se $a2 != 0 ( $a2 == 1 ) ou seja, o array acabou
	
	
	j IteraNoArray

IsPrime:
	# CRIA O INIDICE DO LOOP EM $s0
	slt  $s1, $s0, $t2 # se 2 < num
	bne $s1, $zero, IsPrimeLoop
	addi $v0, $zero, 1 # Eh primo
	
	jr $ra
	
IsPrimeLoop:
	div	$t2, $s0					
	mfhi	$t3	# $t3 contem (num % x)
	slti	$t4, $t3, 1	# se o resto for menor que 1		
	beq	$t4, $zero, is_prime_loop_continue # se ($t3 == 0)
	add	$v0, $zero, $zero # nao eh primo
	jr	$ra	
	
is_prime_loop_continue:		
	addi $s0, $s0, 1 # incrementa 1 no $s0
	j IsPrime	# continua o loop


ColocaNoArray:
	sw $t2, 0($t8)
	# INCREMENTA SEGUNDO INDICE EM 4
	addi $t8, $t8, 4
	j VoltaAqui
	
	
Exit:
