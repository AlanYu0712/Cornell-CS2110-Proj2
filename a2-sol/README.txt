This code is organized a little different than yours probably is, because I
chose to implement the circular linked list in addition to the standard one.

 - File CLinkedList.java contains the circular implementation

 - File ListTest.java contains my black-box tests.  These tests work for both
   CLinkedList and DLinkedList (and in fact, for any java.util.List).  I have
   small Test classes in CLinkedList and DLinkedList that both extend these
   tests with tests that are specific to those classes.  In particular, both
   override the assertInvariants method, since the invariants are different for
   the two data structures.

 - This is a really good example of using subclasses in real life!

I've also implemented the ListIterator interface at the bottom of the
CLinkedList if you would like to see that.  It's not tested at all!
