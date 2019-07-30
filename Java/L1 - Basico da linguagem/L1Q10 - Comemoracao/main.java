import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
      Scanner in = new Scanner (System.in);
		int dm, dy, dt, cm = 0, cy = 0, ct = 0;
		String Curvam1 = in.next();
		int dist1 = in.nextInt();
		String Curvam2 = in.next();
		int dist2 = in.nextInt();
		String Curvam3 = in.next();
		int dist3 = in.nextInt();
		String Curvam4 = in.next();
		int dist4 = in.nextInt();

		String Curvay1 = in.next();
		int disty1 = in.nextInt();
		String Curvay2 = in.next();
		int disty2 = in.nextInt();
		String Curvay3 = in.next();
		int disty3 = in.nextInt();
		String Curvay4 = in.next();
		int disty4 = in.nextInt();
	
		String Curvat1 = in.next();
		int distt1 = in.nextInt();
		String Curvat2 = in.next();
		int distt2 = in.nextInt();
		String Curvat3 = in.next();
		int distt3 = in.nextInt();
		String Curvat4 = in.next();
		int distt4 = in.nextInt();	
		
		dm = dist1 + dist2 + dist3 + dist4;
		dy = disty1 + disty2 + disty3 + disty4;
		dt = distt1 + distt2 + distt3 + distt4;
		if (Curvam1.equals("Esquerda") && Curvam2.equals("Esquerda") && Curvam3.equals("Esquerda") || Curvam2.equals("Esquerda") && Curvam3.equals("Esquerda") && Curvam4.equals("Esquerda")) {
			System.out.println("Mario caiu em um buraco negro.");
			cm = 1;
		} if (Curvay1.equals("Esquerda") && Curvay2.equals("Esquerda") && Curvay3.equals("Esquerda") || Curvay2.equals("Esquerda") && Curvay3.equals("Esquerda") && Curvay4.equals("Esquerda")) {
			System.out.println("Yoshi caiu em um buraco negro.");
			cy = 1;
		} if (Curvat1.equals("Esquerda") && Curvat2.equals("Esquerda") && Curvat3.equals("Esquerda") || Curvat2.equals("Esquerda") && Curvat3.equals("Esquerda") && Curvat4.equals("Esquerda")) {
			System.out.println("Toad caiu em um buraco negro.");	
			ct = 1;
        }      if (dm <= dt && dm <= dy && cm != 1 ||dm < dt && cy == 1 && cm != 1 || dm < dy && ct == 1 && cm != 1 || cy == 1 && ct == 1 && cm != 1){
        	System.out.println("Mario venceu a corrida!");
        } else if (dy <= dt && dy <= dm && cy != 1 ||dy < dt && cm == 1 && cy != 1 || dy < dm && ct == 1 && cy != 1 || ct == 1 && cm == 1 && cy != 1)  {
        	System.out.println("Yoshi venceu a corrida!");
        } else if (dt <= dm && dt <= dy && ct != 1 ||dt < dm && cy == 1 && ct != 1|| dt < dy && cm == 1 && ct != 1 || cy == 1 && cm == 1 && ct != 1) {
        	System.out.println("Toad venceu a corrida!");
        }
    
  }
}