package drhoo.intuit;

public interface AccountService {

	public abstract void run();

	public abstract Integer getUserId(String name);

	public abstract Address getAddress();

	public abstract MessageSystem getMessageSystem();

}