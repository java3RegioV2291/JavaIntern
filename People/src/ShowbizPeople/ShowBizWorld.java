package ShowbizPeople;

public class ShowBizWorld {
	public static void main(String[] args) {
		KOL kol1 = new KOL();
		kol1.setGeneralInfor("Hà Linh", 25);
		
		
		KOL kol2 = new KOL();
		kol2.setGeneralInfor("Kendal", 29);
		
		Follower follower1 = new Follower();
		follower1.setGeneralInfor("A",12); 
		follower1.followKol(kol1);
		follower1.followKol(kol2);
				
		Follower follower2 = new Follower();
		follower2.setGeneralInfor("B",20);		
		follower2.followKol(kol2);
		
		Follower follower3 = new Follower();
		follower3.setGeneralInfor("C",19);
		follower3.followKol(kol2);
		
		kol1.publishPost(" Toi vua di Hawaii");
		kol2.publishPost(" Toi vua di bien");
		return;
	}

}