import java.io.*;
import java.util.*;

public class HuxleyCode {
  public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Lista carro = new Lista(); // 67
		Lista aviao = new Lista(); // 65
		Lista moto = new Lista(); // 77
		Lista bicicleta = new Lista(); // 66
		Lista submarino = new Lista(); // 83
		Lista tanque = new Lista(); // 84
		while (in.hasNext()) {
			String caso = in.next();
			if (caso.equals("VEICULO!!!")) {
				String tipoVeiculo = in.next();
				if (tipoVeiculo.substring(0, 2).equals("67")) {
					int valorCarro = Integer.parseInt(tipoVeiculo);
					carro.repetido(valorCarro);
					carro.inserir(valorCarro);
				} else if (tipoVeiculo.substring(0, 2).equals("65")) {
					int valorAviao = Integer.parseInt(tipoVeiculo);
					aviao.repetido(valorAviao);
					aviao.inserir(valorAviao);
				} else if (tipoVeiculo.substring(0, 2).equals("66")) {
					int valorBicicleta = Integer.parseInt(tipoVeiculo);
					bicicleta.repetido(valorBicicleta);
					bicicleta.inserir(valorBicicleta);
				} else if (tipoVeiculo.substring(0, 2).equals("77")) {
					int valorMoto = Integer.parseInt(tipoVeiculo);
					moto.repetido(valorMoto);
					moto.inserir(valorMoto);
				} else if (tipoVeiculo.substring(0, 2).equals("83")) {
					int valorSubmarino = Integer.parseInt(tipoVeiculo);
					submarino.repetido(valorSubmarino);
					submarino.inserir(valorSubmarino);
				} else if (tipoVeiculo.substring(0, 2).equals("84")) {
					int valorTanque = Integer.parseInt(tipoVeiculo);
					tanque.repetido(valorTanque);
					tanque.inserir(valorTanque);
				} else {
					System.out.println("VERIFICAR TIPO DE VEICULO");
				}
			} else if (caso.equals("VERIFICAR")) {
				String tipoVeiculo = in.next();
				if (tipoVeiculo.substring(0, 2).equals("67")) {
					int valorCarro = Integer.parseInt(tipoVeiculo);
					String resultado = "AINDA NAO";
					resultado = carro.verificar(valorCarro, resultado);
					System.out.println(resultado);
				} else if (tipoVeiculo.substring(0, 2).equals("65")) {
					int valorAviao = Integer.parseInt(tipoVeiculo);
					String resultado = "AINDA NAO";
					resultado = aviao.verificar(valorAviao, resultado);
					System.out.println(resultado);
				} else if (tipoVeiculo.substring(0, 2).equals("66")) {
					int valorBicicleta = Integer.parseInt(tipoVeiculo);
					String resultado = "AINDA NAO";
					resultado = bicicleta.verificar(valorBicicleta, resultado);
					System.out.println(resultado);
				} else if (tipoVeiculo.substring(0, 2).equals("77")) {
					int valorMoto = Integer.parseInt(tipoVeiculo);
					String resultado = "AINDA NAO";
					resultado = moto.verificar(valorMoto, resultado);
					System.out.println(resultado);
				} else if (tipoVeiculo.substring(0, 2).equals("83")) {
					int valorSubmarino = Integer.parseInt(tipoVeiculo);
					String resultado = "AINDA NAO";
					resultado = submarino.verificar(valorSubmarino, resultado);
					System.out.println(resultado);
				} else if (tipoVeiculo.substring(0, 2).equals("84")) {
					int valorTanque = Integer.parseInt(tipoVeiculo);
					String resultado = "AINDA NAO";
					resultado = tanque.verificar(valorTanque, resultado);
					System.out.println(resultado);
				}
			} else if (caso.equals("IMPRIMIR")) {
				String tipoVeiculo = in.next();
				if (tipoVeiculo.substring(0, 2).equals("67")) {
					int tamanhoGaragem = carro.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						carro.trocarPosicao();
					}
					String imprimir = "";
					imprimir = carro.imprimir(imprimir);
					if (imprimir.equals("")) {
						System.out.println("A GARAGEM ESTA VAZIA :(");
					} else {
						System.out.println(imprimir);
					}
				} else if (tipoVeiculo.substring(0, 2).equals("65")) {
					int tamanhoGaragem = aviao.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						aviao.trocarPosicao();
					}
					String imprimir = "";
					imprimir = aviao.imprimir(imprimir);
					if (imprimir.equals("")) {
						System.out.println("A GARAGEM ESTA VAZIA :(");
					} else {
						System.out.println(imprimir);
					}
				} else if (tipoVeiculo.substring(0, 2).equals("66")) {
					int tamanhoGaragem = bicicleta.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						bicicleta.trocarPosicao();
					}
					String imprimir = "";
					imprimir = bicicleta.imprimir(imprimir);
					if (imprimir.equals("")) {
						System.out.println("A GARAGEM ESTA VAZIA :(");
					} else {
						System.out.println(imprimir);
					}
				} else if (tipoVeiculo.substring(0, 2).equals("77")) {
					int tamanhoGaragem = moto.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						moto.trocarPosicao();
					}
					String imprimir = "";
					imprimir = moto.imprimir(imprimir);
					if (imprimir.equals("")) {
						System.out.println("A GARAGEM ESTA VAZIA :(");
					} else {
						System.out.println(imprimir);
					}
				} else if (tipoVeiculo.substring(0, 2).equals("83")) {
					int tamanhoGaragem = submarino.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						submarino.trocarPosicao();
					}
					String imprimir = "";
					imprimir = submarino.imprimir(imprimir);
					if (imprimir.equals("")) {
						System.out.println("A GARAGEM ESTA VAZIA :(");
					} else {
						System.out.println(imprimir);
					}
				} else if (tipoVeiculo.substring(0, 2).equals("84")) {
					int tamanhoGaragem = tanque.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						tanque.trocarPosicao();
					}
					String imprimir = "";
					imprimir = tanque.imprimir(imprimir);
					if (imprimir.equals("")) {
						System.out.println("A GARAGEM ESTA VAZIA :(");
					} else {
						System.out.println(imprimir);
					}
				}
			} else if (caso.equals("VENDER")) {
				String tipoVeiculo = in.next();
				if (tipoVeiculo.substring(0, 2).equals("67")) {
					int tamanhoGaragem = carro.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						carro.trocarPosicao();
					}
					String imprimirRepetidos = "";
					int quantRepetido = carro.quantRepetido(0);
					imprimirRepetidos = carro.imprimirRepetidos(imprimirRepetidos, 0, quantRepetido-1);
					if (imprimirRepetidos.equals("")) {
						System.out.println("NADA REPETIDO POR ENQUANTO :)");
					} else {
						System.out.println(imprimirRepetidos);
						for (int aux = 0; aux < quantRepetido; aux++) {
							carro.removerRepetido();
						}
					}
				} else if (tipoVeiculo.substring(0, 2).equals("65")) {
					int tamanhoGaragem = aviao.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						aviao.trocarPosicao();
					}
					String imprimirRepetidos = "";
					int quantRepetido = aviao.quantRepetido(0);
					imprimirRepetidos = aviao.imprimirRepetidos(imprimirRepetidos, 0, quantRepetido-1);
					if (imprimirRepetidos.equals("")) {
						System.out.println("NADA REPETIDO POR ENQUANTO :)");
					} else {
						System.out.println(imprimirRepetidos);
						for (int aux = 0; aux < quantRepetido; aux++) {
							aviao.removerRepetido();
						}
					}
				} else if (tipoVeiculo.substring(0, 2).equals("66")) {
					int tamanhoGaragem = bicicleta.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						bicicleta.trocarPosicao();
					}
					String imprimirRepetidos = "";
					int quantRepetido = bicicleta.quantRepetido(0);
					imprimirRepetidos = bicicleta.imprimirRepetidos(imprimirRepetidos, 0, quantRepetido-1);
					if (imprimirRepetidos.equals("")) {
						System.out.println("NADA REPETIDO POR ENQUANTO :)");
					} else {
						System.out.println(imprimirRepetidos);
						for (int aux = 0; aux < quantRepetido; aux++) {
							bicicleta.removerRepetido();
						}
					}
				} else if (tipoVeiculo.substring(0, 2).equals("77")) {
					int tamanhoGaragem = moto.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						moto.trocarPosicao();
					}
					String imprimirRepetidos = "";
					int quantRepetido = moto.quantRepetido(0);
					imprimirRepetidos = moto.imprimirRepetidos(imprimirRepetidos, 0, quantRepetido-1);
					if (imprimirRepetidos.equals("")) {
						System.out.println("NADA REPETIDO POR ENQUANTO :)");
					} else {
						System.out.println(imprimirRepetidos);
						for (int aux = 0; aux < quantRepetido; aux++) {
							moto.removerRepetido();
						}
					}
				} else if (tipoVeiculo.substring(0, 2).equals("83")) {
					int tamanhoGaragem = submarino.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						submarino.trocarPosicao();
					}
					String imprimirRepetidos = "";
					int quantRepetido = submarino.quantRepetido(0);
					imprimirRepetidos = submarino.imprimirRepetidos(imprimirRepetidos, 0, quantRepetido-1);
					if (imprimirRepetidos.equals("")) {
						System.out.println("NADA REPETIDO POR ENQUANTO :)");
					} else {
						System.out.println(imprimirRepetidos);
						for (int aux = 0; aux < quantRepetido; aux++) {
							submarino.removerRepetido();
						}
					}
				} else if (tipoVeiculo.substring(0, 2).equals("84")) {
					int tamanhoGaragem = tanque.tamanhoGaragem(0);
					for (int aux = 0; aux < tamanhoGaragem; aux++) {
						tanque.trocarPosicao();
					}
					String imprimirRepetidos = "";
					int quantRepetido = tanque.quantRepetido(0);
					imprimirRepetidos = tanque.imprimirRepetidos(imprimirRepetidos, 0, quantRepetido-1);
					if (imprimirRepetidos.equals("")) {
						System.out.println("NADA REPETIDO POR ENQUANTO :)");
					} else {
						System.out.println(imprimirRepetidos);
						for (int aux = 0; aux < quantRepetido; aux++) {
							tanque.removerRepetido();
						}
					}
				}
			}
		}

	}
} 
class Lista {
    private int veiculo;
    private boolean repetido;
    private Lista veiculoProximo;

