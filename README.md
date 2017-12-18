# springboot-dubbo

## 如何使用
### 安装zookeeper

      wget https://mirrors.tuna.tsinghua.edu.cn/apache/zookeeper/zookeeper-3.4.11/zookeeper-3.4.11.tar.gz
      
      tar zxvf zookeeper-3.4.11.tar.gz
      
      cd zookeeper-3.4.11/conf/
      
      cp zoo_sample.cfg zoo.cfg
      
      ../bin/zkServer.sh start
      
修改dubbo-provider和dubbo-consumer中的配置,将spring.dubbo.registry.address设为安装的zookeeper地址
      
      
### 创建数据库
1. 执行study.sql中的脚本
2. 修改dubbo-provider数据库配置信息

### 启动服务
1. 启动ProviderApplication
2. 启动DubboConsumerApplication
3. 访问http://127.0.0.1:8081/swagger-ui.html
4. 访问http://127.0.0.1:8085/druid 可以查看数据库监控情况

