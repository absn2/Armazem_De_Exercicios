import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      Scanner in = new Scanner (System.in);
		int n = in.nextInt(), u=0, i=1;
		while (n > 0 && i != u) {
			i = in.nextInt();
			n--;
			u++;
			if (i == u ) {
				System.out.printf("o ingresso de numero %d foi sorteado", i); 
			}		
		}
    
  }
}