    public Lista() {
        this.veiculo = 0;
        this.repetido = false;
        this.veiculoProximo = null;
    }

    public void inserir(int veiculo) {
        if (this.veiculo == 0) {
            this.veiculo = veiculo;
            this.veiculoProximo = new Lista();
        } else {
            this.veiculoProximo.inserir(veiculo);
        }
    }

    public void repetido (int veiculo) {
    	if (this.veiculo != 0) {
    		if (this.veiculo == veiculo) {
    			this.repetido = true;
    		} this.veiculoProximo.repetido(veiculo);
    	}
    }
    
    public String verificar (int veiculo, String resultado) {
    	if (this.veiculo != 0) {
    		if (this.veiculo == veiculo) {
    			return resultado = "EXISTE";
    		}return this.veiculoProximo.verificar(veiculo, resultado);
    	} return resultado;
    }
    
    public int tamanhoGaragem (int contador) {
    	if (this.veiculo != 0) {
    		 contador += 1;
    		return this.veiculoProximo.tamanhoGaragem(contador);
    	}return contador;
    }
    
    public void trocarPosicao () {
    	if (this.veiculo != 0 && this.veiculoProximo.veiculo != 0) {
    		if (this.veiculo > this.veiculoProximo.veiculo) {
    			int aux = this.veiculo;
    			boolean auxTrocar = this.repetido;
    			this.veiculo = this.veiculoProximo.veiculo;
    			this.veiculoProximo.veiculo = aux;
    			this.repetido = this.veiculoProximo.repetido;
    			this.veiculoProximo.repetido = auxTrocar;
    		}this.veiculoProximo.trocarPosicao();
    	}
    }
    
