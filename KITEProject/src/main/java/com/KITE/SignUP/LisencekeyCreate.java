package com.KITE.SignUP;

import java.util.UUID;

public class LisencekeyCreate {
	
	public String Licencekey() {
		UUID uuid = UUID.randomUUID();
		String key = uuid.toString();
		
		return key;
	}

}
