package com.xiuuu.xiuuu.encrypt;

import java.math.BigInteger;
import java.util.Random;

public class DiffieHellman {

    
    private BigInteger generateRandomPrimeNumber() {
        BigInteger bi = BigInteger.probablePrime(1024, new Random());
        while(true) {
            if(returnPrime(bi)){
                return bi;
            }
            bi = BigInteger.probablePrime(1024, new Random());
        }
    }
    
    public boolean returnPrime(BigInteger number) {
        //check via BigInteger.isProbablePrime(certainty)
        if (!number.isProbablePrime(5))
            return false;

        //check if even
        BigInteger two = new BigInteger("2");
        if (!two.equals(number) && BigInteger.ZERO.equals(number.mod(two)))
            return false;

        //find divisor if any from 3 to 'number'
        for (BigInteger i = new BigInteger("3"); i.multiply(i).compareTo(number) < 1; i = i.add(two)) { //start from 3, 5, etc. the odd number, and look for a divisor if any
            if (BigInteger.ZERO.equals(number.mod(i))) //check if 'i' is divisor of 'number'
                return false;
        }
        return true;
    }
        
}
