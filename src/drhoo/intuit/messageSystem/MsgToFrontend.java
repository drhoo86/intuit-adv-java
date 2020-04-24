package drhoo.intuit.messageSystem;

import drhoo.intuit.base.Abonent;
import drhoo.intuit.base.Address;
import drhoo.intuit.base.Frontend;
import drhoo.intuit.base.Msg;

public abstract class MsgToFrontend extends Msg{

	public MsgToFrontend(Address from, Address to) {
		super(from, to);
	}

	public void exec(Abonent abonent) {
		if(abonent instanceof Frontend){
			exec((Frontend)abonent);
		}
	}
	
	public abstract void exec(Frontend frontend);

}
