package programs;

public interface Test extends Test1,Test2{

	@Override
	default void testDef() {
		// TODO Auto-generated method stub
		//Test1.super.testDef();
		System.out.println("test");
	}

}
