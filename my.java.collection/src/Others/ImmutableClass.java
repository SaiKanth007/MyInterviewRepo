package src.Others;

//https://www.geeksforgeeks.org/create-immutable-class-java/
public final class ImmutableClass {

	final private Object member1;
	final private Object member2;

	public ImmutableClass(Object member1, Object member2) {
		this.member1 = member1;
		this.member2 = member2;
	}

	public Object getMember1() {
		return member1;
	}

	public Object getMember2() {
		return member2;
	}

}
