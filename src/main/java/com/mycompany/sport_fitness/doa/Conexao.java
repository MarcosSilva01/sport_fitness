/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sport_fitness.doa;

import com.mysql.jdbc.Connection;
import java.sql.*;

/**
 *
 * @author heito
 */
public class Conexao {

    protected Connection conexao() throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "";
            url += "jdbc:mysql://localhost:3306/sport_fitness";
            url += "user=root&password=M@rc0sfelipe";
            con = (Connection) DriverManager.getConnection(url);
            System.out.println("Conexão aberta.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        return con;
    }
}
