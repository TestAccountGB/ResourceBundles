package resourceBundles;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class ResourceBundlesTest {
	private static Scanner scan = new Scanner(System.in);
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//Mas que porra e ResourceBundles? E basicamente um jeito muito foda de deixar nosso sistema trabalhando em
		//Diversos idiomas, como assim? A gente pode deixar mensagens predestinadas em diversos idiomas, por exemplo:
		//A mensagem "Bom dia" posso deixar ela para o idioma portugues e a mensagem "Good Morning" em ingles, sem
		//Mudar quase nada nada no codigo :O
		
		//Mas como cria um?
		
		//Simples meu amigo, primeiramente vamos criar um novo arquivo, igual criar um pacote ou uma nova classe, mas
		//Ao inves de criar uma class vamos criar um "file", mas tem uma parte muito importante que e a criacao do nome
		
		//Criando um nome...
		
		//Primeiramente vamos precisar de um "nome base", ----chamado de "label"-----, e esse nome colocamos ele relacionado
		//As strings que vao estar la, por exemplo: Quero criar um ResourceBundle de mensagens do cadastro, entao seu
		//Nome base vai ser "mensagensCadastro", mas normalmente colocamos esse nome base em ingles, ou seja, seu
		//Nome base ficaria "registrationMessages". Ok, depois de pensar em um nome, precisamos pensar nos idiomas
		//Que queremos colocar. Depois de pensar nos idiomas, temos que colocar eles no formato da ISO 639, ou seja,
		//Codigo da lingua (en (english)), e depois o codigo do pais (US (United States)), mesma coisa que o Locale.
		
		//Ok, depois de pensar nisso tudo vamos separar por underlines ( _ ), exemplo: 
		//registrationMessages_en_US.properties
		//Por que tem .properties no final? Essa e a extensao do ResourceBundles, ou seja, pro java reconher que aquele
		//Arquivo e um ResourceBundle precisamos usar o .properties.
		
		//Obs.: Crie o ResourceBundle no package "src", que ja vem de package padrao.
		
		//Instanciando um ResourceBundle...
		
		Locale localeEnglish = new Locale("en","US");
		Locale localeBrazil = new Locale("pt","BR");
		ResourceBundle rb = ResourceBundle.getBundle("welcomeMessages", localeEnglish);
		
		//Aviso Rapidinho:
		//Quando a gente "instancia" uma bundle com uma locale que nao temos criado no package "src", por exemplo:
		//ResourceBundle rb = ResourceBundle.getBundle("welcomeMessages", new Locale("en", "CA"));
		//Ele vai fazer o seguinte:
		
		//Vai procurar pelo locale que a gente colocou:
		//welcomeMessages_en_CA.properties
		//Mas se ele nao achar ele vai procurar apenas pela lingua:
		//welcomeMessages_en.properties
		//Mas se nao achar ele vai procurar o locale padrao da jvm (Depende do seu pc):
		//welcomeMessages_pt_BR.properties
		//Se ele nao achar ele vai procurar apenas pela lingua:
		//welcomeMessages_pt.properties
		//E se nao achar de novo ele vai procurar apenas pelo nome base:
		//welcomeMessages.properties

		//Ou seja, toma cuidado ao criar ResourceBundles, porque voce pode mostrar mensagens no idioma que voce nao
		//Quer, apenas porque colocou o locale escrito errado 
		
		//Voltando ao assunto...
		
		//Como pode ter visto, o ResourceBundle e uma classe abstrata, ou seja, nao podemos instancia-la, temos que usar
		//O metodo .getBundle().
		
		//Como usa ele? No primeiro parametro bote o nome base do seu ResourceBundle, por isso e importante criar um
		//Nome base e no segundo parametro bote a locale que voce quer, que ele vai procurar a ResourceBundle assim:
		//NomeBase + Locale, ou seja, welcomeMessages_en_US com a locale dos estados unidos. Obs.: Se voce nao colocar
		//Nenhuma Locale no metodo, ele vai pegar a locale da sua jvm padrao, como vejo isso? Assim...
		
		System.out.println(Locale.getDefault());
		
		//Ok, vamos para a pratica...
		
		//Para chamar as mensagens que escrevos nos Bundles usamos o metodo getString(), e o nome da chave dentro dos
		//Parenteses como String.
		
		System.out.println("\n========================");
		System.out.println(rb.getString("welcome"));
		System.out.println("\n" + rb.getString("number"));
		int Int = scan.nextInt();
		System.out.println("\n" + rb.getString("numberResult") + " 3 = " + (Int+3));
		System.out.println("\n\nTeste welcomeMessages.properties:\n" + rb.getString("lava"));
		
		//Para mudar o idioma e so colocar no .getBundle() o localeBrazil que ele vai mudar as mensagens automaticamente
		//Legal né? kkk
		
		//Aviso de amigo:
		//Toda vez que for fazer um projeto grandinho, tente trabalhar com ResourceBundle, porque la na frente voce pode
		//Querer botar diversos idiomas no seu sistema, e se voce nao tiver criado ele com ResourceBundle, vai dar uma
		//Dor de cabeca tremenda colocar outros idiomas. Outro motivo de suar ResourceBundle e que tudo fica organizado
		//Em um so arquivo com todas as mensagens
	}
}