package main.dao;

import main.model.Roupa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoupaDAO {

    ProdutoBaseDAO pdao = new ProdutoBaseDAO();

    public void inserir(Roupa r) throws SQLException {
        int id = pdao.inserir(r);
        r.setId(id);

        String sql = "INSERT INTO roupa (id_roupa, cor, tamanho, genero, material, lavavel_na_maquina) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, r.getCor());
            stmt.setString(3, r.getTamanho());
            stmt.setString(4, r.getGenero());
            stmt.setString(5, r.getMaterial());
            stmt.setBoolean(6, r.isLavavelNaMaquina());
            stmt.executeUpdate();
        }
    }

    public Roupa buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM produto_base pb "
                + "INNER JOIN roupa r ON pb.id_prod = r.id_roupa "
                + "WHERE pb.id_prod=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Roupa(
                        rs.getInt("id_prod"),
                        rs.getString("nome"),
                        rs.getString("cor"),
                        rs.getString("tamanho"),
                        rs.getString("genero"),
                        rs.getString("marca"),
                        rs.getString("material"),
                        rs.getBoolean("lavavel_na_maquina"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                );
            }
        }
        return null;
    }

    public List<Roupa> listarTodos() throws SQLException {
        List<Roupa> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto_base pb "
                + "INNER JOIN roupa r ON pb.id_prod = r.id_roupa";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Roupa(
                        rs.getInt("id_prod"),
                        rs.getString("nome"),
                        rs.getString("cor"),
                        rs.getString("tamanho"),
                        rs.getString("genero"),
                        rs.getString("marca"),
                        rs.getString("material"),
                        rs.getBoolean("lavavel_na_maquina"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                ));
            }
        }

        return lista;
    }

    public void atualizar(Roupa r) throws SQLException {
        String sql1 = "UPDATE produto_base SET nome=?, marca=?, quantidade=?, preco=? WHERE id_prod=?";
        String sql2 = "UPDATE roupa SET cor=?, tamanho=?, genero=?, material=?, lavavel_na_maquina=? "
                + "WHERE id_roupa=?";

        try (Connection conn = Conexao.getConnection()) {

            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, r.getNome());
            stmt1.setString(2, r.getMarca());
            stmt1.setInt(3, r.getQuantidade());
            stmt1.setDouble(4, r.getPreco());
            stmt1.setInt(5, r.getId());
            stmt1.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, r.getCor());
            stmt2.setString(2, r.getTamanho());
            stmt2.setString(3, r.getGenero());
            stmt2.setString(4, r.getMaterial());
            stmt2.setBoolean(5, r.isLavavelNaMaquina());
            stmt2.setInt(6, r.getId());
            stmt2.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        pdao.remover(id);
    }
}
