package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**biblioteca.c74ygm22cyzq.us-east-2.rds.amazonaws.com
 *jdbc:mysql://localhost:3306/biblioteca
 * @author jpcab
 */
public class Banco {
    private Statement stmt;
    private ResultSet rs;
    public Connection conn;

    // Construtor
    public Banco() {
        String url = "jdbc:mysql://biblioteca.c36nogcf3xn0.sa-east-1.rds.amazonaws.com:3306/biblioteca";
        String usr = "admin";
        String pas = "ifrn$2024";
        try {
            // Use o driver atualizado
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, usr, pas);
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, 
                                        ResultSet.CONCUR_READ_ONLY);
        } catch (Exception e) {
            System.out.println("Erro " + e.getMessage());
        }
    }
    
    // Método para obter o nome do usuário
    public String getUsuario(String login) throws SQLException {
        String nome = "";
        rs = stmt.executeQuery("SELECT * FROM usuario WHERE login = '"+login+"'");
        
        while (rs.next()) {
            nome = rs.getString("nome");
        }
        
        return nome;
    }
}
