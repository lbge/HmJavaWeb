package com.xducs.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xducs.dao.ProvinceDao;
import com.xducs.dao.impl.ProvinceDaoImpl;
import com.xducs.domain.Province;
import com.xducs.jedis.util.JedisPoolUtils;
import com.xducs.service.ProvinceService;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/3/22 - 15:26
 */
public class ProvinceServiceImpl implements ProvinceService {
    ProvinceDao dao = new ProvinceDaoImpl();
    @Override
    public List<Province> findAll() {
       
        return dao.findAll();
    }

    @Override
    public String findAllByJson() {

        Jedis jedis = JedisPoolUtils.getJedis();
        String province_json = jedis.get("province");
        if (province_json == null || province_json.length() == 0){
            System.out.println("redis中没数据");
            List<Province> ps = dao.findAll();
            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json= mapper.writeValueAsString(ps);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            jedis.set("province",province_json);
            jedis.close();
        }else {
            System.out.println("redis中有数据");

        }
        return province_json;
    }
}
