
import java.sql.Connection;  // Importando biblioteca necessária para criar a conexão Java - SQL
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

 /*
 * @author saulo.leite
 */

public class ConexaoDAO { // 
    public Connection conectaBD(){ //Retorna uma variável de conexão
        Connection conn = null; // Var utilizada na conexão 
        
        //Tentativa e excessão 
        try {
            String url = "jdbc:mysql://localhost:3306/bancoteste?user=root&passwprd="; //URL utilizada para conexão
            conn = DriverManager.getConnection(url); // Armazeando na variável toda a informação da URL
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getLocalizedMessage()); //Messagem de erro
        }
        
        return conn;
    
    }
}
