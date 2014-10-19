import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Hashtable;

import javax.net.ssl.HttpsURLConnection;


import android.os.AsyncTask;

/**
 * 
 * @author Sahit Chintalapudi
 *
 */
public class Requests extends AsyncTask<Hashtable<String,String>,String,Void>{
	URL url; //url to send requests to
	public Requests(URL url)
	{
		this.url = url;
	}
	/**
	 * called on start(). performs request operation
	 * @param request:
	 * 		request[0] contains pair "REQUEST", "..." where ... is GET or POST
	 * 		request[1] contains headers
	 * 		if posting:
	 * 		request[2] contains key/val pairs to be posted
	 */
	@Override
	protected Void doInBackground(Hashtable<String,String>... request) {
		//init connection to site
		HttpsURLConnection conn = null;
		try {
			conn = (HttpsURLConnection) url.openConnection();
		} catch (IOException e) { e.printStackTrace(); }
		conn.setReadTimeout(10000);
		conn.setConnectTimeout(10000);
	
		if(request[0].get("REQUEST").equals("POST")) {
			try {
				post(conn,request[1], request[2]);
			} catch (IOException e) {}
		} else if (request[1].get("REQUEST").equals("GET")) {
			get(conn,request[1]);
		}
		return null;
	}
	//POST request
	private void post(HttpsURLConnection conn, Hashtable<String,String> headers, 
			Hashtable<String,String> content) throws IOException
	{
		//setup connection for POST
		conn.setDoInput(true);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		//Writer to connection
		OutputStream os = conn.getOutputStream();
		BufferedWriter writer = new BufferedWriter(
		        new OutputStreamWriter(os, "UTF-8"));
		//iterate over headers
		for(String headerKey : headers.keySet()) {
			conn.setRequestProperty(headerKey, headers.get(headerKey));
		}
		
		
	}
	
	//GET request
	private void get(HttpsURLConnection conn, Hashtable<String,String> headers)
	{
		
	}
	
	//adds URL Parameters to a URL and returns it as a URL(not a String)
	public static URL buildURL(String URL,Hashtable<String,String> params)
	{
		return null;
	}

}
