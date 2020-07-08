package cn.gov.hebei.ylbzj.service.impl;

import cn.gov.hebei.ylbzj.dao.SysOperLogMapper;
import cn.gov.hebei.ylbzj.domain.SysOperLog;
import cn.gov.hebei.ylbzj.service.ISysOperLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志 服务层处理
 *
 */
@Service
public class SysOperLogServiceImpl implements ISysOperLogService
{
    @Autowired
    private SysOperLogMapper operLogMapper;

    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    @Override
    public void insertOperlog(SysOperLog operLog)
    {
        operLogMapper.insertOperlog(operLog);
    }


}
