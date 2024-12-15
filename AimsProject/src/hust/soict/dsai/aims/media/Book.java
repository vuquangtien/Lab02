package hust.soict.dsai.aims.media;
import java.util.*;

public class Book extends Media {
    private int id;
    private List<String> authors = new ArrayList<String>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<String> getAuthors() {
        return authors;
    }
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public Book(int id, String title, String category, List<String> authors, float cost) {
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.authors = authors;
    }
    public Book(int id, String title, String category, float cost) {
        super();
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
	//Add an author 
    public void addAuthor(String AuthorName){
    	if (!authors.contains(AuthorName)) {
    		authors.add(AuthorName);
            System.out.println("The author has been added to the list");
        }else{System.out.println("The author has already been in the list");}
    }
    
    //Remove an author
    public void removeAuthor(String AuthorName){
    	if (authors.contains(AuthorName)) {
    		authors.remove(AuthorName);
            System.out.println("The author has been removed from the list");
        }else{System.out.println("The author is not in the list");}
    }
    //Override toString method
    public String toString() {
		return "Book - [" + title + 
				"] - [" + category +
				"]: [" + cost + "$]";
	}

}
