package tasks

def findPrimes(int n) {
    boolean[] isPrime = new boolean[n+1]

    for (int i = 0; i < n; i++) {
        isPrime[i] = true
    }

    for (int i = 2; i*i <= n; i++) {
        if (isPrime[i]) {
            for (int j = 2*i; j <= n; j = j + i) {
                if (j % i == 0) {
                    isPrime[j] = false
                }
            }
        }
    }

    for (int i = 2; i < n; i++) {
        if (isPrime[i]) {
            println i
        }
    }
}

findPrimes(20) // 2, 3, 5, 7, 11, 13, 17, 19

//    for (int p=2; p*p<=n; p++)
//    {
//        // If prime[p] is not changed, then it is a prime
//        if (prime[p] == true)
//        {
//            // Update all multiples of p
//            for (int i=p*2; i<=n; i += p)
//                prime[i] = false;
//        }
//    }
//
//    // Print all prime numbers
//    for (int p=2; p<=n; p++)
//        if (prime[p])
//            cout << p << " ";
//}