package com.loja.lojaVirtual.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.loja.lojaVirtual.modelo.Produto;

@Repository
public class ProdutoDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Produto buscarPorId(int id) {
        String sql = "SELECT * FROM produtos WHERE id = ?";
        List<Produto> resultado = jdbcTemplate.query(sql, new ProdutoRowMapper(), id);
        return resultado.isEmpty() ? null : resultado.get(0);
    }

    public List<Produto> listarTodos() {
        String sql = "SELECT * FROM produtos ORDER BY nome";
        return jdbcTemplate.query(sql, new ProdutoRowMapper());
    }

    private static class ProdutoRowMapper implements RowMapper<Produto> {
        @Override
        public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Produto(
                rs.getInt("id"),
                rs.getString("nome"),
                rs.getString("descricao"),
                rs.getDouble("preco")
            );
        }
    }
}
