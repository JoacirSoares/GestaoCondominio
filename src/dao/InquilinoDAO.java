/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Inquilino;
import java.sql.Connection;
import java.sql.PreparedStatement;
import conexao.Conexao;
import entities.enums.Sexo;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joacir
 */
public class InquilinoDAO {
    private final Conexao conexao;
    private final Connection conn;
    
    // O construtor é executado automaticamente sempre que um novo objeto é criado.
    
    public InquilinoDAO() {
        this.conexao = new Conexao();
        this.conn = (Connection) this.conexao.getConexao();
    }
    
    public void inserir(Inquilino inquilino) {
        String sql = "INSERT INTO inquilino(nome, idade, telefone, email, sexo) VALUES" 
                + "(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setString(1, inquilino.getNome());
            stmt.setInt(2, inquilino.getIdade());
            stmt.setString(3, inquilino.getTelefone());
            stmt.setString(4, inquilino.getEmail());
            stmt.setString(5, inquilino.getSexo().name());
            stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro ao inserir Inquilino: " + e.getMessage());
        }
    }
    
    public Inquilino getInquilino(int id) {
        String sql = "SELECT * FROM inquilino WHERE idinquilino = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Inquilino inquilino = new Inquilino();
            // posicionando o result set na primeira posicao
            rs.first();
            inquilino.setIdinquilino(id);
            inquilino.setNome(rs.getString("nome"));
            inquilino.setIdade(rs.getInt("idade"));
            inquilino.setTelefone(rs.getString("telefone"));
            inquilino.setEmail(rs.getString("email"));
            inquilino.setSexo(Sexo.valueOf(rs.getString("sexo")));
            return inquilino;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Inquilino: " + e.getMessage());
            return null;
        }
    }
    
    public void editar(Inquilino inquilino, int id) {
        String sql = "UPDATE inquilino SET nome = ?, idade = ?, telefone = ?, email = ?, sexo = ? WHERE idinquilino = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setString(1, inquilino.getNome());
            stmt.setDouble(2, inquilino.getIdade());
            stmt.setString(3, inquilino.getTelefone());
            stmt.setString(4, inquilino.getEmail());
            stmt.setString(5, inquilino.getSexo().name());
            stmt.setInt(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao editar inquilino: " + e.getMessage());
        }
    }
    
    public void excluir(int id) {
        String sql = "DELETE FROM inquilino Where idinquilino = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro ao excluir inquilino: " + e.getMessage());
        }
    }
    
    public List<Inquilino> getInquilino() {
        String sql = "SELECT * FROM inquilino";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Inquilino> listaInquilino = new ArrayList<>();
            // percorre o "rs" e salva as imformações dentro de uma variavel "Inquilino"
            // e depois Salva essa variavel dentro da lista
            while(rs.next()) {
                Inquilino inquilino = new Inquilino();
                inquilino.setIdinquilino(rs.getInt("idinquilino"));
                inquilino.setNome(rs.getString("nome"));
                inquilino.setIdade(rs.getInt("idade"));
                inquilino.setTelefone(rs.getString("telefone"));
                inquilino.setEmail(rs.getString("email"));
                inquilino.setSexo(Sexo.valueOf(rs.getString("sexo")));
                listaInquilino.add(inquilino);
            }
            return listaInquilino;
        } catch(SQLException e) {
           System.out.println("Erro ao buscar inquilino: " + e.getMessage());
           return null; 
        }
    }
    
    public List<Inquilino> getInquilino(String nomeInquilino) {
        String sql = "SELECT * FROM inquilino WHERE identificacaounidade LIKE = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Inquilino> listaInquilino = new ArrayList<>();
            // percorre o "rs" e salva as imformações dentro de uma variavel "Inquilino"
            // e depois Salva essa variavel dentro da lista
            while(rs.next()) {
                Inquilino inquilino = new Inquilino();
                inquilino.setIdinquilino(rs.getInt("idinquilino"));
                inquilino.setNome(rs.getString("nome"));
                inquilino.setIdade(rs.getInt("idade"));
                inquilino.setTelefone(rs.getString("telefone"));
                inquilino.setEmail(rs.getString("email"));
                inquilino.setSexo(Sexo.valueOf(rs.getString("sexo")));
                listaInquilino.add(inquilino);
            }
            return listaInquilino;
        } catch(SQLException e) {
           System.out.println("Erro ao buscar inquilino: " + e.getMessage());
           return null; 
        }
    }
    
}
