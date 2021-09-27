package steps;

import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import microsoft.LoginPage;
import static microsoft.Microsft.*;



public class LoginStep {
	
	LoginPage login = new LoginPage(driver);

	@Quando("usuario tiver acessando o app")
	public void usuarioTiverAcessandoOApp() {
	    
	}
	@Quando("inserir o email {string}")
	public void inserirOEmail(String email) {
	    login.inserirEmail(email);
	}
	@Quando("acionar o botao de entrar")
	public void acionarOBotaoDeEntrar() {
		login.acionarBotaoEntrar();
	}
	@Quando("inserir a senha {string}")
	public void inserirASenha(String senha) {
		login.inserirSenha(senha); 
	}
	@Entao("o app exibe a tela inicial")
	public void oAppExibeATelaInicial() {
	    
	}
}
