.data

a: .word 10
b: .word 14
c: .word 8
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
checkTriangulo: #checa se é possivel criar um triangulo com os lados dados inicialmente.
	bge $s1,$t3, exit # se um lado é maior ou igual que a soma dos outros dois, entao ele nao bate nas especificacoes.
	bge $s2,$t2, exit 
	bge $s3,$t1, exit
	ble  $s1,$t7, exit # se um lado é menor ou igual que o modulo da subtracao entre outros dois lados, entao ele nao bate nas especificaoes
	ble $s2,$t6, exit
	ble $s3,$t5,exit
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
