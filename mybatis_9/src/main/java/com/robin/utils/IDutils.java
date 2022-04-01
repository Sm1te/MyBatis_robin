package com.robin.utils;





import org.junit.Test;

import java.util.UUID;


public class IDutils{
        public static String getId(){
                return UUID.randomUUID().toString().replaceAll("-", "");
        }

        @Test
        public void test(){
                String id = getId();
                System.out.println(id);
        }
}
