/**************************************************************************************
 * BearStore
 * Ahmed Hadaka
 * 
 * this program get the maker and type for every bear and store it into
 * anArraylist
 * then, display them on the screen.
 **************************************************************************************/
public class BearStoreMain {

    public static void main(String[] args) {
        BearStore store = new BearStore();
        store.addStdBears(3);
        store.addUserSpecifiedBears(2);
        store.displayInventory();
    }
}
