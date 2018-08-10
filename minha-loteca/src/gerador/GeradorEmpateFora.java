package gerador;

import java.util.ArrayList;
import java.util.List;

import modelo.Volante;
import util.Util;

public class GeradorEmpateFora {

	private String[] matriz1 = new String[] { "x", "x", "2", "x", "2", "x", "2"}; 
	private String[] matriz2 = new String[] { "x", "x", "2", "x", "x", "2", "x"};
	private String[] matriz3 = new String[] { "x", "x", "x", "2", "2", "x", "x"};
	private String[] matriz4 = new String[] { "x", "x", "x", "2", "x", "2", "2"};
	private String[] matriz5 = new String[] { "x", "2", "2", "2", "2", "2", "2"};
	private String[] matriz6 = new String[] { "x", "2", "2", "2", "x", "x", "x"};
	private String[] matriz7 = new String[] { "x", "2", "x", "x", "2", "2", "x"};
	private String[] matriz8 = new String[] { "x", "2", "x", "x", "x", "x", "2"};
	private String[] matriz9 = new String[] { "2", "x", "2", "2", "2", "2", "x"};
	private String[] matriz10 = new String[] { "2", "x", "2", "2", "x", "x", "2"};
	private String[] matriz11 = new String[] { "2", "x", "x", "x", "2", "2", "2"};
	private String[] matriz12 = new String[] { "2", "x", "x", "x", "x", "x", "x"};
	private String[] matriz13 = new String[] { "2", "2", "2", "x", "2", "x", "x"};
	private String[] matriz14 = new String[] { "2", "2", "2", "x", "x", "2", "2"};
	private String[] matriz15 = new String[] { "2", "2", "x", "2", "2", "x", "2"};
	private String[] matriz16 = new String[] { "2", "2", "x", "2", "x", "2", "x"};
	
	
	public List<Volante> empateFora(String[] definicao){
		List<Volante> listaVolantesEmpateFora = new ArrayList<>();
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz1));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz2));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz3));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz4));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz5));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz6));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz7));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz8));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz9));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz10));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz11));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz12));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz13));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz14));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz15));
		listaVolantesEmpateFora.add(gerarVolante(definicao, matriz16));
		
		return listaVolantesEmpateFora;
	}
	
	public Volante gerarVolante(String[] definicao, String[] matriz) {
		int contMatriz = 0;
		int contVolante = 0;
		Volante volante = new Volante();
		volante.setId(Util.id + "");
		
		for(String escolha : definicao) {
			if(escolha.equalsIgnoreCase("d")) {
					volante.getPalpites()[contVolante] = matriz[contMatriz];
					contMatriz++;
					contVolante++;
			} else {
				volante.getPalpites()[contVolante] = escolha;
				contVolante++;
			}
		}
		
		Util.id++;
		return volante;
	}
	
}
