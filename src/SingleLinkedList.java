public class SingleLinkedList {
	Node head;
	public void addLast(Object data) {//Adds the item to the end of the SLL
		if(head == null) {
			Node node = new Node(data);
			head = node;
		}
		else {
			Node temp = head;
			while(temp.getLink() != null) {
				temp = temp.getLink();
			}
			Node node = new Node(data);
			temp.setLink(node);
		}
	}
	public void addFirst(Object data) { //Adds the item at the top of the SLL
		if(head == null) {
			Node node = new Node(data);
			head = node;
		}
		else {
			Node node = new Node(data);
			node.setLink(head);
			head = node;
		}
	}
	public void addToIndex(Object newdata, int index) { //Adds the item to the specified index
		if(index==0) {
			Node node = new Node(newdata);
			node.setLink(head);
			head = node;
			return;
		}
		if(size() < index) {
			System.out.println("Index out of range");
			return;
		}
		Node temp = head;
		for(int i=1; i<index; i++) {
			temp = temp.getLink();
		}
		Node newnode = new Node(newdata);
		newnode.setLink(temp.getLink());
		temp.setLink(newnode);
	}
	public Object getFirst() { //Returns the head
		if(head == null) {
			System.out.println("Linked list is empty");
			return null;
		}
		return head.getData();
	}
	public Object getLast() { //Returns the last item
		if(head == null) {
			System.out.println("Linked list is empty");
			return null;
		}
		Node temp = head;
		while(temp.getLink() != null) {
			temp = temp.getLink();
		}
		return temp.getData();
	}
	public void removeFirst() { //Removes the first element
		if(head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		head = head.getLink();
	}
	public void removeLast() { //Removes the last element
		if(head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		if(size() == 1) head=null;
		Node temp = head;
		while(((Node)temp.getLink()).getLink() != null) {
			temp = temp.getLink();
		}
		temp.setLink(null);
	}
	public void removeFromIndex(int index) { //Removes item from specified index
		if(head == null) {
			System.out.println("Linked list is empty");
			return;
		}
		if(index >= size()) {
			System.out.println("Index out of range");
			return;
		}
		if(index == 0) {
			head = head.getLink();
			return;
		}
		Node temp = head;
		for(int i=0; temp !=null && i<index-1 ; i++) {
			temp = temp.getLink();
		}
		if(temp == null || temp.getLink() == null) return;
		Node next = (temp.getLink()).getLink();
		temp.setLink(next);
	}
	public void removeItem(Object dataToDelete) { //Deletes specified item
		Node temp = head;
		Node prev = null;
		if(temp != null && temp.getData() == dataToDelete) {
			head = temp.getLink();
			return;
		}
		while(temp != null && temp.getData() != dataToDelete) {
			prev = temp;
			temp = temp.getLink();
		}
		if(temp == null) return;
		prev.setLink(temp.getLink());
	}
	public int size() { //Returns length of SLL
		Node temp = head;
		int counter=0;
		while(temp != null) {
			temp = temp.getLink();
			counter++;
		}
		return counter;
	}
	public void replace(Object newdata, int index) { //deletes the item in the specified index and inserts a new one
		removeFromIndex(index);
		addToIndex(newdata, index);
	}
	public void swapNodes(int a, int b) { //Swaps nodes from two specified index
		if(a==b) return;
		int index1 = a<b ? a: b;
		int index2 = a>b ? a: b;
		Node temp = head;
		int index =0;
		Node temp1 = null;
		Node temp2= null;
		Node temp1front= null;
		Node temp2front= null;
		while(temp != null) {
			if(index == index1) temp1 = temp;
			if(index == index2) temp2 = temp;
			if(index == index1-1) temp1front = temp;
			if(index == index2-1) temp2front = temp;
			temp = temp.getLink();
			index++;
		}
		if (temp1 == null || temp2 == null) {
			System.out.println("Index out of range");
			return;
		}
		if(temp1front != null) temp1front.setLink(temp2);
		else head = temp2;
		temp2front.setLink(temp1);
		temp = temp1.getLink();
		temp1.setLink(temp2.getLink());
		temp2.setLink(temp);
	}
	public int getFirstIndex(Object item) { //Returns index of specified item (returns first occurrence)
		if(head == null) {
			System.out.println("Linked list is empty");
			return -1;
		}
		Node temp =head;
		int count=0;
		while(temp!=null) {
			if(item == temp.getData()) return count ;
			temp = temp.getLink();
			count++;
		}
		return -1;
	}
	public Object fromIndex(int index) { //Returns node from specified index
		if(head == null) {
			System.out.println("Linked list is empty");
			return null;
		}
		if(index<0 || index>=this.size()) {
			System.out.println("Specified index is invalid");
			return null;
		}
		Node temp =head;
		for(int i=0; i<index;i++) {
			if(temp == null) return null;
			temp = temp.getLink();
		}
		return temp.getData();
	}
	public boolean isContain(Object item) { //Returns whether SLL contains specified item as boolean
		Node  temp = head;
		while(temp !=null) {
			if(temp.getData() == item) return true;
			temp = temp.getLink();
		}
		return false;
	}
	public void sortedInsert(Object newdata, boolean ascending) {
		Node data = new Node(newdata);
		if(head == null) {
			head = data;
			return;
		}
		Node temp = head;
		try {
			if( ascending ? ((int)newdata < (int)head.getData()) : ((int)newdata > (int)head.getData())) {
				data.setLink(head);
				head = data;
				return;
			}
			while(temp.getLink() != null) {
				if(ascending ? (((int)temp.getLink().getData()) >= (int)newdata) : (((int)temp.getLink().getData()) <= (int)newdata)) break;
				temp = temp.getLink();
			}
		}catch(Exception e) {
			if(ascending ? (((String)newdata).compareTo((String)(head.getData()))<0) : (((String)newdata).compareTo((String)(head.getData()))>0)) {
				data.setLink(head);
				head = data;
				return;
			}
			while(temp.getLink() != null) {
				if(ascending ? (((String)temp.getLink().getData()).compareTo((String)newdata)>=0) :  (((String)temp.getLink().getData()).compareTo((String)newdata)<=0)) break;
				temp = temp.getLink();
			}
		}
		data.setLink(temp.getLink());
		temp.setLink(data);
	}
	public void sort(boolean ascending) {
		if(size() == 1) return;
		SingleLinkedList newList = new SingleLinkedList();
		Node temp = head;
		for(int i = 0; i<size() ; i++) {
			newList.sortedInsert(temp.getData(), ascending);
			temp = temp.getLink();
		}
		head = newList.head;
	}
	public void display() { //Displays all the items in SLL
		if (head == null) 
			System.out.println("linked list is empty");
		else {
			Node temp = head;
			while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.getLink();
			} 
		}
	}
}
