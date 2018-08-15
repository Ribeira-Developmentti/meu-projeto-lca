package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import modelo.Resultado;
import modelo.Tabela;
import modelo.Volante;

public class Util {

	public static int id = 1;

	public static void imprimirVolantesTXT(List<Volante> todosVolantes) {
		try (PrintStream writer = new PrintStream("volantes_impressos.txt")) {

			writer.println("++++++++++ Volantes Impressos em TXT +++++++++++");
			for (Volante vol : todosVolantes) {
				writer.println();
				writer.println("+ Volante " + vol.getId());

				for (int i = 0; i < vol.getPalpites().length; i++) {
					if (i < 9) {
						writer.println("Jogo  " + (i + 1) + ": " + vol.getPalpites()[i]);
					} else {
						writer.println("Jogo " + (i + 1) + ": " + vol.getPalpites()[i]);
					}
				}

				writer.println("- - - - - - - - - - - - - - - - - - - - - - - - ");
			}
			writer.println();
			writer.println();
			writer.println("++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+ Volantes impressos com sucesso.              +");
		} catch (IOException e) {
			System.out.println("+ Não conseguiu gravar o arquivo.              +" + e.getMessage());
		}
	}

	public static void salvarResultado(Resultado r) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("resultado.obj"))) {
			out.writeObject(r);
			System.out.println("+ Resultado salvo com sucesso.                 +");
		} catch (IOException e) {
			System.err.println("+ Erro ao salvar resultado.                    +" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static Resultado carregarResultado() {
		Resultado result = null;
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("resultado.obj"))) {
			result = (Resultado) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
			return result;
		}
		return result;
	}

	public static void conferirVolante(Volante v, Resultado resultado) {
		for (int i = 0; i < resultado.getResultadoJogos().length; i++) {
			char[] pal = v.getPalpites()[i].toCharArray();
			for (char x : pal) {
				if (resultado.getResultadoJogos()[i].equalsIgnoreCase(Character.toString(x))) {
					int pontuacaoVolante = v.getPontuacao();
					pontuacaoVolante++;
					v.setPontuacao(pontuacaoVolante);
					break;
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public static List<Volante> carregarTodosVolantes() {
		List<Volante> volantes = new ArrayList<>();
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("volantes.obj"))) {
			volantes = (List<Volante>) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
			return volantes;
		}
		return volantes;
	}

	public static void salvarTabelaJogos(Tabela tabelaJogos) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("tabela-jogos.obj"))) {
			out.writeObject(tabelaJogos);
			System.out.println("+ Tabela salva com sucesso.                    +");
		} catch (IOException e) {
			System.err.println("+ Erro ao salvar tabela.                       +" + e.getMessage());
			e.printStackTrace();
		}
	}

	public static Tabela carregarTabelaJogos() {
		Tabela tab = null;
		try (ObjectInput in = new ObjectInputStream(new FileInputStream("tabela-jogos.obj"))) {
			tab = (Tabela) in.readObject();
		} catch (IOException | ClassNotFoundException e) {
			// e.printStackTrace();
			return tab;
		}
		return tab;
	}

	public static void salvarVolantes(List<Volante> todosVolantes) {
		try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("volantes.obj"))) {
			out.writeObject(todosVolantes);
			System.out.println("+ Volantes salvos com sucesso.                 +");
		} catch (IOException e) {
			System.err.println("+ Erro ao salvar volantes.                     +" + e.getMessage());
			e.printStackTrace();
		}

	}
}
