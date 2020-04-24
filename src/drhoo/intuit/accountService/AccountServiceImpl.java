package drhoo.intuit.accountService;

import java.util.HashMap;
import java.util.Map;

import drhoo.intuit.base.Abonent;
import drhoo.intuit.base.AccountService;
import drhoo.intuit.base.Address;
import drhoo.intuit.base.MessageSystem;
import drhoo.intuit.utils.TimeHelper;

public class AccountServiceImpl implements AccountService, Abonent, Runnable {
	private Address address;
	private MessageSystem ms;
	
	private Map<String, Integer> fakeAccounter = new HashMap<String, Integer>();
	
	public AccountServiceImpl(MessageSystem ms){
		this.ms = ms;
		this.address = new Address();
		ms.addService(this);
		this.fakeAccounter.put("Tully", 1);
		this.fakeAccounter.put("Sully", 2);
	}
	
	
	@Override
	public void run(){
		while(true){
				ms.execForAbonent(this);
				TimeHelper.sleep(10);
		}
	}

	@Override
	public Integer getUserId(String name){
		TimeHelper.sleep(5000);
		return fakeAccounter.get(name);
	}
	
	@Override
	public Address getAddress() {
		return address;
	}
	
	@Override
	public MessageSystem getMessageSystem(){
		return ms;
	}
}
