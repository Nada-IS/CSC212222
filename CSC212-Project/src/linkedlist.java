import java.util.*;

public class linkedlist<T> implements List<T>{
		public Node<T>head; 
		public Node<T>current;
		Scanner input= new Scanner(System.in);
		public linkedlist() { 
			System.out.println('n');
		head=current=null; 
		} 
		public boolean empty() { 
		return head==null;//1 
		//bigO(1) 
		} 
		public boolean last() { 
		return current.next==null; 
		//bigO(1) 
		} 
		public boolean full( ) { 
		return false; 
		//bigO(1) 
		} 
		public void findFirst() { 
		current=head; 
		//bigO(1) 
		} 
		public void findNext() { 
		current=current.next; 
		//bigO(1) 
		} 
		public T retrieve() { 
		return current.data;
		//bigO(1) 
		} 
		public void update(T val) { 
		current.data=val; 
		}
		public boolean exist(T E) {
		if(empty())
		return false;
		findFirst();
		Contact e =((Contact)E);
		while (current.next!=null)//cuurent.next!=null
		{
		Contact a =((Contact)current.data);
		if(a.getName().equals(e.getName()) || a.getPhoneNumber().equals(e.getPhoneNumber())) {
		System.out.print("the contact is already exist " + a.toString() +"\n");
		return true;
		}
		//findNext();
		}
		/*check the last elemnt
		Contact a =((Contact)current.data);
		if(a.getName().equals(e.getName()) || a.getPhoneNumber().equals(e.getPhoneNumber())) {
		System.out.print("the contact is already exist " + a.toString() +"\n");
		return true; }*/
		return false; 
		}
		public void add(T Con) {
		Node<T> con = new Node(Con); 
		Contact CastCon = ((Contact)con.data);
		if(!(exist(Con)))
		if(head==null)
		head = current = con;
		else {
		if(CastCon.compareTo(((Contact)head.data)) < 0) {
		con.next=head;
		head=con;
		}
		else {
		Node<T> prev = null;
		Node<T> temp = head;
		while(temp!=null) {
		if(CastCon.compareTo(((Contact)temp.data))< 0){
		prev.next = con;
		con.next = temp;
		current = con;
		break;
		}
		prev = temp;
		temp = temp.next;
		}//end while
		}
		} 
		}//end add
		public Contact search() {
		
		System.out.println("Enter search criteria: ");
				 
		int x;
		x = input.nextInt();
		switch(x) {
		 case 1: //by name
		  System.out.println("Enter the name: ");
		  String name= input.next();
		  current=head;
		  while(current.getNext()!= null) {
		  if(((Contact) current.getData()).getName().equals(name))
		   return ((Contact)current.getData());
		  else
		  return null;}
		break;
						
		case 2: //phone
		 System.out.println("Enter the phone number: ");
		 String number= input.next();
		 current=head;
		 while(current.getNext()!= null) {
		  if(((Contact) current.getData()).getPhoneNumber().equals(number))
		  return ((Contact)current.getData());
		  else
			return null;}
		break;
						
	    case 3: //email
		 search_email();
		    break;
						
		case 4: //address
		  search_address();
		  break;
						
		case 5: //birthday
			search_birthday();
			 break;
		default:
			System.out.println("Re-enter a correct number from 1-5");
					}
		return null;
				
				
			}
		
		public Contact delete() {
		 Node<T> d= current;
		if (current == head) {//Current is the first one 
			head = head.next; 
		current=head;
		return d;
		} 
		else {
			
		if(current.next==null) {
				Node<T> temp =current;
				temp.next=null;
				current=head;
				return d;}
				
			else {// current in the middle
				Node<T> before =head;
				while(before.next!=current)
				{before=before.getNext();}
				
				before.next=current.getNext();}
			return d;}
				}//end delete
		
		public linkedlist<T> search_email(){
			linkedlist LL_email= new linkedlist();
			System.out.println("Enter the E-mail: ");
			String email= input.next();
			current=head;
			
			while(current.getNext()!= null) {
				if(((Contact) current.getData()).getEmailAddress().equals(email)) {
					LL_email.add(current);
					return LL_email;}
			else 
				return null;
				}
			return null;}
		
		public linkedlist<T> search_address(){
			linkedlist LL_address= new linkedlist();
			System.out.println("Enter the Address: ");
			String address= input.next();
			current=head;
			
			while(current.getNext()!= null) {
				if(((Contact) current.getData()).getAddress().equals(address)) {
					LL_address.add(current);
					return LL_address;}
			else
				return null;
		}
			return LL_address;}
			
		public linkedlist<T> search_birthday(){
			linkedlist LL_birthday= new linkedlist();
			System.out.println("Enter the birthday: ");
			String birthday= input.next();
			current=head;
			
			while(current.getNext()!= null) {
				if(((Contact) current.getData()).getBirthday().equals(birthday)) {
					LL_birthday.add(current);
					return LL_birthday;}
			else return null;
		}
			return LL_birthday;
		}
		
		/*public void add(T c) {
		Node NewC =new Node(c);
		if (head==null) 
		head=current=new Node(c);
		else {
		Node<T> temp = head;
		while(temp.getNext()!=null) {
		Contact a = ((Contact)temp.data);
		Contact c1 = ((Contact)NewC.data);
		if((a.getName().equals(c1.getName())) || (a.getPhoneNumber().equals(c1.getPhoneNumber()))) 
		System.out.println("The Cnatact is already exist");
		else {
		current = head;
		temp = current.next;
		//if (c1.getName().compareTo(((Contact)current.data).getName()) < 0 )
		if (c1.compareTo(a)< 0){
		NewC.next=temp;
		current.next=NewC;
		current=NewC;
		}
		else {
		temp = temp.next;
		current = current.next;
		}
		}
		}//end while
		}
		}*/
		}



