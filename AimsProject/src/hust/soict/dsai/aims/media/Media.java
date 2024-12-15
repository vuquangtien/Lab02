package hust.soict.dsai.aims.media;
import java.util.Comparator;

public class Media {
//Add fields
    protected String title;
    protected String category;
    protected float cost;
    protected int id;
//Generate getter & setter
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	//Override the equals method  
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Media myMedia = (Media) obj;
        return this.title.equals(myMedia.title);
	}
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST =
			new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE =
			new MediaComparatorByCostTitle();
}
