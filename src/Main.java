import Heap.MaxHeap;
import Trie.Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("card");
        trie.insert("care");
        trie.insert("careful");
        var words = trie.findWords("car");
        System.out.println(words);

    }
}


