<img align="center" src="skilloLogo.png" alt="Skillo Academy Logo" width="350" height="100"/>


<div align="center">

# Test automation framework
</div>

## Automating iSkillo Training Website

## Table of Contents
- [Overview](#overview)
- [Application / software under test](#application--software-under-test)
- [List of test cases](#list-of-test-cases)
- [Installation](#installation)
- [Usage](#usage)
- [Bug report](#bug-report)
- [Contact](#contact)

## Overview
ISkillo social networking platform is an online platform where users can create a profile, share content and follow other people's content,
connect with friends, family, and colleagues in real time. 

Users can easily engage with
a broader online community with just one click. As well as to follow and control their access to the online media and news from the commodity of their home.

ISkillo has enabled this magical instant access to information and communication with the goal of building a vast worldwide network.

## Application / software under test
- **ISkillo Training Website** - [<<< **iSkillo Training Website** >>>](http://training.skillo-bg.com:4200/)



## Test  are performed with Selenium WebDriver v.4.21.0 and TestNG v.7.10.2 - Java v.21 unit framework:

### _List of test cases:_
- **Registration feature**:
  - Verify user can register in the system with valid credentials.
  - Verify user cannot register in the system with invalid credentials.


- **Login feature**:
  - Verify an already registered user can successfully log in the system with their valid credentials.  
  - Verify an already registered user can successfully log in the system with their valid credentials and then successfully log out.
  - Verify an already registered user CANNOT successfully log in the system  with WRONG PASSWORD. 
  - Verify an already registered user CANNOT successfully log in the system  with WRONG USERNAME. 
  - Verify an already registered user CANNOT successfully log in the system  with NO CREDENTIALS (empty credentials).


- **Post feature**:
    - Verify a logged user can successfully navigate to their Profile Page, create a new post and delete the new post after that.

  
- **Profile feature**:
  - Verify a logged user can successfully upload a new profile picture.

## Installation

**INSTALLATION REQUIREMENTS:**

- To get a local copy of the project repository from my GitHub profile use this link: [_**LINK TO THE REPOSITORY.**_](https://github.com/tsvetavvasileva/SKAU14TAF/tree/My-1st-Draft)
- Make sure you have JAVA version 21 and up.
- Make sure you have Maven version 3.8.1 and up.
- Make sure you have Testng version 7.10.2 and up.
- Make sure you have Selenium version 4.21.0 and up.


**INSTALLATION STEPS:**

Please, navigate to the Test Automation Framework using the link above,

Make sure that you clone the repository to your local machine. There are 3 different ways to do this, as shown below:
 
**Step num. 1:**
- Go to the GitHub.com website with the link above and click on the "Code" button.

**Step num. 2***:
- Copy the Repository HTTPS URL link and use git Bash to create your local copy: 
  
- Open the console and use git clone command and the path link of the repository that you have copied from GitHub.
  

  *_(alternative Step num. 2): Click on the "Code" button, use the alternative Download ZIP option._

**Step num. 3:**
- Open iIntelliJ Idea Community Edition v 2024.1.1 and from the File menu open the project.

## Usage

**CHECK FOLDER PATHS:**

These are steps that need to be done for Windows OS users:
Go to SRC TEST RESOURCES folder and verify if the following folders are present:
- There is a folder with name "_reports_".
- There is a folder with name "_screenshots_".
- There is a folder with name "_uploads_".
- There is a folder with name "_download_".

IF NOT:
When you build the project in src/test/java/gui and run the Maven test command you will find the folders are created by the automation script.

**TO RUN THE AUTOMATION:**

**STEP 1:** Go to the right vertical tab menu options within IntelliJ and click on Maven tab.

**STEP 2:**
Under Lifecycle dropdown Run these commands:
**_maven clean & maven test_.**

**STEP 3:**
Wait for the automation to start and after the tests execution a report will be generated.


## Bug report
If there are any bugs that have been reported during this automation framework execution, please use the bug report to check and review them. 

## Contact

- [Skillo Student](mailto:tsveta.v.vasileva@gmail.com): Tsveta Valentinova Vasileva
- Project Link: [TAF Selenium 4 TestNG 7 ](https://github.com/tsvetavvasileva/SKAU14TAF/tree/My-1st-Draft)

