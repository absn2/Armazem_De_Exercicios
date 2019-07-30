import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      Scanner in = new Scanner (System.in);
		    String pessoa1 = in.next();
		    String pessoa2 = in.next();
		    String pessoa3 = in.next();
		    String pessoa4 = in.next();
		    String pessoa5 = in.next();
		    String posicao1 = "Princesa";
		    String posicao2 = "";
		    String posicao3 = "";
		    String posicao4 = "";
		    String posicao5 = "";
		    if (pessoa2.equals("Mario") || pessoa4.equals("Mario")) {
		        posicao2 = "Mario"; 
		    } if (pessoa3.equals("Mario") || pessoa5.equals("Mario")) {
		        posicao3 = "Mario"; 
		    } if (posicao2.equals("Mario")) { 
		    	if (pessoa2.equals("Toad") || pessoa4.equals("Toad")) {
		    		posicao4 = "Toad";
		    	} if (pessoa3.equals("Toad") || pessoa5.equals("Toad")) {
		    		posicao3 = "Toad";
		    	}
	        } if (posicao3.equals("Mario")) { 
	        	if (pessoa3.equals("Toad") || pessoa5.equals("Toad")) {
	        		posicao5 = "Toad";
	        	} if (pessoa2.equals("Toad") || pessoa4.equals("Toad")) {
	        		posicao2 = "Toad";
	        	}
	        } if (posicao2.equals("Mario") && posicao3.equals("Toad")) { 
	        	if (pessoa2.equals("Luigi") || pessoa4.equals("Luigi")) {
	        		posicao4 = "Luigi";
	        	} if (pessoa3.equals("Luigi") || pessoa5.equals("Luigi")) {
	        		posicao5 = "Luigi";
	        	}
	        } if (posicao2.equals("Toad") && posicao3.equals("Mario")) {
	        	if (pessoa2.equals("Luigi") || pessoa4.equals("Luigi")) {
	        		posicao4 = "Luigi";
	        	} if (pessoa3.equals("Luigi") || pessoa5.equals("Luigi")) {
	        		posicao5 = "Luigi";
	        	}
	        } if (posicao2.equals("Mario") && posicao4.equals("Toad")) { 
	        	if (pessoa3.equals("Luigi") || pessoa5.equals("Luigi")) {
	        		posicao3 = "Luigi";
	        	}
	        } if (posicao4.equals("")) {
	        	posicao4 = "Yoshi";
	        } if (posicao5.equals("")) {
	        	posicao5 = "Yoshi";
	        }
		    System.out.println(posicao1);
	        System.out.println(posicao2);
		    System.out.println(posicao3);
		    System.out.println(posicao4);
		    System.out.println(posicao5);
  }
}