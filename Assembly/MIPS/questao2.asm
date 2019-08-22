# QUESTAO 2

.data
# INICIALIZANDO A COM 1
A: .word 1
# INICIALIZANDO B COM 2
B: .word 2
# INICIALIZANDO X COM 0
X: .word 0

.text

lw $s0, A
lw $s1, B
lw $s2, X

# SE 0 < A -> A >= 0
slt $t1,$zero,$s0
# SE A < B
slt $t2, $s0,$s1
# VERIFICA SE AS 2 CONDICIONAIS FORAM ACEITAS
and $t3, $t1, $t2

# COLOCA VALOR 1 NO RESGISTRADOR $t4
addi $t4, $zero,1

# VERIFICA A CONDICIONAL
beq $t3, $t4, BOTA1

# --------------------------------------------

# SE A > B
slt $t5, $s1,$s0
# SE A < 0
slt $t6,$s0,$zero
# SE A < 0 E A > B
and $t7, $t5, $t6
# VERIFICA A CONDICIONAL
beq $t7, $t4, BOTA2

# FAZ O ELSE EM RELACAO AS CONDICIONAIS
# SOMA OS VALORES DAS CONDICIONAIS
add $t8, $t3, $t7
beq $t8,$zero, ELSE

BOTA1:
	# COLOCA VALOR 1 NO X
	addi $s2, $zero, 1
	j EXIT

BOTA2:
	# COLOCA VALOR 2 NO X
	addi $s2, $zero, 2
	j EXIT
ELSE:
	# COLOCA VALOR 3 NO X
	addi $s2, $zero, 3
	j EXIT
	
EXIT:
	
