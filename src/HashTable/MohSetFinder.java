package HashTable;

import java.util.HashSet;
import java.util.Set;

public class MohSetFinder {

    public char findFirstRepeatingChar(String str){

        Set<Character> set  = new HashSet();
        var chars = str.toCharArray();

        for(var ch : chars){

            if(set.contains(ch)){
                return ch;
            }
            else {
                set.add(ch);
            }
        }
        return Character.MIN_VALUE;
    }
}
