# README #

### What is this repository for? ###

This is the second programming assignment of CS542-Programming the design patterns.
The assignment is based on the analysis and implementation of the OBSERVER PATTERN.

### Data Structure ###

This assignment uses Binary Search Tree(BST) as the implementation data structure.
The structure of the tree node is defined in the Node class. Every node of the tree
contains an observer list that stores the references to the observer nodes.

### Operations that can be performed on the tree ###

* Create Node ==> Time complexity is O(n) in the worst case; O(1) when tree is empty.
* Insert Course ==> Time complexity is O(n) in the worst case; O(1) otherwise.
* Delete Course ==> Time complexity is O(n) in the worst case; O(1) otherwise.
* Print Nodes ==> Uses the inorder traversal technique on the tree hence the it is 
guaranteed that the nodes of the tree will always be printed in the asceding manner
of sort functionality.

All of these implementations are declared and defined in the MyTree.java. The Node
class implements both the Observer as well as Subject interfaces defined in the
myTree package.

### File Structure ###

 studentCoursesBackup
 == README.txt
 == src
	=== build.xml
	=== studentCoursesBackup
       	=== driver
            === Driver.java
        === util
            === TreeBuilder.java
	   		=== Results.java
	   		=== FileProcessor.java
	   		=== FileDisplayInterface.java
	   		=== StdoutDisplayInterface.java
	   	=== myTree
	   		=== Node.java
	   		=== SubjectI.java
	   		=== ObserverI.java

### How do I run this project? ###

You need to be in the base directory of the project to perform following operations :
* To clean : ant -buildfile src/build.xml clean
* To build : ant -buildfile src/build all
* To run : ant -buildfile src/build.xml run -Darg0=FIRST -Darg1=SECOND -Darg2=THIRD -Darg3=FOURTH -Darg4=FIFTH 

### Cautions about the project ###

* It accepts only 5 arguments: input, delete, output-1, output-2, output-3
* If the number of arguments are less than 5 or more, it will display en error
message on the CLI and will exit.
* Input files should be placed inside "src/" directory of the base directory.
* The build file is designed in such a way that it expects the inputfiles within the "src/" directory. 

### Who do I talk to? ###

* Owner: Aniruddha Tekade | atekade1@binghamton.edu [Admin]
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
[Date:10/03/2017]
