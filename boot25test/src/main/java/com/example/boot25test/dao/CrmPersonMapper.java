package com.example.boot25test.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.boot25test.pojo.CrmPerson;
import org.springframework.stereotype.Repository;

@Repository
public interface CrmPersonMapper extends BaseMapper<CrmPerson> {
}
