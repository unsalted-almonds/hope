package com.shilin.hope.yama;

/**
 * Description:
 * <p>
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class CountPrimes {

    public int countPrimes(int n) {
        int res = 0;

        if (n < 2) {
            return res;
        }

        // Sieve of Eratosthenes
        // if false then it's prime
        boolean[] visited = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (visited[i])
                continue;

            int j = 2;
            while (i * j < n) {
                visited[i * j] = true;
                j++;
            }
        }

        for (int i = 2; i < visited.length; i++) {
            if (!visited[i]) res++;
        }

        return res;

    }


}

