package ShowbizPeople;
import java.util.List;
import java.util.ArrayList;
public class KOL extends AbstractPeople2 {
	protected boolean hasNewPost;
	
	List<Follower>  listOfFollower = new ArrayList<>();
	
	protected void saveFollowers (Follower _follower) {
		listOfFollower.add(_follower);			
	}
	protected void publishPost(String newPost) {	
		System.out.println(this.getName() +" dang bai: " + newPost);
		this.hasNewPost= true;
		//System.out.println("Tiktoker " + this.getName() + " vừa đăng bài mới");
		for (Follower person: listOfFollower) {
			person.receiveNoti(this);
		}
	}
	
	
}
