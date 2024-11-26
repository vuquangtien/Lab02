package aims.media;

abstract class Media {
    protected String name;
    protected String category;
    protected float cost;

    public Media() {}
    public Media(String name, String category, float cost) {
        this.name = name;
        this.category = category;
        this.cost = cost;
    }

    public String getName() {return name;}
    public String getCategory() {return category;}
    public float getCost() {return cost;}

    public void setName(String name) {this.name = name;}
    public void setCategory(String category) {this.category = category;}
    public void setCost(float cost) {this.cost = cost;}
}