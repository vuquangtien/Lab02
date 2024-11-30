package aims.media;
import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
    protected static int nbMedias = 100000;
    protected int id;
    protected String title;
    protected String category;
    protected float cost;

    public Media() {
        nbMedias ++;
        this.id = nbMedias;
    }
    public Media(String title) {
        nbMedias ++;
        this.id = nbMedias;
        this.title = title;
    }

    public Media(String title, String category, float cost) {
        nbMedias ++;
        this.id = nbMedias;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public String getDetail() {
        return "Media - " + getId()
                + " - " + getTitle() 
                + " - " + getCategory() 
                + " - " + getCost() + "$";
    }

    public String toBackupString() {
        return id + ";" + title + ";" + category + ";" + cost;
    }

    @Override 
    public int compareTo(Media other) {
        return this.title.compareTo(other.title);
    }

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();     

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

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Media other = (Media) o; 
        return getTitle().equals(other.getTitle());
    }
}