import java.util.*;
import java.lang.*;

public class MyCollections {

	public static void main(String[] args) {
		List<String> al = new ArrayList<String>();
			
        // Add elements to list al
		al.add("One");
        al.add("Two");
        al.add("Three");
        al.add("Four");
        al.add("Five");
        al.add("Six");
        al.add("Eight");
        al.add("Nine");
        al.add("Ten");
        // Add elements at specific index
        al.add(0, "Zero");
        
        // ArrayList
        System.out.println("Here's my list:");
        for (int i = 0; i < al.size(); i++) {
        	System.out.print(al.get(i));
        	if (i != 9) {
        		System.out.print(", ");
        	}
        	if (i == 4) {
        		System.out.println();
        	}
        }
        System.out.println();
        System.out.println();
        System.out.println("----------");
        
        
        System.out.println("Is Seven in the list? " + al.contains("Seven"));
        if (!al.contains("Seven")) {
        	al.add(7, "Seven");
        	System.out.println("Adding Seven to the list at index " + al.indexOf("Seven") + ".");
        }
        System.out.println();
        System.out.println("----------");
        
        // LinkedList
        LinkedList<String> ll = new LinkedList<String>();
        System.out.println("Size of LinkedList: " + ll.size());
        System.out.println("Is LinkedList empty? " + ll.isEmpty());
        if (ll.isEmpty()) {
        	ll.add("Orange");
        	System.out.println("Adding Orange to the LinkedList at index " + ll.indexOf("Orange") + ".");
        }
        // Add items to LinkedList
        ll.addFirst("Red");
        ll.add("Yellow");
        ll.add("Green");
        ll.add("Blue");
	    ll.add("Indigo");
	    ll.addLast("Violet");
        System.out.println("LinkedList contains colors of the rainbow: ");
	    System.out.println(ll);
	    System.out.println();
        System.out.println("----------");
        
        // Iterator
	    ListIterator<String> myItr = null;
        myItr = al.listIterator();
        System.out.println("Count forward:");
        while(myItr.hasNext()){
            System.out.println(myItr.next());
            if (myItr.nextIndex() == 6) {
            	break;
            }
        }
        
        System.out.println();
        System.out.println("Count backwards:");
        while(myItr.hasPrevious()){
            System.out.println(myItr.previous());
        }
        System.out.println();
        System.out.println("----------");
        
        // Hashtable & Enumeration
        Hashtable<String,String> ht = new Hashtable<String,String>();
        Enumeration abb;
        String coil;
        // Add keys
        ht.put("T1", "First Coil");
        ht.put("T6", "Second Coil");
        ht.put("T11", "Final Coil");
        ht.put("A5", "Midas");
        ht.put("A9", "Creator");
        ht.put("O1", "Delta");
        abb = ht.keys();
        System.out.println("Looking for group. Astrologian ilvl 270.");
        System.out.println("Cleared the following tiers:");
        while (abb.hasMoreElements()) {
        	coil = (String) abb.nextElement();
        	System.out.println(coil + ": " + ht.get(coil));
        }
        
        // HashSets and LinkedHashSets do not allow duplicate keys and allows null keys. 
        // LinkedHashSets keep the order of the keys; HashSets do not.
        // HashMaps are similar to Hashtables except that they permit null keys and are not synchronized.
        // Synchronized means only one thread can access it at a time
        // LinkedHashMpas preserves the insertion order; HashMaps do not.
        
        System.out.println();
        System.out.println("----------");
        
        // TreeSet
        TreeSet<Integer> ts = new TreeSet<Integer>();

        ts.add(23);
        ts.add(34);
        ts.add(24);
        ts.add(26);
        
        Iterator<Integer> it = ts.iterator();
        System.out.println("Pool of ages in asc order: ");
        while (it.hasNext()) {
        	System.out.println(it.next() + " ");
        }
        System.out.println();
        // Retrieve first data from tree set
    	System.out.println("Youngest: " + ts.first());
    	// Retrieve last data from tree set
    	System.out.println("Oldest: " + ts.last());
        System.out.println();
    	
        // Remove all
    	ts.clear();
    	if (ts.isEmpty()) {
    		System.out.println("There are no more ages.");
    		System.out.println("Therefore, we're dead.");
    	}
    	System.out.println();
        System.out.println("----------");
        
    	// TreeMap
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();

        tm.put(23, "Winter");
        tm.put(34, "Tech");
        tm.put(28, "Ardbob");
        tm.put(26, "Tanisaurus");
        
        Set set = tm.entrySet();
        Iterator iterator = set.iterator();
        System.out.println("How old is everyone?");
        System.out.println();
        while (iterator.hasNext()) {
        	// Iterate through a map
        	Map.Entry me = (Map.Entry)iterator.next();
        	System.out.print(me.getValue() + " is ");
        	System.out.println(me.getKey() + ".");
        }
        System.out.println();
        System.out.println(tm.get(tm.firstKey()) + " is the youngest.");
        System.out.println(tm.get(tm.lastKey()) + " is the oldest.");
    }
}