package Model;

public class Artwork {
    private int id;
    private String title;
    private String description;
    private String imagePath;
    private int userId;

    public Artwork(int id, String title, String description, String imagePath, int userId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imagePath = imagePath;
        this.userId = userId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImagePath() { return imagePath; }
    public void setImagePath(String imagePath) { this.imagePath = imagePath; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
}