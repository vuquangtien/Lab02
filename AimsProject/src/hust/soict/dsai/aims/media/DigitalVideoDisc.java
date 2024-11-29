package aims.media;

public class DigitalVideoDisc {
    private static int nbDigitalVideoDiscs = 100001;
    private int id;
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;


    public DigitalVideoDisc(String title) {
        this.title = title;
        nbDigitalVideoDiscs ++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category,  float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs ++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director,  float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        nbDigitalVideoDiscs ++;
        this.id = nbDigitalVideoDiscs;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        nbDigitalVideoDiscs ++;
        this.id = nbDigitalVideoDiscs;
    }

    public String getDetail() {
        return "DVD - " + getTitle() 
                + " - " + getCategory() 
                + " - " + getDirector() 
                + " - " + getLength() 
                + " - :" + getCost() + " $";
    }

    public boolean search(String title) {
        String[] words = title.toLowerCase().split("\\s+");
        String[] titleWords = this.title.toLowerCase().split("\\s+");
        for (String word : words) {
            boolean found = false;
            for (String titleWord : titleWords) {
                if (titleWord.startsWith(word)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
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

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{title = \'" + title + "\', "
            + "category = \'" + category + "\', "
            + "director = \'" + director + "\', "
            + "length = " + length + ", "
            + "cost = " + cost +", "
            + "id = "+ id +"}";
    }
}