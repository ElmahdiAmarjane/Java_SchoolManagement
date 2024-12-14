# Use a lightweight OpenJDK image
FROM openjdk:23-jdk-slim

# Set the working directory
WORKDIR /app

# Install required dependencies for JavaFX, Xvfb, and VNC
RUN apt-get update && \
    apt-get install -y libgl1-mesa-glx libgtk-3-0 wget unzip xvfb x11vnc fluxbox && \
    rm -rf /var/lib/apt/lists/*  # Clean up to reduce image size

# Download and unzip JavaFX SDK
RUN wget https://download2.gluonhq.com/openjfx/23.0.1/openjfx-23.0.1_linux-x64_bin-sdk.zip && \
    unzip openjfx-23.0.1_linux-x64_bin-sdk.zip -d /opt/javafx && \
    rm openjfx-23.0.1_linux-x64_bin-sdk.zip

# Copy MySQL connector JAR into the container
COPY libs/mysql-connector-j-9.0.0.jar /app/libs/mysql-connector-java.jar

# Copy the application JAR into the container
COPY gestion.jar /app/app.jar

# Set the environment variable for DISPLAY
ENV DISPLAY=:99

# Expose VNC port for debugging GUI if needed
EXPOSE 5900

# Start Xvfb, VNC server, and run the JavaFX application
CMD ["sh", "-c", "Xvfb :99 -screen 0 1280x720x24 & fluxbox & x11vnc -display :99 -nopw -forever & \
     java --module-path /opt/javafx/javafx-sdk-23.0.1/lib \
          --add-modules javafx.controls,javafx.fxml \
          --add-opens javafx.graphics/com.sun.javafx.fxml=ALL-UNNAMED \
          --add-opens javafx.graphics/com.sun.javafx.util=ALL-UNNAMED \
          --add-opens javafx.base/com.sun.javafx.reflect=ALL-UNNAMED \
          -cp /app/app.jar:/app/libs/mysql-connector-java.jar \
          -jar /app/app.jar"]
