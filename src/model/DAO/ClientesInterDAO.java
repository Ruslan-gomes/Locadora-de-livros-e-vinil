package model.DAO;

import java.util.List;

import model.VO.ClientesVO;

public interface ClientesInterDAO {
	public void Cadastrar(ClientesVO vo);
	public void Deletar(ClientesVO vo);
	public void Editar(ClientesVO vo);
	public List<ClientesVO> Pesquisar(ClientesVO vo);
	public List<ClientesVO> Listar();
}
