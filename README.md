### Circle CI Badge
[![CircleCI](https://circleci.com/gh/kawgh1/testing-java-junit5.svg?style=svg)](https://circleci.com/gh/kawgh1/testing-java-junit5)

go to README.md raw to view badge code


## Mockito
Mockito allows lighter (and thus faster) unit and integration testing while avoiding
some challenges when creating many POJOs interacting with each other in a test environment

#### Types of Mocks
- Dummy - object used just to get the code to compile
- Fake - object that has an implementation, but is not production ready
- Stub - object with pre-defined answers to method calls
- Mock - object with pre-defined answers to method calls, and has expectations of executions. Can throw an exception if an unexpected invocation is detected
- Spy - a "spy" is a Mock-like wrapper around an actual object which allows you to intercept calls to the object, inspect things or pass things directly along to the underlying object 


#### Mockito Terminology
- Verify - used to verify number of times a mocked method has been called - if twice, then not 1 time, not 3 times, provides precision and method control
- Argument Matcher - Matches arguments passed to a Mocked Method and will allow or disallow
- Argument Captor - Captures arguments passed to a Mocked Method
    - Allows you to perform assertions of what was passed in to the method
    
    
#### Mockito Annotations
- @Mock - used to create a mock
- @Spy - used to create a spy
- @InjectMocks - injects mocks/spys into a class under test
- @Captor - captures arguments to a mock


#### Mockito Maven dependencies
- org.mockito - mockito-core
- org.mockito - mockito-junit-jupiter
- both ver 2.23.0+
- scope - test


# Introduction to JUnit 5 with Maven

All source code examples in the repository are for my [Online Course - Testing Spring Beginner to Guru](https://www.udemy.com/testing-spring-boot-beginner-to-guru/?couponCode=GITHUB_REPO)

This source code repository contains JUnit 5 test examples with Maven.

## Setup
### Requirements
* Should use Java 11 or higher. Previous versions of Java are un-tested.
* Use Maven 3.5.2 or higher

## Support
For questions and help:
* Please post in course
* Or post in the Slack Community exclusive to the course.

GitHub Issues will not be addressed.
