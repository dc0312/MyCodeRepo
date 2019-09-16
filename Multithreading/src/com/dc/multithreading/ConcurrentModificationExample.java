package com.dc.multithreading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationExample {

    public static void main(String[] args) {
        List<String> li = new ArrayList<>();
        li.add("a");
        li.add("b");
        li.add("c");
        li.add("d");
        li.add("e");
        Iterator<String> itr = li.iterator();
        while(itr.hasNext()){
            String str = (String)itr.next();
            if(str.equalsIgnoreCase("b")){
                itr.remove();     //removing second last in list works fine
            }
        }
        System.out.println(li);
    }
}


/*I think you mean, if you're iterating a list, why does list.remove() cause a ConcurrentModificationException to be thrown
whereas iterator.remove() does not?

Consider this example:

    List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));

    for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
        if (iter.next().equals("b")) {
            // iter.remove();    // #1
            // list.remove("b"); // #2
        }
    }
If you uncomment line #1, it will work fine. If you uncomment line #2 (but leave #1 commented) then
 it will cause the subsequent call to iter.next() to throw ConcurrentModificationException.

The reason is that the iterator is a separate object that has some references to the internal state of the underlying list.
 If you modify the list while the iterator is in operation, it could cause the iterator to behave badly, e.g. by skipping elements, repeating elements,
  indexing off the end of the array, etc. It attempts to detect such modifications and so it throws ConcurrentModificationException if it does.

Removing elements through the iterator works and does not cause exceptions, because this updates the underlying list and
the iterator's state that refers to the internals of the list, so everything can stay consistent.

However, there is nothing special about iterator.remove() that makes it work in all cases.
If there are multiple iterators iterating over the same list, modifications made by one will cause problems for the others.
Consider:

    Iterator<String> i1 = list.iterator();
    Iterator<String> i2 = list.iterator();
    i1.remove();
    i2.remove();
We now have two iterators pointing into the same list. If we modify the list using one of them,
it disrupts the operation of the second, so the call to i2.remove() will result in ConcurrentModificationException.*/
