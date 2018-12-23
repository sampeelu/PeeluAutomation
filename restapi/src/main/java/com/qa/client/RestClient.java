package com.qa.client;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class RestClient<CloseableHttpResponse> {
	
	// GET method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //http get request
		CloseableHttpResponse closebaleHttpResponse =  (CloseableHttpResponse) httpClient.execute(httpget); //hit the GET URL

		return closebaleHttpResponse;

	}
	
	//get the method with header
	public CloseableHttpResponse get(String url, HashMap<String, String> headerMap) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //http get request
		
		for(Map.Entry<String,String> entry : headerMap.entrySet()){
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		CloseableHttpResponse closebaleHttpResponse =  (CloseableHttpResponse) httpClient.execute(httpget); //hit the GET URL
		return closebaleHttpResponse;
			
		}
		//post method
	public CloseableHttpResponse post(String url, String entityString, HashMap<String, String> headerMap) throws ClientProtocolException, IOException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPost httppost = new HttpPost(url); //http post request
		httppost.setEntity(new StringEntity(entityString)); //for payload
		
		//for headers:
		for(Map.Entry<String,String> entry : headerMap.entrySet()){
			httppost.addHeader(entry.getKey(), entry.getValue());
		}
		
		CloseableHttpResponse closebaleHttpResponse = (CloseableHttpResponse) httpClient.execute(httppost);
		return closebaleHttpResponse;
		
		
	}
		
	}

