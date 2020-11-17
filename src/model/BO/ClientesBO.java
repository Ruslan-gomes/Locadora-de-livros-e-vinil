package model.BO;

import model.VO.ClientesVO;

public class ClientesBO {
	
	
	void cadastrarCliene(ClientesVO cliente)
	{
		/* Recebe um Objeto do tipo ClientesVO verifica se j�
		 * esta cadastrado, ent�o usa os setters para cadastrar os dados.
		 * 
		 */
	}
	
	void deletarCliente(ClientesVO cliente)
	{
		/*
		 * Recebe um Objeto do tipo ClientesVO e deleta a tupla espec�fica definida pela chave 
		 * prim�ria CPF.
		 */
	}
	
	void editarCliente(ClientesVO cliente)
	{
		/*
		 * Recebe um Objeto do tipo ClientesVO verifica se o cliente j� esta cadastrado
		 * depois altera o/os campos solicitados.
		 */
	}
	
	void pesquisarCliente(ClientesVO cliente)
	{
		/*
		 * Recebe um Objeto do tipo ClientesVO e usa a chave prim�ria CPF para encontrar o cliente
		 * solicitado.
		 */
	}
}
