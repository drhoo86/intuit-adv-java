package drhoo.intuit;

public interface AddressService {

	public abstract Address getAddress(Class<?> abonentClass);

	public abstract void setAddress(Abonent abonent);

}