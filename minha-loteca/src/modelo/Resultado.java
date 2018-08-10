package modelo;

import java.io.Serializable;
import java.util.Arrays;

public class Resultado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String concurso;
	private String[] resultadoJogos;
	
	public Resultado(String concurso, String[] resultadoJogos) {
		super();
		this.concurso = concurso;
		this.resultadoJogos = resultadoJogos;
	}

	public Resultado() {
		super();
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	public String[] getResultadoJogos() {
		return resultadoJogos;
	}

	public void setResultadoJogos(String[] resultadoJogos) {
		this.resultadoJogos = resultadoJogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((concurso == null) ? 0 : concurso.hashCode());
		result = prime * result + Arrays.hashCode(resultadoJogos);
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
		Resultado other = (Resultado) obj;
		if (concurso == null) {
			if (other.concurso != null)
				return false;
		} else if (!concurso.equals(other.concurso))
			return false;
		if (!Arrays.equals(resultadoJogos, other.resultadoJogos))
			return false;
		return true;
	}

	
	

}
