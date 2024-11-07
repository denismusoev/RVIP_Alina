FROM openjdk:17-oracle

ADD target/RVIP-lab1-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "-Dspring.profiles.active=dev", "/app/RVIP-lab1-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
