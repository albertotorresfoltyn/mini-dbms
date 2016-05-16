package Data;
/**
 * this class contains all database
 * @author Google, Stack Overflow, Ullman, et al and Alberto
 *
 */
public class Super {

	private List<DataBase> list;
	/**
	 * constructor
	 */
	public Super(){
		this.list = new List<DataBase>();
	}
	/**
	 * add a new database into super
	 * @param d new database
	 */
	public void add(DataBase d){
		this.list.add(d);
	}
	/**
	 * remove a database from super
	 * @param d the database being removing
	 */
	public void remove(DataBase d){
		this.list.remove(d);
	}
	/**
	 * get a iterator
	 * @return all database
	 */
	public Iterable<DataBase> getAll(){
		return this.list.getAll();
	}
	/**
	 * get one database
	 * @param n the name of database
	 * @return the reference of database
	 */
	public DataBase getDataBase(String n){
		for(DataBase d : this.getAll()){
			if(d.getName().compareTo(n)==0)return d;
		}
		
		return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
