package fatec.poo.control;

import fatec.poo.model.Vendedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Lucas
 */
public class DaoVendedor {
    
    private Connection conn;
    
    public DaoVendedor(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Vendedor(cpfVendedor,nome,endereco,cidade,uf,cep,ddd,telefone,salarioBase,TaxaComissao) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1,vendedor.getCpf());
            ps.setString(2,vendedor.getNome());
            ps.setString(3,vendedor.getEndereco());
            ps.setString(4,vendedor.getCidade());
            ps.setString(5,vendedor.getUf());
            ps.setString(6,vendedor.getCep());
            ps.setString(7,vendedor.getDdd());
            ps.setString(8,vendedor.getTelefone());
            ps.setDouble(9,vendedor.getSalarioBase());
            ps.setDouble(10,vendedor.getTaxaComissao());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Vendedor set nome = ?,endereco = ?,cidade = ?,uf = ?,cep = ?,ddd = ?,telefone = ?,salarioBase = ?,TaxaComissao = ? " +
                                        "where cpfVendedor = ?");

            ps.setString(2,vendedor.getNome());
            ps.setString(3,vendedor.getEndereco());
            ps.setString(4,vendedor.getCidade());
            ps.setString(5,vendedor.getUf());
            ps.setString(6,vendedor.getCep());
            ps.setString(7,vendedor.getDdd());
            ps.setString(8,vendedor.getTelefone());
            ps.setDouble(9,vendedor.getSalarioBase());
            ps.setDouble(10,vendedor.getTaxaComissao());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
     public void excluir(Vendedor vendedor) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Cliente where cpfVendedor = ?");
            
            ps.setString(1, vendedor.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
     
     public  Vendedor consultar (String cpf) {
        Vendedor v = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from Vendedor where " +
                                                 "cpfVendedor = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) { //(rs.next() == true) forma redundante de fazer
                v = new Vendedor (cpf, rs.getString("nome"),rs.getDouble("salarioBase"));
                v.setEndereco(rs.getString("endereco"));
                v.setCidade(rs.getString("cidade"));
                v.setUf(rs.getString("uf"));
                v.setCep(rs.getString("cep"));
                v.setDdd(rs.getString("ddd"));
                v.setTelefone(rs.getString("telefone"));
                v.setTaxaComissao(rs.getDouble("TaxaComissao"));
   
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (v);
    } 
    
}
