package com.xducs.service;

import com.xducs.domain.Province;

import java.util.List;

/**
 * @author Linbo Ge
 * @date 2020/3/22 - 15:25
 */
public interface ProvinceService {

    public List<Province> findAll();

    public String findAllByJson();
}
