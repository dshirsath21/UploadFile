// This code is implemented in JAVA for RESTAPI @PUT method to upload file with Authentication type Basic to specific location on remote 

import java.io.File;
import java.io.FileNotFoundException;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;


String HostName = "localhost:8080/xyz";
String UserName = "test";
String Password = "test";
String remotePath = "/remoteDir";  // This one is path in your host where you have to upload file 
String localFile = "d:\\AutoSet\\TestData\\TestFile.csv";

// Authentication 
PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
authScheme.setUserName(userName);
authScheme.setPassword(passWord);

// ResstAssured authentication step 
RestAssured.authentication = authScheme;

// RestAssured baseURI step 
RestAssured.baseURI = hostName;

File localFileToUpload = new File(localFile);

Response response = null;

try {
			response = (Response) given().multiPart(localFileToUpload).when().put(remoteFile);
		} catch (Exception err) {
			err.printStackTrace();
		}

System.out.println(response.getStatusCode());
System.out.println(response.asString())
