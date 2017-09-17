## Spring 事务

Spring 事务核心 API:
- PlatformTransactionManager：事务管理器，包含多个实现，可以为不同持久化框架提供不同实现。Spring Boot 中开启事务注解（@EnableTransactionManagement）后自动创建
- TransactionDefinition：事务定义
- TransactionStatus：维护，获取事务的各种状态

### declarative
Spring 声明式事务实现，分别使用以下方式实现事务：
- FactoryBean
- AspectJ
- Annotation 方式实现事务

### programmatic
Spring 编程式事务实现