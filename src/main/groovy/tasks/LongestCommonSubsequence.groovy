package tasks

def lcs(String w1, String w2, int p1, int p2) {
    if(p1 == 0 || p2 == 0) {
        return 0
    }

    if (w1.charAt(p1 - 1) == w2.charAt(p2 - 1)) {
        return 1 + lcs(w1, w2, p1-1, p2-1)
    } else {
        return Math.max(lcs(w1, w2,p1-1, p2), lcs(w1, w2,p1, p2-1))
    }
}

println lcs( "AGGTAB", "GXTXAYB","AGGTAB".length(), "GXTXAYB".length())
