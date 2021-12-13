package dao;


import conection.ConexaoMySQL;
import model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {
    public void create(Produto produto){
        Connection connection = ConexaoMySQL.iniciarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT INTO produto (nome, preco, quantidadeEstoque) VALUES(?, ?, ?)");

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidadeEstoque());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySQL.encerrarConexao(connection, stmt);
        }
    }

    public ArrayList<Produto> read(){
        Connection connection = ConexaoMySQL.iniciarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM produto");
            rs = stmt.executeQuery();

            while (rs.next()){
                Produto prod = new Produto();
                prod.setId(rs.getInt("id"));
                prod.setNome(rs.getString("nome"));
                prod.setPreco(rs.getDouble("preco"));
                prod.setQuantidadeEstoque(rs.getInt("quantidadeEstoque"));
                listaProdutos.add(prod);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySQL.encerrarConexao(connection, stmt);
        }
        return listaProdutos;
    }

    public void update(Produto produto){
        Connection connection = ConexaoMySQL.iniciarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("UPDATE  produto SET nome = ?, preco = ?, quantidadeEstoque = ? WHERE id = ?");
            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidadeEstoque());
            stmt.setInt(4, produto.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySQL.encerrarConexao(connection, stmt);
        }

    }

    public void delete(Produto produto){
        Connection connection = ConexaoMySQL.iniciarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE from produto WHERE id = ?");
            stmt.setInt(1, produto.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySQL.encerrarConexao(connection, stmt);
        }
    }

}
