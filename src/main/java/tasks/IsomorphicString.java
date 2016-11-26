package tasks;

import java.util.HashMap;

public class IsomorphicString {

    public boolean isIsomorphic(String source, String target) {
        HashMap<Character, Character> mapping = new HashMap<>();

        if (source.length() != target.length()) {
            return false;
        }

        for (int i = 0; i < source.length(); i++) {
            if (mapping.containsKey(source.charAt(i))) {
                if (mapping.get(source.charAt(i)) != target.charAt(i)) {
                    return false;
                }
            } else {
                mapping.put(source.charAt(i), target.charAt(i));
            }
        }

        return true;
    }

}
