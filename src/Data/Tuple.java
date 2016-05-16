package Data;
/**
 * This is the tuple class. It is one basic element for List,Table, and other structure. 
 * @author Google, Stack Overflow, Ullman, et al and Alberto
 *
 */
public class Tuple {
	
	private Object[] data;
	private int dataSize;
	
	private int[] types;
	private String[] names;
	
	private String name;
	private String name1;
	/**
	 * constructor
	 * @param size size of attributes
	 * @param d the data
	 */
	public Tuple(int size, Object[] d){
		this.dataSize=size;
		this.data=d;
		
	}
	/**
	 * set attributes' types and names
	 * @param t types
	 * @param s names
	 */
	public void setNames(int[] t,String[] s){
		this.types = t;
		this.names = s;
	}
	/**
	 * get attributes' types
	 * @return types
	 */
	public int[] getTypes(){
		return this.types;
	}
	/**
	 * get attributes' names
	 * @return names
	 */
	public String[] getNames(){
		return this.names;
	}
	
	/**
	 * get the data from this tuple
	 * @return the data
	 */
	public Object[] getData(){
		return this.data;
	}
	/**
	 * get the data size
	 * @return the data size
	 */
	public int getSize(){
		return this.dataSize;
	}
	/**
	 * toString method
	 */
	public String toString(){
		String t = "";
		for(int i = 0;i<this.dataSize;i++){
			t+=this.data[i].toString()+"  ";			
		}
		
		return t;
	}
	/**
	 * set name (from table)
	 * @param s string
	 */
	public void setName(String s){
		this.name = s;
	}
	/**
	 * set name (from AS statement)
	 * @param s string
	 */
	public void setName1(String s){
		this.name1 = s;
	}
	/**
	 * check whether has the same name
	 * @param s string
	 * @return true if yes, false otherwise
	 */
	public boolean checkName(String s){
		if(s.compareTo(this.name)==0)return true;
		if(s.compareTo(this.name1)==0)return true;
		return false;
	}
	public String getTableName(){
		return name;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] data = new String[3];
		data[0]="abc";
		data[1]="bcd";
		data[2]="cde";
		Tuple t = new Tuple(3,data);
		System.out.println(t);

	}

}
