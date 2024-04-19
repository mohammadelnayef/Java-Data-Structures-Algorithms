import java.util.*;

public class Main {
    public static void main(String[] args) {

        MohBinaryTree tree = new MohBinaryTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(15);
        tree.insert(7);
        tree.insert(8);
        tree.insert(4);
        tree.insert(17);

        System.out.println(tree.find(100));

    }
}


