# poc-docker-springboot-helloworldip
Simple, dockerized spring boot service that prints hello world, along with the hosts IP address and other info.

### Run and test locally
mvn package && java -jar target/poc-docker-springboot-helloworldip-1.0.0-SNAPSHOT.jar

go to http://localhost:8080

### Build the Docker image then push to DockerHub
mvn package docker:build

You may need to initialize the environment, if so:

eval "$(docker-machine env default)"

docker push tfritz/poc-docker-springboot-helloworldip

### Run the Docker Container
docker run -p 8080:8080 -t tfritz/poc-docker-springboot-helloworldip