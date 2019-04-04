public class Main {

    public static void main(String[] args) {
        Box box = new Box(10);

        box.add( new Book("Fedor Dostojevski", "Crime and Punishment", 2) ) ;
        box.add( new Book("Robert Martin", "Clean Code", 1) );
        box.add( new Book("Kent Beck", "Test Driven Development", 0.7) );

        box.add( new CD("Pink Floyd", "Dark Side of the Moon", 1973) );
        box.add( new CD("Wigwam", "Nuclear Nightclub", 1975) );
        box.add( new CD("Rendezvous Park", "Closer to Being Here", 2012) );

        System.out.println( box );
        box.add(box);
//        Box biggerBox = new Box(10);
//        biggerBox.add(box);
//        Box smallBox = new Box(3);
//        smallBox.add(new CD("Eminem", "LP" , 2011));
//        smallBox.add(new Book("Abe", "vampire", 1));
//        biggerBox.add(smallBox);
//        System.out.println(biggerBox);
    }
}
