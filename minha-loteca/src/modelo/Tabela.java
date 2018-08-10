package modelo;

import java.io.Serializable;
import java.util.Arrays;

public class Tabela implements Serializable {

	private static final long serialVersionUID = 1L;

	private String concurso;
	private String[] jogos;
	
	public Tabela() {
		super();
	}

	public Tabela(String concurso, String[] jogos) {
		super();
		this.concurso = concurso;
		this.jogos = jogos;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public String[] getJogos() {
		return jogos;
	}

	public void setJogos(String[] jogos) {
		this.jogos = jogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((concurso == null) ? 0 : concurso.hashCode());
		result = prime * result + Arrays.hashCode(jogos);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tabela other = (Tabela) obj;
		if (concurso == null) {
			if (other.concurso != null)
				return false;
		} else if (!concurso.equals(other.concurso))
			return false;
		if (!Arrays.equals(jogos, other.jogos))
			return false;
		return true;
	}
	
	
}
