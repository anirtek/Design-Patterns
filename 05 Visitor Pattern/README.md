# CS 542 : Programming Assignment 05 #

## What is this repository for? ##

This is a group programming assignment of CS 542-Programming the design patterns.
The assignment is based on the implementation of VISITOR PATTERN.

## Data Structure(s) Used ##

### TREE: Unbalanced Binary Search Tree.

* Node Structure: 
1. WordCount

* Operation(s) performed are all thread safe and synchronized:
    1. insertNode() => Time Complexity: O(log n), Space Complexity: O(1)
    2. searchNode() => Time complexity: O(log n), Space Complexity: O(1)

3. deleteNode() => Time Complexity: O(log n), Space Complexity: O(1)

* Why I choose unbalanced Binary Search Tree over AVL: AVL consumes more 
memory as it has to maintain balance factor and each operation can be more 
slower in order to perform rotations. BST in the average case has O(log n), 
worst case has O(n) time complexity while AVL has O(log n). As BST consumes 
less memory and is easy to debug, and know that the worst case will be 
rare here, hence BST is better to implement than AVL. 

### Working Protocol / Algorithm for this project ###

* Driver: Reads a command line input arguments and validates them. 
* Driver creates the instances of following classes :
1. FileProcessor - which reads the input file line by line
2. InputProcessor - which parses the line read by FileProcessor.
3. Results - used to store the results and write to files.
4. MyTree - implements the Element Interface 
5. PopulateVisitor - responsible for reading the line processed by 
InputProcessor class and sends to MyTree (the tree builder class to insert it).
6. PalindromeHighlight
7. PrimeLength
8. PrintTree

The client / element MyTree calls the accept() methods of its own and passes the 
instance of the PopulateVisitor in it. PopulateVisitor then calls its own visit()
method and starts receiving the processed input from the InputProcessor class.

After receiving the input, PopulateVisitor sends the input to the insert() method
of the MyTree class which performs the operation of the inserting the data into 
the tree. Finally, the PopulateVisitor returns the instance of the inserted tree.

After processing of PopulateVisitor is finished completely, PalindromeHighlight
comes into the picture which basically performs the operation of checking 
whether the data at every node of the tree is palidrome. If it is palindrome,
and has a length more than 3, PalidromeHiglight appends the suffix "-PRIME"
at the end of node word.

PrimeLength is the third visitor that is working on the tree processed by 
PalindromeHighlight and all it does is to check if a word has a length prime
or not. If the length of the word is prime, it converts that word into the 
UPPERCASE otherwise proceeds.

PrintTree is the last visitor that has the responsiblity of printing all the 
nodes of the tree into the required place which can be either of console or
to the output file provided by the user. PrintTree performs this operation 
using its local instance of Result class which enables PrintTree to make a
call to its WriteSchedulesToFile() method.

## Debugger Level Desciptions ##

        * DEBUG_VALUE=4 [Print to stdout everytime a constructor is called]
        * BUG_VALUE=3 [Print to stdout everytime the accept() is called] 
        * BUG_VALUE=2 [Print to stdout everytime an visit() is called]
        * BUG_VALUE=1 [Print to stdout everytime a palidrome checking is performed]
        * BUG_VALUE=0 [No output should be printed from the application to stdout] 

## How To Run This Project ##

        You need to be in the base directory of the project to perform following operations :

        * To clean : ant -buildfile src/build.xml clean
        * To build : ant -buildfile src/build.xml all
        * To run : ant -buildfile src/build.xml run -Darg0=InputFile -Darg1=OutputFile -Darg2=DebugLevel

## Cautions about the project ##

        * It accepts only 3 arguments: input file name, output file name, int debug level[0-4]
        * Input and output file paths should be valid and accessible. Throws exception otherwise.
        * If the output file specified does not exist, then it creates the file 
        "Output.txt" and writes theh final output into it.
        * This project considers case-sensitivity between the strings being compared.

## Who do I talk to? ##

        * Owner1: Aniruddha Tekade | atekade1@binghamton.edu [Admin]
        * Owner2: Vidhi Kamdar | vkamdar1@binghamton.edu [Admin]
        * Reader1: Gaurav Rattihali | grattih1@binghamton.edu [Read]
        * Reader2: Pankaj Saha | psaha4@binghamton.edu [Read]

## Declaration ##

        "I have done this assignment completely on my own. I have not copied 
        it, nor have I given my solution to anyone else. I understand that if
        I am involved in plagiarism or cheating I will have to sign an
        official form that I have cheated and that this form will be stored in
        my official university record. I also understand that I will receive a
        grade of 0 for the involved assignment for my first offense and that I
        will receive a grade of F for the course for any additional
        offense. 
        [Date:11/21/2017]
