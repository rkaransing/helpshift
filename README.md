# README for Data Structure implementation.

## Problem statement : 
Design a data structure that can store key-value pairs. Keys are unique, and are used to identify values which may be
random, and non-unique. Data structure should provide the following functionality:
1. Insert a new key-value pair. If the key already exists, replace its value.
2. Retrieve the value of a given key, if it exists, otherwise return null.
3. Display the current state of the data structure.


## Assumptions :
1. As per problem statement details provided, the key will be always of type integer and value will be String.
2. Key length will be within integer range : 0 to 2147483647  

## Language Used for Implementation:
1. Java

## Data Structre Details
1. For storing all keys, I have used Trie data structure instead of normal Linear data structure
 Time complexity for searching in case of Trie Data Structure is **O(m)**, where '**m**' is **length** of key to be searched, 
 it is very efficient as compared to any other linear DS like List of objects, Array etc.

## How to run:
1. Go to the base directory after extracting the zip file from Github.
2. Execute below commands on CLI :
```
mvn clean
mvn compile
mvn exec:java -Dexec.mainClass="org.helpshift.App"
```
3. Select Command numbers from CLI.
4. Output will be printed on CLI(STDOUT) itself.

```
or simply import project in IDE(Intelij/Eclipse) and run App.java class
```
## How to run unit-test cases :
1. Go to the base directory after extracting the zip file from Github.
2. Execute below commands on CLI :
```
mvn clean
mvn compile
mvn test
```
```
or simply import the project with IDE and run test cases.
```
## Future possible expansions:
As we are using Integer value as key here but we can also use String as a key and we can have one flag in properties file which will like "useStringAsKey = true/false", due to which we wont have any length restrictions on key also though its not mentioned now for 'deletion' of record or making DS clear, we can free up the pointers and have that implementation also.
