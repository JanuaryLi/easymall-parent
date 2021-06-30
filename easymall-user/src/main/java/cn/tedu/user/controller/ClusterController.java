package cn.tedu.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ClusterController {
    @Autowired
    private JedisCluster cluster;
    @RequestMapping("cluster")
    public String setAndGet(HttpServletRequest req,String key, String value){
        System.out.println(req.getRemoteAddr());
        cluster.set(key,value);//name wang,cluster怎么连redis
        //调用set命令?
        return cluster.get(key);
    }
}
