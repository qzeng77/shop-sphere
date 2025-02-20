📌 ShopSphere 项目架构（微服务架构）
本项目是一个 基于 Spring Boot + Spring Cloud 的微服务架构，包括 5 个主要服务 和 基础设施，如下：

🌍 项目整体架构
```plaintext
                           ┌──────────────────┐
                           │  API Gateway     │
                           │  (Spring Cloud)  │
                           └────────▲─────────┘
                                    │
 ┌───────────────────┬───────────────────┬───────────────────┐
 │  Account Service  │    Order Service  │  Payment Service  │
 │  (MySQL/Postgre)  │   (Cassandra)     │   (PostgreSQL)    │
 └───────────────────┴───────────────────┴───────────────────┘
          │                        │                    │
          ▼                        ▼                    ▼
 ┌───────────────────┐    ┌───────────────────┐    ┌───────────────────┐
 │  Item Service     │    │  Auth Service     │    │  Event Processing │
 │  (MongoDB)        │    │  (JWT + Security) │    │  (Kafka)          │
 └───────────────────┘    └───────────────────┘    └───────────────────┘

```
📂 目录结构
```plaintext
ShopSphere/
│── api-gateway/         # API 网关（Spring Cloud Gateway）
├── service-registry/     # 服务注册中心
├── config-server/        # 配置中心
│── services/
│   ├── account-service/ # 账号管理（Spring Boot + MySQL）
│   ├── order-service/   # 订单管理（Spring Boot + Cassandra + Kafka）
│   ├── payment-service/ # 支付管理（Spring Boot + PostgreSQL）
│   ├── item-service/    # 商品管理（Spring Boot + MongoDB）
│   ├── auth-service/    # 认证授权（Spring Security + JWT）
│── common/              # 公共库（DTO, Utils, Feign Client）
│── infrastructure/
│   ├── database/        # 数据库初始化 SQL/配置
│   ├── kafka/           # Kafka 配置
│── docker/              # Docker 配置
│── deployment/          # 部署配置（Docker Compose, Kubernetes）
│── docs/                # 文档
│── .gitignore
│── README.md
│── docker-compose.yml   # 一键启动所有服务
│── pom.xml              # Maven 项目管理

```

🛠 关键技术栈
```plaintext
组件	          技术
开发框架	     Spring Boot 3, Spring Cloud
API 管理	     Spring Cloud Gateway, Swagger
数据库  	     PostgreSQL, MySQL, MongoDB, Cassandra
服务通信	     Spring Cloud OpenFeign, RestTemplate
事件驱动架构	 Kafka
身份认证	     Spring Security, JWT
容器化	       Docker, Docker Compose
单元测试	     JUnit, Mockito, PowerMock, Jacoco
日志 & 监控	 ELK (Elasticsearch, Logstash, Kibana), Prometheus
CI/CD	       GitHub Actions, Jenkins
```


🚀 服务拆分
```plaintext
1️⃣ API Gateway
负责 路由转发 和 身份认证
依赖 Spring Cloud Gateway
2️⃣ Account Service
用户管理：注册、登录、修改信息
认证方式：Spring Security + JWT
数据存储：PostgreSQL / MySQL
3️⃣ Item Service
负责 商品信息管理
存储 商品元数据
由于商品数据结构多变，使用 MongoDB
4️⃣ Order Service
负责 订单创建、更新、查询
订单状态：Created -> Paid -> Completed
采用 Cassandra（支持高并发读写）
通过 Kafka 进行异步消息通知（如订单支付成功）
5️⃣ Payment Service
负责 支付事务处理
需保证 幂等性（避免重复支付）
存储支付信息到 PostgreSQL
通过 Kafka 通知订单状态变更
6️⃣ Auth Service
处理 用户认证
采用 Spring Security + JWT
生成 OAuth2 Token
```
