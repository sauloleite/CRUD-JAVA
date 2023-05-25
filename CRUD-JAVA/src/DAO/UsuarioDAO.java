/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class UsuarioDAO {
    //Criar uma variável de conexão
    
    Connection conn; // Variável de conexão
    
    public ResultSet autenticacaoUsuario(UsuarioDTO ObjUsuarioDTO){
        
        conn = new ConexaoDAO().conectaBD(); //Recebe algo referente a nossa classe de conexão realizando uma conexão
        
        try {
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ? "; //String para pegar dados do banco de dados
            PreparedStatement pstm = conn.prepareStatement(sql); //Buscando dados no banco de dados
            pstm.setString(1, ObjUsuarioDTO.getNome_usuario()); //Adicionando o dado "de nome de usuario" no primeiro "?"
            pstm.setString(2, ObjUsuarioDTO.getSenha_usuario()); //Adicionando o dado "de senha" no segundo "?"
            
            ResultSet rs = pstm.executeQuery(); // Execulta o pstm e salva na variável rs 
            
            return rs; // Retorna rs
            
            
        } catch (SQLException erro){ //Exceção
            JOptionPane.showMessageDialog(null, "UsuarioDAO " + erro);
            return null;
        
        }
    }
}
