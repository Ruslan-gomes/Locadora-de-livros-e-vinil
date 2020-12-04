import model.VO.FuncionariosVO;

public class teste {

	public static void main(String[] args) {
		FuncionariosVO usuario = new FuncionariosVO();
		usuario.setLogin("123");
		usuario.setSenha("senha");
		FuncionariosVO funcionario = new FuncionariosVO();
		funcionario.setLogin("123");
		funcionario.setSenha("senha1");
		
		if(usuario.getLogin().equals(funcionario.getLogin()) && usuario.getSenha().equals(funcionario.getSenha())){
			
		}else {
			
		}

	}

}
