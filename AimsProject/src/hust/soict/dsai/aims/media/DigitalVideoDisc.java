package aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category,  float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director,  float cost) {
        super(title, category, cost, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost, length, director);
    }

    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength() + " minutes");
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
}