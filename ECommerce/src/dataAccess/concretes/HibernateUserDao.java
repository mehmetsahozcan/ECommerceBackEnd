package dataAccess.concretes;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao {

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName()+" " +  "adl� kullan�c� Hibernate ile eklendi ");
	}

	@Override
	public void delete(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName()+" " +  "adl� kullan�c� Hibernate ile silindi ");
		
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() + " " + user.getLastName()+" " +  "adl� kullan�c� Hibernate ile g�ncellendi ");		
	}

	@Override
	public void get() {
		// TODO Auto-generated method stub
		
	}

}
