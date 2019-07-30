import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
	    String H, I;
		String R = "";
		H = in.nextLine();
	    I = in.nextLine(); 
	    int L = in.nextInt();
	    if (I.equals("FireFlower")) {
	    	if (H.equals("Mario")) {
	    		L = L - 292;
	            if (L <= 0) {
	            	R = "Mario conseguiu derrotar o Bowser e salvar a princesa Peach.";
	            } else {
	            	R = "O Bowser conseguiu escapar.";
	            }
	    } else {
	    	L = L - 280;
	    	if (L <= 0) {
	    		R = "Luigi conseguiu derrotar o Bowser e salvar a princesa Peach.";
	    	} else {
	    		R = "O Bowser conseguiu escapar.";
	    	}
	    }
	} else if (I.equals("IceFlower")) {
		if (H.equals("Mario")) {
			L = L - 200;
			if (L <= 0) {
				R = "Mario conseguiu derrotar o Bowser e salvar a princesa Peach.";
			} else {
				R = "O Bowser conseguiu escapar.";
			}
		} else {
			L = L - 180;
			if (L <= 0) {
				R = "Luigi conseguiu derrotar o Bowser e salvar a princesa Peach.";
			} else {
				R = "O Bowser conseguiu escapar.";
			}
		}
	} else if (I.equals("BoomerangFlower")) {
		if (H.equals("Mario")) {
			L = L - 128;
			if (L <= 0) {
				R = "Mario conseguiu derrotar o Bowser e salvar a princesa Peach.";
			} else {
				R = "O Bowser conseguiu escapar.";
			}
		} else {
			L = L - 112;
			if (L <= 0) {
				R = "Luigi conseguiu derrotar o Bowser e salvar a princesa Peach.";
			} else {
				R = "O Bowser conseguiu escapar.";
			}
		}
	} System.out.println(R);
	}
}
	   
		   