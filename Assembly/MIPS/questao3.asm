.data
	a: .word -35
	b: .word -2
	result: .word 0	

.text
	lw $t1,a
	lw $t2,b
	lw $t3, result
	#Este programa recebe dois numeros e checa se o primeiro deles ( a ) igual a um positivo negativo ou zero
	
	beq $t1,0,End #sendo zero ele termina pois o valor 0 ja esta armazenado na variavel result
	bgtz $t1,Positivo
	
	Negativo: 
		add $t1,$t1,1#sendo negativo ele faz ($t3(result) - $t2(b)) $t1(a) vezes sempre armazenando em $t3
		sub $t3,$t3,$t2
		beq $t1,0,Exit
		j Negativo	
	Positivo: 
		sub $t1,$t1,1#se for positivo ele faz ($t3(result) + $t2(b)) $t1(a) vezes sempre armazenando em $t3
		add $t3,$t3,$t2
		beq $t1,0,Exit
		j Positivo	
	
	Exit:
		sw  $t3, result #armazena $t3 em result
	
	End:
