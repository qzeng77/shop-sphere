FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app

# 先复制 pom 文件
COPY pom.xml .
COPY ./services/account-service/pom.xml ./services/account-service/

# 再复制源代码
COPY ./services/account-service/src ./services/account-service/src

# 构建
WORKDIR /app/services/account-service
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/services/account-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

