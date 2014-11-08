cs211-project5
==============
I did one test case, and went through the debugger and it seems to sort the Person objects okay. I really was just working on getting the add and search functions to work. I haven’t yet looked at the differences in the ArrayList, linked list, and small array and why they take longer or shorter. And we need to write more test cases for:
1. boundary cases for the add method to make sure they get sorted correctly
2. public Comparable getData() returns the data of the node, which must be of Comparable type.
	make sure that data is of class Comparable and that Comparables other than Person actually work
3. test the search method to see if it finds what we’re actually looking for (I haven’t done this at all. I’m just guessing that the method is finding her Waldo String in the Driver class because it finishes)
4. any other bugs that you can think of that will get triggered because of limit cases and such.

If you know how to use github, you can commit any changes you have. If not, you can just email anything you write.
https://github.com/kcustom11/cs211-project5

here’s one of my prints of the Driver class. Notice the different times for adding and searching between the three types of lists.
adding: unsorted array(faster than)unsorted ArrayList(faster than)Linked List(faster than)sorted ArrayList
searching: unsortedArrayList(faster than)linked list(faster than)sorted ArrayList(faster than)sorted array
however the searching seems to vary a bit based on where the Waldo String shows up (early or later)

seeded waldo
done adding 10000 people in sorted linked list in 	498617966

done adding 10000 people in unsorted ArrayList in 	5549117

done adding 10000 people in unsorted small array in 	4834568

done adding 10000 people in sorted ArrayList in 	2313307119

done searching linked list for LLNode@7f31245a in 	1021778

done searching unsortedArrayList for 6340 in 		796007

done searching sorted small array for 4660 in 		18411718

done searching sortedArrayList for 4469 in 		1062755
