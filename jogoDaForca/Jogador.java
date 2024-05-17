package jogoDaForca;

public class Jogador {

	private int tentativasRestantes;
	private boolean[] letrasUtilizadas;

	public Jogador(int tentativas) {
		this.tentativasRestantes = tentativas;
		this.letrasUtilizadas = new boolean[26];
	}

	public boolean tentarLetra(char letra) {
		if (letrasUtilizadas[letra - 'a']) {
			return false;
		}
		letrasUtilizadas[letra - 'a'] = true;
		return true;
	}

	public void diminuirTentativas() {
		tentativasRestantes--;
	}

	public int getTentativasRestantes() {
		return tentativasRestantes;
	}
}
