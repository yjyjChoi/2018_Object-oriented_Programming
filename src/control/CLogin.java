package control;
import model.MLogin;

public class CLogin {
	private MLogin mLogin;

	public boolean validateUser(String ID, String password) {
		this.mLogin = new MLogin();
		return this.mLogin.validateUser(ID, password);
	}
}
