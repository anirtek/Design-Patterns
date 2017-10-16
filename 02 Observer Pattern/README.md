# README - Project Description #

## Backup System for Student Course Assignments ##

* Create a class Node to store the B-Number (4 digit int) and an arraylist of course names (strings). The possible course names are "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K".
* Write code for a tree that has the features to insert, search, and delete Nodes. You need to write code for the tree by yourself. However, you are allowed to get help from a book or online source (for example the source code for BST, AVL, 2-3, 2-3-4, etc.) If you do so, cite the URL of where you got the code from both in your source code and also README.txt. It will be considered CHEATING if you do not cite the source of any code on tree that you use/adapt.
* As you need to modify the code to implement the Observer pattern, you can't just use an in-built tree in Java. Each Node of the tree should implement both the Subject and the Observer interface. Do not use the built-in Observer classes/interfaces in Java.
* Populate the tree using the data from an input file, input.txt, that has the following format:
	1234:C
	2345:D
	1234:A
	1234:D
	1234:E
	2345:F
	3425:C
	...

* The inputs may not be unique (some entries may repeat). So, either ignore the repeated inputs manually (if you use an ArrayList, for example), or use a key-value data structure that ensures unique entries. Assume that the input.txt and delete.txt will be well formatted.

* Your tree builder should be such that when you create a node (node_orig as the variable name), you should clone (using the prototype pattern) it twice to get two Nodes (let's say backup_Node_1 and backup_Node_2 as the variables holding the references). Setup backup_Node_1 and backup_Node_2 as observers of node_orig. node_orig, backup_Node_1, and backup_Node_2, should be instances of the same Node class. As node_orig is the subject, you should store the references of backup_Node_1 and backup_Node_2 in a data structure for listeners in Node_orig (array list of references, for example).

* Apply the following delete operations, processing line at a time, from the file delete.txt. The file has the following format:
	1234:C <br />
	2345:D <br />
	1234:A <br />
	... <br />

* Search for the node with the B_Number in the line, and then delete the corresponding course in that Node. If that course does not exist to delete, then ignore and move to the next line. NEW: I the nodes does not exist with that BNumber, then ignore and move to the next line. Once the changes to the node_orig are done, the changes should be updated to both the corresponding nodes (call notifyAll(...)). Note that the updates for a line in delete.txt should be sent, before the next line is processed.

* From the command line accept the following args: input.txt, delete.txt, output1.txt, output2.txt, output3.txt.
Add a method to your tree, printNodes(Results r, ...), that stores in Results the list of courses for each student, sorted by the B_Number.

* Your driver code should do the following:
	1. Read command line arguments.
	2. Build the three trees, based on input.txt and the observer pattern.
	3. Apply updates according to delete.txt
	4. Create a new Results instance and call printNodes(...) on each of the three trees to store the BNumber and list of courses to store in Results. So, each of the three trees will use a different instance of Results.
	5. Call a method in Results, via the method in FileDisplayInterface, to write the data stored in Results to output1.txt, output2.txt, and output3.txt, for the three trees. NEW Your output should be sorted (ascending order) by BNumber.
	6. You should run a "diff" on the three output files to make sure your Observer pattern worked correctly.
	7. In your README.txt, briefly describe how the observer pattern has been implemented.

### What is this repository for? ###

This is the second programming assignment of CS542-Programming the design patterns. The assignment is based on the analysis and implementation of the OBSERVER PATTERN.

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
