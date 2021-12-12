package dao;

import conection.ConexaoMySQL;
import model.Venda;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class VendaDAO {
         public void create(Venda venda){
            Connection connection = ConexaoMySQL.iniciarConexao();
            PreparedStatement stmt = null;
            try {
                stmt = connection.prepareStatement("INSERT INTO venda (vlrTotal) VALUES(?)");
                stmt.setFloat(1, venda.getVlrTotal());

                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoMySQL.encerrarConexao(connection, stmt);
            }
        }

        public ArrayList<Venda> read(){
            Connection connection = ConexaoMySQL.iniciarConexao();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            ArrayList<Venda> listaVenda = new ArrayList<>();
            try {
                stmt = connection.prepareStatement("SELECT * FROM venda");
                rs = stmt.executeQuery();

                while (rs.next()){
                    Venda vend = new Venda();
                    vend.setId(rs.getInt("id"));
                    vend.setVlrTotal(rs.getInt("vlrVenda"));
                    listaVenda.add(vend);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoMySQL.encerrarConexao(connection, stmt);
            }
            return listaVenda;
        }

        public void update(Venda venda){
            Connection connection = ConexaoMySQL.iniciarConexao();
            PreparedStatement stmt = null;
            try {
                stmt = connection.prepareStatement("UPDATE  venda SET vlrVenda = ? WHERE id = ?");
                stmt.setFloat(1, venda.getVlrTotal());
                stmt.setInt(2, venda.getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoMySQL.encerrarConexao(connection, stmt);
            }

        }

        public void delete(Venda venda){
            Connection connection = ConexaoMySQL.iniciarConexao();
            PreparedStatement stmt = null;
            try {
                stmt = connection.prepareStatement("DELETE from venda WHERE id = ?");
                stmt.setInt(1, venda.getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                ConexaoMySQL.encerrarConexao(connection, stmt);
            }
        }
}
