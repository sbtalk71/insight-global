# Use the official Jenkins LTS image as the base
FROM jenkins/jenkins:jdk21

# Switch to the root user to install system-level tools
USER root

# Install tools like Git and Maven (example for Debian-based image)
RUN apt-get update && apt-get install -y git maven

# Switch back to the jenkins user
USER jenkins
