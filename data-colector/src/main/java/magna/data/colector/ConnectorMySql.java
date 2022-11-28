/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package magna.data.colector;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author AlfaUser
 */
public class ConnectorMySql {
    private JdbcTemplate connection;

    public ConnectorMySql() {
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:sqlserver://meubanco.database.windows.net/magna");

        dataSource.setUsername("root");

        dataSource.setPassword("trigo1102");

        this.connection = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConnection() {
        return connection;
    }
}
