## Sudoku RESTful Web Service

This project implements the backend of a Sudoku game as of a RESTful web service with Spring.
It can validate successive moves on a Sudoku board and to recognise and indicate if the Sudoku is finished.
This project implements a service that accepts HTTP GET with optional parameters.
The given Sudoku board and the solution are shown at the bottom.

## Requirements

* [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) or later
* [Maven 3.0+](http://maven.apache.org/download.cgi)

## Build with Maven

* [Welcome to Apache Maven](https://maven.apache.org/)
* [Building Java Projects with Maven](https://spring.io/guides/gs/maven/)

## Build and run the tests with Maven
 
 **mvn clean test**
 
## Run the service

* cd into project-root-folder using your terminal.

* Using Maven you can run the application using **mvn spring-boot:run**. 
  Or you can build an executable JAR file with **mvn clean package** and run the JAR by typing:

```  
  java -jar target/sudoku-1.0.0.jar
```  

## Test the service

Start the service and visit http://localhost:8080/sudoku, you will see the following response, with a JSON representation:

```
{"currentBoard":[[7,0,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],
[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],"isSolved":false}
```

##### You can supply three optional parametes (you must supply all or none):
* **num**: the candidate number on the Sudoku board.
* **row**: the row on the Sudoku board.
* **col**: the column on the Sudoku board.

For example visit http://localhost:8080/sudoku?num=9&row=0&col=1, you will see the following response:

```
{"currentBoard":[[7,9,0,0,4,0,5,3,0],[0,0,5,0,0,8,0,1,0],[0,0,8,5,0,9,0,4,0],[5,3,9,0,6,0,0,0,1],[0,0,0,0,1,0,0,0,5],[8,0,0,7,2,0,9,0,0],
[9,0,7,4,0,0,0,0,0],[0,0,0,0,5,7,0,0,0],[6,0,0,0,0,0,0,5,0]],"isSolved":false,"isValidCandidate":true,"isPossibleSolution":true}
```

##### The response parametes:
* **currentBoard**: a JSON representation of the current Sudoku board as a series of the board's lines.
* **isSolved**: Indicates whether the Sudoku is solved.
* **isValidCandidate**: Indicates whether the candidate is valid.
* **isPossibleSolution**: Indicates whether the candidate is part of a possible solution.

## The given Sudoku board:

```
[7,0,0,0,4,0,5,3,0]
[0,0,5,0,0,8,0,1,0]
[0,0,8,5,0,9,0,4,0]
[5,3,9,0,6,0,0,0,1]
[0,0,0,0,1,0,0,0,5]
[8,0,0,7,2,0,9,0,0]
[9,0,7,4,0,0,0,0,0]
[0,0,0,0,5,7,0,0,0]
[6,0,0,0,0,0,0,5,0]
```

## The Sudoku board solution:

```
[7,9,2,1,4,6,5,3,8]
[4,6,5,2,3,8,7,1,9]
[3,1,8,5,7,9,6,4,2]
[5,3,9,8,6,4,2,7,1]
[2,7,6,9,1,3,4,8,5]
[8,4,1,7,2,5,9,6,3]
[9,5,7,4,8,1,3,2,6]
[1,2,3,6,5,7,8,9,4]
[6,8,4,3,9,2,1,5,7]
```