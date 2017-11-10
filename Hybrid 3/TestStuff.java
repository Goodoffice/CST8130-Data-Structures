
public class TestStuff {

	public static void main(String[] args) {
		Stuff myStuff = new Stuff(17);
		System.out.println(myStuff);
		myStuff.doSomething(2.9);
		System.out.println(myStuff);
		String s = "Original";
		myStuff.ChangeString(s);
		System.out.println(s);
		System.out.println(myStuff);

	}

}
