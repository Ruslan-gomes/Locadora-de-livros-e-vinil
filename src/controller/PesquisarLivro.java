package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.BO.ProdutosBO;
import model.VO.LivrosVO;
import view.Telas;

public class PesquisarLivro {
	public static PesquisarLivro pesquisarLivro;
	
	@FXML private TextField titulo;
	@FXML private TextField genero;
	@FXML private TextField anolancamento;
	@FXML private TableView<LivrosVO> tabelalivros;
	
	ProdutosBO<LivrosVO> bo = new ProdutosBO<LivrosVO>();
	ObservableList<LivrosVO> lista;
	
	public static final String PEN_SOLID = "M290.74 93.24l128.02 128.02-277.99 277.99-114.14 12.6C11.35 513.54-1.56 500.62.14 485.34l12.7-114.22 277.9-277.88zm207.2-19.06l-60.11-60.11c-18.75-18.75-49.16-18.75-67.91 0l-56.55 56.55 128.02 128.02 56.55-56.55c18.75-18.76 18.75-49.16 0-67.91z";
	public static final String TRASH_SOLID = "M432 32H312l-9.4-18.7A24 24 0 0 0 281.1 0H166.8a23.72 23.72 0 0 0-21.4 13.3L136 32H16A16 16 0 0 0 0 48v32a16 16 0 0 0 16 16h416a16 16 0 0 0 16-16V48a16 16 0 0 0-16-16zM53.2 467a48 48 0 0 0 47.9 45h245.8a48 48 0 0 0 47.9-45L416 128H32z";
	
	@FXML
	void initialize()
	{
		pesquisarLivro = this;
		LivrosVO vo = new LivrosVO();
		
		TableColumn<LivrosVO, String> colunaTitulo = new TableColumn<>("Título");
		TableColumn<LivrosVO, String> colunaGenero = new TableColumn<>("Gênero");
		TableColumn<LivrosVO, Calendar> colunaAnoLancamento = new TableColumn<>("Ano de lançamento");
		TableColumn<LivrosVO, String> colunaPaginas = new TableColumn<>("Qtd páginas");
		TableColumn<LivrosVO, String> colunaExemplares = new TableColumn<>("qtde exemplares");
		TableColumn<LivrosVO, Double> colunaValorAluguel = new TableColumn<>("Valor aluguel");
		TableColumn<LivrosVO, LivrosVO> colunaEditar = new TableColumn<>("");
		TableColumn<LivrosVO, LivrosVO> colunaDeletar = new TableColumn<>("");
		
		colunaTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		colunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
		colunaAnoLancamento.setCellValueFactory(new PropertyValueFactory<>("anoLancamento"));
		colunaAnoLancamento.setCellFactory( cell -> {          
            return new TableCell<LivrosVO, Calendar>() {
                SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                
                @Override
                protected void updateItem(Calendar item, boolean empty) {
                   super.updateItem(item, empty);
                   
                   if( !empty ) {
                	   setText(""+item.getWeekYear());
                   }else {
                      setText("");
                      setGraphic(null);
                   }
                }
            };        
         } );
		colunaPaginas.setCellValueFactory(new PropertyValueFactory<>("qtdPaginas"));
		colunaExemplares.setCellValueFactory(new PropertyValueFactory<>("qtdExemplares"));
		colunaValorAluguel.setCellValueFactory(new PropertyValueFactory<>("valorAluguel"));
		
		tabelalivros.getColumns().addAll(colunaTitulo, colunaGenero, colunaAnoLancamento, colunaPaginas, colunaExemplares, colunaValorAluguel, colunaEditar, colunaDeletar);
		
		lista = FXCollections.observableArrayList(bo.listarProduto(vo));
		tabelalivros.setItems(lista);
		
		Utils.initButtons(colunaEditar, 15, PEN_SOLID, "svg-gray", (LivrosVO LivrosVO, ActionEvent event) -> {
			System.out.println("Você clicou para editar as informações de: " + LivrosVO.getTitulo());
			try {
				Telas.telaEditaLivro();
				EditarLivro.editarLivro.insereTexto(LivrosVO);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		Utils.initButtons(colunaDeletar, 15, TRASH_SOLID, "svg-red", (LivrosVO LivrosVO, ActionEvent event) -> {
			System.out.println("Você clicou para deletar as informações de: "+ LivrosVO.getTitulo());
			// Aqui vai toda a lógica para deletar o livro
			try {
				Telas.telaConfirmaDelecao();
				ConfirmarDelecao.confirmarDelecao.setLivro(LivrosVO);
			} catch (Exception e) {
				try {
					Telas.telaErro();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
	}
	
	
	public void pesquisarLivro(ActionEvent event) throws Exception
	{
		LivrosVO vo = new LivrosVO();
		if(titulo.getText() != null && !titulo.getText().isEmpty())
		{
			vo.setTitulo(titulo.getText());
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabelalivros.setItems(lista);
			titulo.setText("");
		}
		else if(genero.getText() != null && !genero.getText().isEmpty())
		{
			vo.setGenero(genero.getText());
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabelalivros.setItems(lista);
			genero.setText("");
		}
		else if(anolancamento.getText() != null && !anolancamento.getText().isEmpty())
		{
			Calendar data = Calendar.getInstance();
			int a = Integer.parseInt(anolancamento.getText());
			data.set(Calendar.YEAR, a);
			vo.setAnoLancamento(data);
			
			lista = FXCollections.observableArrayList(bo.pesquisarProduto(vo));
			tabelalivros.setItems(lista);
			anolancamento.setText("");
		}
	}
	
	public void atualizaTableView() {
		LivrosVO vo = new LivrosVO();
		tabelalivros.setItems(null);
		lista = FXCollections.observableArrayList(bo.listarProduto(vo));
        tabelalivros.setItems(lista);
	}
	
	public void limparPesquisa(ActionEvent event) throws Exception
	{
		this.atualizaTableView();
	}
}
