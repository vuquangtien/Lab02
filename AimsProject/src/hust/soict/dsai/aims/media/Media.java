package aims.media;

public abstract class Media {
    protected static int nbMedias = 100001;
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

}