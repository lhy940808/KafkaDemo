# KafkaDemo
kafka消息队列的java应用

master分支是搭建了最简单的springboot的一个web入门程序，集成了mybatis框架，可作为最简单的demo直接使用
其他分支都是基于master分支拉取的，保证master分支是一个最干净的分支，
dev分支用来列举其他方面的东西，如消息队列

####feature-fenkufenbiao 
该分支用来实现分库分表的功能

####遇到的问题
刚开始没注意用mybatis插件生成的mapper配置文件，sql里用的全是b_member0这个表名，应该使用
逻辑表名 也就是tb_member，否则会报错Missing the data source name:null  猜测是这样配置无法满足映射规则

