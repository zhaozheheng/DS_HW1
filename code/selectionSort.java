import java.util.Scanner;
import javax.print.DocFlavor.INPUT_STREAM;

public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkList list = new LinkList();
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		java.util.Random random = new java.util.Random();
		System.out.println("Enter the size of the list you like:");	//input size of the list
		int size = scanner.nextInt();	//get the size of list
		for (int i = 0; i < size; i++) {
			list.insertFirst(random.nextInt(100));	//generate the list by using random int
		}
		System.out.println("Unsorted List:");
		list.displayList();	//display the unsorted list
		System.out.println();
		list.selectSort();	//sort the list
		System.out.println("Sorted List:");
		list.displayList();	//display the sorted list
	}

}

class Node {	//define the node structure
	public int val;
	public Node next;
	
	public Node(int id) {
		val = id;
	}
	
	public void displayLink() {	//display the node value
		System.out.print(val + " ");
	}
}

class LinkList{	//define the linked list structure
	private Node head;
	
	public LinkList() {	//initialize the head node of the list
		head = null;
	}
	
	public boolean isEmpty() {	//check whether the list is empty
		return (head == null);
	}
	
	public void insertFirst(int id) {	//insert node at the head of the list
		Node newNode = new Node(id);
		newNode.next = head;
		head = newNode;
	}
	
	public void displayList() {	//display the whole list
		Node current = head;
		while(current != null) {
			current.displayLink();
			current = current.next;
		}
	}
	
	public void selectSort() {	//selection sort algorithm
		Node current;
		Node current2;
		Node min;
		int tmp;
		current = head;
		while (current != null) {
			min = current;
			current2 = current.next;
			while (current2 != null) {
				if (min.val > current2.val) {
					min = current2;
				}
				current2 = current2.next;
			}
			tmp = current.val;
			current.val = min.val;
			min.val = tmp;
			current = current.next;
		}
	}
}
