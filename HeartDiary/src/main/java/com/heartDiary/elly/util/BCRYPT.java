package com.heartDiary.elly.util;

import org.mindrot.jbcrypt.BCrypt;

public class BCRYPT {

    public static String hashpw(String loginPw) {
        return BCrypt.hashpw(loginPw, BCrypt.gensalt());
    }

    public static boolean checkpw(String loginPw, String hashedLoginPw) {
        return BCrypt.checkpw(loginPw, hashedLoginPw);
    }
}