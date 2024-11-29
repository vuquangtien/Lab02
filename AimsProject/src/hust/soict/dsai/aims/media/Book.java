package aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();
    
    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public boolean findAuthor(String authorName) {
        for (String author : authors) {
            if (authorName.toLowerCase() == author.toLowerCase()) {
                return true;
            }
        }
        return false;
    }

    public void addAuthor(String authorName) {
        if (!findAuthor(authorName)) {
            authors.add(authorName);
            System.out.println("Author named '"+ authorName + "' is added successfully");
        } else {
            System.out.println("Author named '"+ authorName +"'is already in author list");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author named'" + authorName + "' is removed successfully");
        } else {
            System.out.println("Cannot find author named '" + authorName + "'");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

}