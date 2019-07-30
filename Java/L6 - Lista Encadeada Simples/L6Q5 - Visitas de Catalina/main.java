import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Lista lugares = new Lista ();
		while (in.hasNext()) {
			String lugar = in.nextLine();
			String distancia = in.nextLine();
			int distanciaValor = Integer.parseInt(distancia);
			lugares.inserir(lugar, distanciaValor);
		}
		String imprimir = "";
		imprimir = lugares.imprimir(imprimir);
		System.out.print(imprimir);
	}
}
class Lista {
    private String lugar;
    private int distancia;
    private Lista lugarProximo;
    
    public Lista() {
    	this.lugar = "";
    	this.distancia = 0;
    	this.lugarProximo = null;
    }
    
    public void inserir (String lugar, int distancia) {
    	if (this.lugar.equals("")) {
    		this.lugar = lugar;
    		this.distancia = distancia;
    		this.lugarProximo = new Lista ();
    	} else if (!this.lugar.equals("")) {
    		if (distancia < this.distancia) {
    			int auxDistancia = this.distancia;
    			String auxLugar = this.lugar;
    			this.distancia = distancia;
    			this.lugar = lugar;
    			this.lugarProximo.inserir(auxLugar, auxDistancia);
    		} else {
    			this.lugarProximo.inserir(lugar, distancia);
    		}
    	}
    }
    
    public String imprimir (String imprimir) {
    	if (!this.lugar.equals("")) {
    		imprimir += this.lugar+"\n";
    		return this.lugarProximo.imprimir(imprimir);
    	}
    	return imprimir;
    }
}