package src.Others;

//https://www.geeksforgeeks.org/singleton-design-pattern/
//Also read about how this can be broken (reflections, serialization, Cloning)
public class SingleTon {

	// lazy loading
	private static SingleTon singleTon = null;

	private SingleTon() {

	}

	public static SingleTon getSingleTon() {
		if (singleTon == null) {
			synchronized (SingleTon.class) {
				if (singleTon == null)
					singleTon = new SingleTon();
			}
		}
		return singleTon;
	}

	public static void main() {

	}
}
