package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.VO.ClientesVO;

public interface ClientesInterDAO {
	public void Cadastrar(ClientesVO vo) throws SQLException;
	public void Deletar(ClientesVO vo);
	public void Editar(ClientesVO vo);
	public ResultSet Pesquisar(ClientesVO vo);
	public ResultSet Listar();
}
