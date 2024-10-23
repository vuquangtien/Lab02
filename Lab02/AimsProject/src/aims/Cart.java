package aims ;

public class Cart {

	public static final int MAX_NUMBER_ORDERED = 20 ;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED] ;
    private int qtyOrdered = 0 ;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < 100) {
        	itemsOrdered[qtyOrdered++] = disc ;
            System.out.println("The disc has been added") ;
        } else {
            System.out.println("The cart is almost full") ;
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0 ; i < qtyOrdered ; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i ; j < qtyOrdered - 1 ; j++) {
                	itemsOrdered[j] = itemsOrdered[j + 1] ;
                }
                itemsOrdered[--qtyOrdered] = null ;
                System.out.println("The disc has been removed") ;
                return ;
            }
        }
        System.out.println("The disc is not in the cart") ;
    }

    public float totalCost() {
        float total = 0.0f ;
        for (int i = 0 ; i < qtyOrdered ; i++) {
            total += itemsOrdered[i].getCost() ;
        }
        return total ;
    }
    
}