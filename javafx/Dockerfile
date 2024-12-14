FROM openjdk:21-jdk-slim

RUN apt-get update && apt-get install -y \
    maven \
    libgl1-mesa-glx \
    libgtk-3-0 \
    wget \
    unzip \
    xvfb \
    x11vnc \
    fluxbox

WORKDIR /app

COPY pom.xml .

RUN mvn package

COPY resources /app/resources
COPY src /app/src

RUN wget https://download2.gluonhq.com/openjfx/23.0.1/openjfx-23.0.1_linux-x64_bin-sdk.zip && \
    unzip openjfx-23.0.1_linux-x64_bin-sdk.zip -d /opt/javafx && \
    rm openjfx-23.0.1_linux-x64_bin-sdk.zip

COPY target/email-marketing-0.0.1-SNAPSHOT-jar-with-dependencies.jar /app/app.jar

ENV DISPLAY=:99

EXPOSE 5900

ENV JAVAFX_HOME=/opt/javafx-sdk
ENV PRISM_VERBOSE=true
ENV JAVAFX_DISABLE_NATIVE_FULLSCREEN=true
ENV DISPLAY=:0


CMD ["sh", "-c", "Xvfb :99 -screen 0 1920x1080x24 & sleep 2 && fluxbox & x11vnc -display :99 -nopw -forever & java --module-path /opt/javafx/javafx-sdk-23.0.1/lib --add-modules javafx.controls,javafx.fxml -jar app.jar"]
