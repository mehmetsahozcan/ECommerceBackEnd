import business.abstracts.UserService;
import business.concretes.UserManager;
import core.GoogleLoginAdapter;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;
import googleLogin.LoginService;

public class Main {

	public static void main(String[] args) {
		
		User mehmet1 = new User("Mehmet","Özcan","abcd@gmail.com","111111");
		User mehmet2 = new User("Me","Özcan","abcgmail.com","123112");
		User mehmet3 = new User("Mehmet","Özcan","abcd@gmail.com","1243112");
		User mehmet4 = new User("Mehmet","Öz","abcgmail.com","12312");
		
		

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
			System.out.println("E-posta onaylanmayý bekliyor!");
			
			boolean isEmailTrue = userService.emailVerification(user);
			if (isEmailTrue) {
				System.out.println("Kayýt baþarýlý!");
			}
			else {
				System.out.println("Kayýt baþarýsýz!");
			}
		}
		else {
			System.out.println("Kayýt baþarýsýz!");
		}
		
		
		
		
		System.out.println("---------------------------------");
	}
	
	private static void loginTest(User user) {
		UserService userService = new UserManager(new HibernateUserDao());
		
		boolean isSuccess = userService.login(user);
		if (isSuccess) {
			System.out.println("Baþarýyla giriþ yapýldý!");
		}
		else {
			System.out.println("Giriþ baþarýsýz!");
		}
		System.out.println("---------------------------------");
		
	}

}
