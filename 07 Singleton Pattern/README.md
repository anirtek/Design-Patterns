# Singleton Pattern #

## Story ##

We have a class called Discount which serves as the role of providing discount
percentage to other classes. However, singleton class Discount has taken care 
that only once instance is allowed to all the classes trying to get a copy of 
dicount.

## Classes ##

1. Discount --> a singleton class
2. SingletonDriver --> Test class

### Working Protocol / Algorithm for this project ###

* Singleton class is a class that has its constructor private.
* Having constructor private prevent outside entities from creating instances.
* Discount class has a class level method call getInstance().
* getInstance() method returns the instance of the Discount class.
* It calls the constructor and sets the copy saved in localInstance variable.
* Everytime any object requests of the object of Discount class, getInstance() 
method will return this copy to them.

## Debugger Level Desciptions ##

## How To Run This Project ##

## Cautions about the project ##

## Who do I talk to? ##

* Owner1: Aniruddha Tekade | atekade1@binghamton.edu [Admin]

## Declaration ##

        "I have done this work completely on my own. I have not copied 
        it, nor have I given my solution to anyone else. I understand that if
        I am involved in plagiarism or cheating I will have to sign an
        official form that I have cheated and that this form will be stored in
        my official university record. I also understand that I will receive a
        grade of 0 for the involved assignment for my first offense and that I
        will receive a grade of F for the course for any additional
        offense. 
        [Date:02/28/2018]
