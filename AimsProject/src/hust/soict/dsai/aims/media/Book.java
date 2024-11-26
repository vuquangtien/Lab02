package aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private int id;
    private String title;
    private String category;
    private float cost;
    private List<String> authors = new ArrayList<String>();
    
    public Book() {}

    public Book(int id, String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.id = id;
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

    public int getID() {return id;}
    public String getTitle() {return title;}
    public String getCategory() {return category;}
    public float getCost() {return cost;}
    public List<String> getAuthors() {return authors;}

    public void setID(int id) {this.id = id;}
    public void setTitle(String title) {this.title = title;}
    public void setCategory(String category) {this.category = category;}
    public void setCost(float cost) {this.cost = cost;}
    public void setAuthor(List<String> authors) {this.authors = authors;}
}