package drhoo.intuit.messageSystem;

import drhoo.intuit.base.Abonent;
import drhoo.intuit.base.AccountService;
import drhoo.intuit.base.Address;
import drhoo.intuit.base.Msg;

public abstract class MsgToAS extends Msg{

	public MsgToAS(Address from, Address to) {
		super(from, to);		
	}

	public void exec(Abonent abonent) {
		if(abonent instanceof AccountService){
			exec((AccountService) abonent);
		}
	}

	public abstract void exec(AccountService accountService);
}
