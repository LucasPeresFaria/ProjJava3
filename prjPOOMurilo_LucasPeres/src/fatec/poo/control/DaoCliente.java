package fatec.poo.control;

import fatec.poo.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Lucas
 */
public class DaoCliente {
    private Connection conn;
    
    public DaoCliente(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO JavaCliente(cpfCliente, nome, endereco, cidade, uf, cep, ddd, telefone, limiteCred) VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getEndereco());
            ps.setString(4, cliente.getCidade());
            ps.setString(5, cliente.getUF());
            ps.setString(6, cliente.getCEP());
            ps.setString(7, cliente.getDDD());
            ps.setString(8, cliente.getTelefone());
            ps.setDouble(9, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("JavaCliente pooCliente set nome = ?, endereco = ?, cidade = ?, uf = ?, cep = ?, ddd = ?, telefone = ?, limiteCred = ?, limiteDisp = ?" +
                                                 "where cpfCliente = ?");
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.setString(3, cliente.getCidade());
            ps.setString(4, cliente.getUF());
            ps.setString(5, cliente.getCEP());
            ps.setString(6, cliente.getDDD());
            ps.setString(7, cliente.getTelefone());
            ps.setDouble(8, cliente.getLimiteCred());
            ps.setDouble(9, cliente.getLimiteDisp());
            ps.setString(10, cliente.getCpf());
           
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
        
     public  Cliente consultar (String cpf) {
        Cliente c = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from JavaCliente where " +
                                                 "cpfCliente = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) {
                c = new Cliente(cpf, rs.getString("nome"), rs.getDouble("limiteCred"));
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setUF(rs.getString("uf"));
                c.setCEP(rs.getString("cep"));
                c.setDDD(rs.getString("ddd"));
                c.setTelefone(rs.getString("telefone"));
                c.setLimiteDisp(rs.getDouble("limiteDisp"));
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (c);
    }    
     
     public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM pooCliente where cpf = ?");
            
            ps.setString(1, cliente.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
}
