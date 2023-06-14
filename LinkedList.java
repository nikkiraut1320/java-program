import java.util.Scanner;

public class LinkedList {
	Node head;
	class Node
	{
		int data;
		Node next;
		Node(int data)
		{
			this.data=data;	
			this.next=null;
		}
	}
	
	public void insertLast(int data)
	{
		Node node=new Node(data);
		if(head==null)
		{
			head=node;
			return;
		}
		else
		{
			Node last=head;
			while(last.next!=null)
			{
				last=last.next;
			}
			
			last.next=node;
		}	
	}
	
	public void insertFirst(int data)
	{
		Node node=new Node(data);
		if(head==null)
		{
			head=node;
			return;
		}
		else
		{
			node.next=head;
			head=node;
		}		
	}
	
	public void deleteFirst()
	{
		if(head==null)
		{
			System.out.println("List is already empty");
			return;
		}
		else if(head.next==null)
		{
			head=null;
			System.out.println("node deleted");
			return;
		}	
		else
		{
			head=head.next;
		}
	}
	
	public void deleteLast()
	{
		if(head==null)
		{
			System.out.println("List is already empty");
		}
		else if(head.next==null)
		{
			head=null;
			System.out.println("Node deleted");
			return;
		}
		else
		{
			Node pre=head;
			Node cur=head.next;
			
			while(cur.next!=null)
			{
				pre=pre.next;
				cur=cur.next;
			}
			pre.next=null;		
		}
	}
	
	public void deleteByValue(int data)
	{
		if(head==null)
		{
			System.out.println("List is already empty");
			return;
		}
		else if(head.data==data)
		{
			head=head.next;
			System.out.println("Element deleted");
			return;
		}
		else
		{
			Node pre=head;
			Node cur=head.next;
			if(cur.data==data)
			{
				pre.next=cur.next;
				System.out.println("Element Deleted");
			}
			pre=pre.next;
			cur=cur.next;
		}
	}
	void search(int d)
	{
		int i=1;
		Node cur=head;
		
		while(cur!=null)
		{
			if(cur.data==d)
			{
				System.out.println("Element found at location "+i);
			}
			cur=cur.next;
			i++;
		}
	}
	
	void display(LinkedList list)
	{
		System.out.println("List :");
		Node cur=head;
		while(cur!=null)
		{
			System.out.println(cur.data);
			cur=cur.next;
		}
	}
	
	void reverse()
	{
		Node pre=null;
		Node cur=head;
		Node next=null;
		
		while(cur!=null)
		{
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		head=pre;
		
	}

	public static void main(String[] args) {
		LinkedList list=new LinkedList();
		Scanner sc=new Scanner(System.in);
		int i = 0;
		int ch=1;
		do
		{
		System.out.println("\n1.Insert First\n2.Insert Last\n3.Delete First\n4.Delete Last"
				+ "\n5.Delete by value\n6.Search\n7.Display\n8.Reverse "
				+ "\nEnter 0 to stop\nEnter Your choice");
		i=sc.nextInt();
		switch(i)
		{
		case 1: 
			System.out.println("Enter no to insert first in linkedlist");
			int no=sc.nextInt();
			list.insertFirst(no);
			break;
			
		case 2:
			System.out.println("Enter no to insert last in linkedlist");
			no=sc.nextInt();
			list.insertLast(no);
			break;
			
		case 3: 
			list.deleteFirst();
			break;
			
		case 4:
			list.deleteLast();
			break;
			
		case 5:
			System.out.println("Enter no to delete by value");
			no=sc.nextInt();
			list.deleteByValue(no);
			break;
		case 6:
			System.out.println("Enter no to search in the list");
			no=sc.nextInt();
			list.search(no);
			break;
			
		case 7: list.display(list);
				break;
		
		case 8:
			list.reverse();
			System.out.println("LIst is reversed");
			break;
		
		default:
			System.out.println("Invalid Choice");
		
		}
		System.out.println("Do you want to continue??");
		ch=sc.nextInt();
	}while(ch!=0);
	}

}
