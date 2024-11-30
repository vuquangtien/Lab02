package aims.media;

public class DigitalVideoDisc extends Disc implements Playable{

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category,  float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, float cost, String director) {
        super(title, category, cost, director);
    }

    public DigitalVideoDisc(String title, String category, float cost, String director, int length) {
        super(title, category, cost, length, director);
    }

    public void play() {
        System.out.println("\n\u001B[33mPLAY THE MEDIA\u001B[37m");
        System.out.println(" - Playing DVD : " + getTitle());
        System.out.println(" - DVD length  : " + getLength() + " minutes");
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

    @Override
    public String toString() {
        // return "DigitalVideoDisc [id=" + id + ", title=" + title + ", category=" 
        //     + category + ", cost=" + cost + ", director=" + director + ", length=" + length + "]";
        return "\n\u001B[33m------ DIGITAL VIDEO DISC ------\n\u001B[37m" + 
               " - ID      : " + id + "\n" + 
               " - Title   : " + title + "\n" + 
               " - Category: " + category + "\n" + 
               " - Cost    : " + cost + "\n" + 
               " - Director: " + director + "\n" + 
               " - Length  : " + length + "\n" +
               "--------------------------------\n";
    }

    @Override
    public String toBackupString() {
        return id + "," + title + "," + category + "," + cost + "," + director + "," + length;
    }
}