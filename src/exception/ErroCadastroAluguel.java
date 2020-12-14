package exception;

import java.io.IOException;

import controller.MensagemErro;
import view.Telas;

public class ErroCadastroAluguel extends Exception{
	private static final long serialVersionUID = 1L;
	
	public ErroCadastroAluguel(String msg) throws IOException {
		Telas.telaErro();
		MensagemErro.mensagemErro.setTexto(msg);
	}
}
