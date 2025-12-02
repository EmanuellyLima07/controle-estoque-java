package main.dao;

import main.model.Perecivel;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerecivelDAO {

    ProdutoBaseDAO pdao = new ProdutoBaseDAO();

    public void inserir(Perecivel p) throws SQLException {
        int id = pdao.inserir(p);
        p.setId(id);

        String sql = "INSERT INTO perecivel (id_pr, categoria, embalagem, origem, dt_fabricacao, dt_validade) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, p.getCategoria());
            stmt.setString(3, p.getEmbalagem());
            stmt.setString(4, p.getOrigem());
            stmt.setDate(5, Date.valueOf(p.getDtFabricacao()));
            stmt.setDate(6, Date.valueOf(p.getDtValidade()));
            stmt.executeUpdate();
        }
    }

    public Perecivel buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM produto_base pb "
                + "INNER JOIN perecivel p ON pb.id_prod = p.id_pr "
                + "WHERE pb.id_prod=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Perecivel pe = new Perecivel(
                        rs.getInt("id_prod"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("categoria"),
                        rs.getString("embalagem"),
                        rs.getString("origem"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getDate("dt_fabricacao").toLocalDate(),
                        rs.getDate("dt_validade").toLocalDate()
                );
                return pe;
            }
        }
        return null;
    }

    public List<Perecivel> listarTodos() throws SQLException {
        List<Perecivel> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto_base pb "
                + "INNER JOIN perecivel p ON pb.id_prod = p.id_pr";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Perecivel(
                        rs.getInt("id_prod"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("categoria"),
                        rs.getString("embalagem"),
                        rs.getString("origem"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getDate("dt_fabricacao").toLocalDate(),
                        rs.getDate("dt_validade").toLocalDate()
                ));
            }
        }

        return lista;
    }

    public void atualizar(Perecivel p) throws SQLException {
        String sql1 = "UPDATE produto_base SET nome=?, marca=?, quantidade=?, preco=? WHERE id_prod=?";

        String sql2 = "UPDATE perecivel SET categoria=?, embalagem=?, origem=?, dt_fabricacao=?, dt_validade=? "
                + "WHERE id_pr=?";

        try (Connection conn = Conexao.getConnection()) {

            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, p.getNome());
            stmt1.setString(2, p.getMarca());
            stmt1.setInt(3, p.getQuantidade());
            stmt1.setDouble(4, p.getPreco());
            stmt1.setInt(5, p.getId());
            stmt1.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, p.getCategoria());
            stmt2.setString(2, p.getEmbalagem());
            stmt2.setString(3, p.getOrigem());
            stmt2.setDate(4, Date.valueOf(p.getDtFabricacao()));
            stmt2.setDate(5, Date.valueOf(p.getDtValidade()));
            stmt2.setInt(6, p.getId());
            stmt2.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        pdao.remover(id);
    }
}
