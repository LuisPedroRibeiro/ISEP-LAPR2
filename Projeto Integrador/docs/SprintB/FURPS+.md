# Supplementary Specification (FURPS+)
 
## Functionality  

 **Reporting** - Support for generating reports.
 
 **Security**
 
 - _Controlled access to certain system features or data._    
 - _The user must be authenticated with seven alphanumeric characters, including three capital letters and two digits type password._  
 - _Only the  Specialist Doctor is allowed to access all client data._
   
 **Workflow** - Support for managing the status of test results (e.g. approved test, pending test).
 
## Usability 

 **Help and Documentation** - User Manual (Existence of informative support for users of the system.)  
 **Prevention of errors entered by the user** - The system needs to test the data introduced by the users of the software (e.g. NHS number must be valid).   
 **Adequacy of the interface for different types of users** - The interface needs to be different for each type of user group (e.g secretary, lab technician), while also being simple, intuitive and consistent.  
 **Aesthetics and design** - The user interface needs to be simple and intuitive.  
 **Interface consistency** - The user interface needs to be consistent.
 
## Reliability 
      
 **Frequency and severity of failure** - The system should not fail more than 5 days in one year and whenever the system fails, there should be no data loss.      
 **Possibility of recovery** - In case the system fails, there should not be any loss of data, being possible to recover it.  
 **Accuracy** - The application should use object serialization to ensure data persistence between two runs of the application.   
 
## Performance  
 
 **Response Time** - Any interface between a user, and the system shall have a maximum response time of 3 seconds.  
 **Start-up Time** - The system should start-up in less than 10 seconds.  
 
## Supportability

**Localization** - The software only supports British English, because it is being developed for Many Labs, which is based in England.   
 
**Testability** 

 - _Unit tests must be implemented for methods that don't involve input/output operations._  
 
 **Adaptability** - The application should be compatible with all platforms for which there exists a Java Virtual Machine.  
 
 **Compatibility** 
 
 - _The software must be compatible with the Barcode generator external API, with  SMS and Email functionalities, and the NHS API._    
 - _The application should be compatible with all platforms for which there exists a Java Virtual Machine._  
 
 **Installability** - Java Virtual Machine needs to exist in the computer in order for the application to execute.  
 
## +  
 
### Design Constraints
 
   
 **Programming languages** - To develop the system design process the programming language to being used must be Java, using  Intellij IDE or Netbeans.      
 **Mandatory standards/patterns** - The design needs to be simple, intuitive and consistent.    
 **Use of development tools** - The development tool must be either Intellij IDEA or Netbeans.  
 **Class library** - The class library for the user interface must be JavaFX 11.  
 
### Implementation Constraints
 
 
 **Mandatory standards/patterns** 
- _The system is going to implement JUnit 4 framework to execute the tests, and the JaCoCo plugin to generate the coverage reports._  
 - _All images must be saved in SVG format._  
 - _The Software has to use Javadoc to generate useful documentation for Java code._  
 - _The Software has to adopt recognized coding standards (e.g. CamelCase)._   
 
 **Implementation languages** - The language to be used on the code development must be Java, using  Intellij IDEA or Netbeans.  
 
 **Operating system** - The application should be compatible with all platforms for which there exists a Java Virtual Machine.  
 
### Interface Constraints
  
 The software must be developed to support interaction with external APIs that generate barcodes, SMS and emails, and the NHS API.
 
### Physical Constraints
 
 The application will be deployed to a machine with 8 GB of RAM.
