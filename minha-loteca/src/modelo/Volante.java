package modelo;

import java.io.Serializable;
import java.util.Arrays;

public class Volante implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String[] palpites;
	private int pontuacao;

	public Volante() {
		this.palpites = new String[14];
	}

	public String[] getPalpites() {
		return palpites;
	}

	public void setPalpites(String[] palpites) {
		this.palpites = palpites;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + Arrays.hashCode(palpites);
		result = prime * result + pontuacao;
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
		Volante other = (Volante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (!Arrays.equals(palpites, other.palpites))
			return false;
		if (pontuacao != other.pontuacao)
			return false;
		return true;
	}
	
	

}
