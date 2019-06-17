
# Java API Programming Challenge

​Small ​Spring Boot ​RESTful Service in Java using the [What3Words](https://www.what3words.com/) API in order to retrieve information about a given set of What3Words.
It uses the [Java Wrapper](https://docs.what3words.com/wrapper/java/) suggested on the documentation.

## Usage

Run the application from your IDE as a simple Java application, or run from the Terminal using Gradle:

```bash
$ gradle bootRun
```

Open `http://localhost:8080/what3words/` in your browser to retrieve the Json coordinates and information of the What3Words "silk.slap.soils", "zealous.range.garage", "slurs.this.shark", or from the Terminal:

```bash
$ curl http://localhost:8080/what3words/
```

The application can also return the coordinates of a specific What3Words combination:


```bash
$ curl http://localhost:8080/what3words/silk.slap.soils
```
