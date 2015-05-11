/**
 * A double-linked list with a pointer to its first and last element.
 */
public class List {
	private Element first;
	private Element last;

	public List() {
		first = last = null;
	}

	/**
	 * Returns true if this list contains no elements.
	 * 
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * Returns the first element in this list.
	 * 
	 * @return the first element in this list or null if this list is empty
	 */
	public Element getFirst() {
		return first;
	}

	/**
	 * Returns the last element in this list.
	 * 
	 * @return the last element in this list or null if this list is empty
	 */
	public Element getLast() {
		return last;
	}

	/**
	 * Inserts the specified element at the beginning of this list.
	 * 
	 * @param value
	 *            the element to add
	 */
	public void addFirst(Element element) {
		if (isEmpty()) {
			first = last = element;
		} else {
			element.setNext(first);
			first.setPrev(element);
			first = element;
		}
	}

	/**
	 * Inserts the specified element at the end of this list.
	 * 
	 * @param value
	 *            the element to add
	 */
	public void addLast(Element element) {
		if (isEmpty()) {
			first = last = element;
		} else {
			last.setNext(element);
			element.setPrev(last);
			last = element;
		}
	}

	/**
	 * Returns the element at the specified position in this list.
	 * 
	 * @param index
	 *            index of the element to return
	 * @return the element at the specified position in this list or null if the position is smaller than 1 or greater than the length of the list
	 */
	public Element get(int position) {
		if (position < 1) {
			return null;
		}
		Element runningElement = first;
		for (int i = 1; i < position; i++) {
			if (runningElement == null) {
				return null;
			}
			runningElement = runningElement.getNext();
		}
		return runningElement;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		Element runningElement = first;
		while (runningElement != null) {
			sb.append(runningElement.getValue().toString());
			if (!runningElement.equals(last)) {
				sb.append(", ");
			}
			runningElement = runningElement.getNext();
		}
		sb.append("]");
		return new String(sb.toString());
	}

	/**
	 * Inserts an element behind another element.
	 * 
	 * @param newElement
	 *            the new element that is to be inserted into the list
	 * @param prev
	 *            the element behind which the new element is to be inserted
	 */
	public void insertAfter(Element newElement, Element prev) {
		if (prev.equals(last)) {
			last = newElement;
		} else {
			Element next = prev.getNext();
			newElement.setNext(next);
			next.setPrev(newElement);
		}
		prev.setNext(newElement);
		newElement.setPrev(prev);
	}

	/**
	 * Inserts an element ahead of another element.
	 * 
	 * @param newElement
	 *            the new element that is to be inserted into the list
	 * @param next
	 *            the element ahead of which the new element is to be inserted
	 */
	public void insertBefore(Element newElement, Element next) {
        //TODO: Code hier einfuegen
	}

	/**
	 * Remove an element from the list.
	 * 
	 * @param element
	 *            the element that is to be removed
	 */
	public void deleteThis(Element element) {
		//TODO: Code hier einfuegen
	}

	/**
	 * Determines and returns this list's length, i.e., its number of elements
	 * 
	 * @return this list's length
	 */
	public int length() {
		//TODO: Code hier einfuegen
        
        return -1;
	}

	/**
	 * Inverts the list, i.e., reverses the sequence of elements of this list.
	 */
	public void reverse() {
		//TODO: Code hier einfuegen
	}
	
	public static void main(String[] args) {
		System.out.println("Beginne mit leerer Liste:");
		List list = new List();
		System.out.println("\t" + list);

		System.out.println("Fuelle Liste:");
		list.addFirst(new Element("as"));
		list.addFirst(new Element("you"));
		list.addFirst(new Element("are"));
		list.addLast(new Element("bored"));
		list.addLast(new Element("as"));
		list.addLast(new Element("I"));
		list.addLast(new Element("am"));
		System.out.println("\t" + list);

		System.out.println("Loesche Element an Position 4:");
		list.deleteThis(list.get(4));
		System.out.println("\t" + list);

		System.out.println("Fuege neues Element \"excited\" vor Position 4 ein:");
		list.insertBefore(new Element("excited"), list.get(4));
		System.out.println("\t" + list);

		System.out.println("Invertiere Liste:");
		list.reverse();
		System.out.println("\t" + list);

		System.out.println("Berechne Laenge der Liste:");
		System.out.println("\t" + list.length());
	}

}
