package cn.tedu.user.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Sharded;

@Component
public class RedisUtils {
        @Autowired
        private ShardedJedisPool pool;
        //对jedis的方法做二次封装
    //新增或更改数据
    public void addOrUpdata(String key,String value){
        ShardedJedis jedis = pool.getResource();
        try{
            jedis.set(key,value);
        }catch(Exception e){
            //异常逻辑
        }finally {
            pool.returnResource(jedis);
        }
    }
}
