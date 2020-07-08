package cn.gov.hebei.ylbzj.job;

import cn.gov.hebei.ylbzj.service.ISysCountService;
import cn.gov.hebei.ylbzj.util.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *定时任务
 */
@Component
public class CountJob {

    @Autowired
    private Counter counter;

    @Autowired
    private ISysCountService sysCountService;

    @Scheduled(cron = "*/5 * * * * ? ")
    public void syncSave(){

        if(counter.getCountSum()>0){
            System.out.println("定时保存");

                sysCountService.updateCount(counter.getCountSum());

        }

    }


}
