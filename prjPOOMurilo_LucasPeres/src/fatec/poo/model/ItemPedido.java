package fatec.poo.model;
/**
 * @author 0030481711036
 * @author 0030481721015
 */
public class ItemPedido {

    private int sequencia;
    private double qtdeVendida;
    private Produto produtos;
    private Pedido pedidos;

    public ItemPedido(int sequencia, double qtdeVendida,Produto produtos) {
        this.sequencia = sequencia;
        this.qtdeVendida = qtdeVendida;
        this.produtos = produtos;
    }

    public int getSequencia() {
        return sequencia;
    }
    
    public double getQtdeVendida() {
        return qtdeVendida;
    }

    /*-------------Relacionamento de classe------------------*/
    
     public void setPedido(Pedido pedido){
        this.pedidos = pedido;
    } 
     
    /*----------------Métodos operacionais-------------------*/
   
    public void setQtdeVendida(double qtdeVendida) {
          produtos.setQtdeEstoque(produtos.getQtdeEstoque() - qtdeVendida);
    }
    
    public void listarproduto(){
        System.out.println("\nQuantidade pedida: " + qtdeVendida);
        System.out.println("Estoque disponivel: " + produtos.getQtdeEstoque());  
    }
    
    public double CalcPedido(){
        return qtdeVendida * produtos.getPreco();
    }
}
