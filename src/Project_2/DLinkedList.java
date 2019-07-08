package Project_2;



import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * An instance is a doubly linked list. It provides much of the functionality
 * of Java class java.util.LinkedList.
 */
public class DLinkedList<E> extends java.util.AbstractList<E> {
	
    /** Number of nodes in the linked list. */
    private int size;

    /** first node of the linked list (null if the list is empty) */
    private Node head;

    /** last  node of the linked list (null if the list is empty) */
    private Node tail;
    
    
    /** Constructor: an empty linked list. 
     * @return */
    public  DLinkedList() {
    	  	
        // TODO item #1
        // Look at the class invariant to determine how to implement this.
        //throw new NotImplementedError();
    	head= null;
    	tail = null;
    	size= 0;
    }

    
    
    /**
     * Return the number of elements in this list.
     * This operation must take constant time.
     */
    public @Override int size() {
    	
        // TODO item #2
        // This is an extremely small method
        //throw new NotImplementedError();

    	return this.size;
    }
    
    

    /**
     * Return "[s0, s1, .., sn]" where (s0, s1, .., sn) are strings representing
     * the objects contained in this, in order.  Uses toString to convert the
     * objects to strings.
     *
     * For example, if this contains 6 3 8 in that order, the result is "[6, 3, 8]".
     */
    public @Override String toString() {
    	
        String res= "[";
        // invariant: res = "[s0, s1, .., sk" where sk is the object before node n
        for (Node n = head; n != null; n= n.succ) {
            if (n != head)
                res= res + ", ";
            res= res + n.data;
        }
        return res + "]";
    }
    

    /**
     * Return "[sn, .., s1, s0]" where (s0, s1, .., sn) are strings representing
     * the objects contained in this, in order.  Uses toString to convert the
     * objects to strings.
     *
     * For example, if this contains 6 3 8 in that order, the result is "[8, 3, 6]".
     */
    public String toStringRev() {
    	
        // TODO item #3
        // This should use field tail and the pred fields in nodes.
        // Do NOT use field size.
        //throw new NotImplementedError();
    	String res ="[";
    	for(Node n=tail; n!=null; n=n.pred) {
    		if(n!= tail) {
    			res = res +", ";
    		}
    		res= res+ n.data;
    	}
    	return res +"]";
    }
    
    
    
    /**
     * Place element in a new node at the end of the list and return the new node.
     * This operation must take constant time.
     */
	private Node append(E element) {
    	
        // TODO item #4
        // This mid-size helper function will be used by other methods
       // throw new NotImplementedError();
		Node n = new Node(tail, element, null);
    	if(tail!=null) {
    		this.tail.setsucc(n);
    	}
		this.tail=n;
		if(head==null) {
			head=n;
		}
		size +=1;
		return n;
    }
	
	
    
    /** Append element to the end of this list and return true. */
    public @Override boolean add(E element) {
    	
        // TODO item #5
        // Rely on helper methods to keep this method small
        // This is THE MOST IMPORTANT method to get right because it will be used
        // in nearly every test
        //throw new NotImplementedError();
    	Node n=this.append(element);
    	if(n==tail) {
    		return true;
    	}
    	return false;
    }
    
    
    
    /**
     * Return the Node at the given index of this list.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */    
	private Node getNode(int index) {
		
    	//return (DLinkedList<E>.Node) mylist.get(index);
        // TODO item #6
        // This large helper method is used more than any other helper method
        // It is used by other public methods or for testing.
        // Note that there are two ways to get to a node: from the head or from the tail.
        // This MUST use the fastest way for index.
        // (If h is exactly the middle, then either way is ok.)
        //throw new NotImplementedError();		
		Node n= null;
		
		if (index>=size||index<0) {
			throw new IndexOutOfBoundsException("your index[0..size) is too big!");
		}
		
    	if(size -index > index) {
    		 n= head;
	    	for (int i =0; i<index; i++) {
	    		n=n.succ;
	    	}
    	}
    	else if(size - index <= index) {
    		n=tail;
    		for (int i =0; i<size-(index+1); i++) {
        		n=n.pred;
        	}	
    	}
    	return n;
    }
    
	
	
