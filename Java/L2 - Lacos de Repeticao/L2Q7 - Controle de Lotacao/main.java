import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
  Scanner in = new Scanner (System.in);
		    int Lotacao = 0; 
		    int Dentro = 0; 
		    int Fila = 0; 
		    int CountVip = 0; 
		    String Porta;
		    int Portint = 0, Entrou = 0, FilaNew = 0;
		    String Acao;
		    Lotacao = in.nextInt();
		    while (in.hasNext()){
		        Acao = in.next();
		        Porta = in.next() ;
		    int Espaco = Lotacao - Dentro;
		    if (Espaco < 0) {
		    	Espaco = 0;
		    }
		        
		        if (!Porta.equals("VIP")){
		        	Portint = Integer.parseInt(Porta);
		        } 
		        
		        if (Acao.equals("Entraram")){
		        	if (Porta.equals("VIP")) {
		        		Dentro = Dentro + 1;
		        		System.out.printf("1 pessoas entraram na casa. Atualmente ha %d pessoas no evento.\n", Dentro);
		        		System.out.printf("\n");
		        		continue;
		       	}
		        	else if (Portint > Espaco){
		            Fila = Fila + Portint - Espaco;
		            FilaNew = Portint - Espaco;
		            Entrou = Espaco;
		            Dentro = Dentro + Espaco;
		            if (Entrou > 0){
		            System.out.printf("%d pessoas entraram na casa. Atualmente ha %d pessoas no evento.\n", Entrou, Dentro);
		            }
		            System.out.printf("Infelizmente a casa esta lotada, %d pessoas foram redirecionadas para a fila.\n", FilaNew);
			        System.out.printf("A fila agora contem %d pessoas.\n", Fila);
		        } else { Dentro = Dentro + Portint;
		        Entrou = Portint;
		        System.out.printf("%d pessoas entraram na casa. Atualmente ha %d pessoas no evento.\n", Entrou, Dentro);
		      
		        }
		        }
		       		       
		        if (Acao.equals("Sairam")){
		            Dentro = Dentro - Portint;
		            Espaco = Lotacao - Dentro;
		            System.out.printf("%d pessoas sairam da casa. Atualmente ha %d pessoas no evento.\n", Portint, Dentro);
		           
		            if (Fila > 0) {
		            	if (Fila > Espaco) {
		            	Fila = Fila - Espaco;
		            	Dentro = Dentro + Espaco;
		            	Entrou = Espaco;
		 			     System.out.printf("%d pessoas da fila entraram na casa.\n", Entrou);
		 			    System.out.printf("A fila agora contem %d pessoas.\n", Fila);
		 			     
		            	} 
		            	else if (Fila <= Espaco){	  
		            Entrou = Fila;	
		            Dentro = Dentro + Fila;
		            Fila = 0;
		            System.out.printf("%d pessoas da fila entraram na casa.\n", Entrou);
		            System.out.print("Todos que estavam na fila de espera conseguiram entrar, atualmente nao ha fila de espera.\n");	
		            System.out.printf("\n");
		            continue; } 
		               
		        } 
		    } System.out.printf("\n");
		  } 
		  System.out.printf("Vai Troinha, agora pede o ubii!");
	 }
}   