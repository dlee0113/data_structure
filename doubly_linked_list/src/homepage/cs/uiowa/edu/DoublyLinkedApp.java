package homepage.cs.uiowa.edu;

// http://homepage.cs.uiowa.edu/~sriram/21/spring07/code/doublyLinked.java
//doublyLinked.java
//demonstrates doubly-linked list
//to run this program: C>java DoublyLinkedApp
////////////////////////////////////////////////////////////////
class Link {
	public long dData; // data item
	public Link next; // next link in list
	public Link previous; // previous link in list
	// -------------------------------------------------------------

	public Link(long d) // constructor
	{
		dData = d;
	}

	// -------------------------------------------------------------
	public void displayLink() // display this link
	{
		System.out.print(dData + " ");
	}
	// -------------------------------------------------------------
} // end class Link
// //////////////////////////////////////////////////////////////

class DoublyLinkedList {
	private Link first; // ref to first item (head)
	private Link last; // ref to last item (tail)
	// -------------------------------------------------------------

	public DoublyLinkedList() // constructor
	{
		first = null; // no items on list yet
		last = null;
	}

	// -------------------------------------------------------------
	public boolean isEmpty() // true if no links
	{
		return first == null;
	}

	// -------------------------------------------------------------
	public void insertFirst(long dd) // insert at front of list
	{
		Link newLink = new Link(dd); // make new link

		if (isEmpty()) { // if empty list, both head and tail reference to the same link
			last = newLink; // newLink <-- last, make new link as tail
		}
		else {
			first.previous = newLink; // newLink <-- old first, point previous pointer of head to new link
			newLink.next = first; // newLink --> old first, point next pointer of new link to head
		}
		
		first = newLink; // first --> newLink, make new node as head as last step regardless of size of the list
	}

	// -------------------------------------------------------------
	public void insertLast(long dd) // insert at end of list
	{
		Link newLink = new Link(dd); // make new link
		
		if (isEmpty()) { // if empty list, both head and tail reference to the same link
			first = newLink; // first --> newLink, make new link as head
		}
		else {
			last.next = newLink; // old last --> newLink, point next pointer of tail to new link
			newLink.previous = last; // old last <-- newLink, point previous pointer of new link to tail
		}
		
		last = newLink; // newLink <-- last, make new link as tail as last step regardless of size of the list
	}

	// -------------------------------------------------------------
	public Link deleteFirst() // delete first link
	{ // (assumes non-empty list)
		Link temp = first;
		
		if (first.next == null) // if only one item
			last = null; // null <-- last
		else
			first.next.previous = null; // null <-- old next, point previous pointer of next node of head to null
		
		first = first.next; // first --> old next // make next node of first node as head
		
		return temp;
	}

	// -------------------------------------------------------------
	public Link deleteLast() // delete last link
	{ // (assumes non-empty list)
		Link temp = last;
		
		if (first.next == null) // if only one item
			first = null; // first --> null
		else
			last.previous.next = null; // old previous --> null, point next pointer of previous node of tail to null
		
		last = last.previous; // old previous <-- last, make previous node of tail as tail
		
		return temp;
	}

	// -------------------------------------------------------------
	// insert dd just after key
	public boolean insertAfter(long key, long dd) { // (assumes non-empty list)
		Link current = first; // start at beginning
		
		while (current.dData != key) // until match is found,
		{
			current = current.next; // move to next link
			
			if (current == null)
				return false; // didn't find it
		}
		
		Link newLink = new Link(dd); // make new link

		if (current == last) // if last link,
		{
			newLink.next = null; // newLink --> null, point next pointer of new link to null (sentinel node)
			last = newLink; // newLink <-- last, make new link as tail
		} else // not last link,
		{
			newLink.next = current.next; // newLink --> old next, point next pointer of new link to next link of current link
			current.next.previous = newLink; // newLink <-- old next, point previous pointer of next link of current link to new link
		}
		
		newLink.previous = current; // old current <-- newLink, point previous pointer of new link to current link
		current.next = newLink; // old current --> newLink, point next pointer of current link to new link
		
		return true; // found it, did insertion
	}

	// -------------------------------------------------------------
	public Link deleteKey(long key) // delete item w/ given key
	{ // (assumes non-empty list)
		Link current = first; // start at beginning
		
		while (current.dData != key) // until match is found,
		{
			current = current.next; // move to next link
			if (current == null)
				return null; // didn't find it
		}
		
		if (current == first) // found it; first item?
			first = current.next; // first --> old next, point next pointer of current node to head
		else
			// not first
			// old previous --> old next
			current.previous.next = current.next; // point next pointer of previous node of current node to next node of current node

		if (current == last) // last item?
			last = current.previous; // old previous <-- last, point previous pointer of current node to tail
		else
			// not last
			// old previous <-- old next
			current.next.previous = current.previous; // point previous pointer of next node of current node to previous node of current node
		
		return current; // return value
	}

	// -------------------------------------------------------------
	public void displayForward() {
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning
		while (current != null) // until end of list,
		{
			current.displayLink(); // display data
			current = current.next; // move to next link
		}
		System.out.println("");
	}

	// -------------------------------------------------------------
	public void displayBackward() {
		System.out.print("List (last-->first): ");
		Link current = last; // start at end
		while (current != null) // until start of list,
		{
			current.displayLink(); // display data
			current = current.previous; // move to previous link
		}
		System.out.println("");
	}
	// -------------------------------------------------------------
} // end class DoublyLinkedList
// //////////////////////////////////////////////////////////////

class DoublyLinkedApp {
	public static void main(String[] args) { // make a new list
		DoublyLinkedList theList = new DoublyLinkedList();

		theList.insertFirst(22); // insert at front
		theList.insertFirst(44);
		theList.insertFirst(66);

		theList.insertLast(11); // insert at rear
		theList.insertLast(33);
		theList.insertLast(55);

		theList.displayForward(); // display list forward
		theList.displayBackward(); // display list backward

		Link firstLinkdeleted = theList.deleteFirst(); // delete first item
		System.out.println("firstLinkdeleted: " + firstLinkdeleted.dData);
		
		Link lastLinkdeleted = theList.deleteLast(); // delete last item
		System.out.println("lastLinkdeleted: " + lastLinkdeleted.dData);
		
		theList.deleteKey(11); // delete item with key 11

		theList.displayForward(); // display list forward

		theList.insertAfter(22, 77); // insert 77 after 22
		theList.insertAfter(33, 88); // insert 88 after 33

		theList.displayForward(); // display list forward
	} // end main()
} // end class DoublyLinkedApp
// //////////////////////////////////////////////////////////////