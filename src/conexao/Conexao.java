/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;

/**
 *
 * @author Joacir
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection getConexao() {
        try {
            // tenta estabelecer a conexão
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/gestaocondominio?serverTimezone=UTC",
                "root",
                "janetenuma2002" // Adicione a senha do seu MySQL
            );
            return conn;
        } catch(SQLException e) {
            // Se deu erro na hora de conectar
            System.out.println("Erro ao conectar" + e.getMessage());
            return null;
        }
    }
	
}
