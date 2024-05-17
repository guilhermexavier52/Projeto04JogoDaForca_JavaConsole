package jogoDaForca;

import java.util.Scanner;

public class JogoDaForca {
	private static final String[] PALAVRAS = { "java", "programacao", "computador", "desenvolvimento", "openai" };
	private static final int MAX_TENTATIVAS = 6;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Palavra palavra = new Palavra(selecionarPalavraSecreta());
		Jogador jogador = new Jogador(MAX_TENTATIVAS);

		while (jogador.getTentativasRestantes() > 0 && !palavra.estaRevelada()) {
			System.out.println("Palavra: " + palavra.getPalavraEscondida());
			System.out.println("Tentativas restantes: " + jogador.getTentativasRestantes());
			System.out.print("Digite uma letra: ");
			char letra = scanner.next().charAt(0);

			if (!jogador.tentarLetra(letra)) {
				System.out.println("Você já tentou essa letra. Tente outra.");
				continue;
			}

			if (!palavra.revelarLetra(letra)) {
				System.out.println("Letra não encontrada na palavra secreta.");
				jogador.diminuirTentativas();
			} else {
				System.out.println("Letra encontrada na palavra secreta!");
			}
		}

		if (palavra.estaRevelada()) {
			System.out.println("Parabéns! Você ganhou! A palavra secreta era: " + palavra.getPalavraSecreta());
		} else {
			System.out.println("Você perdeu! A palavra secreta era: " + palavra.getPalavraSecreta());
		}
	}

	private static String selecionarPalavraSecreta() {
		return PALAVRAS[(int) (Math.random() * PALAVRAS.length)];
	}

}
