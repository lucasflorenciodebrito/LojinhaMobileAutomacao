package modulos.produto;


import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import telas.LoginTela;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

@DisplayName("Testes Mobiles do Módulo do Produto")
public class ProdutoTest {

    private  WebDriver app;

    @BeforeEach
    public void beforeEach() throws MalformedURLException {
        DesiredCapabilities capacidades = new DesiredCapabilities();
        capacidades.setCapability("deviceName","moto g(9) play");
        capacidades.setCapability("platform", "Android");
        capacidades.setCapability("udid","ZF5236CGKZ");
        capacidades.setCapability("appPackage", "com.lojinha");
        capacidades.setCapability("appActivity", "com.lojinha.ui.MainActivity");
        capacidades.setCapability("app","C:\\Users\\Lucas\\OneDrive\\Documentos\\PTQS\\Lojinha+Android+Nativa\\lojinha-nativa.apk" );

        this.app = new RemoteWebDriver(new URL("http:127.0.0.1:4723/wd/hub"), capacidades);
        this.app.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @DisplayName("Validação do Valor do Produto não permitido")
    @Test
    public void testValidarValorDeProdutoNaoPermitido()  {

        String mensagemApresentada = new LoginTela(app)
                .preencherUsuario("admin")
                .preencherSenha("admin")
                .clickBotaoLogin()
                .abrirTelaAdicaoProduto()
                .preencherNomeProduto("Iphone")
                .preencherValorProduto("700001")
                .preencherProdutoCor("preto, cinza")
                .submeterComErro()
                .obterMensagemDeErro();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);


    }

    @AfterEach
    public void afterEach(){
        app.quit();
    }
}
