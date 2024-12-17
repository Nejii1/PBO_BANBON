/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BENGKELBAN;

/**
 *
 * @author syukr
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class BaseLogin extends JFrame {
    public abstract void openDashboard(String role);

    public void checkCredentials(String username, String password) {
        try {
            Connection conn = KONEKSI.getConnection();
            String sql = "SELECT * FROM user_login WHERE username=? AND password=?";
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, username);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String role = rs.getString("role");
                JOptionPane.showMessageDialog(null, "Login Berhasil sebagai " + role);
                openDashboard(role);
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
}
