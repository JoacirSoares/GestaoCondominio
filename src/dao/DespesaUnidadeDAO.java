/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.DespesaUnidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import conexao.Conexao;
import entities.enums.StatusPagamento;
import entities.enums.TipoDespesa;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

/**
 *
 * @author Joacir
 */
public class DespesaUnidadeDAO {
    private final Conexao conexao;
    private final Connection conn;
    
    public DespesaUnidadeDAO() {
        this.conexao = new Conexao();
        this.conn = (Connection) this.conexao.getConexao();
    }
        
    // O construtor é executado automaticamente sempre que um novo objeto é criado.
    
    public List<DespesaUnidade> getDespesas() {
        String sql = "SELECT * FROM despesaunidade";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<DespesaUnidade> listaDespesa = new ArrayList<>();
            // percorre o "rs" e salva as imformações dentro de uma variavel "DespesaUnidade"
            // e depois Salva essa variavel dentro da lista
            while(rs.next()) {
                DespesaUnidade despesaUnidade = new DespesaUnidade();
                despesaUnidade.setIddespesaUnidade(rs.getInt("iddespesaUnidade"));
                despesaUnidade.setTipoDespesa(TipoDespesa.valueOf(rs.getString("tipoDespesa")));
                despesaUnidade.setValor(rs.getDouble("valor"));
                despesaUnidade.setDescricao(rs.getString("descricao"));
                despesaUnidade.setVencimentoFatura(rs.getString("vencimentoFatura"));
                despesaUnidade.setStatusPagamento(StatusPagamento.valueOf(rs.getString("statusPagamento")));
                listaDespesa.add(despesaUnidade);
            }
            return listaDespesa;
        } catch(SQLException e) {
           System.out.println("Erro ao buscar Despesa: " + e.getMessage());
           return null; 
        }
    }
    
    public List<DespesaUnidade> getDespesas(String nomeDespesa) {
        String sql = "SELECT * FROM despesaunidade WHERE identificacaounidade LIKE = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            List<DespesaUnidade> listaDespesa = new ArrayList<>();
            // percorre o "rs" e salva as imformações dentro de uma variavel "DespesaUnidade"
            // e depois Salva essa variavel dentro da lista
            while(rs.next()) {
                DespesaUnidade despesaUnidade = new DespesaUnidade();
                despesaUnidade.setIddespesaUnidade(rs.getInt("iddespesaUnidade"));
                despesaUnidade.setTipoDespesa(TipoDespesa.valueOf(rs.getString("tipoDespesa")));
                despesaUnidade.setValor(rs.getDouble("valor"));
                despesaUnidade.setDescricao(rs.getString("descricao"));
                despesaUnidade.setVencimentoFatura(rs.getString("vencimentoFatura"));
                despesaUnidade.setStatusPagamento(StatusPagamento.valueOf(rs.getString("statusPagamento")));
                listaDespesa.add(despesaUnidade);
            }
            return listaDespesa;
        } catch(SQLException e) {
           System.out.println("Erro ao buscar Despesa: " + e.getMessage());
           return null; 
        }
    }
    
    public void inserir(DespesaUnidade despesaUnidade) {
        String sql = "INSERT INTO despesaunidade(tipoDespesa, valor, descricao, vencimentoFatura, statusPagamento) VALUES" 
                + "(?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setString(1, despesaUnidade.getTipoDespesa().name());
            stmt.setDouble(2, despesaUnidade.getValor());
            stmt.setString(3, despesaUnidade.getDescricao());
            stmt.setString(4, despesaUnidade.getVencimentoFatura());
            stmt.setString(5, despesaUnidade.getStatusPagamento().name());
            stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro ao inserir Despesa: " + e.getMessage());
        }
    }
    
    public DespesaUnidade getDespesa(int id) {
        String sql = "SELECT * FROM despesaUnidade WHERE iddespesaUnidade = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_UPDATABLE);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            DespesaUnidade despesaUnidade = new DespesaUnidade();
            // posicionando o result set na primeira posicao
            rs.first();
            despesaUnidade.setIddespesaUnidade(id);
            despesaUnidade.setTipoDespesa(TipoDespesa.valueOf(rs.getString("tipoDespesa")));
            despesaUnidade.setValor(rs.getDouble("valor"));
            despesaUnidade.setDescricao(rs.getString("descricao"));
            despesaUnidade.setVencimentoFatura(rs.getString("vencimentoFatura"));
            despesaUnidade.setStatusPagamento(StatusPagamento.valueOf(rs.getString("statusPagamento")));
            return despesaUnidade;
        } catch (SQLException e) {
            System.out.println("Erro ao buscar Despesa: " + e.getMessage());
            return null;
        }
    }
    
    public void editar(DespesaUnidade despesaUnidade, int id) {
        String sql = "UPDATE despesaunidade SET tipoDespesa = ?, valor = ?, descricao = ?, vencimentoFatura = ?, statusPagamento = ? WHERE iddespesaUnidade = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setString(1, despesaUnidade.getTipoDespesa().name());
            stmt.setDouble(2, despesaUnidade.getValor());
            stmt.setString(3, despesaUnidade.getDescricao());
            stmt.setString(4, despesaUnidade.getVencimentoFatura());
            stmt.setString(5, despesaUnidade.getStatusPagamento().name());
            stmt.setInt(6, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao editar despesa: " + e.getMessage());
        }
    }
    
    public void excluir(int id) {
        String sql = "DELETE FROM despesaunidade Where iddespesaUnidade = ?";
        try {
            PreparedStatement stmt = (PreparedStatement) this.conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
        } catch(SQLException e) {
            System.out.println("Erro ao excluir despesa: " + e.getMessage());
        }
    }
}
