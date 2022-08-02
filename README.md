# Automated Testing Framework for Karaken
This repository contains QA's automated test for Kraken Websocket API
## Prerequisites:
1. JDK 8+
2. Maven 2

## How to run it :

```bash
mvn clean verify \
    -Dtags=<CUCUMBER_TAGS>

```

### Parameters:
Default values highlighted in bold.

`PROJECT` (String)

- **Kraken** - Kraken test suite.

`CUCUMBER_TAGS` (String)

Specify the test suite(s) to run. Eg:
- @webSocket
- @wssApiPositiveTest
- @wssApiPositiveChannelIDTest
- @wssApiNegativeTest

## Writing New Tests

### Working with Feature Files

There are 2 special tags that need to be added at a feature level, depending on the type of tests that will be included.  

@api - Use this tag if you want to make API calls exclusively. It will not open a browser window. 
```
@webSocket
Feature: Subscribe verification
 
 @wssApiPositiveTest
 Scenario: "<$variable>"subscription verify information about
```