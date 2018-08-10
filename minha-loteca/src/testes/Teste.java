package testes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gerador.GeradorEmpateFora;
import modelo.Volante;

public class Teste {

	public static void main(String[] args) {

		//GeradorCasaEmpate gce = new GeradorCasaEmpate();
		//GeradorCasaFora gcf = new GeradorCasaFora();
		GeradorEmpateFora gef = new GeradorEmpateFora();
		
		String[] definicao = { "1", "1", "2", "2", "1x", "12", "x2", "d", "d", "d", "d", "d", "d", "d" };
		String[] jogo1 = { "1" };
		String[] jogo2 = { "1" };
		String[] jogo3 = { "2" };
		String[] jogo4 = { "2", };
		String[] jogo5 = { "1x" };
		String[] jogo6 = { "12" };
		String[] jogo7 = { "x2" };
		String[] jogo8 = { "x", "2" };
		String[] jogo9 = { "x", "2" };
		String[] jogo10 = { "x", "2" };
		String[] jogo11 = { "x", "2" };
		String[] jogo12 = { "x", "2" };
		String[] jogo13 = { "x", "2" };
		String[] jogo14 = { "x", "2" };

		List<Volante> meusVolantes = gef.empateFora(definicao);

		List<Volante> volantes = new ArrayList<>();
		for (String p1 : jogo1) {
			for (String p2 : jogo2) {
				for (String p3 : jogo3) {
					for (String p4 : jogo4) {
						for (String p5 : jogo5) {
							for (String p6 : jogo6) {
								for (String p7 : jogo7) {
									for (String p8 : jogo8) {
										for (String p9 : jogo9) {
											for (String p10 : jogo10) {
												for (String p11 : jogo11) {
													for (String p12 : jogo12) {
														for (String p13 : jogo13) {
															for (String p14 : jogo14) {
																Volante v = new Volante();
																v.getPalpites()[0] = p1;
																v.getPalpites()[1] = p2;
																v.getPalpites()[2] = p3;
																v.getPalpites()[3] = p4;
																v.getPalpites()[4] = p5;
																v.getPalpites()[5] = p6;
																v.getPalpites()[6] = p7;
																v.getPalpites()[7] = p8;
																v.getPalpites()[8] = p9;
																v.getPalpites()[9] = p10;
																v.getPalpites()[10] = p11;
																v.getPalpites()[11] = p12;
																v.getPalpites()[12] = p13;
																v.getPalpites()[13] = p14;

																volantes.add(v);
															}
														}
													}
												}
											}
										}
									}

								}
							}
						}
					}
				}
			}
		}
		
		int premiado = 0;
		for (Volante v : volantes) {
			int p13 = 0;
			int p14 = 0;

			
			
			for (Volante x : meusVolantes) {
				int pontuacao = 0;
				for(int i = 0; i < v.getPalpites().length; i++) {
					if(v.getPalpites()[i].equalsIgnoreCase(x.getPalpites()[i])) {
						pontuacao++;
					}
				}
				
				if (pontuacao == 13) {
					p13++;
					premiado++;
				} else if (pontuacao == 14) {
					p14++;
					premiado++;
				}
			}

			System.out.println("Volante: " + (volantes.indexOf(v) + 1));
			System.out.println("13pts: " + p13);
			System.out.println("14pts: " + p14);
			
			System.out.println("========================================================================");

		}

		System.out.println("Premiados de alguma forma: " + premiado);
		for(Volante v : volantes) {
			System.out.println((volantes.indexOf(v)+1) +": "+ Arrays.toString(v.getPalpites()));
		}

	}

}
