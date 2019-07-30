import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String args[]) {
  Scanner in = new Scanner (System.in);
		int d1 = in.nextInt();
		int m1 = in.nextInt();
		int y1 = in.nextInt();
		int d2 = in.nextInt();
		int m2 = in.nextInt();
		int y2 = in.nextInt();
		int d = 0;
		int ytotal = 0;
		int m = 0;
		int quantidade = 0;
		int m1d = 0; int m2d = 0;
		int dmeses = 0;
		int resposta = 0;
		int y = y1;
		// calculo anos
		ytotal = 365*(y2 - y1);
		while (y <= y2) {
			if (((y % 4 == 0) && (y%100 !=0) || (y%400 == 0))) {
				d = d + 1;
			}y = y + 1;
		}if (((y1 % 4 == 0) && (y1%100 !=0) || (y1%400 == 0)) && m1>02) {
        	d = d - 1;
        }if (((y2 % 4 == 0) && (y2%100 !=0) || (y2%400 == 0))) {
        	if (m2 < 02 || m2 == 02 && d2 <= 29) {
        		d = d - 1;
        	}
	    }quantidade = d + ytotal;
        if (m1 == 01) {
        	m1d = quantidade - d1;
        }if (m1 == 02) {
        	m1d = quantidade - (31+d1);
        }if (m1 == 03) {
        	m1d = quantidade - (31 + 28 + d1);
        }if (m1 == 04) {
        	m1d = quantidade - (31 + 28 + 31 + d1);
        }if (m1 == 05) {
        	m1d = quantidade - (31 + 28 + 31 + 30 + d1);
        }if (m1 == 06) {
        	m1d = quantidade - (31 + 28 + 31 + 30 + 31 + d1);
        }if (m1 == 07) {
        	m1d = quantidade - (31 + 28 + 31 + 30 + 31 + 30 + d1);
        }if (m1 == 8) {
        	m1d = quantidade - (31 + 28 + 31 + 30 + 31 + 30 + 31 + d1);
        }if (m1 == 9) {
        	m1d = quantidade - (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + d1);
        }if (m1 == 10) {
        	m1d = quantidade - (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + d1);
        }if (m1 == 11) {
        	m1d = quantidade - (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + d1);
        }if (m1 == 12) {
        	m1d = quantidade - (31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + d1);
        }if (m2 == 01) {
        	m2d = d2;
        }if (m2 == 02) {
        	m2d = 31+d2;
        }if (m2 == 03) {
        	m2d = 31 + 28 + d2;
        }if (m2 == 04) {
        	m2d = 31 + 28 + 31 + d2;
        }if (m2 == 05) {
        	m2d = 31 + 28 + 31 + 30 + d2;
        }if (m2 == 06) {
        	m2d = 31 + 28 + 31 + 30 + 31 + d2;
        }if (m2 == 07) {
        	m2d = 31 + 28 + 31 + 30 + 31 + 30 + d2;
        }if (m2 == 8) {
        	m2d = 31 + 28 + 31 + 30 + 31 + 30 + 31 +d2;
        }if (m2 == 9) {
        	m2d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + d2;
        }if (m2 == 10) {
        	m2d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + d2;
        }if (m2 == 11) {
        	m2d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + d2;
        }if (m2 == 12) {
        	m2d = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30 + d2;
        }resposta = m1d + m2d;
		System.out.println(resposta);
}
}