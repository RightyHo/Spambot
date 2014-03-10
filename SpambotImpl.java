/**
* A spambot
*/
public class SpambotImpl implements Spambot {
	int numThreads;
	String seed;
	Set<String> toVisitLinks;
	Set<String> visitedLinks;
	Set<String> emails;

	public SpambotImpl(String seed){
		numThreads = 0;
		this.seed = seed;
		toVisitLinks = new HashSet<String>();
		visitedLinks = new HashSet<String>();
		emails =  new HashSet<String>();
	}
/**
* Sets the seed.
*
* The seed is the very first URL that has to be given to the
* system. The associated web page is the starting point for
* the whole process of fetching web pages, extracting their
* links and email addresses, and fetching more web pages.
*
* @param seedUrl the first URL to fetch and analyse
*/
public void setSeed(String seedUrl) throws MalformedURLException {
	this.seed = seedUrl;
}
/**
* Returns the seed URL.
* @return the seed URL.
*/
public String getSeed(){
	return seed;
}
/**
* Sets the number of threads.
*
* The user should be able to set the number of threads to be
* used for running the crawlers.
*
* @param count the number of threads (i.e. crawlers) to start in parallel
*/
public void setThreads(int count){
	numThreads = count;
}
/**
* Initiates the scanning process.
*/
public void scanSite(){
	if(toVisitLinks != null){
		for(String s : toVisitLinks){
			Crawler c1 = new CrawlerImpl(s);
			toVisitLinks = c1.getLinks();
			emails = c1.getEmails();
			String pageDone = wp.getUrl();
			visitedLinks.add(pageDone);
			toVisitLinks.remove(pageDone);
		}
	}

}

/**
* Returns all the emails gathered.
*
* This method should be executed only after the last crawlers
* have stopped. If it is called before that point, its
* behaviour is not defined.
*/
Set<String> getEMails();
}