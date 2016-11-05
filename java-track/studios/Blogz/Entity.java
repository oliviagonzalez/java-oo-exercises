package Blogz;

import java.util.UUID;

public abstract class Entity {
	
	private final UUID uid;
	
	public Entity(){
		this.uid = UUID.randomUUID();
	}
	public UUID getUid(){
		return this.uid;
	}

}
