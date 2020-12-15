
CREATE TABLE Clientes (
CPF varchar (11) NOT NULL UNIQUE,
Nome varchar(50),
Endereco varchar(80),
PRIMARY KEY (CPF));
 
CREATE TABLE Livros (
ID_livro serial PRIMARY KEY,
Titulo varchar(50),
Genero varchar(20),
Ano_lancamento int,
Qtd_paginas int,
Qtd_exemplares int NOT NULL,
Valor_aluguel float NOT NULL);
 
CREATE TABLE Discos (
ID_disco serial PRIMARY KEY,
Titulo varchar(50),
Estilo varchar(30),
Nome_banda varchar(30),
Qtd_exemplares int NOT NULL,
Valor_aluguel float NOT NULL);
 
CREATE TABLE Funcionarios (
ID_func serial PRIMARY KEY,
Cpf varchar(11),
Nome varchar(50),
Login varchar(11),
Senha varchar(50)NOT NULL, 
Endereco varchar(80),   
Cargo varchar(30));
 
CREATE TABLE ex_funcionarios (
ID_func serial PRIMARY KEY,
Cpf varchar(11),
Nome varchar(50),
Login varchar(11),
Senha varchar(50)NOT NULL, 
Endereco varchar(80),   
Cargo varchar(30),
data_demissao date);
 
CREATE TABLE Alugueis (
CPF_cliente varchar(11) NOT NULL,
Nome_produto varchar(50),
Qtd_alugada int NOT NULL,
Data_emprestimo date DEFAULT '0001/01/01',
Data_devolucao date DEFAULT '0001/01/01',
Valor_total float NOT NULL,
FOREIGN KEY (CPF_cliente) REFERENCES Clientes (CPF));
 
INSERT INTO Clientes VALUES 
('61195247460', 'Jonas Lustosa Cabeça', '59625-630 Rua Santa Cecília | Pintos'),
('92178388450', 'Rafaella Bessa Noronha', '59615-390 Rua Romeu Leite Rebouças | Santa Delmira'),
('30537100482', 'Taís Calado Condorcet', '59612-570 Rua Joaquim Pereira Pinto | Abolição'),
('14952439402', 'Lourenço Borges Orriça', '59626-000 Avenida Manuel Nascimento Duarte | Rincão'),
('91052823491', 'Adonai Correia Gameiro', '59619-200 Rua Delfim Moreira | Abolição'),
('57488606434', 'Leandro Moura Peseiro', '59616-190 Rua Santa Lúcia | Santa Delmira'),
('99272832454', 'Alcino Sales Proença', '59607-003 Rua Manoel Aires Lima | Aeroporto'),
('74890967400', 'Aliya Gago Raminhos', '59618-680 Rua Nilo Peçanha | Bom Jardim'),
('97393679418', 'Cláudia Remígio Café', '59607-003 Rua Manoel Aires Lima | Aeroporto'),
('73785193408', 'Jénifer Barrela Prates', '59618-555 Rua Auta de Souza | Bom Jardim'),
('16236065438', 'Emília Carreiro Alvim', '59600-160 Avenida Cunha da Mota | Centro'),
('79087211414', 'Cédric Fragoso Pimentel', '59604-167 Vila de Quinho | Lagoa do Mato'),
('86318124470', 'Mel Ribas Pessoa', '59614-820 Rua São Pedro | Santa Delmira'),
('25909004492', 'Francisco Lalanda Leitão', '59631-151 Rua José Neves | Alto de São Manoel'),
('39802660442', 'Rayssa Bencatel Mamouros', '59621-454 Rua Missionário José Luiz de Queiroz | Barrocas'),
('76406157478', 'Sandra Flávio Fidalgo', '59618-656 Rua Seu Lima | Bom Jardim'),
('18543288401', 'Elisabeth Tuna Rolim', '59600-012 Travessa Mossoroense | Centro'),
('76214619422', 'Natalia Moreira Patrício', '59612-455 Rua Filemon Pimenta | Abolição'),
('45436087477', 'Abraão Girão Bonilha', '59633-835 Rua Sebastião Cândido de França | Alto do Sumaré'),
('29849547421', 'Letizia Quintela Arantes', '59604-274 Vila de Francisco Alves | Lagoa do Mato');
 
INSERT INTO Livros VALUES 
(DEFAULT, 'As seis lições', 'Politica/Economia', '1979', '10', '22', '35'),
(DEFAULT, 'A teoria geral do emprego, do juro e da moeda', 'Política/Economia', '1936', '20', '12', '50'),
(DEFAULT, 'O capital', 'Política/Economia', '1867', '30', '40', '50'),
(DEFAULT, 'Ação humana: um tratado sobre economia', 'Política/Economia', '1949', '40', '10','35'),
(DEFAULT, 'O caminho da servidão', 'Politica/Economia', '1944', '50', '20', '50'),
(DEFAULT, 'O que o governo fez com o nosso dinheiro?', 'Política/Economia', '1963', '60', '10', '50'),
(DEFAULT, 'A anatomia do estado', 'Política/Economia', '1963', '70', '15', '50'),
(DEFAULT, 'Homem economia e estado', 'Política/Economia', '1970', '80', '10', '70'),
(DEFAULT, 'Democracia, o deus que falhou', 'Politica/Economia', '1989', '90', '20', '50');
 
