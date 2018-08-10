package gerador;

import java.util.ArrayList;
import java.util.List;

import modelo.Volante;
import util.Util;

public class GeradorCasaEmpate {
	
	private String[] matriz1 = new String[] { "1", "1", "x", "1", "x", "1", "x" };
	private String[] matriz2 = new String[] { "1", "1", "x", "1", "1", "x", "1" };
	private String[] matriz3 = new String[] { "1", "1", "1", "x", "x", "1", "1" };
	private String[] matriz4 = new String[] { "1", "1", "1", "x", "1", "x", "x" };
	private String[] matriz5 = new String[] { "1", "x", "x", "x", "x", "x", "x" };
	private String[] matriz6 = new String[] { "1", "x", "x", "x", "1", "1", "1" };
	private String[] matriz7 = new String[] { "1", "x", "1", "1", "x", "x", "1" };
	private String[] matriz8 = new String[] { "1", "x", "1", "1", "1", "1", "x" };
	private String[] matriz9 = new String[] { "x", "1", "x", "x", "x", "x", "1" };
	private String[] matriz10 = new String[] { "x", "1", "x", "x", "1", "1", "x" };
	private String[] matriz11 = new String[] { "x", "1", "1", "1", "x", "x", "x" };
	private String[] matriz12 = new String[] { "x", "1", "1", "1", "1", "1", "1" };
	private String[] matriz13 = new String[] { "x", "x", "x", "1", "x", "1", "1" };
	private String[] matriz14 = new String[] { "x", "x", "x", "1", "1", "x", "x" };
	private String[] matriz15 = new String[] { "x", "x", "1", "x", "x", "1", "x" };
	private String[] matriz16 = new String[] { "x", "x", "1", "x", "1", "x", "1" };
	
	
	
	public List<Volante> casaEmpate(String[] definicao){
		List<Volante> listaVolantesCasaEmpate = new ArrayList<>();
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz1));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz2));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz3));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz4));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz5));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz6));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz7));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz8));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz9));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz10));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz11));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz12));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz13));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz14));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz15));
		listaVolantesCasaEmpate.add(gerarVolante(definicao, matriz16));
		
		return listaVolantesCasaEmpate;
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
