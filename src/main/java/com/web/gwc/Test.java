package com.web.gwc;

import com.web.gwc.util.Encryption;
import com.web.gwc.util.HibernateUtil;
import org.hibernate.SessionFactory;

public class Test {
    public static void main(String[] args) {
     // HibernateUtil.getSessionFactory();
String encrypt = Encryption.encrypt("pakaya");
        System.out.println(encrypt);

    }
}
