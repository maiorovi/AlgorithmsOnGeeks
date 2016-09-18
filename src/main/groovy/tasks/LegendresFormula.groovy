package tasks


def largestPower(int n, int p) {
    int count = 0

    while(n > 0) {
        n /= p
        count += n
    }

    count
}

println largestPower(7, 3)
println largestPower(10, 3)