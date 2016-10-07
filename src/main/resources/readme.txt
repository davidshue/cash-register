Steps to build the executable jar
1) go to the folder that contains the project
2) Run the following commands:
    i) gradle clean
    ii) gradle fatJar
3) Go to build/libs, run the following
    i) java -jar register-all-1.0-SNAPSHOT.jar path-to-the-csv-file
4) csv file sample is in src/test/resources/sample.csv
