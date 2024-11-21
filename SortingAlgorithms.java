package dataStructure;
import java.util.InputMismatchException;
import java.util.Scanner;
public class SortingAlgorithms {
	private long[] a;
	private int nElems;
	private ArrayInOb per;
		void Header(){
			System.out.println("Welcome to Sorting Algorithms Using Java\n(Bubble, Selection, Insert & Object)"); }
		public SortingAlgorithms(int max) {
			a = new long[max];
			nElems = 0;
			per = new ArrayInOb(10);}
		public void resetArray() {
		    a = new long[a.length];
		    nElems = 0;
		    per = new ArrayInOb(10);}
		public void display() {
			for(int j=0; j<nElems; j++)
			System.out.print(a[j] + " ");}
		public void display2() {
			for(int j=9; j>=0; j--)
			System.out.print(a[j] + " ");}
		public void bubbleSort(){
			for(int out=nElems-1; out>0; out--)
				for(int in=0; in<out; in++)
					if( a[in] > a[in+1] )
						swap(in, in+1);	}
		public void selectionSort() {
			for(int out=0; out<nElems-1; out++) {
				int min = out;
				for(int in=out+1; in<nElems; in++)
					if(a[in] < a[min] )
						min = in;
					swap(out,min); } }
		private void swap(int one, int two){
			long temp = a[one];
			a[one] = a[two];
			a[two] = temp; }
		public void insertionSort(){
			for(int out=1; out<nElems; out++) {
			long temp = a[out];
			int in = out;
			while(in>0 && a[in - 1] >= temp) {
				a[in] = a[in-1];
				--in;
				} a[in] = temp; } }
		public void Sort() {
		    Scanner scn = new Scanner(System.in);
		    for (int i = 1; i <= 10; i++) {
		        while (true) {
		            try {
		                System.out.print("Enter " + i + (i == 1 ? "st" : (i == 2 ? "nd" : (i == 3 ? "rd" : "th"))) + " item: ");
		                a[nElems] = scn.nextLong(); nElems++; break;
		            } catch (InputMismatchException ex) {
		                System.out.println("Invalid input! Please enter a valid number.");
		                scn.next(); } } } }
		private int getMenuChoice(Scanner scn) {
		    while (true) {
		        try {
		            return scn.nextInt();
		        } catch (InputMismatchException e) {
		            System.out.print("Invalid input! Please enter a valid number: ");
		            scn.next(); } } }
class Person {
	private String lastName, firstName;
	private int age;
	public Person(String last, String first, int a){
		lastName = last;
		firstName = first;
		age = a; }
	public void displayPerson() {
        System.out.println(" Last name: " + lastName + ", First name: " + firstName + ", Age: " + age); }
	public String getLast() {
        return lastName; } }
class ArrayInOb {
    private Person[] a;
    private int nElems;
    public ArrayInOb(int max) {
        a = new Person[max];
        nElems = 0; }
    public void insert(String last, String first, int age) {
        if (nElems < a.length) {
            a[nElems] = new Person(last, first, age);
            nElems++; 	} else {
            System.out.println("Array is full, cannot insert more Persons."); } }
    public void display() {
        for(int j=0; j<nElems; j++)
            a[j].displayPerson();
        System.out.println(""); }
    public void display2() {
        for(int j=9; j>=0; j--)
            a[j].displayPerson();
        System.out.println(""); }
    public void objectSort() {
        for(int out=1; out<nElems; out++) {
            Person temp = a[out];
            int in = out;
            while(in>0 &&a[in-1].getLast().compareTo(temp.getLast())>0) { a[in] = a[in-1]; --in; } a[in] = temp; } } }
	public static void main(String[] args) {
		SortingAlgorithms mid = new SortingAlgorithms(10); Scanner scn = new Scanner(System.in);
		mid.Header();
		int menu, e, age;
		do { do {
			System.out.print("Sorting Algorithms Menu:\n    1.  Bubble Sort\n    2.  Selection Sort\n    3.  Insertion Sort\n    4.  Object Sort\nPlease select a number of the Algorithm for sorting: ");
			menu = mid.getMenuChoice(scn);
			if (menu <= 3 && menu >= 1) {
				System.out.println("Please enter 10 random items "); mid.Sort();
				System.out.println("\nThese are the numbers you entered: "); mid.display();
				switch (menu) { case 1: mid.bubbleSort(); break; case 2: mid.selectionSort(); break; case 3: mid.insertionSort(); break; default: System.out.println("\nInvalid input! Please enter a number between 1 and 4.\n"); }
			} else if(menu == 4){
				System.out.println("Please enter 10 random persons ");
				for (int i = 0; i < 10; i++) {
                    String lastName, firstName;
                    System.out.print("Enter the "+(i+1)+"st person's last name: "); lastName = scn.next();
                    System.out.print("Enter "+(i+1)+"st person's first name: "); firstName = scn.next();
                    System.out.print("Enter age: "); age = mid.getMenuChoice(scn);
                    mid.per.insert(lastName, firstName, age); }
				System.out.println("\nThese are the persons you entered: ");
				mid.per.display();
				mid.per.objectSort();
				} else {
				System.out.println("\nInvalid input! Please enter a number between 1 and 4.\n"); }
			} while(menu > 4);
			System.out.print("\nOrder Menu:\n\n    1.  Ascending\n    2.  Descending\n\nHow would you like to sort those items: ");
			int sort = mid.getMenuChoice(scn);
			if (sort == 1) {
				if (menu == 4) {
	                System.out.println("\nThese are the following persons sorted in Ascending order.");
					mid.per.display();
				} else {
					System.out.println("\nThese are the following items sorted in Ascending order.");
					mid.display(); }
			} else {
				if (menu == 4) {
					System.out.println("\nThese are the following persons sorted in Descending order.");
					mid.per.display2();
				} else {
					System.out.println("\nThese are the following items sorted in Descending order.");
					mid.display2(); } }
				System.out.println("\n\nWould you like to Sort Again?\n   1.  Yes\n   2.  No");
				e = mid.getMenuChoice(scn);
				if (e == 1) {
					 mid.resetArray(); 
				} else if (e >= 3) {
					do {
					System.out.println("Invalid Input!");
					e = mid.getMenuChoice(scn);
					} while(e >= 3); }
		} while (e == 1);
		System.out.println("Thank you for using my program..."); scn.close();} }
