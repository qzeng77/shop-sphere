FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app

# 先复制 pom 文件
COPY pom.xml .
COPY ./services/order-service/pom.xml ./services/order-service/

# 再复制源代码
COPY ./services/order-service/src ./services/order-service/src

# 构建
WORKDIR /app/services/order-service
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/services/order-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

