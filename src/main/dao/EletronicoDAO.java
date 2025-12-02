package main.dao;

import main.model.Eletronico;
import main.model.ProdutoBase;
import main.model.TipoProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EletronicoDAO {

    ProdutoBaseDAO pdao = new ProdutoBaseDAO();

    public void inserir(Eletronico e) throws SQLException {
        int id = pdao.inserir(e);
        e.setId(id);

        String sql = "INSERT INTO eletronico (id_eletro, modelo, garantiaMeses) VALUES (?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, e.getModelo());
            stmt.setInt(3, e.getGarantiaMeses());
            stmt.executeUpdate();
        }
    }

    public Eletronico buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM produto_base pb "
                + "INNER JOIN eletronico e ON pb.id_prod = e.id_eletro "
                + "WHERE pb.id_prod = ?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Eletronico ele = new Eletronico(
                        rs.getInt("id_prod"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("garantiaMeses"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                );
                return ele;
            }
        }
        return null;
    }

    public List<Eletronico> listarTodos() throws SQLException {
        List<Eletronico> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto_base pb "
                + "INNER JOIN eletronico e ON pb.id_prod = e.id_eletro";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Eletronico(
                        rs.getInt("id_prod"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("garantiaMeses"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                ));
            }
        }

        return lista;
    }

    public void atualizar(Eletronico e) throws SQLException {
        String sql1 = "UPDATE produto_base SET nome=?, marca=?, quantidade=?, preco=? WHERE id_prod=?";
        String sql2 = "UPDATE eletronico SET modelo=?, garantiaMeses=? WHERE id_eletro=?";

        try (Connection conn = Conexao.getConnection()) {

            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, e.getNome());
            stmt1.setString(2, e.getMarca());
            stmt1.setInt(3, e.getQuantidade());
            stmt1.setDouble(4, e.getPreco());
            stmt1.setInt(5, e.getId());
            stmt1.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, e.getModelo());
            stmt2.setInt(2, e.getGarantiaMeses());
            stmt2.setInt(3, e.getId());
            stmt2.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        pdao.remover(id);
    }
}
