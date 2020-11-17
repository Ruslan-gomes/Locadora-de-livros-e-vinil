package model.BO;

import model.VO.ClientesVO;

public class ClientesBO {
	
	
	void cadastrarCliene(ClientesVO cliente)
	{
		/* Recebe um Objeto do tipo ClientesVO verifica se já
		 * esta cadastrado, então usa os setters para cadastrar os dados.
		 * 
		 */
	}
	
	void deletarCliente(ClientesVO cliente)
	{
		/*
		 * Recebe um Objeto do tipo ClientesVO e deleta a tupla específica definida pela chave 
		 * primária CPF.
		 */
	}
	
	void editarCliente(ClientesVO cliente)
	{
		/*
		 * Recebe um Objeto do tipo ClientesVO verifica se o cliente já esta cadastrado
		 * depois altera o/os campos solicitados.
		 */
	}
	
	void pesquisarCliente(ClientesVO cliente)
	{
		/*
		 * Recebe um Objeto do tipo ClientesVO e usa a chave primária CPF para encontrar o cliente
		 * solicitado.
		 */
	}
}
