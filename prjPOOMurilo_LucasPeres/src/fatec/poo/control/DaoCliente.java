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
            ps = conn.prepareStatement("INSERT INTO Cliente(cpfCliente,nome,endereco,cidade,uf,cep,ddd,telefone,limiteCred,limiteDisp) VALUES(?,?,?,?)");
            ps.setString(1,cliente.getCpf());
            ps.setString(2,cliente.getNome());
            ps.setString(3,cliente.getEndereco());
            ps.setString(4,cliente.getCidade());
            ps.setString(5,cliente.getUf());
            ps.setString(6,cliente.getCep());
            ps.setString(7,cliente.getDdd());
            ps.setString(8,cliente.getTelefone());
            ps.setDouble(9,cliente.getLimiteCred());
            ps.setDouble(10,cliente.getLimiteDisp());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE Cliente set nome = ?,endereco = ?,cidade = ?,uf = ?,cep = ?,ddd = ?,telefone = ?,limiteCred = ?,limiteDisp = ? " +
                                        "where cpfCliente = ?");

            ps.setString(2,cliente.getNome());
            ps.setString(3,cliente.getEndereco());
            ps.setString(4,cliente.getCidade());
            ps.setString(5,cliente.getUf());
            ps.setString(6,cliente.getCep());
            ps.setString(7,cliente.getDdd());
            ps.setString(8,cliente.getTelefone());
            ps.setDouble(9,cliente.getLimiteCred());
            ps.setDouble(10,cliente.getLimiteDisp());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
     public void excluir(Cliente cliente) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM Cliente where cpfCliente = ?");
            
            ps.setString(1, cliente.getCpf());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
     
     public  Cliente consultar (String cpf) {
        Cliente c = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from Cliente where " +
                                                 "Codigo_Proj = ?");
            
            ps.setString(1, cpf);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) { //(rs.next() == true) forma redundante de fazer
                c = new Cliente (cpf, rs.getString("nome"),rs.getDouble("limiteCred"));
                c.setEndereco(rs.getString("endereco"));
                c.setCidade(rs.getString("cidade"));
                c.setUf(rs.getString("uf"));
                c.setCep(rs.getString("cep"));
                c.setDdd(rs.getString("ddd"));
                c.setTelefone(rs.getString("telefone"));
                c.setLimiteDisp(rs.getDouble("limiteDisp"));
   
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (c);
    } 
    
    
    
}
