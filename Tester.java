import java.util.Set;

public class Tester {
	public static void main(String[] args){
		Tester t = new Tester();
		t.launch();
	}
	private void launch(){
		WebPage wp = new WebPageImpl("http://titan.dcs.bbk.ac.uk/~aho04/test.htm");
		Set<String> webLinks = wp.getLinks();
		Set<String> emailAddresses = wp.getEmails();
		WebPage wp2 = new WebPageImpl("http://titan.dcs.bbk.ac.uk/~aho04/test.htm");
		if(wp.equals(wp2)){
			System.out.println("killed it");

		}
	}
}