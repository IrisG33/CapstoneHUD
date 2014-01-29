package edu.cmu.cs.cs214.hw0;

public class Main {
	/*
	 * create a simple friendship network, and find distance of people in the network
	 */
    public static void main(String[] args) {

         FriendGraph graph = new FriendGraph();
         Person rachel = new Person("Rachel");
         Person ross = new Person("Ross");
         Person ben = new Person("Ben");
         Person kramer = new Person("Kramer");
         graph.addPerson(rachel);
         graph.addPerson(ross);
         graph.addPerson(ben);
         graph.addPerson(kramer);
         graph.addFriendship("Rachel", "Ross");
         graph.addFriendship("Ross", "Ben");
         System.out.println(graph.getDistance("Rachel", "Ross"));
         System.out.println(graph.getDistance("Rachel", "Ben"));
         System.out.println(graph.getDistance("Rachel", "Rachel"));
         System.out.println(graph.getDistance("Rachel", "Kramer"));

        // some more test
         Person iris = new Person("Iris");
         graph.addPerson(iris);
         graph.addFriendship("Ross", "Iris");
         graph.addFriendship("Ben", "Iris");
         System.out.println(graph.getDistance("Rachel", "Iris"));
         System.out.println(graph.getDistance("Iris", "Ross"));
         System.out.println(graph.getDistance("Ben", "Iris"));
         System.out.println(graph.getDistance("Iris", "Kramer"));
         System.out.println(graph.getDistance("Benn", "Iris"));
         
    }
}
