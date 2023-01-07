# Welcome to Flights Analyzer

## About
FlightsAnalyzer is a terminal user interface application that provides peeks from 
[the uploaded dataset](https://www.kaggle.com/datasets/robikscube/flight-delay-dataset-20182022?select=Combined_Flights_2019.csv) 
based on user input. 

### The application can perform the following:
| Command                                                        | Output                                                                                                                 |
|----------------------------------------------------------------|------------------------------------------------------------------------------------------------------------------------|
| airlines                                                       | Table with how many planes each airline own                                                                            |
| airlines top                                                   | Table with the top five airlines in terms of the number of planes they own                                             | 
| airports                                                       | Table with the top 5, most visited airports in the dataset                                                             |
| rainy                                                          | Table with the total number of flights delayed more than 15 minutes on rainy days vs. non rainy days, grouped by month |
| holidays                                                       | Table with the number flights delayed more than 15 minutes on holidays, grouped by month                               |
| from \<origin airport\> to \<destination airport\> on \<date\> | Table with data on flights that occurred at the given date towards the given route                                     |
| view table \<table name\>                                      | Table as is from schema, the result of (select * \<table name\>)                                                       |
| help                                                           | Manual for how to use the app                                                                                          |
| quit                                                           | Exit the app                                                                                                           |

# How to run?
In your terminal, shell, or cmd go to src/main/application/executable/ then type the following command:
- Before you run please make sure **mssql-jdbc-11.2.0.jre18.jar** is in the same directory.
````
java -jar FlightsAnalyzer.jar 
````
- If you would like to rebuild the jar file after some edits, you can do so in intelliJ using built-in artifact.
- We used a jar file instead of Makefile to keep the project structure intact.

# Notes
- The relational model submitted in phase one has been changed, please read the schema in src/main/assets/Flights.sql to review the final version.
- The Flights.sql file inside the assets directory is written in sqlite3 syntax and the application never connects to it, instead the queries are executed on the jdbc uranium connection. 
- The same sql was uploaded to uranium using the mssql extension in VS Code with Microsoft SQL Server syntax.
- The sql file was generated using a java script we wrote in a separate project to parse the csv files.
  - Why did we not include that script in this project you ask? Well, two reasons:
    - If we did include it, we would have to include all the csv files with it as well for the app to run properly, and that is 8+ GB.
    - While creating this project we made lots of edits to the schema and the insert statements on the fly, which turned that script to random pieces of spaghetti code that do not match programming standards.
- If you do attempt to re-read the sql files whether on uranium or sqlite3, expect 6 to 8 hours of runtime.
- The command 'rainy' runs a query that took 40 minutes to execute successfully on uranium.
- The flights data is a snippet from the original (Only May to December) data for two reason
  - We wanted to join the weather data that we scraped from [NOAA](https://www.noaa.gov/) with the flights dates to show delays caused by bad weather, and we were only able to find airports weather starting from May.
  - Loading the full dataset from the source would have resulted in 50+ GB SQL files that neither our local machines would be able to handle nor would uranium read buffer size.

