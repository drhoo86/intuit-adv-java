package drhoo.intuit.messageSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import drhoo.intuit.base.Abonent;
import drhoo.intuit.base.Address;
import drhoo.intuit.base.AddressService;
import drhoo.intuit.base.MessageSystem;
import drhoo.intuit.base.Msg;

public class MessageSystemImpl implements MessageSystem {
	private Map<Address, ConcurrentLinkedQueue<Msg>> messages = new HashMap<Address, ConcurrentLinkedQueue<Msg>>();
	private AddressService addressService = new AddressServiceImpl();
	
	@Override
	public void addService(Abonent abonent){
		addressService.setAddress(abonent);
		messages.put(abonent.getAddress(), new ConcurrentLinkedQueue<Msg>());
	}
	
	@Override
	public void sendMessage(Msg message){
		Queue<Msg> messageQueue = messages.get(message.getTo());
		messageQueue.add(message);		
	}
		
	@Override
	public void execForAbonent(Abonent abonent) {
		Queue<Msg> messageQueue = messages.get(abonent.getAddress());
		if(messageQueue == null){
			return;
		}
		while(!messageQueue.isEmpty()){
			Msg message = messageQueue.poll();
			message.exec(abonent);
		}
	}
	
	@Override
	public AddressService getAddressService(){
		return addressService;
	}
}