INSERT INTO Discos VALUES 
(DEFAULT, 'Revolver', 'Rock/Country', 'Beatles', '10', '100'),
(DEFAULT, 'Abbey road', 'Rock/Country', 'Beatels', '20', '100'),
(DEFAULT, 'News of the world', 'Rock', 'Queen', '20', '50'),
(DEFAULT, 'Hot space', 'Rock', 'Queen', '15', '50'),
(DEFAULT, 'A kindo of magic', 'Rock', 'Queen', '10', '50'),
(DEFAULT, 'Trhiller', 'Pop', 'Michael Jackson', '5', '70'),
(DEFAULT, 'Bad', 'Pop', 'Michael Jackson', '5', '70'),
(DEFAULT, 'Calêndula requiem', 'Rock/Clássica', 'The hanged man', '30', '25'),
(DEFAULT, 'Penstemon Lorem', 'Rock/Clássica', 'The hanged man', '25', '25');
 
INSERT INTO Funcionarios VALUES
(DEFAULT,'22345699910', 'Emmanuel Castro Ferreira','Recep01', '102030', '59620-395 Rua Francisco Gomes Monteiro | Redenção', 'Recepcionista'),
(DEFAULT,'12987691800', 'Daria Lamego Simas', 'Recep02', '030498', '59616-671 Rua Prefeito José Hermínio | Santa Delmira', 'Recepcionista'),
(DEFAULT,'33342190111', 'Jamie Orriça Sardo', 'Aux01', '201806', '59612-410 Rua Ben-Hur Queiroz | Abolição', 'Auxiliar de estoque'),
(DEFAULT,'10090012344', 'Taynara Travassos Prudente', 'Sup01', '003128', '59604-290 Rua Capitão Luiz Firmino | Lagoa do Mato', 'Supervisor');
 
INSERT INTO Alugueis (CPF_cliente, Nome_produto, Qtd_alugada, Data_emprestimo, Valor_total) VALUES 
('61195247460', 'A teoria geral do emprego, do juro e da moeda', '2', '2020/11/12', 100),
('92178388450', 'O capital', '1', '2020/11/10', 20),
('14952439402', 'As seis lições', '5', '2020/11/12', 50),
('99272832454', 'Abbey road', '1', '2020/11/05', 10),
('25909004492', 'Homem economia e estado', '2', '2020/10/30', 20),
('25909004492', 'Trhiller', '1', '2020/10/29', 15);
 
CREATE VIEW relatorio as (SELECT data_emprestimo, valor_total FROM alugueis);

CREATE FUNCTION valor_total(date, date)
RETURNS float
AS 'SELECT SUM(valor_total) AS valor_total FROM relatorio WHERE data_emprestimo >= $1 AND data_emprestimo <= $2;'
LANGUAGE 'sql';

CREATE FUNCTION qtd_alugado(date, date)
RETURNS int
AS 'SELECT COUNT(*) AS qtd_alugado FROM relatorio WHERE data_emprestimo >= $1 AND data_emprestimo <= $2;'
LANGUAGE 'sql';

CREATE TABLE log_operacoes(
operacao varchar(6),
tabela varchar(20),
Data_operacao date);
 
CREATE FUNCTION func_log_clientes() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_operacoes (operacao, tabela, Data_operacao)
                VALUES (TG_OP, 'Clientes', now());
    RETURN NEW;
END;
 
$$ LANGUaGE 'plpgsql';
 
CREATE TRIGGER log_clientes 
AFTER INSERT OR UPDATE OR DELETE ON Clientes
FOR EACH ROW EXECuTE PROCEDURE func_log_clientes();
 
 
CREATE FUNCTION func_log_funcionarios() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_operacoes (operacao, tabela, Data_operacao)
                VALUES (TG_OP, 'funcionarios', now());
    RETURN NEW;
END;
 
$$ LANGUaGE 'plpgsql';
 
CREATE TRIGGER log_Funcionarios
AFTER INSERT OR UPDATE OR DELETE ON Funcionarios
FOR EACH ROW EXECuTE PROCEDURE func_log_funcionarios();
 
 
CREATE FUNCTION func_log_livros() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_operacoes (operacao, tabela, Data_operacao)
                VALUES (TG_OP, 'livros', now());
    RETURN NEW;
END;
 
$$ LANGUaGE 'plpgsql';
 
CREATE TRIGGER log_livros
AFTER INSERT OR UPDATE OR DELETE ON Livros
FOR EACH ROW EXECuTE PROCEDURE func_log_livros();
 
 
CREATE FUNCTION func_log_discos() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_operacoes (operacao, tabela, Data_operacao)
                VALUES (TG_OP, 'discos', now());
    RETURN NEW;
END;
$$ LANGUaGE 'plpgsql';
 
CREATE TRIGGER log_discos
AFTER INSERT OR UPDATE OR DELETE ON Discos
FOR EACH ROW EXECuTE PROCEDURE func_log_Discos();
 
 
CREATE FUNCTION func_log_Alugueis() RETURNS TRIGGER AS $$
BEGIN
    INSERT INTO log_operacoes (operacao, tabela, Data_operacao)
                VALUES (TG_OP, 'Alugueis', now());
    RETURN NEW;
END;
$$ LANGUaGE 'plpgsql';
 
CREATE TRIGGER log_alugueis
AFTER INSERT OR UPDATE OR DELETE ON Alugueis
FOR EACH ROW EXECuTE PROCEDURE func_log_alugueis();
 
CREATE OR REPLACE RULE r1 AS 
ON DELETE TO funcionarios
DO INSERT INTO ex_funcionarios VALUES (OLD.id_func, OLD.cpf, OLD.nome, OLD.login, OLD.senha, OLD.endereco, OLD.Cargo, now());
