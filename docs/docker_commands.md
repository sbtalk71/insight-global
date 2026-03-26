# Essential Docker Commands

## 1. Docker Installation and Version
- Check Docker version:
   
  ```sh 
  docker --version 
  ```
   
- Check detailed Docker information:
   
  ```sh 
  docker info
   ```

## 2. Working with Docker Images
- List all available images:
   ```sh
  docker images
   ```
- Pull an image from Docker Hub:
   ```sh
  docker pull <image_name>
   ```
- Remove an image:
   ```sh
  docker rmi <image_id>
   ```

## 3. Working with Docker Containers
- List running containers:
   ```sh
  docker ps
   ```
- List all containers (including stopped ones):
   ```sh
  docker ps -a
   ```
- Run a container interactively:
   ```sh
  docker run -it <image_name> /bin/bash
   ```
- Run a container in detached mode:
  ```sh 
  docker run -d <image_name>
   ```
- Stop a running container:
   ```sh
  docker stop <container_id>
   ```
- Start a stopped container:
   ```sh
  docker start <container_id>
   ```
- Restart a container:
   ```sh
  docker restart <container_id>
   ```
- Remove a container:
   ```sh
  docker rm <container_id>
   ```

## 4. Docker Logs and Monitoring
- View container logs:
   ```sh
  docker logs <container_id>
   ```
- View running processes inside a container:
   ```sh
  docker top <container_id>
   ```
- View real-time container resource usage:
   ```sh
  docker stats
   ```
- Inspect detailed container information:
   ```sh
  docker inspect <container_id>
   ```

## 5. Docker Networking
- List all networks:
   ```sh
  docker network ls
   ```
- Create a network:
   ```sh
  docker network create <network_name>
   ```
- Connect a container to a network:
   ```sh
  docker network connect <network_name> <container_id>
   ```
- Disconnect a container from a network:
   ```sh
  docker network disconnect <network_name> <container_id>
   ```

## 6. Docker Volumes and Storage
- List all volumes:
   ```sh
  docker volume ls
   ```
- Create a volume:
   ```sh
  docker volume create <volume_name>
   ```
- Remove a volume:
   ```sh
  docker volume rm <volume_name>
   ```
- Use a volume in a container:
   ```sh
  docker run -v <volume_name>:/path/in/container <image_name>
   ```

## 7. Docker Compose
- Start services defined in `docker-compose.yml`:
   ```sh
  docker-compose up -d
   ```
- Stop services:
   ```sh
  docker-compose down
   ```
- Restart services:
   ```sh
  docker-compose restart
   ```
- View logs of services:
   ```sh
  docker-compose logs
   ```

## 8. Docker Build and Tagging
- Build an image from a Dockerfile:
   ```sh
  docker build -t <image_name> .
   ```
- Tag an image:
   ```sh
  docker tag <image_name> <repository_name>:<tag>
   ```
- Push an image to Docker Hub:
   ```sh
  docker push <repository_name>:<tag>
   ```
- Remove dangling images:
   ```sh
  docker image prune
  ``` 

## 9. Docker System Cleanup
- Remove all stopped containers:
   ```sh
  docker container prune
   ```
- Remove all unused networks:
   ```sh
  docker network prune
   ```
- Remove all unused images:
   ```sh
  docker image prune -a
   ```
- Remove all unused volumes:
   ```sh
  docker volume prune
   ```
- Remove all unused resources:
   ```sh
  docker system prune -a
   ```

These commands will help you efficiently manage Docker containers, images, networks, and volumes.
