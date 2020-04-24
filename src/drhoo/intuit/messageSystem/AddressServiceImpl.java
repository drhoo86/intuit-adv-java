package drhoo.intuit.messageSystem;

import java.util.HashMap;
import java.util.Map;

import drhoo.intuit.base.Abonent;
import drhoo.intuit.base.Address;
import drhoo.intuit.base.AddressService;

public class AddressServiceImpl implements AddressService {
	private Map<Class<?>, Address> addresses = new HashMap<Class<?>, Address>();
	
	@Override
	public Address getAddress(Class<?> abonentClass) {
		return addresses.get(abonentClass);
	}
	
	@Override
	public void setAddress(Abonent abonent) {
		addresses.put(abonent.getClass(), abonent.getAddress());
	}
}
