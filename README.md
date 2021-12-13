# Pokedex Java
Pokedex implementation with Java Spring Boot and Thymeleaf HTML templates. Using [the PokeAPI](https://pokeapi.co/).

![Demo screenshot of the application](https://i.ibb.co/3cVFqrF/Schermafdruk-2021-12-13-15-05-49.png)


### Technologies used
This project was built using:

* Java 17
* Spring Boot Framework
* Gradle
* PokeAPI

## Running the application
To kickstart the application and all dependencies required for its operation, you should be running on a machine with
Docker installed. Clone the project, or download the zip file with the source code
from [the releases page](https://github.com/averageflow/pokedex-java/releases) page.
Then all you need is to run `docker-compose up`, optionally `docker-compose up -d` for daemon behaviour.

### Running for development
IntelliJ IDEA is recommended for this project. Launch configurations for this project are available in the `.run` folder. Gradle will need to be installed. You can start it with `./gradlew bootRun`.


## Unit tests
You can run the unit tests for this project if you have Java 17 and Gradle installed, by at the root of the project
executing:
```sh
./gradlew test
```

The unit tests will also be run every time the Docker image is rebuilt.

## Deploying to Kubernetes
I have used minikube to easily run a k8s cluster locally. Assuming `alias kubectl="minikube kubectl --"`.

```sh
minikube start
eval $(minikube docker-env)
docker build -t pokedex-java . --no-cache
kubectl apply -f deployment.yaml
minikube service pokedex-java-service
```

The minikube dashboard can be seen with:
```sh
minikube dashboard
```

All minikube clusters can be deleted with:
```sh
minikube delete --all
```