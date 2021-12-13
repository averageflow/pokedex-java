# Pokedex Java

Pokedex implementation with Java Spring Boot and Thymeleaf HTML templates. Using [the PokeAPI](https://pokeapi.co/).

![Demo screenshot of the application](https://i.ibb.co/3cVFqrF/Schermafdruk-2021-12-13-15-05-49.png)

## Deploying to Kubernetes

```sh
minikube start
eval $(minikube docker-env)
docker build -t pokedex-java .
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