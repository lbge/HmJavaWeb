package com.xducs.test;

import com.xducs.domain.User;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

/**
 * @author Linbo Ge
 * @date 2020/3/13 - 17:16
 */
public class BeanUtilsTest {
    @Test
    public void test() {
        User user = new User();
        try {
            BeanUtils.setProperty(user,"username","zhangsan");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(user);
    }
}
