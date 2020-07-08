package cn.gov.hebei.ylbzj.service.impl;

import cn.gov.hebei.ylbzj.dao.SysCountMapper;
import cn.gov.hebei.ylbzj.service.ISysCountService;
import cn.gov.hebei.ylbzj.util.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 系统访问日志情况信息 服务层处理
 *
 */
@Service
public class SysCountrServiceImpl implements ISysCountService {


    @Autowired
    private SysCountMapper sysCountMapper;
    @Autowired
    private Counter counter;


    @Async
    @Override
    public  void updateCount(long count) {

            if(count>0){
                sysCountMapper.updateCount(counter.getCountSumAndInit());
            }
            counter.initCount();
    }

    @Override
    public int selectCount() {
        return sysCountMapper.selectCount();
    }
}
