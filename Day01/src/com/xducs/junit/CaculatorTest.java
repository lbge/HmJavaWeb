package com.xducs.junit;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 11:25
 */
public class CaculatorTest {

    public static void main(String[] args) {

        Caculator c = new Caculator();
        /*int result1 = c.add(1, 2);
        System.out.println(result1);*/
        int sub = c.sub(9, 5);
        System.out.println(sub);
    }
}
