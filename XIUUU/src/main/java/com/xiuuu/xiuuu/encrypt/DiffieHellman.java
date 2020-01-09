package com.xiuuu.xiuuu.encrypt;

import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellman {
    
    private static final SecureRandom rnd = new SecureRandom();
    
    public static BigInteger nextRandomBigInteger(BigInteger n) {
        BigInteger result = new BigInteger(n.bitLength(), rnd);
        while( result.compareTo(n) >= 0 ) {
            result = new BigInteger(n.bitLength(), rnd);
        }
        return result;
    }

}
