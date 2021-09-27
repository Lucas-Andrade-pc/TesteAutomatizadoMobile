package microsoft;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Microsft {

	public static AndroidDriver<?> driver;

	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "15ab69f9");
		desiredCapabilities.setCapability("automationName", "UiAutomator2");
		desiredCapabilities.setCapability("appPackage", "com.microsoft.todos");
		desiredCapabilities.setCapability("appActivity", "com.microsoft.todos.ui.LaunchActivity");

		URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver(remoteUrl, desiredCapabilities);
	}

	public void selecionarUsuario() {
		MobileElement usuario = (MobileElement) driver
				.findElementByXPath("//android.widget.TextView[@text='hackerTrollx1@outlook.com']");
		usuario.click();
	}

	public void selecionarTarefa() {
		MobileElement tarefa = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text='Tarefas']");
		tarefa.click();
	}

	public void acionarBotaoTarefa() {
		MobileElement botaotarefa = (MobileElement) driver
				.findElement(MobileBy.AccessibilityId("Adicionar uma tarefa"));
		botaotarefa.click();

	}
	
	int contadorTarefa=1;
	public void editarTarefa() {

		MobileElement edit = (MobileElement) driver
				.findElementByXPath("//android.widget.EditText[@text='Adicionar uma tarefa']");
		
		edit.sendKeys("Tarefa "+contadorTarefa);
	}

	public void concluirTarefa() {
		MobileElement concluir = (MobileElement) driver.findElementByXPath(
				"//android.widget.ImageView[@resource-id='com.microsoft.todos:id/create_task_image_button']");
		concluir.click();
	}

	// #######################################################################################################################
	
	public void selecionarTarefaConcluida() {
		MobileElement tarefaConlcuida = (MobileElement) driver.findElementByXPath(
				"//android.widget.TextView[@text='Tarefa 1']");
		tarefaConlcuida.click();
	}

	public void acionarAnotacao() {
		
		MobileElement anotacao = (MobileElement) driver
				.findElementByXPath("//android.widget.TextView[@text='Adicionar anotação']");
		anotacao.click();
		
	}
	public void adicionarMensagem() {
		MobileElement anotacaoMensagem = (MobileElement) driver
				.findElementByXPath("//android.view.ViewGroup[@resource-id='com.microsoft.todos:id/title_row']");
		
		anotacaoMensagem.sendKeys("Anotado com sucesso!");
	}
	
	public void excluirTarefa(){
		MobileElement excluirTarefa = (MobileElement) driver
				.findElement(MobileBy.AccessibilityId("Excluir tarefa"));
		excluirTarefa.click();
	}
	
	public void acionarBotaoExcluir() {
		MobileElement anotacao = (MobileElement) driver
				.findElementByXPath("//android.widget.Button[@text='EXCLUIR']");
		anotacao.click();
	}
	
	//Cenario: Cadastrar nova tarefa #######################################################################################################################
	public void cadastrarUmaNovaAtividade() throws Exception {
		Thread.sleep(4000);
		selecionarUsuario();
		Thread.sleep(5000);
		selecionarTarefa();
		Thread.sleep(4000);
		acionarBotaoTarefa();
		Thread.sleep(4000);
		editarTarefa();
		Thread.sleep(4000);
		concluirTarefa();
		Thread.sleep(4000);
	}
	// Cenario: Editar anotação 
	public void editarAnotacao() throws Exception {
		Thread.sleep(4000);
		selecionarUsuario();
		Thread.sleep(4000);
		selecionarTarefa();
		Thread.sleep(4000);
		selecionarTarefaConcluida();
		Thread.sleep(4000);
		acionarAnotacao();
		Thread.sleep(2000);
		adicionarMensagem();
	}
	//Cenario: Deletar tarefa
	public void deletarTarefa() throws Exception {
		selecionarUsuario();
		Thread.sleep(4000);
		selecionarTarefa();
		Thread.sleep(4000);
		selecionarTarefaConcluida();
		Thread.sleep(4000);
		excluirTarefa();
		acionarBotaoExcluir();
	}

	@Test
	public void sampleTest() throws Exception {
		//cadastrarUmaNovaAtividade();
		//editarAnotacao();
		deletarTarefa();
		contadorTarefa++;
	}

	@After
	public void tearDown() {
		// driver.quit();
	}
}
