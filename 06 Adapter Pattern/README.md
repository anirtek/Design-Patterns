# Adapter Pattern #

## Story ##

The traveller is going to fly from New York to France. He realizes that his laptop charging is down.
To keep the backup ready to work on flight, he charges the laptop with the US-Style power source.
However, he works on the flight throughout and safely reaches the France. But he realizes again that
his battery of laptop is about to get down soon and so he starts searching for the charging sockets.

But the power sockets at Europe is not same as the ones in US. He remembers that he had kelp the 
"US to Europe" power adapter and takes it out. He inserts his powercabel plug int he socket of 
this adapter and the adapter into the local power socket. He feels thankful to this adapter.

## Classes ##

1. EuropeInter --> interface for Europe Styled power sockets
2. USInter --> interface for US styled power sockets
3. EuropePlugs --> class that implements EuropeInter
4. USPlugs --> class that implements USInter
5. PowerAdapter --> the class that inherits the EuropeInter interface
5. ChargingSyste --> the tester/driver class

### Working Protocol / Algorithm for this project ###

* The driver class create an object of EuropePlugs and USPlugs. 
* The object of USplugs is passed to the constructor of PowerAdapter.
* PowerAdapter has a local instance of USPlugs as a part of object.
* But, PowerAdapter class implements the EuropeInter interface methods.
* Using the local USPlugs instance, PowerAdapter class can easily call the USPlugs method.
* Therefore, USPlugs device can be charged with EuropePlug power sockets.
constructor of 

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
