FROM maven:3.8.4-openjdk-17 AS builder
WORKDIR /app

# 先复制 pom 文件
COPY pom.xml .
COPY ./services/item-service/pom.xml ./services/item-service/


# 再复制源代码
COPY ./services/item-service/src ./services/item-service/src

# 构建
WORKDIR /app/services/item-service
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/services/item-service/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

