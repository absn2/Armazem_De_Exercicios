import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      Scanner in = new Scanner (System.in);
	      double x = in.nextDouble();
	      double t = in.nextDouble();
	      double v = 0;
	      double tx = 0;
	      double ep = 0;
	      double f = 0;
	      double fw = 0;
	      double fr = 0;
	      while (tx <= t) {
	          if (tx == 0) {
	              v = 0;
	          } else if (tx == 1) {
	              v = v + x;
	          } else if (tx % 2 == 0) {
	              ep = (tx*2) - 2;
	              f = (tx*2) - 1;
	              fw = f - 1;
	              fr = f * fw;
	              fw--;
	              while (fw > 0){
	                  fr = fr * fw;
	                  fw--;
	              }
	              v = v - (Math.pow(x,ep) / fr);
	          } else if (tx % 2 == 1) {
	              ep = (tx*2) - 2;
	              f = (tx*2) - 1;
	              fw = f - 1;
	              fr = f * fw;
	              fw--;
	              while (fw > 0){
	                  fr = fr * fw;
	                  fw--;
	              }
	              v = v + (Math.pow(x, ep) / fr);
	          }
	          tx++;
	      }
	      v = Math.abs(v);
	      System.out.printf("%.3f", v);
	    
	  }
	}