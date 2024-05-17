package jogoDaForca;

public class Palavra {
	private String palavraSecreta;
	private char[] palavraEscondida;

	public Palavra(String palavra) {
		this.palavraSecreta = palavra;
		this.palavraEscondida = new char[palavra.length()];
	}

	public boolean revelarLetra(char letra) {
		boolean encontrou = false;
		for (int i = 0; i < palavraSecreta.length(); i++) {
			if (palavraSecreta.charAt(i) == letra) {
				palavraEscondida[i] = letra;
				encontrou = true;
			}
		}
		return encontrou;
	}

	public boolean estaRevelada() {
		for (char c : palavraEscondida) {
			if (c == 0) {
				return false;
			}
		}
		return true;
	}

	public String getPalavraEscondida() {
		StringBuilder sb = new StringBuilder();
		for (char c : palavraEscondida) {
			if (c == 0) {
				sb.append("_ ");
			} else {
				sb.append(c).append(" ");
			}
		}
		return sb.toString();
	}

	public String getPalavraSecreta() {
		return palavraSecreta;
	}
}
