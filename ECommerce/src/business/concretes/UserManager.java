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
	
	//i� kurallar�
	
private boolean Check(User user) {
		
		if (user.geteMail().isEmpty() || user.getPassword().isEmpty()) {
			System.out.println("E-mail veya �ifre bo� b�rak�lamaz!!");
			return false;
		}
		
		if (user.getPassword().length() < 6) {
			System.out.println("�ifre en az 6 haneli olmal�!");
			return false;
		}
		if (!user.geteMail().matches(regex)) {
			System.out.println("Ge�ersiz e-posta girdiniz!");
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
			System.out.println("�sim veya soyisim bo� b�rak�lamaz.");
			return false;
		}
		
		if(user.getFirstName().length() < 3 || user.getLastName().length() < 3) {
			System.out.println("�sim ve soyisim en az 3 karakter olmal�d�r.");
			return false;
		}
		System.out.println("Kay�t i�lemi ba�ar�yla ger�ekle�ti.");
		return true;
		
		
	}

	@Override
	public boolean login(User user) {
		if(!Check(user)) {
			return false;
		}
		
		System.out.println("Giri� Ba�ar�l�");
		return true;
		
	}

	@Override
	public boolean emailVerification(User user) {
		System.out.println("E-Posta onayland�. Sisteme kayd�n�z tamamlanm��t�r.");
		userDao.add(user);
		return true;
	}

}
