package fatec.poo.control;

import fatec.poo.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Lucas
 */
public class DaoProduto {
    
    private Connection conn;
    
    public DaoProduto(Connection conn) {
         this.conn = conn;
    }
    
    public void inserir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO JavaProduto(codigo,descricao,qtdeEstoque,unidadeMedida,preco,estoqueMinimo) VALUES(?,?,?,?,?,?)");
            ps.setString(1,produto.getCodigo());
            ps.setString(2,produto.getDescricao());
            ps.setDouble(3,produto.getQtdeEstoque());
            ps.setString(4,produto.getUnidadeMedida());
            ps.setDouble(5,produto.getPreco());
            ps.setDouble(6,produto.getEstoqueMinimo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
    public void alterar(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("UPDATE JavaProduto set descricao = ?,qtdeEstoque = ?,unidadeMedida = ?,preco = ?,estoqueMinimo = ? " +
                                        "where codigo = ?");

            ps.setString(1,produto.getDescricao());
            ps.setDouble(2,produto.getQtdeEstoque());
            ps.setString(3,produto.getUnidadeMedida());
            ps.setDouble(4,produto.getPreco());
            ps.setDouble(5,produto.getEstoqueMinimo());
            ps.setString(6,produto.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
    
     public void excluir(Produto produto) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("DELETE FROM JavaProduto where codigo = ?");
            
            ps.setString(1, produto.getCodigo());
                      
            ps.execute();
        } catch (SQLException ex) {
             System.out.println(ex.toString());   
        }
    }
     
     public  Produto consultar (String codigo) {
        Produto p = null;
       
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT * from JavaProduto where " +
                                                 "codigo = ?");
            
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
           
            if (rs.next()) { //(rs.next() == true) forma redundante de fazer
                p = new Produto (codigo, rs.getString("descricao"));
                p.setQtdeEstoque(rs.getDouble("qtdeEstoque"));
                p.setUnidadeMedida(rs.getString("unidadeMedida"));
                p.setPreco(rs.getDouble("preco"));
                p.setEstoqueMinimo(rs.getDouble("estoqueMinimo"));
   
            }
        }
        catch (SQLException ex) { 
             System.out.println(ex.toString());   
        }
        return (p);
    } 
    
}
