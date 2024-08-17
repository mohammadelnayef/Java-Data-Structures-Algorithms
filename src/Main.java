import Heap.MaxHeap;
import Trie.Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("canada");

        System.out.println(trie.contains("canada"));
    }
}


