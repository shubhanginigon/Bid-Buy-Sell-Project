*** Settings ***
Library  Selenium2Library

*** Variables ***
${expect}  LocationMind
${url}  http://localhost:8080/login
${Browser}  chrome
${delay}  1

*** Test Cases ***
1. Open Website
    Open Browser  ${url}  ${Browser}  options=add_experimental_option("excludeSwitches", ["enable-logging"])
    Maximize Browser Window
    Set Selenium Speed   0.3
2. Input username and password
   Input Text  name=email  st121775@ait.asia
   Input Text  name=password  12345678

3. Login
   Click Button  name=submit

4. Check page info
   Click Link    //a[contains(text(),'Add New Product')]
   Input Text  name=name  Iphone XR
   Input Text  name=price  5000
   Input Text  name=description  Perfect in condition and used for 7 months
   Input Text  name=startDate_  m04-d28-Y2021TH12M08S00a
   Input Text  name=finishDate_  m04-d29-Y2021TH12M08S00p
   

5. logout
   Click Link    //a[contains(text(),'Log Out')]

6. close Browser
   Close Browser

