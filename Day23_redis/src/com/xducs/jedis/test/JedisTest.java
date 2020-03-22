package com.xducs.jedis.test;

import com.xducs.jedis.util.JedisPoolUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis测试类
 *
 * @author Linbo Ge
 * @date 2020/3/22 - 13:44
 */
public class JedisTest {
    @Test
    public void test1() {
        //1.获取链接
        Jedis jedis = new Jedis("localhost", 6379);
        //2.操作
        jedis.set("username", "zhangsan");
        //3.释放
        jedis.close();
    }

    @Test
    public void test2() {
        //1.获取链接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.set("username", "zhangsan");
        String username = jedis.get("username");
        System.out.println(username);

        jedis.setex("code", 20, "haha");
        //3.释放
        jedis.close();
    }

    @Test
    public void test3() {
        //1.获取链接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.hset("user", "name", "lisi");
        jedis.hset("user", "age", "23");
        jedis.hset("user", "gender", "male");
        String name = jedis.hget("user", "name");
//        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");
        Set<String> keySet = user.keySet();
        for (String key : keySet) {
            String value = user.get(key);
            System.out.println(key + ":" + value);
        }
        //3.释放
        jedis.close();
    }

    @Test
    public void test4() {
        //1.获取链接
        Jedis jedis = new Jedis();
        //2.操作
       jedis.lpush("myList","a","b","c");
       jedis.rpush("myList","A","B","C");
        List<String> myList = jedis.lrange("myList", 0, -1);
        System.out.println(myList);
        String element1 = jedis.lpop("myList");
        System.out.println(element1);
        String element2 = jedis.rpop("myList");
        System.out.println(element2);
        //3.释放
        jedis.close();
    }
    @Test
    public void test5() {
        //1.获取链接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.sadd("mySet","java","php","c++");
        Set<String> mySet = jedis.smembers("mySet");
        System.out.println(mySet);

        jedis.setex("code", 20, "haha");
        //3.释放
        jedis.close();
    }
    @Test
    public void test6() {
        //1.获取链接
        Jedis jedis = new Jedis();
        //2.操作
        jedis.zadd("mySortset",2,"亚瑟");
        jedis.zadd("mySortset",3,"后羿");
        jedis.zadd("mySortset",0,"异星");

        Set<String> mySortset = jedis.zrange("mySortset", 0, -1);

        System.out.println(mySortset);

        //3.释放
        jedis.close();
    }

    /**
     * jedis连接池
     */
    @Test
    public void test7(){
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(50);
        config.setMaxIdle(10);
        //1.创建对象
        JedisPool jedisPool = new JedisPool(config,"localhost",6379);
        //2.获取链接
        Jedis jedis = jedisPool.getResource();
        //3.使用
        jedis.set("haha","heihei");
        //4.关闭，归还到连接池
        jedis.close();
    }

    /**
     * 连接池工具类测试
     */
    @Test
    public void test8(){
        Jedis jedis = JedisPoolUtils.getJedis();
        jedis.set("hello","world");
    }
}
