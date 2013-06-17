/*
License: MIT license
Copyright (C) 2013 limbenjamin.com

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

Instructions:
This script checks your current IP address and updates your namecheap domain DDNS.
Replace domain and password with the ones found in your namecheap account before use.
*/ 

import java.net.*;
import java.io.*;
import java.util.*;

public class update_dns {
	public static void main(String[] args) throws Exception{
		URL url = null,url2=null;
		String inputLine;

		try {
		    url = new URL("http://checkip.dyndns.org:8245");
		} catch (MalformedURLException e) {
		    e.printStackTrace();
		}
		BufferedReader in,in2=null;
		    URLConnection con = url.openConnection();
		    con.setReadTimeout( 3000 ); 
		    in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		    while ((inputLine = in.readLine()) != null) {
				String ip=inputLine.substring(inputLine.indexOf("ess")+5, inputLine.indexOf("</body>"));
				url2 = new URL("http://dynamicdns.park-your-domain.com/update?domain=example.com&password=password&host=@&ip="+ip);
			    URLConnection con2 = url2.openConnection();
			    con2.setReadTimeout( 3000 ); 
			    in2 = new BufferedReader(new InputStreamReader(con2.getInputStream()));
			    while ((inputLine = in.readLine()) != null) {
					String ip2=inputLine;
					ip2.concat(null);
			    }
		    }
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		System.out.println("Success "+ip+" "+ timeStamp);
		in.close();
		in2.close();

	}
}

