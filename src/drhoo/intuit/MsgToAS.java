package drhoo.intuit;

public abstract class MsgToAS extends Msg{

	public MsgToAS(Address from, Address to) {
		super(from, to);		
	}

	void exec(Abonent abonent) {
		if(abonent instanceof AccountServiceImpl){
			exec((AccountService) abonent);
		}
	}

	abstract void exec(AccountService accountService);
}
