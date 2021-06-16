package com.example.boot25test.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.boot25test.dao.SysUserMapper;
import com.example.boot25test.pojo.SysUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> {
}
