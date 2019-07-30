import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
	double cache = in.nextDouble();
	while (cache > 0 && in.hasNext()) {
			String curso = in.next();
			String nome = in.next();
			if (curso.equals("CC")) {
				cache = cache - 5.00;
			} else if (curso.equals("EC")) {
				cache = cache - 10.00;
			} else {
				cache = cache - 15.00;
			}
		} if (cache > 0) { 
		System.out.println("Escamou!");
		} if (cache <= 0) {
		   System.out.println("Cebruthius!");
		}
  }
}
