package cn.gov.hebei.ylbzj.controller;

import cn.gov.hebei.ylbzj.annotation.Log;
import cn.gov.hebei.ylbzj.constant.Constants;
import cn.gov.hebei.ylbzj.enums.BusinessType;
import cn.gov.hebei.ylbzj.factory.AsyncFactory;
import cn.gov.hebei.ylbzj.factory.AsyncManager;
import cn.gov.hebei.ylbzj.response.AjaxResult;
import cn.gov.hebei.ylbzj.service.ISysCountService;
import cn.gov.hebei.ylbzj.service.ISysLogininforService;
import cn.gov.hebei.ylbzj.util.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@RequestMapping("/default")
public class DefaultController {


    @Autowired
    private ISysLogininforService logininforService;


    @Autowired
    private ISysCountService sysCountService;

    @Autowired
    private Counter counter;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Log(title = "查询页面", businessType = BusinessType.OTHER)
    @RequestMapping("/index")
    public AjaxResult index() {

        long timeStart = new Date().getTime();
        //异步保存信息
        AsyncManager.me().execute(AsyncFactory.recordLogininfor("", Constants.LOGIN_SUCCESS, ""));
        long timeEnd = new Date().getTime();
        long diff = timeEnd - timeStart;
        int count = logininforService.selectLogininforCount();
        return new AjaxResult(AjaxResult.Type.SUCCESS, "访问次数:" + count);

    }


    @GetMapping("/count")
    public AjaxResult count() {
        counter.incrCount();
        return new AjaxResult(AjaxResult.Type.SUCCESS, "");
    }


    @GetMapping("/countSum")
    public AjaxResult countSum() {
        int count = sysCountService.selectCount();
        return new AjaxResult(AjaxResult.Type.SUCCESS, "访问次数合计:" + count);
    }



    @GetMapping("/rediscount")
    public String rediscount() {
        Long counter_key = redisTemplate.opsForValue().increment("counter_key");
        return String.format("您是第%d位访问此请求",counter_key);
    }

}
