package src.Others;

//implementing a generic iterator
// Go through the iterator implementation once
public class MyInterator<T> {
	T collection;
	int[] storageArray;

	public MyInterator(T pCollection, int length) {
		this.collection = pCollection;
	}
}
