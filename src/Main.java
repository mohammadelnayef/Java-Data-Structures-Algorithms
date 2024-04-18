import java.util.*;

public class Main {
    public static void main(String[] args) {

        MohHashClass myHash = new MohHashClass();
        myHash.put(1, "Mohammad");
        myHash.put(2, "Tom");
        myHash.put(3, "Jim");
        myHash.put(4, "Mike");
        myHash.put(5, "Rex");
        myHash.put(6, "Tim");
        myHash.put(100, "Ramy");

        myHash.remove(100);

        myHash.displayItems();
    }
}

