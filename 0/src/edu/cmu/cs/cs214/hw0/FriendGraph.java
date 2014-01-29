package edu.cmu.cs.cs214.hw0;

public class FriendGraph {
	private Person[] verticles;
	private boolean[] visited;
	private boolean[][] edges;
	private int personNums;
	
	/*
	 * constructor
	 * To create a friendgraph with default size
	 */
	public FriendGraph(){
		verticles = new Person[50];
		edges = new boolean[50][50];
		personNums = 0;
		visited = new boolean[50];
	}
	
	/*
	 * Add person into the graph
	 */
	public void addPerson(Person p){
		verticles[personNums] = p;
		visited[personNums] = false;
		personNums ++;
	}
	
	/**
	 * Add friendship into the graph
	 * @param name1 name of person one
	 * @param name2 name of person two
	 */
	public void addFriendship(String name1, String name2){
		int p1=-1;
		int p2=-1;
		for(int i=0; i<verticles.length; i++){
			if(verticles[i] == null){
				break;
			} else if (verticles[i].getName().equals(name1)) {
				p1 = i;
			} else if(verticles[i].getName().equals(name2)) {
				p2 = i;
			}
		}
		if(p1 == -1)
			System.out.println(name1 + " is not in our graph yet");
		if(p2 == -1)
			System.out.println(name2 + " is not in our graph yet");
		if(p1 != -1 && p2 != -1){
			edges[p1][p2] = true;
			edges[p2][p1] = true;
		}
	}
	
	public void printFriendship(){
		for(int i=0; i<5; i++){
			for (int j=0; j<5;j++){
				System.out.print(edges[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * find the distance of connection of two people in the friengraph
	 * @param personName1 name of person one
	 * @param personName2 name of person two
	 * @return
	 */
	public int getDistance(String personName1, String personName2){
		
		if(personName1.equals(personName2))
			return 0;
		
		int distance = 0;
		
		for(int i=0; i<visited.length; i++){
			visited[i] = false;
		}
		
		int personIndex1 = findPersonIndex(personName1);
		int personIndex2 = findPersonIndex(personName2);
		
		
		Queue queue = new Queue();
		if(personIndex1 != -1 && personIndex2 != -1){
			
			int root = personIndex1;
			queue.enqueue(root);
			while(!queue.isEmpty()){
				int front = (int)queue.dequeue();
				distance++;
				
				//find all unvisited child
				for(int i=0; i<edges[front].length; i++){
					if(edges[front][i] == true && visited[i] != true){
						if(verticles[i].getName().equals(personName2))
							return distance;
						visited[i] = true;
						queue.enqueue(i);
					}	
				}
			}
		}
		return -1;
		
	}
	
	 /*
	  * helper method to find the index of person by the name of the person
	  */
	 private int findPersonIndex(String personName){
		for(int i=0; i<verticles.length; i++){
			if(verticles[i] == null){
				System.out.println(personName + " doesn't exist");
				return -1;
			}if(personName.equals(verticles[i].getName())){
				return i;
			}
		}
		return -1;
	}
}
