package designPatterns.dp04simplePattern;

public class Client {


	public static void main(String[] args) {
		Post post = PostFactory.getInstance("News");
		System.out.println(post);

		Post post1 = PostFactory.getInstance("DC");
		System.out.println(post1);

	}

}
