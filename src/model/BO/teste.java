package model.BO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.DAO.AlugueisDAO;
import model.VO.AlugueisVO;
import model.VO.ClientesVO;
import model.VO.DiscosVO;
import model.VO.LivrosVO;

public class teste {

	public static void main(String[] args) {
		
		//setando a data para pesquisa
		Calendar mes = Calendar.getInstance();
		mes.set(2020, 10, 1);
		
		double faturaMensal;
		AlugueisDAO dao = new AlugueisDAO();
		faturaMensal = dao.faturaMensal(mes);
		
		System.out.println("Fatura mensal = R$" + faturaMensal);
		
		
	}

}
