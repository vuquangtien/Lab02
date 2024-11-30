package aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private ArrayList<String> authors = new ArrayList<>();

    public Book() {
        super();
    }

    public Book(String title) {
        super(title);
    }

    public Book (String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, ArrayList<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    @Override
    public String toString() {
        // return "Book [id=" + id + ", title=" + title + ", category=" + category 
        // + ", cost=" + cost + ", authors=" + authors + "]";
        return "\n\u001B[33m---------- BOOK DETAIL----------\n\u001B[37m" + 
               " - ID      : " + id + "\n" + 
               " - Title   : " + title + "\n" + 
               " - Category: " + category + "\n" + 
               " - Cost    : " + cost + "\n" + 
               " - Authors : " + authors + "\n" + 
               "--------------------------------\n";
    }

    public String toBackupString() {
        return id + ";" + title + ";" + category + ";" + cost + ";" + authors;
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("\u001B[31mTHE AUTHOR '"+ authorName +"' IS ALREADY IN THE LIST OF AUTHORS!\u001B[37m");
        } else {
            authors.add(authorName);
            System.out.println("\u001B[32mTHE AUTHOR '"+ authorName + "' HAS BEEN ADDED TO THE LIST OF AUTHORS!\u001B[37m");
        
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("\u001B[32mTHE AUTHOR '" + authorName + "' HAS BEEN REMOVED FROM THE LIST OF AUTHORS!\u001B[37m");
        } else {
            System.out.println("\u001B[31mCANNOT FIND THE AUTHOR '" + authorName + "'!\u001B[37m");
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

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
}