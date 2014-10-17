import java.net.URL;
import java.util.Hashtable;

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
		if(request[0].get("REQUEST").equals("POST")) {
			post(url,request[1], request[2]);
		} else if (request[1].get("REQUEST").equals("GET")) {
			get(url,request[1]);
		}
		return null;
	}
	//POST request
	private void post(URL url, Hashtable<String,String> headers, 
			Hashtable<String,String> content)
	{
		
		
	}
	
	//GET request
	private void get(URL url, Hashtable<String,String> headers)
	{
		
	}
	
	//adds URL Parameters to a URL and returns it as a URL(not a String)
	public static URL buildURL(String URL,Hashtable<String,String> params)
	{
		return null;
	}

}
