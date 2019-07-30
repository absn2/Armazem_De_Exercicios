import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      Scanner in = new Scanner (System.in);
		String s = "";
		double m, a, b, c, d, ca = 0, cb = 0, cc = 0, cd = 0;
		m = in.nextDouble();
		a = in.nextDouble(); //80 VE
		b = in.nextDouble(); //100 VO
		c = in.nextDouble(); //120 RO
		d = in.nextDouble(); // 80 AM
		ca = 80 / a;
		cb = 100 / b;
        cc = 120 / c;
		cd = 80 / d;	
	    if (ca >= cb && ca >= cc && ca >= cd && m >= a){
	    	s = "Verde";
	    } else if (cb >= ca && cb >= cc && cb >=cd && m >= b){
	    	s = "Vermelho";
	    } else if ( cc >= ca && cc >= cb && cc >= cd && m >= c){
	    	s = "Roxo";
	    } else if (cd >= ca && cd >= cb && cd >= cc && m >= d){
	    	s = "Amarelo";
	    } else {
	    	s = "Acho que vou a pe :(";
	    } System.out.println(s);		
  }
}