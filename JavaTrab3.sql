 create table Produto
 ( codigo number (5) not null,
   descricao varchar2(60) not null,
   qtdeEstoque number(5,2) not null,
   unidadeMedida varchar2(10) not null,
   preco number(10,2) not null,
   estoqueMinimo number(5,2) not null,
   constraint pk_codigo primary key(codigo));
  
  create table ItemPedido
  ( sequencia number (5) not null,
    qtdeVendida number (5,2) not null,
    numero varchar2(10) not null,
    codigo number (5) not null);
                
   create table Pedidos
   ( numero varchar2(10) not null,
     cpfCliente varchar2(11) not null,
     cpfVendedor varchar2(11) not null,
     dataEmissao varchar2(10) not null,
     dataPagto varchar2(10) not null,
     formaPagto number(1) not null, 
     situacao number(1) not null,
     constraint pk_numero primary key (numero));
     
   create table Cliente
   ( cpfCliente varchar2(11) not null,
     nome varchar2(50) not null,
     endereco varchar2(50) not null,
     cidade varchar2(28) not null,
     uf varchar2(2) not null,
     cep varchar2(8) not null,
     ddd varchar2(3) not null,
     telefone varchar(9) not null,
     limiteCred number(7,2) not null,
     limiteDisp number(7,2) not null,
     constraint pk_cpfCliente primary key(cpfCliente));

    create table Vendedor
   ( cpfVendedor varchar2(11) not null,
     nome varchar2(50) not null,
     endereco varchar2(50) not null,
     cidade varchar2(28) not null,
     uf varchar2(2) not null,
     cep varchar2(8) not null,
     ddd varchar2(3) not null,
     telefone varchar(9) not null,
     salarioBase number(6,2) not null,
     TaxaComissao number(5,2) not null,
     constraint pk_cpfVendedor primary key(cpfVendedor));
     
     
    alter table ItemPedido
    add (foreign key(codigo) references Produto);
    alter table ItemPedido
    add (foreign key(numero) references Pedidos);
    alter table ItemPedido
    add constraint chave_composta_ItemPedido primary key (codigo, numero);

     alter table pedidos
     add constraint fk_cpf_cliente foreign key (cpfCliente) references Cliente(cpfCliente);
     alter table pedidos
     add constraint fk_cpf_vendedor foreign key (cpfVendedor) references Vendedor(cpfVendedor);   
   
     
     