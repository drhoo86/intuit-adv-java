package drhoo.intuit.examples;

public class TestLongId {

	public static void main(String[] args) {
		LongId<String>  stringId = new LongId<String>(1000);
		LongId<Integer> integerId = new LongId<Integer>(100);
		
		printIds(stringId, integerId);

	}

	public static void printIds(	LongId<String>  sid,
									LongId<Integer> iid) {
		
		System.out.println(" stringId = " + sid.getLong());
		System.out.println("integerId = " + iid.getLong());		
	}
}
