package src.Others;

import java.io.Serializable;

//https://www.geeksforgeeks.org/singleton-design-pattern/
//Also read about how this can be broken (reflections, serialization, Cloning)
public class SingleTon implements Serializable, Cloneable {

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

	// to protect singleTOn behavior from serialization and deserialization effects
	protected Object readResolve() {
		return singleTon;
	}

	@Override
	// to project singleTon behavior from Cloning
	public SingleTon clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	// to project singleTon behavior from Reflection, we have to use Enum
	// https://dzone.com/articles/java-singletons-using-enum
	public static void main() {

	}
}
