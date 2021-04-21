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
   Input Text  name=email  yountentshering@gmail.com
   Input Text  name=password  12345678
3. Login
   Click Button  name=submit
4. Check page info
   

5. close Browser
   Close Browser


