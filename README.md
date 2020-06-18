# WebApp Automation Framework

This is a Automation Framework.
 - Written in **JAVA**
 - Test framework using **TestNG**
 - Build Tool - **Maven**
 - Reporting Framework - **Allure**
 - Http client - **Rest-Assured** 
 - UI tests - **Selenide**
 
#### Rest-Api tests command run: 
  - mvn clean install test -DsuiteXml=testng-rest.xml allure:report -f api-tests/pom
  
 #### UI tests command run: 
   - mvn clean install test -DsuiteXml=testng-ui.xml allure:report -f ui-tests/pom