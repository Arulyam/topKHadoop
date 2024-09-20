# Project Template - Top-K Hadoop Example. 

# Running on Laptop     ####

Prerequisite:

- Maven 3

- JDK 1.6 or higher

- (If working with eclipse) Eclipse with m2eclipse plugin installed


The java main class is:

edu.cs.utexas.HadoopEx.WordCountTopKDriver 

Input file:  Book-Tiny.txt  

Specify your own Output directory like 

# Running:

Here is an additional data set:

Flight Data Set: https://storage.googleapis.com/cs378/flights.csv.bz2
['YEAR,MONTH,DAY,DAY_OF_WEEK,AIRLINE,FLIGHT_NUMBER,TAIL_NUMBER,ORIGIN_AIRPORT,DESTINATION_AIRPORT,SCHEDULED_DEPARTURE,DEPARTURE_TIME,DEPARTURE_DELAY,TAXI_OUT,WHEELS_OFF,SCHEDULED_TIME,ELAPSED_TIME,AIR_TIME,DISTANCE,WHEELS_ON,TAXI_IN,SCHEDULED_ARRIVAL,ARRIVAL_TIME,ARRIVAL_DELAY,DIVERTED,CANCELLED,CANCELLATION_REASON,AIR_SYSTEM_DELAY,SECURITY_DELAY,AIRLINE_DELAY,LATE_AIRCRAFT_DELAY,WEATHER_DELAY']


## Create a JAR Using Maven 

To compile the project and create a single jar file with all dependencies: 
	
```mvn clean package```


## Run your application

Inside your shell with Hadoop

Running as Java Application:

```java -jar target/topKHadoop-0.1-SNAPSHOT-jar-with-dependencies.jar SOME-Text-Fiel.txt  intermediatefolder  output  ``` 

For example 
```java -jar target/topKHadoop-0.1-SNAPSHOT-jar-with-dependencies.jar 20-news-same-line.txt  intermediatefolder  output  ``` 

Or has hadoop application

```hadoop jar your-hadoop-application.jar edu.cs.utexas.HadoopEx.WordCountTopKDriver arg0 arg1 arg2 ```


