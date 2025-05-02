# Microservices Sizing and Containerization Notes

## How to Right-Size & Identify Service Boundaries of Microservices?

### Domain-Driven Sizing
- Focus on business capabilities and domain boundaries
- Align services with business domains

### Event Storming Sizing
- Use collaborative workshop technique to model domains
- Identify aggregates and bounded contexts

## Why Containers Are Better Than VMs

- **Lightweight**: Containers are much quicker to create, restart, and destroy compared to VMs
- **Isolated environments**: Each container has its own isolated virtual network and environment, allowing different languages/runtimes per container
- **Portability**: When deploying to new environments, containers require minimal setup since all dependencies and libraries are included
    - Example: No need to install Java or Spring Boot separately as they're packaged within the container
    - Containers are self-contained packages with all required dependencies

## Container Concepts

### What is a Container?
A loosely isolated environment that allows building and running software packages. These packages (container images) include:
- Application code
- All dependencies required to run the application

### Software Containerization
An OS virtualization method used to deploy and run containers without requiring full virtual machines

## Docker Overview

Docker is a platform that implements containerization technology:
- Open-source platform
- Enables developers to automate deployment, scaling, and management of applications using containers

## Container Isolation Mechanisms

### Namespaces
- Provide isolated environments
- Each container runs with its own set of namespaces isolating:
    - Process IDs
    - Network interfaces
    - IPC resources
    - Hostnames

### Control Groups (cgroups)
- Provide resource management capabilities
- Allow administrators to control and limit:
    - CPU usage
    - Memory allocation
    - Disk I/O
    - Network bandwidth

## Docker Image Generation Methods

1. **Dockerfile**
    - Write a Dockerfile to define image contents

2. **Buildpacks**
    - Automated tools to generate Docker images from source code
    - Doesn't require writing a Dockerfile (but needs Docker Desktop installed)
    - Implementation:
        - Add image name configuration in pom.xml
        - Run: `mvn spring-boot:build-image`

3. **Google Jib**
    - Automated tool specifically for Java applications
    - Doesn't require Docker Desktop
    - Implementation:
        - Add image name configuration in pom.xml
        - Run: `mvn compile jib:dockerBuild`


## Docker Compose
A tool for defining and running multi-container applications.
```bash
docker compose up -d   # Start containers in detached mode
docker compose down    # Stop and remove containers
docker compose start   # Start existing containers
docker compose stop    # Stop running containers
```