package jfxui;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class Mediator {

	public Mediator(EntityManagerFactory emf) {
		if(emf == null){
			throw new NullPointerException("EMF cannot be null");
		}
		this.emf = emf;
	}
	
	public EntityManager createEntityManger(){
		return this.emf.createEntityManager();
	}
	
	private EntityManagerFactory emf;
}