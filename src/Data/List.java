package Data;

import java.util.Iterator;

/**
 * this is a link list
 * @author Google, Stack Overflow, Ullman, et al and Alberto
 *
 * @param <E> the type of the elements
 */
public class List<E> {
	
	private int size;
	private Node<E> first; // always be a empty node
	private Node<E> pointer; // point to the list node in the list
	/**
	 * this standard constructor
	 */
	public List(){
		this.size = 0;
		this.first = new Node<E>(null,null);
		this.pointer = this.first;
	}
	/**
	 * add a new element into the list
	 * @param e a new element 
	 */
	public void add(E e){
		this.pointer.setNext(new Node<E>(e,this.pointer));
		this.pointer = this.pointer.getNext();
		this.size++;
	}
	/**
	 * remove one node from this list
	 * @param e the element will be remove
	 * @return the element removed; null for otherwise
	 */
	public E remove(E e){
		Node<E> p = this.first.getNext();
		while(p!=null){
			if(p.getElement()==e){
				p.getPrev().setNext(p.getNext());
				if(p.getNext()!=null) p.getNext().setPrev(p.getPrev());
				if(this.pointer==p) this.pointer = this.pointer.getPrev();
				this.size--;
				return p.getElement();
			}
			p=p.getNext();
		}
		return null;
	}
	/**
	 * get the size of this list
	 * @return a integer number (size)
	 */
	public int getSize(){
		return this.size;
	}
	
	/**
	 * standard toString method
	 */
	public String toString(){
		String s = "";
		Node<E> p = this.first.getNext();
		while(p!=null){
			s+=p.toString() +'\n';
			p=p.getNext();
		}
		
		return s;
	}
	/**
	 * get all element in the list
	 * @return a Iterable object
	 */
	public Iterable<E> getAll(){
		return new ElementIterable<E>(this.first.getNext());
	}
	
	/**
	 * the iterable class
	 * @author Bing
	 *
	 * @param <E> the type of element
	 */
	@SuppressWarnings("hiding")
	private class ElementIterable<E> implements Iterable<E>{
		
		private Node<E> pointer;
		/**
		 * constructor
		 * @param p the reference of the first node
		 */
		public ElementIterable(Node<E> p){
			this.pointer = p;
		}
		
		@Override
		public Iterator<E> iterator() {
			return new ELementIterator<E>(this.pointer);
		}
		/**
		 * the iterator
		 * @author Bing
		 *
		 * @param <E> the type of element
		 */
		private class ELementIterator<E> implements Iterator<E>{

			private Node<E> pointer;
			/**
			 * constructor
			 * @param p the reference of the first node
			 */
			public ELementIterator(Node<E> p){
				this.pointer = p;
			}
			@Override
			public boolean hasNext() {
				return this.pointer!=null;
			}

			@Override
			public E next() {
				Node<E> n = this.pointer;
				this.pointer = this.pointer.getNext();
				return n.getElement();
			}

			@Override
			public void remove() {
				// do not use this method
				
			}
			
		}
		
	}

	
	/**
	 * this is the node in the link list
	 * @author Bing
	 *
	 * @param <E> the type of the elements
	 */
	@SuppressWarnings("hiding")
	private class Node<E>{
		private E element;
		private Node<E> next;
		private Node<E> prev;
		/**
		 * the constructor
		 * @param e the element
		 * @param p the previous node
		 */

		public Node(E e, Node<E> p){
			this.element = e;
			this.prev = p;
			this.next = null;
		}
		/**
		 * get the reference of next node
		 * @return next node
		 */

		public Node<E> getNext(){
			return this.next;
		}
		/**
		 * get the reference of previous node
		 * @return previous node
		 */
		public Node<E> getPrev(){
			return this.prev;
		}
		/**
		 * get the element which this node held
		 * @return the element
		 */
		public E getElement(){
			return this.element;
		}
		/**
		 * change the reference of next node
		 * @param n the reference of node
		 */
		public void setNext(Node<E> n){
			this.next = n;
		}
		/**
		 * change the reference of previous node
		 * @param p the reference of node
		 */
		public void setPrev(Node<E> p){
			this.prev = p;
		}
		/**
		 * change the element which this node held
		 * @param e the element
		 */
		@SuppressWarnings("unused")
		public void setElement(E e){
			this.element = e;
		}
		/**
		 * standard toString method
		 */
		public String toString(){
			return this.element.toString();
		}
		
	}
	
	/**
	 * test function
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new List<String>();
		l.add("abc");
		l.add("bcd");
		l.add("asd");
		for(String s : l.getAll()){
			if(s.compareTo("abc")==0){
				//l.remove(s);
			}
		}
		System.out.println(l);
		System.out.println(l.getSize());
	}

}
