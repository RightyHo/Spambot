import java.util.Set;
import java.io.*;
import java.lang.*;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashSet;

public class WebPageImpl implements WebPage{
	String url;

	public WebPageImpl(String url){
		this.url = url;
	}
	/**
	* Returns the URL that identifies this web page.
	* @return the URL that identifies this web page.
	*/
	public String getUrl(){
		return url;
	}
	/**
	* Returns all the links on this webpage.
	*
	* Implementing classes should return a read-only view of this
	* set, using Collections.unmodifiableSet().
	*
	* @return all the links on this webpage.
	*/
	public Set<String> getLinks(){
		Set<String> result = new HashSet<String>();
		BufferedReader in = null;
		try{
			URL web = new URL(url);
			InputStream is = web.openStream();
			in = new BufferedReader(new InputStreamReader(is));
			String line;
			String link;
			while ((line = in.readLine()) != null) {
				if(line.contains("<a")){
					int start = line.indexOf("<a");
					int end = line.indexOf(">");
					link = line.substring(start,end);
					if(!(link.contains("@"))){
						System.out.println("This is a web link: " + link);
						result.add(link);
					}
				}
			}
			return result;
		} catch (IOException ex){
			ex.printStackTrace();
		} finally {
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}
	/**
	* Returns all the emails on this webpage.
	*
	* Implementing classes should return a read-only view of this
	* set, using Collections.unmodifiableSet().
	*
	* @return all the emails on this webpage.
	*/
	public Set<String> getEmails(){
		Set<String> result = new HashSet<String>();
		BufferedReader in = null;
		try{
			URL web = new URL(url);
			InputStream is = web.openStream();
			in = new BufferedReader(new InputStreamReader(is));
			String line;
			String link;
			while ((line = in.readLine()) != null) {
				if(line.contains("<a")){
					int start = line.indexOf("<a");
					int end = line.indexOf(">");
					link = line.substring(start,end);
					if(link.contains("@")){
						System.out.println("This is an Email address: " + link);
						result.add(link);
					}
				}
			}
			return result;
		} catch (IOException ex){
			ex.printStackTrace();
		} finally {
			try {
				if(in != null){
					in.close();
				}
			} catch (IOException ex){
				ex.printStackTrace();
			}
		}
		return result;
	}
	// Also, implementing classes should override equals() to
	// ensure that p1.equals(p2) returns true if and only if
	// p1.getUrl().equals(p2.getUrl()) returns true
	@Override
	public boolean equals(WebPage otherPage){
		if(otherPage.getUrl().equals(url)){
			return true;
		} else {
			return false;
		}
	}
}