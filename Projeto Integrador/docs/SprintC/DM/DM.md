# OO Analysis 

### _Conceptual Class Category List_ ###

**Business Transactions**

* Test  

---

**Transaction Line Items**

* Sample    
* TestReport 
* ReferenceValue
* TestParameterResult

---

**Product/Service related to a Transaction or Transaction Line Item**

* Parameter
* TestParameter
* TestParameterResult
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
* ParameterCategory  
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
* ExternalModule

---

**Records of finance, work, contracts, legal matters**

* TestReport
* NHSReport     

---

**Financial Instruments** 

---

**Documents mentioned/used to perform some work/**

* TestParameterResult  
* TestReport
* NHSReport  
* LabOrder

---

### **Concepts Associations** ###

| Concept (A) 		         |  Association   	   |  Concept (B)      				 	 |   
|:------------------------|:-----------------|:--------------------------------------------------|  
|	**_Administrator_**                 |	creates                 |	**_ParameterCategory_**				 |
|	**_Administrator_**                 |	creates                 |	**_ClinicalAnalysisLaboratory_**	 |
|	**_Administrator_**                 |	creates                 |	**_Employee_**				         |
|   **_Administrator_**                 |   (extends)               |   **_Employee_**                       |
|	**_Administrator_**                 |	creates                 |	**_TestType_**				         |
|	**_Administrator_**                 |	creates                 |	**_Parameter_**				         |
|	**_Administrator_**			        |   works at                |   **_Company_**                        |
|	**_Administrator_**                 |	sends                   |	**_Notification_**				     |
|   **_Client_**                        |   has a                   |   **_LabOrder_**                       |
|	**_Client_**                        |	receives                |	**_Notification_**       			 |
|	**_Client_**                        |	receives                |	**_TestParameterResult_**  		     |
|   **_ClinicalChemistryTechnologist_** |   generates               |   **_TestParameterResult_**            |
|	**_ClinicalChemistryTechnologist_** |   works at                |   **_ChemicalLaboratory_**             |
|   **_ClinicalChemistryTechnologist_** |   (extends)               |   **_Employee_**                       | 
|   **_ClinicalAnalysisLaboratory_**    |   has                     |   **_TestType_**                       | 
|	**_Company_**                       |	conducts                |	**_TestType_**    				     |
|	**_Company_**                       |	has                     |	**_Client_**    				     |
|	**_Company_**                       |	has                     |	**_Employee_**    				     |
|	**_Company_**                       |	owns                    |	**_ClinicalAnalysislaboratory_**     |
|	**_Company_**                       |	owns                    |	**_ChemicalLaboratory_**		     |
|   **_Company_**                       |   uses                    |   **_BarcodeAPI_**                     |
|   **_Company_**                       |   uses                    |   **_EmailAPI_**                       |
|   **_Company_**                       |   uses                    |   **_NHSSender_**                      |
|   **_Company_**                       |   uses                    |   **_SMSAPI_**                         |
|   **_EmailAPI_**                      |   creates and sends       |   **_Notification_**                   |
|   **_Employee_**                      |   relates to              |   **_User_**                           |
|	**_LaboratoryCoordinator_**         |	approves                |   **_TestReport_**                     |
|	**_LaboratoryCoordinator_**         |	approves                |   **_TestParameterResult_**            |
|	**_LaboratoryCoordinator_**         |	works at                |   **_ChemicalLaboratory_**             |
|   **_LaboratoryCoordinator_**         |   (extends)               |   **_Employee_**                       | 
|	**_MedicalLabTechnician_**          |	works at                |	**_ClinicalAnalysisLaboratory_**     |
|	**_MedicalLabTechnician_**          |	uses                    |	**_BarcodeAPI_**                     |
|   **_MedicalLabTechnician_**          |   (extends)               |   **_Employee_**                       |
|	**_NHSSender_**		                |	sends		            |   **_NHSReport_**			             |
|	**_Parameter_**           	        |	presented under         |	**_ParameterCategory_**     		 |
|	**_Parameter_**           	        |	has                     |	**_TestParameter_**     		     |
|	**_Receptionist_**			        |	works at			    |	**_ClinicalAnalysisLaboratory_**     |
|   **_Receptionist_**	                |   receives                |   **_LabOrder_**                       |
|	**_Receptionist_**			        |	registers			    |	**_Client_**                         |
|	**_Receptionist_**			        |	registers			    |	**_Test_**                           |
|	**_Receptionist_**			        |	sends    			    |	**_Notification_**                   |
|   **_Receptionist_**                  |   (extends)               |   **_Employee_**                       | 
|   **_ReferenceValue_**                |   provided by             |   **_ExternalModule_**                 |
|   **_Sample_**				        |	is analysed by	        |   **_ClinicalChemistryTechnologist_**  |
|	**_Sample_**				        |	is associated with      |	**_BarcodeAPI_**					 |
|   **_Sample_**				        |	is collected by         |	**_MedicalLabTechnician_**			 |
|	**_Sample_**                        |	needs                   |	**_Test_**       				     |
|   **_SMSAPI_**                        |   creates and sends       |   **_Notification_**                   |
|   **_SpecialistDoctor_**              |   (extends)               |   **_Employee_**                       | 
|	**_SpecialistDoctor_**	            |	generates			    |	**_TestReport_**				     | 
|	**_SpecialistDoctor_**	            |	receives			    |	**_TestParameterResult_**			 |
|	**_SpecialistDoctor_**	            |	works at		        |	**_ChemicalLaboratory_**		     |
|	**_Test_**                          |	request analysis of     |	**_Parameter_**    				     |
|	**_Test_**                          |	has                     |	**_TestParameter_**          	     |
|	**_Test_**                          |	relates to              |	**_TestReport_**          	         |
|	**_TestReport_**			        |	results from		    |	**_TestParameterResult_**			 |
|	**_TestParameter_**                 |	contains                |   **_TestParameterResult_**			 |			 |
|	**_TestParameterResult_**           |	results from            |   **_Sample_**						 |
|	**_TestParameterResult_**           |	records                 |   **_ReferenceValue_**			     |
|   **_TestType_**                      |   requests                |   **_ParameterCategory_**              |
|   **_TestType_**                      |   makes use of            |   **_ExternalModule_**                 |
|   **_User_**                          |   relates to              |   **_Client_**                         |
|   **_User_**                          |   relates to              |   **_Employee_**                       |

### **Concepts Attributes** ###


| Concepts | Attributes  |   
|:---------|:-----------|  
| **_Administrator_** | . |
| **_BarcodeAPI_** | . |
| **_ChemicalLaboratory_** | address, phoneNumber, taxIdentificationNumber, name. |
| **_Client_** | name, phoneNumber, taxIdentificationNumber, email, birthDate, gender, nhsId, citizenCardNumber. |
| **_ClinicalAnalysisLaboratory_** | address, phoneNumber, tinNumber, name, laboratoryId. |
| **_ClinicalChemistryTechnologist_** | . |
| **_Company_** | designation. |
| **_EmailAPI_** | email. |
| **_Employee_** | name, password, phoneNumber, email, employeeID, socCode, organizationRole, address. |
| **_ExternalModule_** | . |
| **_LabOrder_** | testType, parameter. |
| **_LaboratoryCoordinator_** | . |
| **_MedicalLabTechnician_** | . |
| **_NHSReport_** | numberOfTestsRequested, numberOfPositiveResults, covidCasesDay, covidCasesWeek, covidCasesMonth, covidCasesDayPrediction, covidCasesWeekPrediction, covidCasesMonthPrediction. |
| **_NHSSender_** | . | 
| **_Notification_** | message. |
| **_Parameter_** | code, shortName, description. |
| **_ParameterCategory_** | code, name. |
| **_Receptionist_** | . |
| **_ReferenceValue_** | upperReferenceValue, lowerReferenceValue.
| **_Sample_** | barcode. |
| **_SMSAPI_** | phoneNumber. | 
| **_SpecialistDoctor_** | doctorIndexNumber. |
| **_Test_** | code, nhsCode, description, createdAt, sampleDate, resultDate, reportDate. |
| **_TestReport_** | description, header. |
| **_TestParameterResult_** | value, metric, createdAt. |
| **_TestType_** | description, code, collectionMethod. |
| **_User_**   | name, email, password. |


## Domain Model



![DM.svg](../../SprintB/DM/DM.svg)



