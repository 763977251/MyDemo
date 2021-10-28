package com.shang.springsecuritydemo.service.impl;

import com.shang.springsecuritydemo.entity.SysPermission;
import com.shang.springsecuritydemo.mapper.SysPermissionMapper;
import com.shang.springsecuritydemo.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 权限表(SysPermission)表服务实现类
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl implements SysPermissionService {
    @Resource
    private SysPermissionMapper sysPermissionMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysPermission queryById(Integer id) {
        return this.sysPermissionMapper.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysPermission> queryAllByLimit(int offset, int limit) {
        return this.sysPermissionMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermission insert(SysPermission sysPermission) {
        this.sysPermissionMapper.insert(sysPermission);
        return sysPermission;
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysPermission update(SysPermission sysPermission) {
        this.sysPermissionMapper.update(sysPermission);
        return this.queryById(sysPermission.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysPermissionMapper.deleteById(id) > 0;
    }

    @Override
    public List<SysPermission> selectListByUser(Integer userId) {
        return sysPermissionMapper.selectListByUser(userId);
    }

    @Override
    public List<SysPermission> selectListByPath(String path) {
        return sysPermissionMapper.selectListByPath(path);
    }
}