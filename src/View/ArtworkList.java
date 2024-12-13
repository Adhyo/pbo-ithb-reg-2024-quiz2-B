package View;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ArtworkList extends JFrame {
    private User currentUser;

    public ArtworkList(User user) {
        this.currentUser = user;

        setTitle("Daftar Karya Seni");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JButton addArtworkButton = new JButton("Tambahkan Karya Seni");
        add(addArtworkButton, BorderLayout.NORTH);

        JPanel artworkPanel = new JPanel();
        artworkPanel.setLayout(new GridLayout(0, 1));

        ArtworkController artworkController = new ArtworkController();
        List<Artwork> artworks = artworkController.getAllArtworks();

        for (Artwork artwork : artworks) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel titleLabel = new JLabel("Title: " + artwork.getTitle());
            JLabel descriptionLabel = new JLabel("Description: " + artwork.getDescription());

            panel.add(titleLabel, BorderLayout.NORTH);
            panel.add(descriptionLabel, BorderLayout.CENTER);

            artworkPanel.add(panel);
        }

        JScrollPane scrollPane = new JScrollPane(artworkPanel);
        add(scrollPane, BorderLayout.CENTER);

        addArtworkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AddArtwork(currentUser);
            }
        });

        setVisible(true);
    }
}
