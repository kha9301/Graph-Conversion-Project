
public class Vertex<AnyType> {
	private AnyType vertexName;

	public Vertex(AnyType d) {
		setData(d);

	}

	public AnyType getData() {
		return vertexName;
	}

	public void setData(AnyType v) {
		vertexName = v;
	}

	public String toString(AnyType d) {
		String conString = d.toString();
		return conString;
	}

}
