package fatec.poo.model;
import java.util.ArrayList;

/**
 * @author 0030481711036
 * @author 0030481721015
 */
public class Vendedor extends Pessoa{
    private double salarioBase, taxaComissao;
    ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public Vendedor(String cpf, String nome, double salarioBase) {
        super(cpf,nome);
        this.salarioBase = salarioBase;
        pedidos = new ArrayList<Pedido>();
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }
    
    /*----------------Métodos operacionais-------------------*/
  
    public void addPedido(Pedido P){
        pedidos.add(P);
        P.setVendedor(this);
    }
    
}
