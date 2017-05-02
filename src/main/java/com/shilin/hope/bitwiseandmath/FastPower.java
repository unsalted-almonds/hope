package com.shilin.hope.bitwiseandmath;

public class FastPower {
	
	// this is a good class of breaking up problems into smaller pieces by using recurrsions
	// requires some quality thinking 
	
    /*
     * @param a, b, n: 32bit integers
     * @return: An integer
     */

    
    public int fastPower(int a, int b, int n) {
        // write your code here
        if (a < 0 || b <= 0 || n < 0) {
            return -1;
        }

        
        return (int)mod(a, b, n);
        
    }
    
    private long mod(int a, int b, int n) {
        if (n == 0) {
            return 1 % b;
        } else if (n == 1){
            return a % b;
        }else {
            long halfMod = mod(a, b, n/2);
            
            long res = (halfMod*halfMod)%b;
            if (n % 2 != 0 ){
                res = (res * a)%b;
            }
            
            return res;
        }

        
    }
}
