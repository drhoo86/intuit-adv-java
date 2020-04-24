package drhoo.intuit;

public abstract class MsgToFrontend extends Msg{

	public MsgToFrontend(Address from, Address to) {
		super(from, to);
	}

	public void exec(Abonent abonent) {
		if(abonent instanceof FrontendImpl){
			exec((Frontend)abonent);
		}
	}
	
	abstract void exec(Frontend frontend);

}
