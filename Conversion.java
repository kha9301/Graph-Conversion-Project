import java.io.BufferedReader;

public class Conversion<AnyType> {
	List<AnyType> a = new DoublyLinkedList<AnyType>();// Stores Edges (both 0s
														// and 1s)
	List<AnyType> b = new DoublyLinkedList<AnyType>();// Stores Vertices

	Conversion(BufferedReader br) {
		System.out.println();
		System.out.println("The Matrix");
		System.out.println();
		try {
			String strLine = null;

			/*-------------------------------------STORE VERTEX NAMES INTO LINKED LIST 'b'  --------------------------------------*/

			String fLine = br.readLine();
			String[] vertices = fLine.split("\\s+");
			Vertex[] VerArray = new Vertex[vertices.length];

			for (int i = 0; i < vertices.length; i++) {
				if (!vertices[i].equals(""))
					VerArray[i] = new Vertex(vertices[i]);
				b.add((AnyType) VerArray[i]);
				// a doubly linked list of vertices
				System.out.print(vertices[i] + " ");
			}
			System.out.println();

			/*-------------------------------------STORE VERTEX NAMES INTO LINKED LIST 'b'  --------------------------------------*/

			// for (int i = 0; i < VerArray.length; i++)
			// {System.out.println(VerArray[i].getData());}

			/*-----------STORE 0s and 1s TO CORRESPONIDNG VERTEX NAMES INTO LINKED LIST 'a'  --------------------------------------*/

			while ((strLine = br.readLine()) != null) {
				int x = 0;// ensures every LinkedList does not count empty space
				String[] splited = strLine.split("\\s+");

				for (int i = 0; i < splited.length; i++) {
					if (splited[i].equals("0")) {
						// 0s stay because they don't need for adjacency list
						a.add((AnyType) new Vertex("0"));
						System.out.print(splited[i] + " ");
						x++;
					} else if (splited[i].equals("1")) {
						// convert 1s to corresponding vertex
						a.add((AnyType) VerArray[x]);
						// a doubly linked list of vertices.

						x++;
						System.out.print(splited[i] + " ");
					}
				} // for
				System.out.println();
			} // while
			/*-----------STORE 0s and 1s TO CORRESPONIDNG VERTEX NAMES INTO LINKED LIST 'a'  --------------------------------------*/

		} catch (Exception e) {
			System.out.println(e);
		}

		/*-------------------------------------STORE ADJACENCY LISTS INTO LINKED LIST ARRAY --------------------------------------*/

		int numOfVertex = b.size(); // reference

		DoublyLinkedList[] adjacencyList = new DoublyLinkedList[numOfVertex];

		for (int i = 0; i < numOfVertex; i++) {
			DoublyLinkedList answers = new DoublyLinkedList();
			adjacencyList[i] = answers;
			answers.add(b.get(i + 1));
		} // The name of each vertices comes in front of the list.

		int placeholder = 1;
		while (placeholder != numOfVertex + 1) {
			for (int i = 0; i < numOfVertex; i++) {
				adjacencyList[i].add(a.get((i * numOfVertex) + placeholder));
				// this stores each adjcaent vertices after each name of the
				// vertices
			}
			placeholder++;
		} // The adjacency list for a vertex comes after each name.
		/*-------------------------------------STORE ADJACENCY LISTS INTO LINKED LIST ARRAY--------------------------------------*/

		//
		//

		/*-----------------------------------------------PRINT ADJACENCY LISTS-------------------------------------------------*/

		System.out.println();
		System.out.println("Adjacency List From The Matrix");
		System.out.println();

		placeholder = 0;
		while (placeholder != b.size()) {
			for (int i = 1; i < b.size() + 2; i++) {
				if (i == 1) {
					System.out.print(((Vertex) adjacencyList[placeholder].get(i)).getData() + " : ");
				}
				if (i > 1 && i < b.size() + 1) {
					if (((Vertex) adjacencyList[placeholder].get(i)).getData().equals("0")) {
						System.out.print("");
					} else
						System.out.print(((Vertex) adjacencyList[placeholder].get(i)).getData() + " ");
				}
				if (i == b.size() + 1 && !((Vertex) adjacencyList[placeholder].get(i)).getData().equals("0")) {
					System.out.print(((Vertex) adjacencyList[placeholder].get(i)).getData());
				}
			}
			placeholder++;
			System.out.println();
		}
		/*-----------------------------------------------PRINT ADJACENCY LISTS-------------------------------------------------*/

	}

}
