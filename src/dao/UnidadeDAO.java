/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.Unidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import conexao.Conexao;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Joacir
 */
public class UnidadeDAO {
    private final Conexao conexao;
    private final Connection conn;
    
    // O construtor é executado automaticamente sempre que um novo objeto é criado.
    
    public UnidadeDAO() {
        this.conexao = new Conexao();
        this.conn = (Connection) this.conexao.getConexao();
    }
    
    public Unidade getUnidade(int id) {
        String sql = "SELECT * FROM unidade WHERE idunidade = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            Unidade unidade = new Unidade();
            // posicionando o result set na primeira posicao
            rs.first();
            unidade.setIdunidade(id);
            unidade.setIdentificacao(rs.getString("identificacao"));
            unidade.setProprietario(rs.getString("proprietario"));
            unidade.setCondominio(rs.getString("condominio"));
            unidade.setEndereco(rs.getString("endereco"));
            return unidade;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar unidade: " + e.getMessage());
            return null;
        }
    }
    
    public void inserir(Unidade unidade) {
        String sql = "INSERT INTO unidade(identificacao, proprietario, condominio, endereco) VALUES" 
                + "(?, ?, ?, ?)";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setString(1, unidade.getIdentificacao());
            stmt.setString(2, unidade.getProprietario());
            stmt.setString(3, unidade.getCondominio());
            stmt.setString(4, unidade.getEndereco());
            stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro ao inserir unidade: " + e.getMessage());
        }
    }
    
    public void editar(Unidade unidade, int id) {
        String sql = "UPDATE unidade SET Identificacao = ?, proprietario = ?, condominio = ?, endereco = ? WHERE idunidade = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setString(1, unidade.getIdentificacao());
            stmt.setString(2, unidade.getProprietario());
            stmt.setString(3, unidade.getCondominio());
            stmt.setString(4, unidade.getEndereco());
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao editar unidade: " + e.getMessage());
        }
    }
    
    public void excluir(int id) {
        String sql = "DELETE FROM unidade Where idunidade = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro ao excluir unidade: " + e.getMessage());
        }
    }
    
    public List<Unidade> getUnidade() {
        String sql = "SELECT * FROM unidade";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Unidade> listaUnidade = new ArrayList<>();
            // percorre o "rs" e salva as imformações dentro de uma variavel "Inquilino"
            // e depois Salva essa variavel dentro da lista
            while(rs.next()) {
                Unidade unidade = new Unidade();
                unidade.setIdunidade(rs.getInt("idunidade"));
                unidade.setIdentificacao(rs.getString("identificacao"));
                unidade.setProprietario(rs.getString("proprietario"));
                unidade.setCondominio(rs.getString("condominio"));
                unidade.setEndereco(rs.getString("endereco"));
                listaUnidade.add(unidade);
            }
            return listaUnidade;
        } catch(SQLException e) {
           System.out.println("Erro ao buscar unidade: " + e.getMessage());
           return null; 
        }
    }
    
    public List<Unidade> getUnidade(String nomeunidade) {
                String sql = "SELECT * FROM unidade WHERE nomeunidade LIKE = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<Unidade> listaUnidade = new ArrayList<>();
            // percorre o "rs" e salva as imformações dentro de uma variavel "Inquilino"
            // e depois Salva essa variavel dentro da lista
            while(rs.next()) {
                Unidade unidade = new Unidade();
                unidade.setIdunidade(rs.getInt("idunidade"));
                unidade.setIdentificacao(rs.getString("identificacao"));
                unidade.setProprietario(rs.getString("proprietario"));
                unidade.setCondominio(rs.getString("condominio"));
                unidade.setEndereco(rs.getString("endereco"));
                listaUnidade.add(unidade);
            }
            return listaUnidade;
        } catch(SQLException e) {
           System.out.println("Erro ao buscar unidade: " + e.getMessage());
           return null; 
        }
    }
    
}
