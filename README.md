## Workshop Setup
This branch can be used to check that you have correctly installed everything that you need for the workshop.



### Java
You will need Java 17 with GraalVM to run this workshop.
Optionally, you can also use Java 8 with earlier parts of the workshop as long as you can switch to Java 17 easily.

We recommend using SDKMAN! to manage installed Java versions, but you're free to use whatever you prefer as long as Java 17 is available.



#### SDKMAN!
The following instructions can be used if you are using SDKMAN!

1. Install SDKMAN! for your system by following instructions at https://sdkman.io/
2. Install Java 8 by typing `sdk install java 8.0.362-librca`
3. Install Java 17 by typing `sdk install java 22.3.r17-nik`

Check that you can use Java 8

```shell
$ sdk use java 8.0.362-librca
$ java -version
openjdk version "1.8.0_362"
OpenJDK Runtime Environment (build 1.8.0_362-b09)
OpenJDK 64-Bit Server VM (build 25.362-b09, mixed mode)
```

Check that you can use Java 17

```shell
$ sdk use java 22.3.r17-nik
$ java -version
openjdk version "17.0.5" 2022-10-18 LTS
OpenJDK Runtime Environment GraalVM 22.3.0 (build 17.0.5+8-LTS)
OpenJDK 64-Bit Server VM GraalVM 22.3.0 (build 17.0.5+8-LTS, mixed mode, sharing)
```

Check that you can use GraalVM

```shell
$ native-image --version
GraalVM 22.3.0 Java 17 CE (Java Version 17.0.5+8-LTS)
```



#### Without SDKMAN!
If you prefer not to use SKDMAN! you can install Java and GraalVM whichever way you're most comfortable.
As long as you have Java 17 and the `native-image` tool install, you should be fine.

Please check your installation by checking the output of `java -version` and `native-image --version`:

```shell
$ java -version
openjdk version "17.0.5" 2022-10-18 LTS
OpenJDK Runtime Environment GraalVM 22.3.0 (build 17.0.5+8-LTS)
OpenJDK 64-Bit Server VM GraalVM 22.3.0 (build 17.0.5+8-LTS, mixed mode, sharing)

$ native-image --version
GraalVM 22.3.0 Java 17 CE (Java Version 17.0.5+8-LTS)
```

If you get an error saying that `native-image` is not found, e.g.:

```
command not found: native-image
```

This might not be a big problem, it might only mean that your GraalVM installation does not have `native-image` pre-installed. Try to install it with the GraalVM Updater:

```shell
$ gu install native-image
```

And check the version again:

```shell
$ native-image --version
```



### Maven
This workshop uses `mvnw` so you shouldn't need to install Maven directly.

To check that Maven works run the following command from this directory.

On Linux/Mac

```shell
$ ./mvnw --version
```

On Windows

```shell
$ mvnw.cmd --version
```

If you want to ensure your local Maven cache has most of the files we'll need, you can build the pom files in this directory:

```shell
$ ./mvnw package
```

You should see a "success" message after these command:
```
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
```



### Docker Compose
We will be using Docker Compose to setup run things like Postgres which we will need for the workshop.
We recommend Docker Desktop if possible, but any Docker installation that can run `docker compose` should work fine.

Docker Desktop is free for educational purposes.

Please install Docker from https://www.docker.com or using your favorite open source distribution.

To check docker is running, you can run:

```shell
$ docker run --rm hello-world
```

To check docker compose is working, run the following from this directory:

```shell
$ docker compose -f docker-compose-hello.yml up
```

Once you see the "hello world" output, you can destroy the containers using:

```shell
$ docker compose -f docker-compose-hello.yml down
```

TIP: Depending on your installation, you might need to use the command `docker-compose` rather than `docker compose`.

If the hello world example works, then you can try starting the full docker compose configuration that we'll be using:

```shell
$ docker compose up
```

NOTE: it will take some time to initially start the containers

Check that the following links work:

http://localhost:9090 (Prometheus)
http://localhost:3000 (Grafana)

If everything works you can hit `ctrl-c` to stop docker compose and you can destroy the containers using:

```shell
$ docker compose down
```



### HTTPie
We'll need to make some REST calls to our application.
You can use whatever tool you like, but if you have no preference we recommend HTTPie.

You can install it from https://httpie.io/



### IDE
You can use any Java IDE you like to work with the code, just check that it can work with Maven projects.

Please import the `dog-service` project.
