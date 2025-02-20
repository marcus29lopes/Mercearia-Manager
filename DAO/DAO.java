package DAO;

import model.Product;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DAO<T> {
    private Connection connect;

    public DAO(Connection connect) {
        this.connect = connect;
    }

    //inserir dados e vai gerar a chave automatica
    public int add(String sql, Object... attributes) {
        try (PreparedStatement stmt = connect.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            addAttributes(stmt, attributes);
            if (stmt.executeUpdate() > 0) {
                ResultSet result = stmt.getGeneratedKeys();
                if (result.next()) {
                    return result.getInt(1); //acessa o primeiro valor do resultSet 1 se refere a priemira coluna
                }
            }
            return -1; //Se não houver chave gerada ou se a inserção falhar retorna -1

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<T> listar() {
        List<T> lista = new ArrayList<>();
        String sql = "SELECT * FROM pessoa";  // Busca todas as pessoas no banco

        try (PreparedStatement statement = connect.prepareStatement(sql);
             ResultSet resultado = statement.executeQuery()) {

            while (resultado.next()) {
                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                lista.add((T) new Product(id, nome));  // Adiciona no ArrayList
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar pessoas", e);
        }

        return lista;
    }

    public int att(String sql, Object... attributes) {
        return executeUpdate(sql, attributes);
    }

    public int delete(String sql, Object... attributes) {
        return executeUpdate(sql, attributes);
    }

    private int executeUpdate(String sql, Object... attributes) {
        try (PreparedStatement stmt = connect.prepareStatement(sql)) {
            addAttributes(stmt, attributes);
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    //vai definir o tipo de cada elemento e usa o metodo apropriado do stmt para
    // definir o valor correspondente no paramentro sql
    private void addAttributes(PreparedStatement stmt, Object[] attributes) throws SQLException {
        for (int i = 0; i < attributes.length; i++) {
            Object attribute = attributes[i];
            int index = i + 1;
            if (attribute instanceof String) {
                stmt.setString(index, (String) attribute);
            } else if (attribute instanceof Integer) {
                stmt.setInt(index, (Integer) attribute);
            } else if (attribute instanceof BigDecimal) {
                stmt.setBigDecimal(index, (BigDecimal) attribute);
            } else {
                throw new IllegalArgumentException("Type not supported: " + attribute.getClass().getName());
            }
        }

    }

}
