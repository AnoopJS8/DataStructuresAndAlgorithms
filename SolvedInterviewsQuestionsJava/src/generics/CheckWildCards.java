package generics;

import java.util.Collection;
import java.util.LinkedList;

/*
 * The addAll method adds all the items from a collection to the queue. Suppose
 * that we wanted to do the opposite: Add all the items that are currently on
 * the queue to a given collection. An instance method defined as
 * 
 * public void addAllTo(Collection<T> collection) would only work for
 * collections whose base type is exactly the same as T. This is too
 * restrictive. We need some sort of wildcard. However, "? extends T" won't
 * work. Suppose we try it:
 * 
 * public void addAllTo(Collection<? extends T> collection) { // Remove all
 * items currently on the queue and add them to collection while ( ! isEmpty() )
 * { T item = dequeue(); // Remove an item from the queue. collection.add( item
 * ); // Add it to the collection. ILLEGAL!! } } The problem is that we can't
 * add an item of type T to a collection that might only be able to hold items
 * belonging to some subclass, S, of T. The containment is going in the wrong
 * direction: An item of type T is not necessarily of type S. For example, if we
 * have a queue of type Queue<Shape>, it doesn't make sense to add items from
 * the queue to a collection of type Collection<Rect>, since not every Shape is
 * a Rect. On the other hand, if we have a Queue<Rect>, it would make sense to
 * add items from that queue to a Collection<Shape> or indeed to any collection
 * Collection<S> where S is a superclass of Rect.
 * 
 * To express this type of relationship, we need a new kind of type wildcard:
 * "? super T". This wildcard means, roughly,
 * "either T itself or any class that is a superclass of T." For example,
 * Collection<? super Rect> would match the types Collection<Shape>,
 * ArrayList<Object>, and Set<Rect>. This is what we need for our addAllTo
 * method. With this change, our complete generic queue class becomes:
 */


class Queue<T> {
	private LinkedList<T> items = new LinkedList<T>();

	public void enqueue(T item) {
		items.addLast(item);
	}

	public T dequeue() {
		return items.removeFirst();
	}

	public boolean isEmpty() {
		return (items.size() == 0);
	}

	public void addAll(Collection<? extends T> collection) {
		// Add all the items from the collection to the end of the queue
		for (T item : collection)
			enqueue(item);
	}

	public void addAllTo(Collection<? super T> collection) {
		// Remove all items currently on the queue and add them to collection
		while (!isEmpty()) {
			T item = dequeue(); // Remove an item from the queue.
			collection.add(item); // Add it to the collection.
		}
	}
}

public class CheckWildCards {

}

