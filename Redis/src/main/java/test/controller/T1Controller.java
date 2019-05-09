package test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import test.dao.RedisDao;
/**
 * Redis + SpringMVC 配置（Jedis 框架）
 * @author ht_z
 *
 */
@Controller
@RequestMapping("/t1")
public class T1Controller
{
    @Autowired
    private RedisDao redisDao;
    
    @ResponseBody
    @RequestMapping("/tt")
    public String tt() {
        
        for(int i=0;i<100;i++) {
            redisDao.set("hello #" + i, "jarod zhao #" + i);
        }
        return "tt";
    }
    
}
