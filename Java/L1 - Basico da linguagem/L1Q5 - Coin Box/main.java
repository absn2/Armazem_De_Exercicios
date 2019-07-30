import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      	Scanner in = new Scanner (System.in);
		int x, y, z, a, b;
		x = in.nextInt();
		y = in.nextInt();
		z = in.nextInt();
		if (x >= y && x >= z && y >= z) {
			System.out.printf("%d %d %d", x, y, z);
		}else if (x >= y && x >= z && z >= y) {
			System.out.printf("%d %d %d", x, y, z);
		}else if (y >= x && y >= z && x >= z) {
			System.out.printf("%d %d %d", y, x, z);
		}else if (y >= x && y >= z && z >= x) {
			System.out.printf("%d %d %d", y, z, x);
		}else if (z >= x && z >= y && x >= y) {
			System.out.printf("%d %d %d", z, x, y);
		}else if (z >= x && z >= y && y >= x) {
			System.out.printf("%d %d %d", z, y ,x);
		}
  }
}