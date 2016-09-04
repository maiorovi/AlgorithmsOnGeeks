package tasks;

public class PermutationsOfAString {

    public void findAllPermutationsOfAString(String s) {
        permute(s, 0);
    }

    private void permute(String s, int start) {
        char[] tmp = s.toCharArray();

        if (s.length() - start == 0) {
            System.out.println(s);
            return;
        }

        for (int i = start; i < s.length(); i++) {
            permute(swap(s, start, i), start+1);
        }
    }

    private String swap(String s, int i, int j) {
        char[] tmp = s.toCharArray();
        char temp = tmp[i];
        tmp[i] = tmp[j];
        tmp[j] = temp;

        return new String(tmp);
    }

    public static void main(String[] args) {
        PermutationsOfAString perms = new PermutationsOfAString();

        perms.findAllPermutationsOfAString("abcd");
    }
}
