package com.xducs.test;

import com.xducs.junit.Caculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Linbo Ge
 * @date 2020/2/26 - 11:33
 */
public class CacularTest {
    /**
     * 初始化方法
     */

    @Before
    public void init(){
        System.out.println("init....");
    }

    @After
    public void close(){
        System.out.println("close...");
    }
    @Test
    public void testAdd() {
        Caculator c = new Caculator();
        int result1 = c.add(1, 2);
        Assert.assertEquals(3, result1);
    }

    @Test
    public void testSub() {
        Caculator c = new Caculator();
        int sub = c.sub(6, 2);
        System.out.println("sub...");
        Assert.assertEquals(4, sub);
    }
}
