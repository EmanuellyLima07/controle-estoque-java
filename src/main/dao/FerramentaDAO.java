package main.dao;

import main.model.Ferramenta;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FerramentaDAO {

    ProdutoBaseDAO pdao = new ProdutoBaseDAO();

    public void inserir(Ferramenta f) throws SQLException {
        int id = pdao.inserir(f);
        f.setId(id);

        String sql = "INSERT INTO ferramenta (id_fer, tipo, categoria, material, peso, comprimento, eletrica, potencia) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setString(2, f.getTipo());
            stmt.setString(3, f.getCategoria());
            stmt.setString(4, f.getMaterial());
            stmt.setDouble(5, f.getPeso());
            stmt.setDouble(6, f.getComprimento());
            stmt.setBoolean(7, f.isEletrica());
            stmt.setInt(8, f.getPotencia());
            stmt.executeUpdate();
        }
    }

    public Ferramenta buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM produto_base pb "
                + "INNER JOIN ferramenta f ON pb.id_prod = f.id_fer "
                + "WHERE pb.id_prod=?";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Ferramenta(
                        rs.getInt("id_prod"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("tipo"),
                        rs.getBoolean("eletrica"),
                        rs.getInt("potencia"),
                        rs.getString("categoria"),
                        rs.getString("material"),
                        rs.getDouble("peso"),
                        rs.getDouble("comprimento"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                );
            }
        }
        return null;
    }

    public List<Ferramenta> listarTodos() throws SQLException {
        List<Ferramenta> lista = new ArrayList<>();

        String sql = "SELECT * FROM produto_base pb "
                + "INNER JOIN ferramenta f ON pb.id_prod = f.id_fer";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Ferramenta(
                        rs.getInt("id_prod"),
                        rs.getString("nome"),
                        rs.getString("marca"),
                        rs.getString("tipo"),
                        rs.getBoolean("eletrica"),
                        rs.getInt("potencia"),
                        rs.getString("categoria"),
                        rs.getString("material"),
                        rs.getDouble("peso"),
                        rs.getDouble("comprimento"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco")
                ));
            }
        }

        return lista;
    }

    public void atualizar(Ferramenta f) throws SQLException {
        String sql1 = "UPDATE produto_base SET nome=?, marca=?, quantidade=?, preco=? WHERE id_prod=?";
        String sql2 = "UPDATE ferramenta SET tipo=?, categoria=?, material=?, peso=?, comprimento=?, eletrica=?, potencia=? "
                + "WHERE id_fer=?";

        try (Connection conn = Conexao.getConnection()) {

            PreparedStatement stmt1 = conn.prepareStatement(sql1);
            stmt1.setString(1, f.getNome());
            stmt1.setString(2, f.getMarca());
            stmt1.setInt(3, f.getQuantidade());
            stmt1.setDouble(4, f.getPreco());
            stmt1.setInt(5, f.getId());
            stmt1.executeUpdate();

            PreparedStatement stmt2 = conn.prepareStatement(sql2);
            stmt2.setString(1, f.getTipo());
            stmt2.setString(2, f.getCategoria());
            stmt2.setString(3, f.getMaterial());
            stmt2.setDouble(4, f.getPeso());
            stmt2.setDouble(5, f.getComprimento());
            stmt2.setBoolean(6, f.isEletrica());
            stmt2.setInt(7, f.getPotencia());
            stmt2.setInt(8, f.getId());
            stmt2.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        pdao.remover(id);
    }
}
