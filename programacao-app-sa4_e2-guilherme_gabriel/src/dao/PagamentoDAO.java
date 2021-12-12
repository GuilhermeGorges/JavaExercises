package dao;

import conection.ConexaoMySQL;
import model.Pagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PagamentoDAO {
    public void create(Pagamento pagamento){
        Connection connection = ConexaoMySQL.iniciarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT INTO pagamento (tipoPagamento) VALUES(?)");

            stmt.setInt(1, pagamento.getTipoPagamento());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySQL.encerrarConexao(connection, stmt);
        }
    }

    public ArrayList<Pagamento> read(){
        Connection connection = ConexaoMySQL.iniciarConexao();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Pagamento> listaPagamentos = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM pagamento");
            rs = stmt.executeQuery();

            while (rs.next()){
                Pagamento pag = new Pagamento();
                pag.setId(rs.getInt("id"));
                pag.setTipoPagamento(rs.getInt("tipoPagamento"));
                listaPagamentos.add(pag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySQL.encerrarConexao(connection, stmt);
        }
        return listaPagamentos;
    }

    public void update(Pagamento pagamento){
        Connection connection = ConexaoMySQL.iniciarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("UPDATE  pagamento SET tipoPagamento = ? WHERE id = ?");
            stmt.setInt(1, pagamento.getTipoPagamento());
            stmt.setInt(2, pagamento.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySQL.encerrarConexao(connection, stmt);
        }

    }

    public void delete(Pagamento pagamento){
        Connection connection = ConexaoMySQL.iniciarConexao();
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("DELETE from pagamento WHERE id = ?");
            stmt.setInt(1, pagamento.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoMySQL.encerrarConexao(connection, stmt);
        }
    }
}