    /**
     * Return the Node at the given index of this list.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
	public @Override E get(int index) {
    	
        // TODO item #7
        // Rely on helper methods to keep this method small.
        // Note that the helper method could throw the exception; doesn't
        // have to be done here.
        //throw new NotImplementedError();
		return this.getNode(index).data;
    }
    
    /**
     * Replace the element at the given index of this list with e.
     * Takes time proportional to min(index, size - index).
     *
     * @param index the index of the node, in [0..size).
     *              0 is the first element, 1 is the second, etc.
     * @param e     the new value to place in the list
     * @return      the former value stored at the index
     * @throws IndexOutOfBoundsException if index is not in [0..size)
     */
    public @Override E set(int index, E element) {
    	
        // TODO item #8
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
        //throw new NotImplementedError();
    	if(index >= size || index<0){
    		throw new IndexOutOfBoundsException("your index [0..size) is to big");
    	}
    	this.getNode(index).setdata(element);
    	return this.getNode(index).data;
    }
    
    
    /**
     * Insert element in a new node at the beginning of the list and return the
     * new node.
     * Runs in constant time.
     */
    private Node prepend(E element) {

        // TODO item #9
        // This mid-size helper function will be used by other methods
        //throw new NotImplementedError();
    	Node n= new Node(null,element, head);
    	this.head = n;
    	size+=1;
    	return n;
    }
    
    
    /**
     * Insert element into a new node before Node node and return the new node.
     * Takes constant time.
     *
     * @param element the element to insert
     * @param node a non-null Node that must be in this list
     */
    private Node insertBefore(E element, Node node) {
    	assert node!=null;
    	
        // TODO item #10
        // This mid-size helper function will be used by other methods.
        // Do NOT test whether node is actually a Node of this list because
        // it will then not be a constant-time operation.
        //throw new NotImplementedError();   	
    	Node n0=node.pred;
    	Node n = new Node(n0, element, node);    	  	
    	node.setpred(n);
    	if(n0!=null) {
    	n0.setsucc(n);
    	}else if(n0==null) {
    		head=n;
    	}
    	size+=1;
    	return n;
    }
    
    
    /**
     * Insert e into this list at position i.
     * The element currently at index i, as well as all later elements, are
     * shifted down to make room for element.
     * Takes time proportional to min (index, size - index).
     *
     * @param e the element to insert
     * @param i the place to put e, in [0..size] (note: i == size is allowed!)
     * @throws IndexOutOfBoundsException if i is not in [0..size]
     */
    public @Override void add(int index, E element) {
    	
    	// TODO item #11
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
        //throw new NotImplementedError();
    	if(index>=size) {
    		throw new IndexOutOfBoundsException("your index[0..size) is too big!");
    	}
    	Node node0 = this.getNode(index).pred;
    	Node node = this.getNode(index);
    	Node n= new Node(node0,element, node);
    	node0.setsucc(n);
    	node.setpred(n);
    	size+=1;
    }
    
    
    
    /**
     * Remove n from this list and return its data.
     *
     * @param  n the node to remove.  It must be in this list and non-null.
     * @return the data inside of n
     */
    private E removeNode(Node n) {
    	
        // TODO item #12
        // This is a large helper method
        //throw new NotImplementedError();
    	n.pred.setsucc(n.succ);
    	n.succ.setpred(n.pred);
    	n.setsucc(null);
    	n.setpred(null);
    	return n.data;
    }
    
    
    /**
     * Remove and return the element at index i.
     * Takes time proportional to min(i, size - i).
     *
     * @param i the index of the element to remove, in [0..size).
     *          0 is the first element, 1 is the second, etc.
     * @return the removed element
     * @throws IndexOutOfBoundsException if i is not in [0..size)
     */
    public @Override E remove(int i) {

        // TODO item #13
        // Rely on helper methods to keep this method small.
        // Note that a helper method could throw the exception; doesn't
        // have to be done here.
        //throw new NotImplementedError();
    	int h=-1;
    	
    	for(Node n =head; n!=null; n=n.succ) {
    		h++;
    		if(h==i) {
    			Node n0 = n.pred;
    			Node n2 = n.succ;
    			n0.setsucc(n2);
    			n2.setpred(n0);
    			return n.data;
    		}
    	}
		throw new IndexOutOfBoundsException("your number[0..size) is too big!");
    }
    
    ////////////////////////////////////////////////////////////////////////////
    
    /** An instance is a node of this list. */
    private class Node {
        /** Predecessor of this node on list (null if this is the first node). */
        private Node pred;
        
        /** The data in this element. */
        private E data;
        
        /** Successor of this node on list. (null if this is the last node). */
        private Node succ;
        
