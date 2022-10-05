package magna.data.colector;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class TesteBanco {
    public static void main(String[] args) {
        Connector con = new Connector();
        JdbcTemplate banco = con.getConnection();

//        banco.execute(
//            "CREATE TABLE filme ("
//                    + "id INT PRIMARY KEY AUTO_INCREMENT,"
//                    + "nome VARCHAR(255) NOT NULL,"
//                    + "ano_lancamento int NOT NULL"
//                    + ");"
//        );

//        String insert = "INSERT INTO filme VALUES(null, ?, ?)";
//
//        String nomeFilme = "Filme 2";
//        Integer anoFilme = 2000;
//
//        banco.update(insert, nomeFilme, anoFilme);
//
//        List filmes = banco.queryForList("SELECT * FROM filme");
//
//        List<Filme> listaFilmes = banco.query("SELECT * FROM filme", new BeanPropertyRowMapper<>(Filme.class));
//
//        for (Filme item:
//             listaFilmes) {
//            System.out.println(item.toString());
//        }
//        banco.execute("CREATE TABLE Empresa(" +
//                "    id_empresa int primary key auto_increment," +
//                "    nome_empresa varchar(50)," +
//                "    CNPJ char(14)," +
//                "    telefone varchar(20)" +
//                ");"
//        );
//
        banco.update("INSERT INTO Empresa(nome_empresa) values('teste')");

        List response = banco.queryForList("SELECT * from Empresa");
        
        System.out.println(response);
    }
}
