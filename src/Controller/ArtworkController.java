package Controller;

import Model.*;
import Database.*;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArtworkController {
    public List<Artwork> getAllArtworks() {
        List<Artwork> artworks = new ArrayList<>();
        String query = "SELECT Artworks.*, Users.name AS artist_name FROM Artworks JOIN Users ON Artworks.user_id = Users.id";
        try (Connection conn = Database.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Artwork artwork = new Artwork(
                    rs.getInt("id"),
                    rs.getString("title"),
                    rs.getString("description"),
                    rs.getString("image_path"),
                    rs.getInt("user_id")
                );
                artworks.add(artwork);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artworks;
    }

    public void addArtwork(String title, String description, String imagePath, int userId) {
        String query = "INSERT INTO Artworks (title, description, image_path, user_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, title);
            stmt.setString(2, description);
            stmt.setString(3, imagePath);
            stmt.setInt(4, userId);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Karya seni berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}