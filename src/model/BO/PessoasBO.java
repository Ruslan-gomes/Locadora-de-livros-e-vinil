package model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ClientesDAO;
import model.DAO.FuncionariosDAO;
import model.VO.ClientesVO;
import model.VO.FuncionariosVO;
import model.VO.PessoasVO;

public class PessoasBO<VO> implements PessoasInterBO<VO>{

	@Override
	public void cadastrarPessoa(VO vo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarPessoa(PessoasVO pessoa) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editarPessoa(PessoasVO pessoa) {
		// TODO Auto-generated method stub
		
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
					func.setSenha(rs.getInt("Senha"));
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
					func.setSenha(rs.getInt("Senha"));
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

	
}
