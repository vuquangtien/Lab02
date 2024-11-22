package Lab03.AimProjects.Source.aims.disc;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    private int id;
    private static int nbDigitalVideoDisc = 0;

    public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = directory;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDisc = nbDigitalVideoDisc + 1;
        id = nbDigitalVideoDisc;
    }

    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDisc = nbDigitalVideoDisc + 1;
        id = nbDigitalVideoDisc;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbDigitalVideoDisc = nbDigitalVideoDisc + 1;
        id = nbDigitalVideoDisc;

    }

    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        nbDigitalVideoDisc = nbDigitalVideoDisc + 1;
        id = nbDigitalVideoDisc;

    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public int getID() {
        return id;
    }

    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " - " + cost + "$";
    }

    public boolean isMatch(String title) {
        return this.title.equalsIgnoreCase(title);
    }


}