    public String imprimir (String imprimir) {
    	if (this.veiculo != 0) {
    		if (this.veiculoProximo.veiculo == 0) {
    		    imprimir += this.veiculo;
    		} else {
    		   imprimir += this.veiculo+ " "; 
    		}
    		return this.veiculoProximo.imprimir(imprimir);
    	} return imprimir;
    }
    
    public String imprimirRepetidos (String imprimirRepetidos, int aux, int quantRepetido) {
    	if (this.veiculo != 0) {
    		if (this.repetido == true) {
    			if (aux == quantRepetido) {
    			    imprimirRepetidos += this.veiculo;
    			} else {
    			    imprimirRepetidos += this.veiculo + " ";
    			    aux += 1;
    			}
    		}return this.veiculoProximo.imprimirRepetidos(imprimirRepetidos, aux, quantRepetido);
    	} return imprimirRepetidos;
    }
    
    public int quantRepetido (int contador) {
    	if (this.veiculo != 0) {
    		if (this.repetido == true) {
    			contador += 1;
    		} return this.veiculoProximo.quantRepetido(contador);
    	}return contador;
    }
    
    public void removerRepetido () {
    	if (this.veiculo != 0) {
    		if (this.repetido == true) {
    			this.veiculo = this.veiculoProximo.veiculo;
    			this.repetido = this.veiculoProximo.repetido;
    			this.veiculoProximo.repetido = this.veiculoProximo.veiculoProximo.repetido;
    			this.veiculoProximo = this.veiculoProximo.veiculoProximo;
    		} else {
    			this.veiculoProximo.removerRepetido();
    		}
    	}
    }
    	
}