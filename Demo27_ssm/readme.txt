需求:查询所有的商品展示在页面

一.环境搭建
    1.导入jar 复制
    2.配置文件
        dao
            applicatioinContext-dao.xml
              1)可以引入外db.properties
              2)配置数据库连接池
              3)SqlSessionFactoryBean  工厂对象 (注入连接池, 加载文件)
              4)MapperScannerConfig..扫描 (加载映射文件,创建Mapper代理对象)

            sqlMapConfig.xml
                空

            ItemMapper.xml  映射文件
                空


        service
            applicationContext-service.xml
                1)包扫描 只扫描  com.itheima.service


            applicationContext-transaction.xml
                1)平台事务管理器 DataSourceTransactionManager 注入连接池对象
                2)通知 -- 属性和方法--设置隔离级别  传播行为..
                3)aop
                    切点
                    通知增强切点



        controller
             springmvc.xml
                1)包扫描  com.itheima.controller
                2)三大组件


        基础配置文件
            db.properties
            log4j.properties

        web.xml
            1)前端控制器  DispatcherServlet
                init-param 指定加载springmvc.xml的位置
                load-on-startup  加载时机  2

            2)监听器 作用:监听加载spring配置文件,只加载一次
                cotext-param 执行 spring配置文件的目录




     配置没有问题:启动tomcat  hello...