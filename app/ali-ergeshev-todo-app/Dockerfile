# ---------- build stage ----------
FROM eclipse-temurin:17-jdk AS builder
WORKDIR /app

# копируем только то, что нужно для dependency cache
COPY gradlew .
COPY gradle gradle
COPY build.gradle settings.gradle ./
RUN chmod +x gradlew && ./gradlew --no-daemon -v

# теперь копируем исходники и собираем
COPY . .
RUN ./gradlew --no-daemon clean build

# ---------- runtime stage ----------
FROM eclipse-temurin:17-jre
WORKDIR /app

RUN useradd -r -u 10001 appuser
COPY --from=builder /app/build/libs/*.jar /app/app.jar
RUN chown -R appuser:appuser /app
USER appuser

EXPOSE 8080
HEALTHCHECK --interval=15s --timeout=3s --start-period=20s --retries=5 \
  CMD wget -qO- http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["java","-jar","/app/app.jar"]
