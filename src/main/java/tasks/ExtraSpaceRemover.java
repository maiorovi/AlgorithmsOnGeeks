package tasks;

public class ExtraSpaceRemover {

    public String remove(String str) {
        if (str.isEmpty()) {
            return str;
        }

        char[] chrs = trimLeft(str).toCharArray();
        StringBuffer sb = new StringBuffer();
        int j = 0;
      for (int i = 0; i < chrs.length-1; i++) {
          if (!Character.isWhitespace(chrs[i])) {
              sb.append(chrs[i]);
          } else if (chrs[i+1] == '?' || chrs[i+1] == '.' || chrs[i+1] == '!') {
              continue;
          } else if (!Character.isWhitespace(chrs[i + 1])) {
              sb.append(" ");
              sb.append(chrs[++i]);
          }
      }

        return chrs[chrs.length - 1] != ' ' ? sb.append(chrs[chrs.length - 1]).toString() : sb.toString();
    }

    private String trimLeft(String str) {
        int i = 0;
        char[] ch = str.toCharArray();

        while(Character.isWhitespace(ch[i]) && i < ch.length - 1) {
            i++;
        }

        return str.substring(i);
    }


}
