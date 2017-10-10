# README #

This repository is created for maintaining code of CS542 Programming Design Patterns - Assignment_1.
The program accepts only 2 inputs - input file name and output file name. 

While reading the input, the file processor makes sure that no float or string input is
considered and throws exception and continues with the next line. The valid inputs are the 
integer numbers int he range 0-10000. 

The main() function exists in Drive.java. MyArrayList data strcture is actually 
an integer array of initial size = 50 and increased by 1/2 of previous size 
whenever required. FileProcessor.java handles the mechanisms for reading the input file,
validating the file name, and also makes sure that the file handler is closed after
the use.

Every test case that is run inside the MyArrayListTest.java class's testMe() methods is 
stored in with the object of Results.java and later on saved/written into the output.txt
file using writeToFile() method of the same class. 

The project also displayes the input data in a vertical manner along with the sum calculation,
status of more than 10 test case methods for myArrayList instance and validates each case
before actually writing the output to the output file.

The program would not run if no input file is provided and will exit by throwing system error.
However, program runs even if no output file is provided. It rather creates an output file 
and writes the output line by line to the file.
     

### Who do I talk to? ###

* Repo owner or admin : Aniruddha Tekade | atekade1@binghamton.edu
* Repo being watched by : Gaurav Rattihali | grattih1@binghamton.edu

Assuming you are in the directory containing this README:

## To clean:
ant -buildfile src/build.xml clean

-----------------------------------------------------------------------
## To compile: 
ant -buildfile src/build.xml all

-----------------------------------------------------------------------
## To run by specifying arguments from command line 
## We will use this to run your code
ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND

## If you are running with just one argument
## In this case it will automatically create the output.txt
ant -buildfile src/build.xml run -Darg0=FIRST


-----------------------------------------------------------------------

## To create tarball for submission
ant -buildfile src/build.xml tarzip or tar -zcvf firstName_secondName_assign_number.tar.gz firstName_secondName_assign_number

-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating I will have to sign an
official form that I have cheated and that this form will be stored in
my official university record. I also understand that I will receive a
grade of 0 for the involved assignment for my first offense and that I
will receive a grade of F for the course for any additional
offense."

[Date: 09/15/2017]

-----------------------------------------------------------------------

Provide justification for Data Structures used in this assignment in
term of Big O complexity (time and/or space)

Time Complexity : The entire project has the complexity of O(n^2) considering
the worst case. The only method that executes in O(n^2) is insertSorted()
method in the MyArrayList.java class. This might take above complexity only when
the input is given in sorted manner. O(n log n); otherwise since it uses the 
implicit sorting method of the class Arrays which inturn uses Quick Sort.

Other methods such as sum(), indexOf(), removeValue() etc takes O(n) time complexity.

Space Complexity : The space complexities for the data structure of Results.java 
class is constant as it consumes space equivalenet to the number of testcases + 1.
The space complexity of MyArrayList.java data structure is O(n+n/2) which is also linear. 
-----------------------------------------------------------------------

Provide list of citations (urls, etc.) from where you have taken code
