package tasks

int minimum(int a, int b, int c) {
    Math.min(Math.min(a,b),c)
}

int findMin(Integer[] arr)  {
    int n = arr.length
    int[] sum = new int[n]

    sum[0] = arr[0]
    sum[1] = arr[1]
    sum[2] = arr[2]

    for (int i = 3; i < arr.length; i++) {
        sum[i] = arr[i] + minimum(sum[i-1], sum[i-2], sum[i-3])
    }

    return minimum(sum[-1], sum[n-2], sum[n-3])
}
Integer[] arr = [1,2,3].toArray()
Integer[] arr1 = [1, 2, 3, 6, 7, 1].toArray()
println findMin(arr,)
println findMin(arr1)