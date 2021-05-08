package business.concretes;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	private UserDao userDao;
	private String regex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

	
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	//iþ kurallarý
	
private boolean Check(User user) {
		
		if (user.geteMail().isEmpty() || user.getPassword().isEmpty()) {
			System.out.println("E-mail veya þifre boþ býrakýlamaz!!");
			return false;
		}
		
		if (user.getPassword().length() < 6) {
			System.out.println("Þifre en az 6 haneli olmalý!");
			return false;
		}
		if (!user.geteMail().matches(regex)) {
			System.out.println("Geçersiz e-posta girdiniz!");
			return false;
		}
		return true;
	}
	

	@Override
	public boolean register(User user) {
		if(!Check(user)) {
			return false;
		}
		
		if(user.getFirstName().isEmpty() || user.getLastName().isEmpty()) {
			System.out.println("Ýsim veya soyisim boþ býrakýlamaz.");
			return false;
		}
		
		if(user.getFirstName().length() < 3 || user.getLastName().length() < 3) {
			System.out.println("Ýsim ve soyisim en az 3 karakter olmalýdýr.");
			return false;
		}
		System.out.println("Kayýt iþlemi baþarýyla gerçekleþti.");
		return true;
		
		
	}

	@Override
	public boolean login(User user) {
		if(!Check(user)) {
			return false;
		}
		
		System.out.println("Giriþ Baþarýlý");
		return true;
		
	}

	@Override
	public boolean emailVerification(User user) {
		System.out.println("E-Posta onaylandý. Sisteme kaydýnýz tamamlanmýþtýr.");
		userDao.add(user);
		return true;
	}

}
