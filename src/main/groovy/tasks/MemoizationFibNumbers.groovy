package tasks

import groovy.transform.Field

@Field int[] cache =  init(10000)

def fib(int n) {

    if (cache[n] == -1) {
        if (n <= 1) {
            cache[n] = n
        } else {
            cache[n] = fib(n - 1) + fib(n - 2)
        }
    }

    return cache[n]
}


def init(int n) {
    int[] arr = new int[n]
    for (int i = 0; i < arr.length; i++) {
        arr[i] = -1
    }

    arr
}


println fib(7)