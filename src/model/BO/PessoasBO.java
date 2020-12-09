package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.AutenticationException;
import model.DAO.ClientesDAO;
import model.DAO.FuncionariosDAO;
import model.VO.ClientesVO;
import model.VO.FuncionariosVO;

public class PessoasBO<VO> implements PessoasInterBO<VO>{

	@Override
	public void cadastrarPessoa(VO vo) throws SQLException {
		if(vo instanceof ClientesVO){
			if(((ClientesVO) vo).getCpf() != null && ((ClientesVO) vo).getNome() != null && ((ClientesVO) vo).getEndereco() != null) {
				ClientesDAO dao = new ClientesDAO();
				dao.Cadastrar((ClientesVO)vo);
			}else throw new SQLException();
		}
		else {
			if(((FuncionariosVO) vo).getCpf() != null && ((FuncionariosVO) vo).getNome() != null && ((FuncionariosVO) vo).getEndereco() != null && ((FuncionariosVO) vo).getLogin() != null && ((FuncionariosVO) vo).getSenha() != null && ((FuncionariosVO) vo).getCargo() != null){
				FuncionariosDAO dao = new FuncionariosDAO();
				dao.Cadastrar((FuncionariosVO)vo);
			}else  throw new SQLException();
		}
	}

	@Override
	public void deletarPessoa(VO vo) {
		if(vo instanceof ClientesVO)
		{
			ClientesDAO dao = new ClientesDAO();
			dao.Deletar((ClientesVO)vo);
		}
		else
		{
			FuncionariosDAO dao = new FuncionariosDAO();
			dao.Deletar((FuncionariosVO)vo);
		}
		
	}

	@Override
	public void editarPessoa(VO vo) {
		if(vo instanceof ClientesVO)
		{
			ClientesDAO dao = new ClientesDAO();
			dao.Editar((ClientesVO)vo);
		}
		else
		{
			FuncionariosDAO dao = new FuncionariosDAO();
			dao.Editar((FuncionariosVO)vo);
		}
	}

	@Override
	public void pesquisarPessoa(VO vo) {
		
		if(vo instanceof ClientesVO)
		{
			ClientesDAO dao = new ClientesDAO();
			ResultSet rs = dao.Pesquisar((ClientesVO)vo);
			
			List<ClientesVO> clientes = new ArrayList<ClientesVO>();
			
			try {
				while(rs.next())
				{
					ClientesVO cliente = new ClientesVO();
					cliente.setCpf(rs.getString("Cpf"));
					cliente.setNome(rs.getString("Nome"));
					cliente.setEndereco(rs.getString("Endereco"));
					clientes.add(cliente);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			FuncionariosDAO dao = new FuncionariosDAO();
			ResultSet rs = dao.Pesquisar((FuncionariosVO)vo);
			
			List<FuncionariosVO> funcionarios = new ArrayList<FuncionariosVO>();
			
			try {
				while(rs.next())
				{
					FuncionariosVO func = new FuncionariosVO();
					func.setCpf(rs.getString("Cpf"));
					func.setNome(rs.getString("Nome"));
					func.setEndereco(rs.getString("Endereco"));
					func.setLogin(rs.getString("Login"));
					func.setSenha(rs.getString("Senha"));
					func.setCargo(rs.getString("Cargo"));
					func.setId(rs.getLong("Id_func"));
					funcionarios.add(func);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void ListarPessoa(VO vo) {
		if(vo instanceof ClientesVO)
		{
			ClientesDAO dao = new ClientesDAO();
			ResultSet rs = dao.Listar();
			
			List<ClientesVO> clientes = new ArrayList<ClientesVO>();
			
			try {
				while(rs.next())
				{
					ClientesVO cliente = new ClientesVO();
					cliente.setCpf(rs.getString("Cpf"));
					cliente.setNome(rs.getString("Nome"));
					cliente.setEndereco(rs.getString("Endereco"));
					clientes.add(cliente);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			FuncionariosDAO dao = new FuncionariosDAO();
			ResultSet rs = dao.Listar();
			
			List<FuncionariosVO> funcionarios = new ArrayList<FuncionariosVO>();
			
			try {
				while(rs.next())
				{
					FuncionariosVO func = new FuncionariosVO();
					func.setCpf(rs.getString("Cpf"));
					func.setNome(rs.getString("Nome"));
					func.setEndereco(rs.getString("Endereco"));
					func.setLogin(rs.getString("Login"));
					func.setSenha(rs.getString("Senha"));
					func.setCargo(rs.getString("Cargo"));
					func.setId(rs.getLong("Id_func"));
					funcionarios.add(func);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public FuncionariosVO autenticar(FuncionariosVO usuario) throws AutenticationException{
		FuncionariosDAO dao = new FuncionariosDAO();
		FuncionariosVO funcionario = new FuncionariosVO();
		ResultSet rs = dao.Pesquisar(usuario);
		
		try {
			while(rs.next()){
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setLogin(rs.getString("login"));
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setCargo(rs.getString("cargo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//throw new AutenticationException();
		}
		
		if(usuario.getLogin().equals(funcionario.getLogin()) && usuario.getSenha().equals(funcionario.getSenha())){
			return funcionario;
		}else throw new AutenticationException();
		
	}
	
}
