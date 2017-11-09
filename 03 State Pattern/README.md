# README #

### What is this repository for? ###

This is the second programming assignment of CS542-Programming the design patterns.
The assignment is based on the analysis and implementation of the STATE PATTERN.

### Data Structure ###

This assignment uses enums in java for logger in the MyLogger class. 
The space & time complexity of the enums is always O(1).

### Working Protocol / Algorithm for this project ###

The driver.java class validates the input which are exactly 3. The inputs are always
accepted only from the commmand line while starting to execute this project. The driver.java
also throws exception in case the invalid input is received and exits the program. 

drive.java then created the instances of the context class which is SecurityFactor.java as well
as the instances of all the state classes of the airport.

The state classes implements the AirportStateI interface which has just following 3 methods - 
 * tighternOrLoosenSecuryt()
 * computeAverageTraffic()
 * computerAverageProhibitedItems() 
 
The SecurityFactor class sets the local instances of the state classes and processes the input 
received by FileProcessor class.

Based on the local state of the airport, the state is changed after considering the two factors - 
* Average Traffice Per Day
* Average Number of Prohibited Items Per Day 

### Debugger Level Desciptions ###

DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
 
DEBUG_VALUE=3 [Print to stdout everytime the state is changed] 

DEBUG_VALUE=2 [Print to stdout everytime a set of operations are performed]

DEBUG_VALUE=1 [Print to stdout everytime an exception occurs and handles]

DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]

### How To Run This Project ###

You need to be in the base directory of the project to perform following operations :
* To clean : ant -buildfile src/build.xml clean
* To build : ant -buildfile src/build.xml all
* To run : ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD 

### File Structure ###

 airportSecurityState
 == README.md
 == src
	=== build.xml
	=== airportSecurityState
       	=== driver
            === Driver.java
        === util
            === FileProcessor.java
	   		=== Results.java
	   		=== MyLogger.java
	   	=== airportStates
	   		=== AirportStatesI.java
	   		=== StateLowRisk.java
	   		=== StateModerateRisk.java
	   		=== StateHighRisk.java
	   		=== SecurityFactors.java

### Cautions about the project ###

* It accepts only 3 arguments: input file name, output file name and 
int from 0 - 4 debug level.
* If the number of arguments are less than 3 or more, it will display en error
message on the CLI and will exit.
* Input files should be placed inside "src/" directory of the base directory.
* The build file is designed in such a way that it expects the inputfiles within the "src/" directory.
* Even though it should be able to locate and pick the input and output files from anypath
provided.

### Who do I talk to? ###

* Owner1: Aniruddha Tekade | atekade1@binghamton.edu [Admin]
* Reader1: Gaurav Rattihali | grattih1@binghamton.edu [Read]
* Reader2: Pankaj Saha | psaha4@binghamton.edu [Read]

### Declaration ###

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense.
[Date:11/08/2017]
