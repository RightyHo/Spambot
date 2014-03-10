/**
* An interface for a crawler program
*
*/
public class CrawlerImpl {
	String url;
	public CrawlerImpl(Str url){
		this.url = url;
	}

	public Set<String> getLinks(){
		WebPage wp = new WebPageImpl(url);
		return wp.getLinks();
	}
	public Set<String> getEmails(){
		return wp.getEmails();

	}
}