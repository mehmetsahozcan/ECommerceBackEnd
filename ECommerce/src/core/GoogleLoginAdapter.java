package core;

public class GoogleLoginAdapter implements LoginService {

	@Override
	public void login() {
		googleLogin.LoginService loginService = new googleLogin.LoginService();
		loginService.loginGoogle();
		
	}

	@Override
	public void register() {
		googleLogin.LoginService loginService = new googleLogin.LoginService();
		loginService.registerGoogle();
		
	}

}
