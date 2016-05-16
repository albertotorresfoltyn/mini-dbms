package Data;
/**
 * this DataBase class contains tables by using List structure
 * @author Google, Stack Overflow, Ullman, et al and Alberto
 *
 */
public class DataBase {
	private List<Table> list;
	private String name;
	
	/**
	 * the constructor
	 * @param n the name of database
	 */
	public DataBase(String n){
		list = new List<Table>();
		this.name = n;
	}
	
	/**
	 * add a new table into database
	 * @param t the new table
	 */
	public void add(Table t){
		this.list.add(t);
	}
	/**
	 * remove a table from database
	 * @param t the table being removed
	 */
	public void remove(Table t){
		this.list.remove(t);
	}
	/**
	 * get the iterator
	 * @return all tables
	 */
	public Iterable<Table> getAll(){
		return this.list.getAll();
	}
	/**
	 * get the name of database
	 * @return name
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * toString method
	 */
	public String toString(){
		String s = this.name+"\n";
		for(Table t : this.getAll()){
			s+=t.getName()+" ";
		}
		s+="\n";
		return s;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
