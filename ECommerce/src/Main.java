import business.abstracts.UserService;
import business.concretes.UserManager;
import core.GoogleLoginAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;
import googleLogin.LoginService;

public class Main {

	public static void main(String[] args) {
		
		User mehmet1 = new User("Mehmet","�zcan","abcd@gmail.com","111111");
		User mehmet2 = new User("Me","�zcan","abcgmail.com","123112");
		User mehmet3 = new User("Mehmet","�zcan","abcd@gmail.com","1243112");
		User mehmet4 = new User("Mehmet","�z","abcgmail.com","12312");
		
		

		registerTest(mehmet1);
		registerTest(mehmet2);
		registerTest(mehmet3);
		registerTest(mehmet4);
		
		loginTest(mehmet1);
		loginTest(mehmet2);
		loginTest(mehmet3);
		loginTest(mehmet4);
		
		
	}
	
	private static void registerTest(User user) {
		UserService userService = new UserManager(new HibernateUserDao());
		
		boolean isSuccess = userService.register(user);
		if (isSuccess) {
			System.out.println("E-posta onaylanmay� bekliyor!");
			
			boolean isEmailTrue = userService.emailVerification(user);
			if (isEmailTrue) {
				System.out.println("Kay�t ba�ar�l�!");
			}
			else {
				System.out.println("Kay�t ba�ar�s�z!");
			}
		}
		else {
			System.out.println("Kay�t ba�ar�s�z!");
		}
		
		
		
		
		System.out.println("---------------------------------");
	}
	
	private static void loginTest(User user) {
		UserService userService = new UserManager(new HibernateUserDao());
		
		boolean isSuccess = userService.login(user);
		if (isSuccess) {
			System.out.println("Ba�ar�yla giri� yap�ld�!");
		}
		else {
			System.out.println("Giri� ba�ar�s�z!");
		}
		System.out.println("---------------------------------");
		
	}

}
