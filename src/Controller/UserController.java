package Controller;

import Model.*;
import Database.*;

import javax.swing.*;
import java.sql.*;

public class UserController {
    public User login(String email, String password) {
        String query = "SELECT * FROM Users WHERE email = ?";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                if (rs.getString("password").equals(password)) {
                    return new User(rs.getInt("id"), rs.getString("name"), email, password);
                } else {
                    JOptionPane.showMessageDialog(null, "Password salah.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Email tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}