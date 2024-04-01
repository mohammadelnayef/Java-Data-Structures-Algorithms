import java.util.*;

public class Main {
    public static void main(String[] args) {

        MohHash mohMap = new MohHash();
        var firstNonRepeatableChar = mohMap.findFirstNonRepeatedCharacter("a green apple");
        System.out.println(firstNonRepeatableChar);

        var firstNonRepeatableChar2 = mohMap.findFirstNonRepeatedCharacter("aaaa");
        System.out.println(firstNonRepeatableChar2);

        var firstNonRepeatableChar3 = mohMap.findFirstNonRepeatedCharacter("");
        System.out.println(firstNonRepeatableChar3);

    }
}

