package cn.gov.hebei.ylbzj.util;

import lombok.Synchronized;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.LongAdder;

@Component
public class Counter {



    private static LongAdder count=new LongAdder();

    /* *//**
     * 初始化计数器
     *//*
    public Counter(@Autowired ISysCountService sysCountService) {
        count.add(new Long(sysCountService.selectCount()));

    }*/

    public Counter() {
        count.reset();
    }

    /**
     * 计数器自增
     */
    public  void incrCount() {
        count.increment();
    }


    /**
     * 初始化
     */
    public void initCount(){
        count.reset();
    }
    /**
     * 计算和
     */
    public long getCountSum(){

        return   count.sum();
    }

    @Synchronized
    public long getCountSumAndInit(){
        long finCount= count.sum();
        count.increment();
        System.out.println(finCount);
        return finCount;
    }

}
