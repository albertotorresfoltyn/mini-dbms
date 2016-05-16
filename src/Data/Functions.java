package Data;

import GUI.*;

/**
 * this class contains all static function of table
 * 
 * @author Google, Stack Overflow, Ullman, et al and Alberto
 * 
 */
public class Functions {
	private static Super SUPER_DATABASE = new Super(); // contains all database
	private static Window WINDOW = null;
	private static DataBase current_db = null;

	/**
	 * create a reference of windows
	 * 
	 * @param w
	 *            the main windows
	 */
	public static void setWindow(Window w) {
		WINDOW = w;
	}

	/**
	 * output a string to window
	 * 
	 * @param s
	 *            the output string.
	 */
	public static void output(String s) {
		WINDOW.print(s);
	}

	/**
	 * create a new database
	 * 
	 * @param name
	 *            the name of database (String)
	 */
	public static void create_database(String name) {
		SUPER_DATABASE.add(new DataBase(name));
		output("Create new database " + name);
	}

	/**
	 * change current database
	 * 
	 * @param name
	 *            the name of database
	 */
	public static void change_database(String name) {
		DataBase current_db_t = SUPER_DATABASE.getDataBase(name);
		if (current_db_t == null) {
			output("DataBase " + name + " not existed!");
			return;
		}
		current_db = current_db_t;
		output("Change current Database to " + name);
	}

	/**
	 * add new table into current database
	 * 
	 * @param name
	 *            the table's name
	 * @param t
	 *            the types of attributes
	 * @param n
	 *            the names of attributes
	 */
	public static void create_table(String name, int[] t, String[] n) {
		current_db.add(new Table(name, t, n));

		output("add table " + name + " into database " + current_db.getName());

		// output(current_db.toString());
	}

	/**
	 * insert a new tuple
	 * 
	 * @param name
	 *            the name of table
	 * @param data
	 *            the data of tuple
	 * @param size
	 *            the size of data
	 */
	public static void insert_tuple(String name, Object[] data, int size,
			int[] type) {

		for (Table t : current_db.getAll()) {

			if (t.getName().compareTo(name) == 0) {
				if (t.addTuple(new Tuple(size, data), type) == 1) {
					output("insert a tuple into table " + t.getName());

					// output(t.toString());
					break;
				}
				output("the tuple not suit for table " + t.getName());
				break;

			}

		}

	}

	/**
	 * get a table from current database
	 * 
	 * @param name
	 *            the name of table
	 * @return the reference of table
	 */
	public static Table getTable(String name) {
		for (Table t : current_db.getAll()) {
			if (t.getName().compareTo(name) == 0)
				return t;
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
