package main.dao;

import main.model.ProdutoBase;
import main.model.TipoProduto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoBaseDAO {

    public int inserir(ProdutoBase p) throws SQLException {
        String sql = "INSERT INTO produto_base (nome, marca, quantidade, preco, data_cadastro, tipo_produto) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getMarca());
            stmt.setInt(3, p.getQuantidade());
            stmt.setDouble(4, p.getPreco());
            stmt.setDate(5, Date.valueOf(p.getDataCadastro()));
            stmt.setString(6, p.getTipoProduto().name());

            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        return -1;
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM produto_base WHERE id_prod=?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
