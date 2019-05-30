package fatec.poo.model;
import java.util.ArrayList;

/**
 * @author 0030481711036
 * @author 0030481721015
 */
public class Cliente extends Pessoa{
   private double limiteCred;
   private double limiteDisp;
   private Pessoa pessoa;
    ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

    public Cliente(String cpf, String nome, double limiteCred) {
        super(cpf, nome);
        this.limiteCred = limiteCred;
        this.limiteDisp = limiteCred;
    }
    
    public double getLimiteCred() {
        return limiteCred;
    }

    public void setLimiteCred(double limiteCred) {
        this.limiteCred = limiteCred;
        
    }
    public double getLimiteDisp() {
        return limiteDisp;
    }
    
    public void setLimiteDisp(double limiteDisp) {
        this.limiteDisp -= limiteDisp;
    }
        
    
    
    /*----------------Métodos operacionais-------------------*/
  
    public void addPedido(Pedido P){
        pedidos.add(P);
        P.setCliente(this);
    }
 
  
}
