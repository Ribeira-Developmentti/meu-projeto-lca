
package adm;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import gerador.Gerador;
import modelo.Resultado;
import modelo.Tabela;
import modelo.Volante;
import util.Util;

public class Menu {

	private static List<Volante> todosVolantes = new ArrayList<>();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		controlador();
	}

	public static void controlador() {
		String opcaoDoUsuario = menuInicial();

		if (opcaoDoUsuario.equalsIgnoreCase("1")) {
			System.out.println("+ ============================================ +");
			System.out.println("+ Jogo / Times                                 +");

			String[] jogosDoConcursoDesejado = new String[14];
			in.nextLine();// esvazia o buffer.

			for (int i = 0; i < jogosDoConcursoDesejado.length; i++) {
				if (i < 9) {
					System.out.print("+  " + (i + 1) + ": ");
					jogosDoConcursoDesejado[i] = "0" + (i + 1) + ": " + in.nextLine();
				} else {
					System.out.print("+ " + (i + 1) + ": ");
					jogosDoConcursoDesejado[i] = (i + 1) + ": " + in.nextLine();
				}
			}

			System.out.print("+ Concurso da tabela de jogo: ");
			String concursoDesejado = in.nextLine();
			System.out.println("+ ============================================ +");

			System.out.println("+ Confirmação dos dados informados!            +");
			System.out.println("+ Concurso: " + concursoDesejado);
			System.out.println("+ Jogo / Times                                 +");
			for (String jogo : jogosDoConcursoDesejado) {
				System.out.println("+ " + jogo);
			}
			System.out.println("+ ============================================ +");
			System.out.println("+ s. Salvar Tabela                             +");
			System.out.println("+ m. Menu Inicial                              +");

			String comando = null;
			boolean exibirMensagem = false;
			do {
				if (exibirMensagem == true) {
					System.out.println("+ Opção inválida.                              +");
				}

				comando = in.next();
				exibirMensagem = true;
			} while ((comando == null) || (!comando.equalsIgnoreCase("s") && !comando.equalsIgnoreCase("m")));

			if (comando.equalsIgnoreCase("s")) {
				Tabela tabelaJogos = new Tabela(concursoDesejado, jogosDoConcursoDesejado);
				Util.salvarTabelaJogos(tabelaJogos);
				controlador();
			} else if (comando.equalsIgnoreCase("m")) {
				controlador();
			}

		} else if (opcaoDoUsuario.equalsIgnoreCase("2")) {

			String tipoVolante = tipoVolante();
			String[] palpiteUsuario = palpiteJogos();

			if (tipoVolante.equalsIgnoreCase("1")) {
				exibirPalpitesJogos(palpiteUsuario, "Casa/Empate");
			} else if (tipoVolante.equalsIgnoreCase("2")) {
				exibirPalpitesJogos(palpiteUsuario, "Casa/Fora");
			} else if (tipoVolante.equalsIgnoreCase("3")) {
				exibirPalpitesJogos(palpiteUsuario, "Empate/Fora");
			}

			System.out.println("+ Está correto os palpites dos jogos?          +");
			System.out.println("+ s. Confirmar.                                +");
			System.out.println("+ c. Cancelar                                  +");

			String comandoUsuario = null;
			boolean exibirMensagem = false;
			do {
				if (exibirMensagem == true) {
					System.out.println("+ Opção inválida.                              +");
				}

				comandoUsuario = in.next();
				exibirMensagem = true;
			} while ((comandoUsuario == null)
					|| (!comandoUsuario.equalsIgnoreCase("s") && !comandoUsuario.equalsIgnoreCase("c")));

			if (comandoUsuario.equalsIgnoreCase("c")) {
				controlador();
			} else {
				if (tipoVolante.equalsIgnoreCase("1")) {
					gerarTodosVolantes(1, palpiteUsuario);
				} else if (tipoVolante.equalsIgnoreCase("2")) {
					gerarTodosVolantes(2, palpiteUsuario);
				} else if (tipoVolante.equalsIgnoreCase("3")) {
					gerarTodosVolantes(3, palpiteUsuario);
				}

				imprimirTodosVolantes();

				System.out.println("+ s. Salvar Volantes                           +");
				System.out.println("+ m. Menu Inicial                              +");

				String comando2usuario = null;
				boolean exibirMensagem2 = false;
				do {
					if (exibirMensagem2 == true) {
						System.out.println("+ Opção inválida.                              +");
					}

					comando2usuario = in.next();
					exibirMensagem2 = true;
				} while ((comando2usuario == null)
						|| (!comando2usuario.equalsIgnoreCase("s") && !comando2usuario.equalsIgnoreCase("m")));

				if (comandoUsuario.equalsIgnoreCase("s")) {
					Util.salvarVolantes(todosVolantes);
					controlador();
				} else if (comandoUsuario.equalsIgnoreCase("m")) {
					controlador();
				}
			}
		} else if (opcaoDoUsuario.equalsIgnoreCase("3")) {
			if (Util.carregarTodosVolantes().isEmpty()) {
				System.out.println("+ Nenhum volante salvo.                        +");
				controlador();
			} else {
				todosVolantes = Util.carregarTodosVolantes();
				imprimirTodosVolantes();

				System.out.println("+ m. Menu Inicial                              +");
				System.out.println("+ i. Imprimir TXT                              +");

				String comandoUsuario = null;
				boolean exibirMensagem = false;
				do {
					if (exibirMensagem == true) {
						System.out.println("+ Opção inválida.                              +");
					}

					comandoUsuario = in.next();
					exibirMensagem = true;
				} while ((comandoUsuario == null)
						|| (!comandoUsuario.equalsIgnoreCase("m") && !comandoUsuario.equalsIgnoreCase("i")));

				if (comandoUsuario.equalsIgnoreCase("m")) {
					controlador();
				} else if (comandoUsuario.equalsIgnoreCase("i")) {
					Util.imprimirVolantesTXT(todosVolantes);
					controlador();
				}
			}
		} else if (opcaoDoUsuario.equalsIgnoreCase("4")) {
			Resultado resultadoConcurso = Util.carregarResultado();
			if (resultadoConcurso == null) {
				System.out.println("+ Nenhum resultado salvo na base de dados.     +");
				controlador();
			} else {
				todosVolantes = Util.carregarTodosVolantes();

				if (todosVolantes.isEmpty()) {
					System.out.println("+ Nenhum volante para conferir.                +");
					controlador();
				} else {
					int p10 = 0;
					int p11 = 0;
					int p12 = 0;
					int p13 = 0;
					int p14 = 0;
					
					for (Volante v : todosVolantes) {
						Util.conferirVolante(v, resultadoConcurso);
						if (v.getPontuacao() == 10) {
							p10++;
						}
						if (v.getPontuacao() == 11) {
							p11++;
						}
						if (v.getPontuacao() == 12) {
							p12++;
						}
						if (v.getPontuacao() == 13) {
							p13++;
						}
						if (v.getPontuacao() == 14) {
							p14++;
						}
					}
					
					System.out.println("================================================");
					imprimirVolantePontuacao();
					System.out.println("================================================");
					System.out.println("+ Relatório de pontuação                       +");
					System.out.println("+ 10 pontos: " + p10 + "                                 +");
					System.out.println("+ 11 pontos: " + p11 + "                                 +");
					System.out.println("+ 12 pontos: " + p12 + "                                 +");
					System.out.println("+>>>>>>>>>>>>>>>>>>>>>> <<<<<<<<<<<<<<<<<<<<<<<+");
					System.out.println("+ 13 pontos: " + p13 + "                                 +");
					System.out.println("+ 14 pontos: " + p14 + "                                 +");
					System.out.println("================================================");

					System.out.println("+ m. Menu Inicial                              +");
					System.out.println("+ i. Imprimir TXT                              +");

					String comandoUsuario = null;
					boolean exibirMensagem = false;
					do {
						if (exibirMensagem == true) {
							System.out.println("+ Opção inválida.                              +");
						}

						comandoUsuario = in.next();
						exibirMensagem = true;
					} while ((comandoUsuario == null) || (!comandoUsuario.equalsIgnoreCase("m") && !comandoUsuario.equalsIgnoreCase("i")));

					if (comandoUsuario.equalsIgnoreCase("m")) {
						controlador();
					} else if (comandoUsuario.equalsIgnoreCase("i")) {
						try (PrintStream writer = new PrintStream("relatorio.txt")) {

							writer.println("Relatatório de Pontos");
							writer.println();
							writer.println("10 pontos: " + p10);
							writer.println("11 pontos: " + p11);
							writer.println("12 pontos: " + p12);
							System.out.println("+>>>>>>>>>>>>>>>>>>>>>> <<<<<<<<<<<<<<<<<<<<<<<+");
							writer.println("13 pontos: " + p13);
							writer.println("14 pontos: " + p14);

							System.out.println("+ Relatório impresso com sucesso.              +");
						} catch (IOException e) {
							System.out.println("+ Não conseguiu gravar o arquivo.              +" + e.getMessage());
						}
						controlador();
					}
				}

			}
		} else if (opcaoDoUsuario.equalsIgnoreCase("5")) {

			Resultado resultado = new Resultado();
			resultado.setConcurso("");
			resultado.setResultadoJogos(new String[14]);

			System.out.println("+ ============================================ +");
			System.out.print("+ Concurso: " + resultado.getConcurso());
			resultado.setConcurso(in.nextLine());

			in.nextLine();// esvazia o buffer.
			System.out.println("+ Resultado dos jogos");

			for (int i = 0; i < resultado.getResultadoJogos().length; i++) {
				if (i < 9) {
					System.out.print("+ Jogo  " + (i + 1) + ": ");
					resultado.getResultadoJogos()[i] = in.nextLine();
				} else {
					System.out.print("+ Jogo " + (i + 1) + ": ");
					resultado.getResultadoJogos()[i] = in.nextLine();
				}
			}

			System.out.println("================= DETALHAMENTO =================");
			System.out.println("+ Concurso: " + resultado.getConcurso());
			for (int i = 0; i < resultado.getResultadoJogos().length; i++) {
				if (i < 9) {
					System.out.println("+ Jogo  " + (i + 1) + ": " + resultado.getResultadoJogos()[i]);
				} else {
					System.out.println("+ Jogo " + (i + 1) + ": " + resultado.getResultadoJogos()[i]);
				}
			}
			System.out.println("+ ============================================ +");

			System.out.println("+ m. Menu Inicial                              +");
			System.out.println("+ s. Salvar Resultado                          +");

			String comandoUsuario = null;
			boolean exibirMensagem = false;
			do {
				if (exibirMensagem == true) {
					System.out.println("+ Opção inválida.                              +");
				}

				comandoUsuario = in.next();
				exibirMensagem = true;
			} while ((comandoUsuario == null)
					|| (!comandoUsuario.equalsIgnoreCase("m") && !comandoUsuario.equalsIgnoreCase("s")));

			if (comandoUsuario.equalsIgnoreCase("m")) {
				controlador();
			} else if (comandoUsuario.equalsIgnoreCase("s")) {
				Util.salvarResultado(resultado);
				controlador();
			}

		} else if (opcaoDoUsuario.equalsIgnoreCase("6")) {
			List<Volante> volantes = Util.carregarTodosVolantes();
			if (volantes.isEmpty()) {
				System.out.println("+ Nenhum volante para imprimir.                +");
				controlador();
			} else {
				Util.imprimirVolantesTXT(volantes);
				controlador();
			}
		}
	}

	private static void exibirPalpitesJogos(String[] palpitesJogos, String tipoVolantes) {
		Tabela tabelaJogosConcurso = Util.carregarTabelaJogos();
		System.out.println("+ ============================================ +");
		System.out.println("+ " + tipoVolantes);

		for (int i = 0; i < palpitesJogos.length; i++) {
			System.out.println("+ " + tabelaJogosConcurso.getJogos()[i] + " - " + palpitesJogos[i]);
		}
		System.out.println("+ ============================================ +");
	}

	private static String[] palpiteJogos() {

		String[] palpiteUsuario = new String[14];

		if (Util.carregarTabelaJogos() == null) {
			System.out.println("+ Nenhuma tabela de jogos encontrada.          +");
			controlador();
		} else {
			Tabela tabelaJogosConcurso = Util.carregarTabelaJogos();
			System.out.println("+ ============================================ +");
			System.out.println("+ 1, x ou 2: palpite seco.         ( 4 vezes ) +");
			System.out.println("+ 1x, 12 ou x2: duplo alternado.   ( 3 vezes ) +");
			System.out.println("+ d: duplo fixo.                   ( 7 vezes ) +");
			System.out.println("+ ============================================ +");
			System.out.println("+ Jogo / Times                                 +");

			for (int i = 0; i < tabelaJogosConcurso.getJogos().length; i++) {

				System.out.print("+ " + tabelaJogosConcurso.getJogos()[i] + " > ");

				String comandoUsuario = null;
				boolean exibirMensagem = false;

				do {
					if (exibirMensagem == true) {
						System.out.println("+ Opção inválida.                              +");
					}

					comandoUsuario = in.next();
					exibirMensagem = true;
				} while ((comandoUsuario == null) || (!comandoUsuario.equalsIgnoreCase("1")
						&& !comandoUsuario.equalsIgnoreCase("x") && !comandoUsuario.equalsIgnoreCase("2")
						&& !comandoUsuario.equalsIgnoreCase("1x") && !comandoUsuario.equalsIgnoreCase("12")
						&& !comandoUsuario.equalsIgnoreCase("x2") && !comandoUsuario.equalsIgnoreCase("d")));

				palpiteUsuario[i] = comandoUsuario;
			}
		}
		return palpiteUsuario;
	}

	private static void imprimirTodosVolantes() {
		System.out.println("================================================");
		for (Volante v : todosVolantes) {
			System.out.println("+ Volante " + v.getId());
			for (int i = 0; i < v.getPalpites().length; i++) {
				if (i < 9) {
					System.out.println("+ Jogo  " + (i + 1) + ": " + v.getPalpites()[i]);
				} else {
					System.out.println("+ Jogo " + (i + 1) + ": " + v.getPalpites()[i]);
				}
			}
			System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - ");
		}

	}

	private static void gerarTodosVolantes(int tipoVolantes, String[] palpitesJogos) {
		Gerador gerador = new Gerador();
		List<Volante> volantes = gerador.gerarVolantes(tipoVolantes, palpitesJogos);
		for (Volante v : volantes) {
			todosVolantes.add(v);
		}
	}

	private static String menuInicial() {
		todosVolantes = new ArrayList<>();

		String opcao = null;
		boolean exibirMensagem = false;

		System.out.println("+================ Minha Loteca ================+");
		System.out.println("+ 1. Inserir Tabela de jogos                   +");
		System.out.println("+ 2. Gerar Volantes                            +");
		System.out.println("+ 3. Carregar Volantes                         +");
		System.out.println("+ 4. Conferir Volantes                         +");
		System.out.println("+ 5. Inserir Resultado                         +");
		System.out.println("+ 6. Imprimir Volantes \"TXT\"                   +");
		System.out.println("+==============================================+");

		do {
			if (exibirMensagem == true) {
				System.out.println("+ Opção inválida.                              +");
			}

			opcao = in.next();
			exibirMensagem = true;
		} while ((opcao == null) || (!opcao.equalsIgnoreCase("1") && !opcao.equalsIgnoreCase("2")
				&& !opcao.equalsIgnoreCase("3") && !opcao.equalsIgnoreCase("4") && !opcao.equalsIgnoreCase("5")
				&& !opcao.equalsIgnoreCase("6")));

		return opcao;
	}

	private static String tipoVolante() {

		String opcaoDoUsuario = null;
		boolean exibirMensagem = false;

		System.out.println("+================ Tipo Volante ================+");
		System.out.println("+ 1. Casa/Empate                               +");
		System.out.println("+ 2. Casa/Fora                                 +");
		System.out.println("+ 3. Empate/Fora                               +");
		System.out.println("+==============================================+");

		do {
			if (exibirMensagem == true) {
				System.out.println("+ Opção inválida.                              +");
			}

			opcaoDoUsuario = in.next();
			exibirMensagem = true;
		} while ((opcaoDoUsuario == null) || (!opcaoDoUsuario.equalsIgnoreCase("1")
				&& !opcaoDoUsuario.equalsIgnoreCase("2") && !opcaoDoUsuario.equalsIgnoreCase("3")));

		return opcaoDoUsuario;
	}
	
	private static void imprimirVolantePontuacao() {
		for (Volante v : todosVolantes) {
			System.out.println("+ Volante " + v.getId() + " > " + v.getPontuacao() + "pts");
		}		
	}
}