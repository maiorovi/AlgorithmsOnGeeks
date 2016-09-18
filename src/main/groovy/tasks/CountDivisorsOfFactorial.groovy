package tasks

def factorial(Integer n) {
    if (n == 1) {
        return 1
    }

    return n * factorial(n - 1)
}

def easyMethod(Integer n) {
    int number = factorial(n)
    int count =  0

    for (int i = 1; i <= number; i++) {
        if (number % i  == 0) {
            count++
        }
    }

    count
}

println easyMethod(5)


def findAllPrimes(Integer n) {
    boolean[] primes = new boolean[n+1]

    for (int i = 2; i < primes.length; i++) {
        primes[i] = true
    }

    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (primes[i] == true) {
            for (int j = 2*i; j <= n; j = j + i) {
                primes[j] = false
            }
        }
    }

    def result = []

    for (int k = 2; k < primes.length; k++) {
        if (primes[k]) {
            result << k
        }
    }

    result

}
println findAllPrimes(5)
println findAllPrimes(6)
println findAllPrimes(20)

def findLargestPower(int n, int p) {
    def count = 0

    while (n > 0) {
        n /= p
        count += n
    }

    count
}

def fastSolution(int numb) {
    findAllPrimes(numb).collect{
        it ->
        findLargestPower(numb, it)
    }.inject(1) { product, value ->
        product * (value + 1)
    }

}

println fastSolution(5)
println fastSolution(4)
println fastSolution(6)