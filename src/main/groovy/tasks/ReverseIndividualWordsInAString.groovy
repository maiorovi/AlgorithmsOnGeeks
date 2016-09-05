package tasks

def reverseWordInAString(String s) {

    String[] words = s.split(" ")
    StringBuffer buffer = new StringBuffer();
    for (int i = 0; i < words.length; i++) {
        buffer.append(reverseOneWord(words[i]))
        buffer.append(" ")
    }

    String reversedString = buffer.toString().trim()

    reversedString.reverse()
}


private def reverseOneWord(String word) {
    Character[] arr = word.toCharArray()
    def j = arr.length - 1

    for (int i = 0; i < j; i++ ) {
        swap(arr, i, j)
        j--
    }

    new String(arr)
}

private def swap(Character[] arr, Integer i, Integer j) {
    def tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}

println reverseWordInAString("i like this program very much")

