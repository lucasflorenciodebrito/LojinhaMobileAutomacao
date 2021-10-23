package telas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormularioAdicaoDeProdutosTela extends BaseTela{


    public FormularioAdicaoDeProdutosTela(WebDriver app){
        super(app);

    }

    public FormularioAdicaoDeProdutosTela preencherNomeProduto (String nome){

        app.findElement(By.id("com.lojinha:id/productName")).click();
        app.findElement(By.id("com.lojinha:id/productName")).findElement(By.id("com.lojinha:id/editText")).sendKeys(nome);

        return this;
    }

    public FormularioAdicaoDeProdutosTela preencherValorProduto (String valor){

        app.findElement(By.id("com.lojinha:id/productValue")).click();
        app.findElement(By.id("com.lojinha:id/productValue")).findElement(By.id("com.lojinha:id/editText")).sendKeys(valor);

        return this;
    }

    public FormularioAdicaoDeProdutosTela preencherProdutoCor(String cor){

        app.findElement(By.id("com.lojinha:id/productColors")).click();
        app.findElement(By.id("com.lojinha:id/productColors")).findElement(By.id("com.lojinha:id/editText")).sendKeys(cor);

        return this;
    }

    public FormularioAdicaoDeProdutosTela submeterComErro(){

        app.findElement(By.id("com.lojinha:id/saveButton")).click();

        return this;
    }

    public String obterMensagemDeErro(){
        return capturarToast();
    }


}