        /** Constructor: an instance with predecessor node p (can be null),
          * successor node s (can be null), and data e. */
        private Node(Node p, E e, Node s) {
            this.pred = p;
            this.succ = s;
            this.data = e;
        }
        private void setdata(E e) {
        	this.data=e;
        }
        private void setpred(Node p) {
        	this.pred=p;
        }
        private void setsucc(Node s) {
        	this.succ= s;
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * Glass-box tests for DLinkedList.  Since this is an inner
     * class, it has access to DLinkedList's private types, fields, and methods.
     */
    public static class Tests {

        /**
         * Asserts that list satisfies its invariants.  It is useful to call
         * this after any tests that modify a linked list to ensure that the
         * list remains well-formed.
         *
         * @throws AssertionFailedError if the list is not well-formed
         */
        private static void assertInvariants(DLinkedList<?> list) {
            throw new NotImplementedError();
        }

        @Test
        public void testAppend() {
            DLinkedList<String> ll     = new DLinkedList<String>();
            DLinkedList<String>.Node n = ll.append("Mike");
            assertEquals("[Mike]", ll.toString());
            assertEquals("[Mike]", ll.toStringRev());
            assertEquals(1, ll.size());
            assertEquals(ll.tail, n);   
        }

        /** Compare DLinkedList to standard library list */
        @Test
        public void testToString() {
            List<Integer>  ll = new java.util.LinkedList<Integer>();
            List<Integer> dll = new DLinkedList<Integer>();
            
            assertEquals(dll.toString(), ll.toString());

            dll.add(5); ll.add(5);
            System.out.println(dll.toString());
            System.out.println(ll.toString());
            assertEquals(dll.toString(), ll.toString());
            
            dll.add(4); ll.add(4);
            System.out.println(dll.toString());
            System.out.println(ll.toString());
            assertEquals(dll.toString(), ll.toString());
        }
        
        
        @Test
        public void testToStringrev() {
        	DLinkedList<Integer> dll = new DLinkedList<Integer>();
        	dll.add(1);
        	dll.add(2);
        	dll.add(3);
        	assertEquals("[1, 2, 3]", dll.toString());
        	assertEquals("[3, 2, 1]", dll.toStringRev());
        }
        
        @Test
        public void testAdd() {
        	DLinkedList<Integer> dll = new DLinkedList<Integer>();
        	
        	assertEquals(true, dll.add(11));      	        	
        }
        
        @Test
        public void testGetNodeandGet() {
        	
        	DLinkedList<Integer> dll = new DLinkedList<Integer>();
        	dll.add(5);
        	dll.add(4);
        	dll.add(3);
        	
        	assertEquals(3, dll.getNode(2).data);
        	assertEquals(dll.getNode(2).data, dll.get(2));
        	
        	System.out.println("getNode: " + dll.toString());	
        }
        
        @Test 
        public void testSet() {
        	DLinkedList<String>dll = new DLinkedList<String>();
        	
        	dll.add("I");
        	dll.add("Love");
        	dll.add("your");
        	dll.add("dog");
        	
        	assertEquals("[I, Love, your, dog]", dll.toString());
        	
        	assertEquals("her", dll.set(2,"her").toString());
        	
        	assertEquals("[I, Love, her, dog]", dll.toString());
        }
        
        @Test
        public void testPrepend() {
        	DLinkedList<Integer>dll = new DLinkedList<Integer>();
        	
        	dll.add(1);
        	dll.add(2);
        	dll.add(3);
        	
        	assertEquals(0, dll.prepend(0).data);
        	
        	assertEquals("[0, 1, 2, 3]", dll.toString());
        }
        
        @Test
        public void testInsertBefore() {
        	DLinkedList<Integer>dll = new DLinkedList<Integer>();
        	DLinkedList<Integer>.Node n1 = dll.append(4);
        	dll.add(5);
        	DLinkedList<Integer>.Node n2 = dll.append(7);    	
        	
        	assertEquals("[4, 5, 7]", dll.toString());
        	dll.insertBefore(6, n2);
        	assertEquals("[4, 5, 6, 7]", dll.toString());
        	dll.insertBefore(3, n1);
        	assertEquals("[3, 4, 5, 6, 7]", dll.toString());
        }
        
        @Test
        public void TestaddwTwoparam() {
        	DLinkedList<String>dll = new DLinkedList<String>();
        	
        	dll.add("I");
        	dll.add("am");
        	dll.add("alan");
        	
        	assertEquals("[I, am, alan]", dll.toString());
        	
        	dll.add(2, "not");
        	
        	assertEquals("[I, am, not, alan]", dll.toString());
        	
        }
        
        @Test
        public void testRemoveNode() {
        	DLinkedList<Integer>dll = new DLinkedList<Integer>();
        	
        	dll.add(1);
        	dll.add(3);
        	dll.add(5);
        	DLinkedList<Integer>.Node n = dll.append(6);
        	dll.add(7);
        	
        	dll.removeNode(n);
        	
        	assertEquals("[1, 3, 5, 7]", dll.toString());	
        }
        
        @Test
        public void testRemove() {
        	DLinkedList<Integer>dll = new DLinkedList<Integer>();
        	dll.add(2);
        	dll.add(4);
        	dll.add(5);
        	dll.add(6);
        	
        	dll.remove(2);
        	
        	assertEquals("[2, 4, 6]", dll.toString());
        }
        
    }
}
