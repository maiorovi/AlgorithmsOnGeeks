package tasks

def doReplacement(ArrayList<Integer> input) {
    def inp = (Integer[]) input.toArray()
    def tmp = (Integer[]) new Object[inp.length - 1]
    def currentMax = -1;

    for (int i = inp.length - 2; i >= 0; i--) {
        currentMax = Math.max(currentMax, inp[i+1])
        tmp[i] = currentMax
    }


    for (int i = 0; i < inp.length - 1; i++) {
        inp[i] = tmp[i]
    }

    inp[inp.length - 1] = -1

    inp
}


println doReplacement([16, 17, 4, 3, 5, 2]) // 17, 5, 5, 5, 2, -1
println doReplacement([2, 5, 7, 1, 2, 3])