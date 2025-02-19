FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app

# 复制必要文件
COPY pom.xml .
COPY service-registry/pom.xml service-registry/
COPY service-registry/src service-registry/src/

# 修改为直接在模块目录下构建
WORKDIR /app/service-registry
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/service-registry/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]