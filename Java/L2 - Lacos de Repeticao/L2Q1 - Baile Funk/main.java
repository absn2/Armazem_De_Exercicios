import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
    Scanner in = new Scanner (System.in);
		int i = in.nextInt();
		int a = 0;
		int lu = 0;
		int j = 0;
		int li = 0;
		int k = 0;
		int outro = -1;
		while (i >= 0) {
			String Cantor = in.nextLine();
			if (Cantor.equals("Anitta")) {
				a++;
			} else if (Cantor.equals("Ludmilla")) {
				lu++;
			} else if (Cantor.equals("Jojo")) {
				j++;
			} else if (Cantor.equals("Livinho")) {
				li++;
			} else if (Cantor.equals("Kevinho")) {
				k++;
			} else {
				outro++;
			}
			i = i - 1;
		} if (a >= lu && a >= j && a >= li && a >= k && a >= outro) {
			if (a == lu) {
				System.out.println("Houve um empate entre: Anitta, Ludmilla");
			} else if (a == j) {
				System.out.println("Houve um empate entre: Anitta, Jojo");
			} else if (a == li) {
				System.out.println("Houve um empate entre: Anitta, Livinho");
			} else if (a == k) {
				System.out.println("Houve um empate entre: Anitta, Kevinho");
			} else {
				System.out.println("As pessoas estao esperando por Anitta.");
			}
		} else if (lu >= a && lu >= j && lu >= li && lu >= k && lu >= outro) {
			if (lu == a) {
				System.out.println("Houve um empate entre: Anitta, Ludmilla");
			} else if (lu == j) {
				System.out.println("Houve um empate entre: Jojo, Ludmilla");
			} else if (lu == li) {
				System.out.println("Houve um empate entre: Livinho, Ludmilla");
			} else if (lu == k) {
				System.out.println("Houve um empate entre: Kevinho, Ludmilla");
			} else {
				System.out.println("As pessoas estao esperando por Ludmilla.");
			}
		} else if (j >= a && j >= lu && j >= li && j >= k && j >= outro) {
			if (j == a) {
				System.out.println("Houve um empate entre: Anitta, Jojo");
			} else if (j == lu) {
				System.out.println("Houve um empate entre: Jojo, Ludmilla");
			} else if (j == li) {
				System.out.println("Houve um empate entre: Jojo, Livinho");
			} else if (j == k) {
				System.out.println("Houve um empate entre: Jojo, Kevinho");
			} else {
				System.out.println("As pessoas estao esperando por Jojo.");
			}
		} else if (li >= a && li >= lu && li >= j && li >= k && li >= outro) {
			if (li == a) {
				System.out.println("Houve um empate entre: Anitta, Livinho");
			} else if (li == lu) {
				System.out.println("Houve um empate entre: Livinho, Ludmilla");
			} else if (li == j) {
				System.out.println("Houve um empate entre: Jojo, Livinho");
			} else if (li == k) {
				System.out.println("Houve um empate entre: Kevinho, Livinho");
			} else {
				System.out.println("As pessoas estao esperando por Livinho.");
			}
		} else if (k >= a && k >= lu && k >= j && k >= li && k >= outro) {
			if (k == a) {
				System.out.println("Houve um empate entre: Anitta, Kevinho");
			} else if (k == lu) {
				System.out.println("Houve um empate entre: Kevinho, Ludmilla");
			} else if (k == j) {
				System.out.println("Houve um empate entre: Jojo, Kevinho");
			} else if (k == li) {
				System.out.println("Houve um empate entre: Kevinho, Livinho");
			} else {
				System.out.println("As pessoas estao esperando por Kevinho.");
			} 	
	    } else if (outro > a && outro > lu && outro > j && outro > li && outro > k) {
			System.out.println("As pessoas querem ver outra pessoa");		
	}
  }
}