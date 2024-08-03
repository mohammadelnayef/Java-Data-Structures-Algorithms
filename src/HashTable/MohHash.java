package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MohHash {

    public char findFirstNonRepeatedCharacter(String inputString){

        if(inputString.isEmpty()){
            throw new IllegalArgumentException();
        }

        Map<Character, Integer> allCharacters = new HashMap<>();
        ArrayList<Character> nonRepeatableChar = new ArrayList<>();

        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);

            if(ch != ' '){
                if(!allCharacters.containsKey(ch)){
                    allCharacters.put(ch, 1);
                    nonRepeatableChar.add(ch);
                }
                else {
                    allCharacters.remove(ch);
                    nonRepeatableChar.remove(nonRepeatableChar.indexOf(ch));
                }
            }
        }

        if(nonRepeatableChar.isEmpty()){
            return ' ';
        }
        return nonRepeatableChar.get(0);
    }
}
