package lwm2m.downlinkClient;

import java.io.IOException;
import java.net.URI;
import java.util.Scanner;
import java.net.URISyntaxException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
//import com.sun.jersey.core.spi.scanning.Scanner;

public class DownlinkClient {

	static final String endPointName = "6d26bbc3-a66a-455e-b089-3bb2f8ac915e"; // Pre
																				// Installed
																				// EndPointName
																				// UUID.randomUUID()
	static String registrationId; // Fetched from server during bootstrap

	public static void main(String[] args) throws URISyntaxException, InterruptedException {

		// ---------------Discover---------------------//
		Client client = Client.create();
		String output = new String();
	
		System.out.println("Please Enter the Opeartion:");
		Scanner input= new Scanner(System.in);
		String operation= input.next();
		if (operation.equalsIgnoreCase("discover")){
		URI uri1 = new URI("http://localhost:8017/LWM2MClient/lwm2m/3/0/discover");

		System.out.println("\nDiscover request : " + uri1);

		WebResource webResource = client.resource(uri1);

		ClientResponse response = webResource.type("text/plain").get(ClientResponse.class);

		output = response.getEntity(String.class);
		System.out.println("Successfully Discovered : " + output);

		if (response.getStatus() == 200) {
		} else {
			throw new RuntimeException("Error while Discovering : HTTP error code : " + response.getStatus());
		}
		}// discover block	
		/*System.out.println("Continue?");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Ended.");*/
		// ---------------Read---------------------//
		//Scanner inputread= new Scanner(System.in);
		//System.out.println("Please Enter the Opeartion:");
		//String operation= input.next();
		else if (operation.equalsIgnoreCase("read")){
		ReadRequest r1 = new ReadRequest(10, 1, 2);
		ReadRequest r2 = new ReadRequest(6, 1);

		r1.sendReadRequest();
		System.out.println("Continue?");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		r2.sendReadRequest();

		System.out.println("Continue?");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
}
		// ---------------- Write Request --------------//
//Scanner inputWrite= new Scanner(System.in);
//System.out.println("Please Enter the Opeartion:");
//String operationWrite= inputWrite.next();
		else if (operation.equalsIgnoreCase("write")){	
new WriteRequest(1, 1, 0).sendWriteRequest();
}
		// ---------------Execute--------------//
		//System.out.println("Continue?");
		///Scanner inputExecute= new Scanner(System.in);
		//System.out.println("Please Enter the Opeartion:");
		//String operationExecute= inputExecute.next();
		else	if (operation.equalsIgnoreCase("execute")){
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Client client1 = Client.create();
		String output1 = new String();

		URI uri11 = new URI("http://localhost:8017/LWM2MClient/lwm2m/10/0/5/execute");

		System.out.println("\nExecute request : " + uri11);

		WebResource webResource1 = client1.resource(uri11);

		ClientResponse response1 = webResource1.type("application/json").post(ClientResponse.class);

		output1 = response1.getEntity(String.class);
		System.out.println("Successfully Executed : " + output1);

		if (response1.getStatus() == 201) {
		} else {
			throw new RuntimeException("Error while Executing : HTTP error code : " + response1.getStatus());
		}
		}
		// ---------------create---------------------//
		
		//System.out.println("Continue?");
		//Scanner inputCreate= new Scanner(System.in);
		//System.out.println("Please Enter the Opeartion:");
		//String operationCreate= inputCreate.next();
		else if (operation.equalsIgnoreCase("create")){
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		Thread.sleep(2000);

		CreateRequest cr1 = new CreateRequest();
		cr1.sendCreateRequest();
		}
		// ---------------Create Completed---------------------//
		// ---------------Delete---------------------//
		//System.out.println("Continue?");
	//	Scanner inputDelete= new Scanner(System.in);
	//	System.out.println("Please Enter the Opeartion:");
	//	String operationDelete= inputCreate.next();
		if (operation.equalsIgnoreCase("delete")){
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	Thread.sleep(2000);
		
		DeleteRequest dr1 = new DeleteRequest();
		dr1.sendDeleteRequest();
		}
		// ---------------Delete completed---------------------//


		// ------------------- Write Attribute --------------------//
	//	System.out.println("Continue?");
	//	Scanner inputWriteAttr= new Scanner(System.in);
	//	System.out.println("Please Enter the Opeartion:");
	//	String operationWAttr= inputWriteAttr.next();
		else if (operation.equalsIgnoreCase("writeattribute")){
	
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	Thread.sleep(5000);


		WriteAttributeRequest ob1 = new WriteAttributeRequest(10, 0, 0, 5); // resource:/10/0/0
																			// pmin=5
																			// seconds
		ob1.sendWriteAttributeRequest();
		}
		// ------------------- Observation Request ------------------//
		
	//	System.out.println("Continue?");
	//	Scanner inputObserve= new Scanner(System.in);
	//	System.out.println("Please Enter the Opeartion:");
	//	String operationObserve= inputObserve.next();
		else if (operation.equalsIgnoreCase("Observe")){
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	Thread.sleep(2000);

		URI uri_observe = new URI("http://localhost:8017/LWM2MClient/lwm2m/10/0/0/observe?tokenNo=777");

		System.out.println("\nObservation Request at uri : " + uri_observe);

		Client client_observe = Client.create();
		WebResource webresource_observe = client_observe.resource(uri_observe);

		ClientResponse resp_observe = webresource_observe.type("application/json").get(ClientResponse.class);

		String output_observe = resp_observe.getEntity(String.class);
		System.out.println("Observe Request reply : " + output_observe);

		if (resp_observe.getStatus() == 200) {
			System.out.println("Observe Testing Successful");
		} else {
			throw new RuntimeException("Error while Observing : HTTP error code : " + resp_observe.getStatus());
		}
		}
		// ------------------- Cancel Observation ------------------//
		
	//	System.out.println("Continue?");
	//	Scanner inputCancel= new Scanner(System.in);
	//	System.out.println("Please Enter the Opeartion:");
	//	String operationCancel= inputCancel.next();
		else if (operation.equalsIgnoreCase("cancel")){
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	//	Thread.sleep(10000);

		URI uri2 = new URI("http://localhost:8017/LWM2MClient/lwm2m/10/0/0/cancel");

		System.out.println("\nCancel request started at uri : " + uri2);

		WebResource webResource2 = client.resource(uri2);

		ClientResponse response2 = webResource2.type("application/json").post(ClientResponse.class);

		output = response2.getEntity(String.class);
		System.out.println("Cancel Response : " + output);

		if (response2.getStatus() == 200) {
		} else {
			throw new RuntimeException("Error while Discovering : HTTP error code : " + response2.getStatus());
		}
		}//cancel close
	}

}
