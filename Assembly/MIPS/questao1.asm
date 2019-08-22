.data

a: .word 1
b: .word -1
r: .word 0

.text
lw $t1, a
lw $t2, b
lw $t3, r

ifBgtz: #(B > 0) ?
	bgtz $t2, checkA

else:
	addi $t3, $t3, 3
	sw $t3, r
	j exit

ifAgtz: #(A > 0) ?
	bgtz $t1, addOne

else:
	addi $t3, $t3, 2
	sw $t3, r
	j exit

addOne: 
	addi $t3, $t3, 1
	sw $t3, r
exit: #finaliza Codigo


























