package tasks

def missingNumbers1(int[] input) {
//    def n = input.inject(Integer.MIN_VALUE) { max, current -> Math.max(max, current)
//    }
    int n = input.length + 2
    boolean[] present = new boolean[n+1]
    present[0] = true

    input.toList().forEach {
        present[it] = true
    }

    def ans = []

    for (int i = 0; i < present.length; i++) {
        if (!present[i]) {
            ans << i
        }
    }

    ans
}

println missingNumbers1((Integer[])[1, 3, 5, 6].toArray())

def missingNumbers2(int[] input) {
   int length = input.length + 2
    int expectedSum = ((2 + (length - 1)) / 2) * length
    int actualSum = input.inject(0) {
        sum, value -> sum + value
    }

    def diff = (expectedSum - actualSum) / 2
    int fst = -1
    int snd = -1
    int acSum = 0

    for (int i = 0; i < input.length; i++) {
        if (input[i] > diff) {
            break
        }

        acSum += input[i]
    }

    fst =  (1..diff).inject(0) { sum, value -> sum + value} - acSum

    acSum = 0

    for (int i = diff+1; i < input.length; i++) {
        acSum += input[i]
    }

    snd = (diff+1..input.length).inject(0) {sum, value -> sum + value} - acSum

    return [fst,snd]
}

println missingNumbers2((Integer[])[1, 3, 5, 6].toArray())
