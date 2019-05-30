package fatec.poo.model;
import java.util.ArrayList;

/**
 * @author 0030481711036
 * @author 0030481721015
 */
public class Pedido {
    private String numero, dataEmissao,dataPagto;
    private boolean formaPagto, situacao;
    private Vendedor vendedor;
    private Cliente cliente;
    private Produto produto;
    ArrayList<ItemPedido> itens = new ArrayList<ItemPedido>();

    public Pedido(String numero, String dataEmissao) {
        this.numero = numero;
        this.dataEmissao = dataEmissao;
        itens = new ArrayList<ItemPedido>();
    }

    /*--------------Métodos GET & SET-----------------------*/
    
    public String getNumero() {
        return numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public String getDataPagto() {
        return dataPagto;
    }

    public void setDataPagto(String dataPagto) {
        this.dataPagto = dataPagto;
    }

    public boolean getFormaPagto() {
        return formaPagto;
    }

    public void setFormaPagto(boolean formaPagto) {
        this.formaPagto = formaPagto;
    }

    public boolean getSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }
    
    /*-------------Relacionamento de classe------------------*/
    
    public void setVendedor(Vendedor vendedor){
        this.vendedor = vendedor;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    /*---------------Metodos operacionais-------------------*/
    
    public void addItemPedido(ItemPedido item){
        itens.add(item);
        item.setPedido(this);
        
        if(formaPagto == true){
            cliente.setLimiteDisp(item.CalcPedido());
        }
    }  
    
    /*Teste*/
    
    public void listar(){
        System.out.println("\nNome cliente: " + cliente.getNome());
        System.out.println("Limite de credito cliente: " + cliente.getLimiteCred());
        System.out.println("Limite de credito  atual do cliente: " + cliente.getLimiteDisp());
        System.out.println("Qtde de pedidos: " + itens.size());
      
        for(int x=0; x < itens.size(); x++){
            System.out.print("Qtde Vendida: " + itens.get(x).getQtdeVendida() + "\t\t\n\n");
    }
        
    }
}
