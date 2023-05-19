# PROFIT CALCULATOR

## Technical decisions

- Architectural

  Use some interfaces to make easier to scale the app and write tests more reliable.
  Use some constructor to inject service dependencies to guarantee immutability, easier expansion and more reliable tests.
  This code was writed the simple way but anyone can scale or add more usecases.

- Language Java

  Chose this language because the linear execution of thread is easier to understand and develop a simple application to calculate taxes and my professional experience.

- Package manager Maven

  Chose because my personal affinity.

- JSON Mapper

  Chose because its simple, light and affinity.

- Tests Junit 5

  Chose because its better lib to write and execute tests.

## Compile instructions

### Prerequisites

- Docker engine installed

### Execute

Firtly you will need access the folder

```
/nu-profit
```

After you will execute docker command to create a docker image

```
docker build -t nu-profit-1.0 .
```

Then you can run the docker container and create a container

```
docker run --name nu-profit-app -it -p 8080:8080 nu-profit-1.0
```

After executed the last command successfully you can start the container with interactive mode on any times you need.

```
docker start -i nu-profit-app
```

## Compile

The app its already in folder `/target`;
If you would like compile again, follow this steps:

- Install Maven, [Installation instructions](https://maven.apache.org/install.html)
- Install Java 17,[Installation instructions](https://openjdk.org/install/)
- Execute follow commands:

```
mvn install
```

```
mvn assembly:single
```

After you need execute docker steps [Execute](#execute)
