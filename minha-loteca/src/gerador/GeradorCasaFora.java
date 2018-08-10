package gerador;

import java.util.ArrayList;
import java.util.List;

import modelo.Volante;
import util.Util;

public class GeradorCasaFora {

	private String[] matriz1 = new String[] { "1", "1", "2", "1", "2", "1", "2"}; 
	private String[] matriz2 = new String[] { "1", "1", "2", "1", "1", "2", "1"};
	private String[] matriz3 = new String[] { "1", "1", "1", "2", "2", "1", "1"};
	private String[] matriz4 = new String[] { "1", "1", "1", "2", "1", "2", "2"};
	private String[] matriz5 = new String[] { "1", "2", "2", "2", "2", "2", "2"};
	private String[] matriz6 = new String[] { "1", "2", "2", "2", "1", "1", "1"};
	private String[] matriz7 = new String[] { "1", "2", "1", "1", "2", "2", "1"};
	private String[] matriz8 = new String[] { "1", "2", "1", "1", "1", "1", "2"};
	private String[] matriz9 = new String[] { "2", "1", "2", "2", "2", "2", "1"};
	private String[] matriz10 = new String[] { "2", "1", "2", "2", "1", "1", "2"};
	private String[] matriz11 = new String[] { "2", "1", "1", "1", "2", "2", "2"};
	private String[] matriz12 = new String[] { "2", "1", "1", "1", "1", "1", "1"};
	private String[] matriz13 = new String[] { "2", "2", "2", "1", "2", "1", "1"};
	private String[] matriz14 = new String[] { "2", "2", "2", "1", "1", "2", "2"};
	private String[] matriz15 = new String[] { "2", "2", "1", "2", "2", "1", "2"};
	private String[] matriz16 = new String[] { "2", "2", "1", "2", "1", "2", "1"};
	
	public List<Volante> casaFora(String[] definicao){
		List<Volante> listaVolantesCasaFora = new ArrayList<>();
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz1));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz2));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz3));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz4));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz5));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz6));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz7));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz8));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz9));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz10));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz11));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz12));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz13));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz14));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz15));
		listaVolantesCasaFora.add(gerarVolante(definicao, matriz16));
		
		return listaVolantesCasaFora;
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
