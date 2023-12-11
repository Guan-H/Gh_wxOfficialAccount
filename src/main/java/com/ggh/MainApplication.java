package com.ggh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 主类（项目启动入口）
 *
 * @author <a href="https://github.com/liyupi">程序员鱼皮</a>
 * @from <a href="https://yupi.icu">编程导航知识星球</a>
 */
// todo 如需开启 Redis，须移除 exclude 中的内容
@SpringBootApplication(exclude = {RedisAutoConfiguration.class})
@MapperScan("com.ggh.*.mapper")
@EnableScheduling
@EnableAspectJAutoProxy(proxyTargetClass = true, exposeProxy = true)
public class MainApplication {

    public static void main(String[] args) throws UnknownHostException {
//        SpringApplication.run(MainApplication.class, args);
        ConfigurableApplicationContext applicationContext = SpringApplication.run(MainApplication.class, args);
        ConfigurableEnvironment environment = applicationContext.getEnvironment();
        String hostName = InetAddress.getLocalHost().getHostAddress();

        String port = environment.getProperty("server.port");
        String path = environment.getProperty("server.servlet.context-path");
        if(StringUtils.isEmpty(path)){
            path ="";
        }
        // log.info("\n访问地址：http://{}:{}{}",hostName,port,path);
        System.out.println("--------------------------------------------------------");
        System.out.println("\t\t本地访问地址：http://localhost"+":"+port+path);
        System.out.println("\t\t访问地址：http://"+hostName+":"+port+path);
        System.out.println("\t\tSwagger: http://localhost:"+port+"/api/doc.html");
        System.out.println("--------------------------------------------------------");
    }

}
