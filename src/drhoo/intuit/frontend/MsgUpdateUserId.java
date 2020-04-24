package drhoo.intuit.frontend;

import drhoo.intuit.base.Address;
import drhoo.intuit.base.Frontend;
import drhoo.intuit.messageSystem.MsgToFrontend;

public class MsgUpdateUserId extends MsgToFrontend {

	private String name;
	private Integer id;
	
	public MsgUpdateUserId(Address from, Address to, String name, Integer id) {
		super(from, to);
		this.name = name;
		this.id = id;
	}

	public void exec(Frontend frontend) {
		frontend.setId(name, id);
	}

}
