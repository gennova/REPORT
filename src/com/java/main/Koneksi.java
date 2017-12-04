/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Koneksi {

    String url;
    String user;
    String password;
    private Connection koneksi = null;
    private Statement st = null;

    public Koneksi() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //            System.out.println("Driver ditemukan");
            // TODO code application logic here
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            try {
                File file = new File("resource.xml");
                Properties properties;
                try (FileInputStream fileInput = new FileInputStream(file)) {
                    properties = new Properties();
                    properties.loadFromXML(fileInput);
                }
                String db = properties.getProperty("db");
                String host = properties.getProperty("host");
                String username = properties.getProperty("username");
                String passwordnya = properties.getProperty("password");
                user = username;
                password = passwordnya;
                url = "jdbc:mysql://" + host + ":3306/" + db + "";
            } catch (FileNotFoundException e) {
            } catch (IOException e) {
            }

            koneksi = DriverManager.getConnection(url, user, password);

//            System.out.println("Koneksi OK");
            st = koneksi.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Connection bukaKoneksi() throws SQLException {
        koneksi = DriverManager.getConnection(url, user, password);
        return koneksi;
    }

    public Connection getKoneksi() {
        return koneksi;
    }

    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public void tutupKoneksi() throws SQLException {
        if (koneksi != null) {
            koneksi.close();
        }
    }

    public int updateData(String sql) throws SQLException {
        int i = 0;
        i = st.executeUpdate(sql);
        return i;
    }

    public ResultSet lihatData(String sql) throws SQLException {
        ResultSet rs = null;
        rs = st.executeQuery(sql);
        return rs;

    }

    public void executeData(String sql) throws SQLException {
        st.execute(sql);
    }

    public String getStatuc() throws SQLException {
        return koneksi.getWarnings().toString();
    }
}
