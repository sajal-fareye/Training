FROM openjdk:8

# Set the working directory to /app
RUN mkdir /app
WORKDIR /app

# Copy the current directory contents into the container at /app
ADD . /app
COPY ./target/training-0.0.1-SNAPSHOT.jar /app/training-0.0.1-SNAPSHOT.jar

# Make ports available to the world outside this container
EXPOSE 8080 443 8126 8125 8082

#RUN mkdir -p /app/logs/tracklogs
#RUN mkdir -p /app/logs/logs
#RUN mkdir -p /app/logs/exlogs
#RUN mkdir -p /app/logs/dnalogs
RUN wget -N https://download.newrelic.com/newrelic/java-agent/newrelic-agent/current/newrelic-java.zip

RUN unzip newrelic-java.zip -d /app/
RUN mkdir /app/config
RUN touch /app/config/newrelic.yml
RUN ln -sf  /app/config/newrelic.yml /app/newrelic/newrelic.yml
#CMD java -jar /app/fareye-mobi-0.1-SNAPSHOT.war --spring.profiles.active=prod --app.jspritRunSize=200 --app.jspritThreadCount=1 --app.matrixBufferTimeInSecond=25
#ENTRYPOINT ["sh","-c","exec java -javaagent:/app/newrelic/newrelic.jar -jar /app/fareye-mobi-0.1-SNAPSHOT.war -Dserver.tomcat.basedir=/mobi_workdir --app.jspritRunSize=200 --app.jspritThreadCount=1 --app.matrixBufferTimeInSecond=25"]
ENTRYPOINT ["sh","-c","exec java -javaagent:/app/newrelic/newrelic.jar -jar /app/training-0.0.1-SNAPSHOT.jar --server.tomcat.protocol-header=x-forwarded-proto"]
CMD [--spring.profiles.active=prod]