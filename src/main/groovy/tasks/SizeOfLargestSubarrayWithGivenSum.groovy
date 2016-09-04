package tasks

def findLargesSubArray(ArrayList<Integer> list, Integer sum) {
    def input = list.toArray()
    def result = 0
    def currentSum = input[0]
    def position = 0

    for (int i = 1; i < input.length; i++ ) {
        if (currentSum == sum) {
            result = Math.max(result, i - position)
            currentSum = 0
        }

        currentSum += input[i]

        if (currentSum > sum) {
            while(currentSum > sum) {
                currentSum -= input[position++]
            }
        }


    }


    result == 0 ? "no subarray with a given sum" : result.toString()
}

println findLargesSubArray([1, 4, 20, 3, 10, 5] , 33)
println findLargesSubArray([1, 4, 0, 0, 3, 10, 5], 7)
println findLargesSubArray([1, 4], 6)

println findLargesSubArray([1, 4, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 4, 10, 5], 7)


