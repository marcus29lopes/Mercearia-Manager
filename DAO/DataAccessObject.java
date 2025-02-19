package DAO;

import java.math.BigDecimal;
import java.sql.*;

public class DataAccessObject<T> {
    private Connection connect;

    public DataAccessObject(Connection connect) {
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
