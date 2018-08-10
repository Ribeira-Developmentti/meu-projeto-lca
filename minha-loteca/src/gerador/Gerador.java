package gerador;

import java.util.List;

import modelo.Volante;

public class Gerador {

	public List<Volante> gerarVolantes(int tipoVolante, String[] definicaoJogos) {
		if (tipoVolante == 1) {
			return volantesCasaEmpate(definicaoJogos);
		} else if (tipoVolante == 2) {
			return volantesCasaFora(definicaoJogos);
		} else if (tipoVolante == 3) {
			return volantesEmpateFora(definicaoJogos);
		} else {
			return null;
		}
	}

	public List<Volante> volantesCasaEmpate(String[] definicaoJogos) {
		GeradorCasaEmpate gce = new GeradorCasaEmpate();
		return gce.casaEmpate(definicaoJogos);
	}

	public List<Volante> volantesCasaFora(String[] definicaoJogos) {
		GeradorCasaFora gcf = new GeradorCasaFora();
		return gcf.casaFora(definicaoJogos);
	}

	public List<Volante> volantesEmpateFora(String[] definicaoJogos) {
		GeradorEmpateFora gef = new GeradorEmpateFora();
		return gef.empateFora(definicaoJogos);
	}
}
