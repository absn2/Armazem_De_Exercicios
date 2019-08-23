.data

a: .word 3
b: .word 9
c: .word -1
result: .word 0

.text
lw $s1, a
lw $s2, b
lw $s3, c
lw $t4, result
crtCond: # Criando as variaves para checar se é possivel formar um triangulo com esses lados
	add $t1,$s1,$s2
	add $t2,$s1,$s3
	add $t3,$s2,$s3
	sub $t5, $s1,$s2
	sub $t6, $s1,$s3
	sub $t7, $s2,$s3
	abs $t5,$t5
	abs $t6,$t6
	abs $t7,$t7
checkSum: # vendo se se um dos lados é maior que a soma dos outros dois
	line1: 
	bge $s1,$t3, line2
	addi $t8, $s1,0
	addi $t9,$t7,0
	j checkSub
	line2:
	bge $s2,$t2, line3
	addi $t8, $s2,0
	addi $t9,$t6,0
	j checkSub
	line3:
	bge $s3,$t1, exit
	addi $t8, $s3,0
	addi $t9,$t5,0
	j checkSub
checkSub: # vendo se um dos lados é maior que a subtracao (em modulo) dos outros dois.
	bgt $t8,$t9,calcularTriangulo
	j exit
calcularTriangulo: # vendo qual formato de triangulo ele se encaixa
	beq $s1,$s2, equilatero
	beq $s1,$s3, isoceles
	beq $s2,$s3, isoceles
	j escaleno
equilatero: 
	bne $s3,$s1,isoceles
	addi $t4,$t4,1
	j exit

isoceles:
	addi $t4,$t4,2
	j exit
escaleno:
	addi $t4,$t4,3
	j exit
exit:
	sw $t4,result


