package Programs.com.dc.designPatterns.dp08DecoratorDesignPattern;

public class Client {

	public static void main(String[] args) {
		Message m = new TextMessage("The <FORCE> is strong with this one!");
		System.out.println(m.getContent());

		Message decor = new HtmlEncodedMessage(m);

		System.out.println(decor.getContent());

		decor = new Base64EncodedMessage(decor);

		System.out.println(decor.getContent());

	}
}
