package com.xuhuang.house.common;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * 加盐MD5解密
 */
public class HashUtil
{
    private static final HashFunction FUNCTION = Hashing.md5();

    private static final String SALT = "xuhuang.com";

    public static String encrypt(String str)
    {
        HashCode hashCode = FUNCTION.hashString(str + SALT, Charset.forName("UTF-8"));
        return hashCode.toString();
    }

}
