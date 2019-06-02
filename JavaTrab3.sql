  create table JavaCliente
   ( cpfCliente varchar2(11) not null,
     nome varchar2(50) ,
     endereco varchar2(50) ,
     cidade varchar2(28) ,
     uf varchar2(2) ,
     cep varchar2(8) ,
     ddd varchar2(3) ,
     telefone varchar(9) ,
     limiteCred number(7,2) ,
     limiteDisp number(7,2) ,
     constraint pk_cpfCliente primary key(cpfCliente));

    create table JavaVendedor
   ( cpfVendedor varchar2(11) not null,
     nome varchar2(50) ,
     endereco varchar2(50) ,
     cidade varchar2(28) ,
     uf varchar2(2) ,
     cep varchar2(8) ,
     ddd varchar2(3) ,
     telefone varchar(9) ,
     salarioBase number(6,2) ,
     TaxaComissao number(5,2) ,
     constraint pk_cpfVendedor primary key(cpfVendedor));
 
	create table JavaProduto
	( codigo varchar(5) not null,
	descricao varchar2(60) ,
	qtdeEstoque number(5,2) ,
	unidadeMedida varchar2(10) ,
	preco number(10,2) ,
	estoqueMinimo number(5,2) ,
	constraint pk_codigo primary key(codigo));
 
	create table JavaItemPedido
    ( sequencia number (5) not null,
    qtdeVendida number (5,2) ,
    numero varchar2(10) ,
    codigo varchar2(5)) ;
 
    create table JavaPedido
   ( numero varchar2(10) not null,
     cpfCliente varchar2(11) ,
     cpfVendedor varchar2(11) ,
     dataEmissao varchar2(10) ,
     dataPagto varchar2(10) ,
     formaPagto number(1) , 
     situacao number(1) ,
     constraint pk_numero primary key (numero));
 
     alter table JavaItemPedido
     add constraint chave_composta_ItemPedido primary key (codigo, numero);

     alter table Javapedido
     add constraint fk_cpf_cliente foreign key (cpfCliente) references JavaCliente;
     alter table Javapedido
     add constraint fk_cpf_vendedor foreign key (cpfVendedor) references JavaVendedor;   
   
     
     