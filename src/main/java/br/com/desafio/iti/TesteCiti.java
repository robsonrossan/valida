package br.com.desafio.iti;

import javax.swing.JOptionPane;

public class TesteCiti {

	public static void main(String[] args) throws Exception {

		try {

			int vlr = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o primeiro número "));
			int vlr1 = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o segundo número "));
			somar(vlr, vlr1);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Somente número é permitido", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void somar(int valor, int valor1) throws Exception {

		StringBuilder mensagem = new StringBuilder();
		try {

			int soma = valor + valor1;
			mensagem.append("Valor da Soma: ").append(soma);
			JOptionPane.showMessageDialog(null, mensagem);

		} catch (Exception ex) {
			throw new Exception("Erro na soma");
		}
	}
}