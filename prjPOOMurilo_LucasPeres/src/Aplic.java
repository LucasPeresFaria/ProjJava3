import fatec.poo.model.Cliente;
import fatec.poo.model.ItemPedido;
import fatec.poo.model.Pedido;
import fatec.poo.model.Produto;
import fatec.poo.model.Vendedor;

/**
 * @author 0030481711036
 * @author 0030481721015
 */
public class Aplic {
    public static void main(String[] args) {
        
        Cliente cliente1 = new Cliente("52.876.544-9","Fernando Henrique",1000.00);
        Cliente cliente2 = new Cliente("71.586.324-2","Ricardo Ferreira", 700.00);
        Cliente cliente3 = new Cliente("35.565.658-4","Anna Paula", 1200.00);
        
        Vendedor Vendedor1 = new Vendedor("58.565.215-8","Fabiano Silva",1100.00);
        Vendedor Vendedor2 = new Vendedor("44.772.368-1","Carlos Henrique",1300.00);
        Vendedor Vendedor3 = new Vendedor("25.654.654-2","Pedro Farias",1230.00);
        
        Produto produto1 = new Produto("001","Televisor 25p | Samsung");
        produto1.setQtdeEstoque(10);
        produto1.setPreco(800);
        
        Produto produto2 = new Produto("002","Smartphone Galaxy S10 | Samsung");      
        Produto produto3 = new Produto("003","Playtation 4 | Sony");
             
        Pedido pedido1 = new Pedido("0184","29/04/2019");
        pedido1.setFormaPagto(true);
        
        ItemPedido itemP1 = new ItemPedido(00001,1,produto1);
        itemP1.setQtdeVendida(1); //necessita digitar o quantidade novamente
          
        cliente1.addPedido(pedido1);
        Vendedor1.addPedido(pedido1);
        pedido1.addItemPedido(itemP1);
   
        pedido1.listar();
        itemP1.listarproduto();   
    }
}