# OO Analysis 

### _Conceptual Class Category List_ ###

**Business Transactions**

* Test  

---

**Transaction Line Items**

* Sample    
* TestReport  

---

**Product/Service related to a Transaction or Transaction Line Item**

* Parameter  
* TestResult  
* Test   
* LabOrder  

---

**Transaction Records**

---  

**Roles of People or Organizations**

* Employee
* Administrator    
* Client  
* Receptionist    
* SpecialistDoctor    
* ChemicalChemistryTechnologist  
* LaboratoryCoordinator    
* MedicalLabTechnician  
* User  

---

**Places**

* ClinicalAnalysisLaboratory    
* ChemicalLaboratory   

---


**Noteworthy Events**
    
* Notification  

---

**Physical Objects**

* Sample
* LabOrder  

---

**Descriptions of Things**

* Company
* Category  
* TestType
* LabOrder
* TestReport

---

**Catalogs**
 
---

**Containers**
    
---  

**Elements of Containers**
   
---

**Organizations**

* Company  

---

**Other External/Collaborating Systems**

* BarcodeAPI  
* NHSSender
* EmailAPI  
* SMSAPI    

---

**Records of finance, work, contracts, legal matters**

* TestReport
* NHSReport     

---

**Financial Instruments** 

---

**Documents mentioned/used to perform some work/**

* TestResult  
* TestReport
* NHSReport  
* LabOrder

---

### **Concepts Associations** ###
  
| Concept (A) 		         |  Association   	   |  Concept (B)      				 	 |   
|:------------------------|:-----------------|:--------------------------------------------------|  
|	**_Administrator_**          |	creates                 |	**_ParameterCategory_**				 |
|	**_Administrator_**          |	creates                 |	**_ClinicalAnalysisLaboratory_**	 |
|	**_Administrator_**          |	creates                 |	**_Employee_**				         |
|	**_Administrator_**          |	creates                 |	**_TestType_**				         |
|	**_Administrator_**          |	creates                 |	**_Parameter_**				         |
|	**_Administrator_**			 |  works at                |   **_Company_**                        |
|	**_Administrator_**          |	sends                   |	**_Notification_**				     |
|   **_Barcode_**                |  is created by           |   **_BarcodeAPI_**                     |
|   **_Client_**                 |  has a                   |   **_LabOrder_**                       |
|	**_Client_**                 |	receives                |	**_Notification_**       			 |
|	**_Client_**                 |	receives                |	**_TestResult_**  		             |
|   **_ClinicalChemistryTechnologist_** |  generates        |   **_TestResult_**                     |
|	**_ClinicalChemistryTechnologist_** |  works at         |   **_ChemicalLaboratory_**             |
|   **_ParameterCategory_**      |  requests                |   **_TestType_**                       |
|	**_Company_**                |	conducts                |	**_TestType_**    				     |
|	**_Company_**                |	has                     |	**_Client_**    				     |
|	**_Company_**                |	has                     |	**_Employee_**    				     |
|	**_Company_**                |	owns                    |	**_ClinicalAnalysislaboratory_**     |
|	**_Company_**                |	owns                    |	**_ChemicalLaboratory_**		     |
|   **_Company_**                |  uses                    |   **_BarcodeAPI_**                     |
|   **_Company_**                |  uses                    |   **_EmailAPI_**                       |
|   **_Company_**                |  uses                    |   **_NHSSender_**                      |
|   **_Company_**                |  uses                    |   **_SMSAPI_**                         |
|   **_EmailAPI_**               |  creates and sends       |   **_Notification_**                   |
|   **_Employee_**               |  (extends)               |   **_Administrator_**  |
|   **_Employee_**               |  (extends)               |   **_ClinicalChemistryTechnologist_**  | 
|   **_Employee_**               |  (extends)               |   **_SpecialistDoctor_**               | 
|   **_Employee_**               |  (extends)               |   **_LaboratoryCoordinator_**          | 
|   **_Employee_**               |  (extends)               |   **_Receptionist_**                   | 
|   **_Employee_**               |  (extends)               |   **_MedicalLabTechnician_**           |
|  **_Employee_**                |    relates to            |    **_User_**
|	**_LaboratoryCoordinator_**  |	approves                |   **_TestReport_**                     |
|	**_LaboratoryCoordinator_**  |	approves                |   **_TestResult_**                     |
|	**_LaboratoryCoordinator_**  |	works at                |   **_ChemicalLaboratory_**             |
|	**_MedicalLabTechnician_**   |	works at                |	**_ClinicalAnalysisLaboratory_**     |
|	**_MedicalLabTechnician_**   |	uses                    |	**_BarcodeAPI_**                     |
|	**_NHSSender_**		         |	sends		            |   **_NHSReport_**			             |
|	**_Parameter_**              |	conducts                |	**_Test_**    				         |
|	**_Parameter_**              |	generates               |	**_TestResult_**    		         |
|	**_Parameter_**           	 |	is presented under a    |	**_ParameterCategory_**     		 |
|	**_Receptionist_**			 |	works at			    |	**_ClinicalAnalysisLaboratory_**     |
|   **_Receptionist_**	         |  receives                |   **_LabOrder_**                       |
|	**_Receptionist_**			 |	registers			    |	**_Client_**                         |
|	**_Receptionist_**			 |	registers			    |	**_Test_**                           |
|	**_Receptionist_**			 |	sends    			    |	**_Notification_**                   |
|   **_Sample_**				 |	is analysed by	        |   **_ClinicalChemistryTechnologist_**  |
|	**_Sample_**				 |	is associated with      |	**_Barcode_**					     |
|   **_Sample_**				 |	is collected by         |	**_MedicalLabTechnician_**			 |
|	**_Sample_**                 |	needs                   |	**_Test_**       				     |
|   **_SMSAPI_**                 |  creates and sends       |   **_Notification_**                   |
|	**_TestReport_**			 |	results from		    |	**_TestResult_**				     |
|	**_TestResult_**             |	results from            |   **_Sample_**						 |
|	**_SpecialistDoctor_**	     |	generates			    |	**_TestReport_**				     | 
|	**_SpecialistDoctor_**	     |	receives			    |	**_TestResult_**					 |
|	**_SpecialistDoctor_**	     |	works at		        |	**_ChemicalLaboratory_**		     |



 


### **Concepts Attributes** ###


| Concepts | Attributes  |   
|:---------|:-----------|  
| **_Administrator_** | . |
| **_Barcode_** | number. |
| **_BarcodeAPI_** | . |
| **_ChemicalLaboratory_** | address, phoneNumber, taxIdentificatinNumber, name. |
| **_Client_** | name, phoneNumber, taxIdentificationNumber, email, birthDate, gender, nhsId, citizenCardNumber. |
| **_ClinicalAnalysisLaboratory_** | address, phoneNumber, tinNumber, name, laboratoryId. |
| **_ClinicalChemistryTechnologist_** | . |
| **_Company_** | designation. |
| **_EmailAPI_** | email. |
| **_Employee_** | name, password, phoneNumber, email, employeeID, socCode, organizationRole, address. |
| **_LabOrder_** | testType, parameter. |
| **_LaboratoryCoordinator_** | . |
| **_MedicalLabTechnician_** | . |
| **_NHSReport_** | numberOfTestsRequested, numberOfPositiveResults, covidCasesDay, covidCasesWeek, covidCasesMonth, covidCasesDayPrediction, covidCasesWeekPrediction, covidCasesMonthPrediction. |
| **_NHSSender_** | . | 
| **_Notification_** | message. |
| **_Parameter_** | code, shortName, description. |
| **_ParameterCategory_** | code, name |
| **_Receptionist_** | . |
| **_Sample_** | . |
| **_SMSSAPI_** | phoneNumber. | 
| **_SpecialistDoctor_** | doctorIndexNumber. |
| **_Test_** | internalCode, nhsCode, description, dateSampleCollected, dateSampleAnalysis, dateSampleDiagnosis, dateDiagnosisValidation. |
| **_TestReport_** | description, testResult, validation. |
| **_TestResult_** | result. |
| **_TestType_** | description, code, collectionMethod. |
| **_User_**   | name, email, password. |


## Domain Model



![DM.svg](DM.svg)



