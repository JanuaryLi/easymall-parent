package cn.tedu.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Sharded;

import java.util.ArrayList;
import java.util.List;

/**
 * 实现连接池资源对象的配置类,相当于一个xml
 * 实现创建连接池对象,有容器来管理
 */
@Configuration
@ConfigurationProperties(prefix="redis")
public class ShardedJedisConfig {
    //准备几个私有属性,会自动去properties找
    //redis.属性名
    private List<String> nodes;//redis.nodes
    //10.9.104.184:6379,10.9.104.184:6380
    private Integer maxTotal;
    private Integer maxIdle;
    private Integer minIdle;
    //初始化一个bean对象
    @Bean
    public ShardedJedisPool initPool(){
        //利用属性读取的数据,创建参数
        //收集节点信息
        List<JedisShardInfo> info=new ArrayList<>();
        for(String node:nodes){
            //node="10.9.104.184:6379"
            String host=node.split(":")[0];
            int port=Integer.parseInt(node.split(":")[1]);
            info.add(new JedisShardInfo(host,port));
        }
        //创建配置对象config
        JedisPoolConfig config=new JedisPoolConfig();
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            config.setMinIdle(minIdle);
        return new ShardedJedisPool(config,info);
    }
    //添加getter setter方法
    public List<String> getNodes() {
        return nodes;
    }

    public void setNodes(List<String> nodes) {
        this.nodes = nodes;
    }

    public Integer getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(Integer maxTotal) {
        this.maxTotal = maxTotal;
    }

    public Integer getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }
}
