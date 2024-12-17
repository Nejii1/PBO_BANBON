/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BENGKELBAN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KONEKSI {
    public static Connection getConnection() {
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/ban"; // Nama database
        String user = "root"; // Username MySQL
        String password = ""; // Password MySQL
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Koneksi ke database berhasil!");
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection c = KONEKSI.getConnection();
            if (c != null) {
                System.out.println(String.format("Connected to database %s successfully.", c.getCatalog()));
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
