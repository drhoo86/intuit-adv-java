package drhoo.intuit.base;

public interface MessageSystem {

	public abstract void addService(Abonent abonent);

	public abstract void sendMessage(Msg message);

	public abstract void execForAbonent(Abonent abonent);

	public abstract AddressService getAddressService();

}