/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistbiblioteca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author teste123
 */
public class DAO {
     private String usuario = "root";
    private String senha = "";
    private String dbDriver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3307/tcdpoo";
    private Connection con; // guarda informacoes da conexao
    private Statement stm; // guadrda informacoes da instancia de conexao criada
    private ResultSet res; // guarda lista de dados consultados
    
    public Connection conectar(){
        try{
            Class.forName(dbDriver);
            con = DriverManager.getConnection(url, usuario,senha);
            return con;
        } catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco");
        } catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "driver de conexao invalida");
        }
         return con;
    }
    public ResultSet consultar(String comando){
        try {
            con = conectar();
            stm = con.createStatement();
            res = stm.executeQuery(comando);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar o banco");
        }
        return res;     
    }
    public void inserir(String comando){
         try {
             con = conectar();
             stm = con.createStatement();
             stm.executeUpdate(comando);
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao inserir registro");
            
         }
    }
    public void atualizar(String comando){
         try {
             con = conectar();
             stm = con.createStatement();
             stm.executeUpdate(comando);
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao atualizar dados!");
         }
        
        
    }
    public void excluir(String comando){
         try {
             con = conectar();
             stm = con.createStatement();
             stm.executeUpdate(comando);
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, "Erro ao excluir registro");
         }
    }
}
