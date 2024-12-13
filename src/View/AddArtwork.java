package View;

import Controller.*;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddArtwork extends JFrame {
    private JTextField titleField;
    private JTextArea descriptionArea;
    private JButton uploadButton;
    private JButton submitButton;
    private String imagePath;
    private User currentUser;

    public AddArtwork(User user) {
        this.currentUser = user;

        setTitle("Tambah Karya Seni");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        titleField = new JTextField();
        descriptionArea = new JTextArea();
        uploadButton = new JButton("Upload Image");
        submitButton = new JButton("Submit");

        add(new JLabel("Title:"));
        add(titleField);
        add(new JLabel("Description:"));
        add(new JScrollPane(descriptionArea));
        add(uploadButton);
        add(submitButton);

        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int option = fileChooser.showOpenDialog(null);
                if (option == JFileChooser.APPROVE_OPTION) {
                    imagePath = fileChooser.getSelectedFile().getAbsolutePath();
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String description = descriptionArea.getText();
                if (title.isEmpty() || description.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Harus diisi.");
                    return;
                }

                ArtworkController artworkController = new ArtworkController();
                artworkController.addArtwork(title, description, imagePath, currentUser.getId());
                dispose();
                new ArtworkList(currentUser);
            }
        });

        setVisible(true);
    }
}