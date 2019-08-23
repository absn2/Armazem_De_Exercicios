.data

a: .word 5
b: .word 4
c: .word 3
result: .word 0 # nao mexer

.text
lw $s1, a
lw $s2, b
lw $s3, c
lw $t4, result
crtVar: # Criando as variaves para checar se é possivel formar um triangulo com esses lados
	add $t1,$s1,$s2  
	add $t2,$s1,$s3
	add $t3,$s2,$s3
	sub $t5, $s1,$s2
	sub $t6, $s1,$s3
	sub $t7, $s2,$s3
	abs $t5,$t5 # modulo da subtracao
	abs $t6,$t6
	abs $t7,$t7
checkSum: # vendo se se um dos lados é maior que a soma dos outros dois
	line1: 
	bge $s1,$t3, line2 # se um lado é maior que a soma dos outros dois, então cheque se o outro lado bate nas config.
	addi $t8, $s1,0 # se um lado é menor, armazenamos os valores dele e vemos se continua sendo apto.
	addi $t9,$t7,0
	j checkSub
	line2:
	bge $s2,$t2, line3 #se o lado continua sendo maior entao vejo o proximo.
	addi $t8, $s2,0
	addi $t9,$t6,0
	j checkSub
	line3:
	bge $s3,$t1, exit # se continuar sendo maior, então pule pro final.
	addi $t8, $s3,0
	addi $t9,$t5,0
	j checkSub
checkSub: # vendo se um dos lados é maior que a subtracao (em modulo) dos outros dois.
	bgt $t8,$t9,calcularTriangulo
	j exit
calcularTriangulo: # vendo qual formato de triangulo ele se encaixa
	beq $s1,$s2, equilatero #vai checar se ele vai ser um triangulo equilatero
	beq $s1,$s3, isoceles #se um deles for igual é isocoles
	beq $s2,$s3, isoceles
	j escaleno # se todos os lados forem diferentes, logo é um escaleno.
equilatero: 
	bne $s3,$s1,isoceles # se nao for igual é isocoles
	addi $t4,$t4,1 # se for igual result = 1
	j exit

isoceles:
	addi $t4,$t4,2 # se for isoceles result = 2
	j exit
escaleno:
	addi $t4,$t4,3 # se for escaleno result = 3
	j exit
exit:
	sw $t4,result