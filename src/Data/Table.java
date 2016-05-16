package Data;
/**
 * This is Table class. It contains Tuples by using list structure. 
 * @author Google, Stack Overflow, Ullman, et al and Alberto
 *
 */
public class Table {
	
	private List<Tuple> list;
	private int[] types;
	private String[] names;
	private String name;
	private int[] attribute_size;
	
	/**
	 * the constructor
	 * @param t the types of attributes
	 * @param n the names of attributes
	 * @param na the name of Table
	 */
	public Table(String na,int[] t,String[] n){
		this.list = new List<Tuple>();
		this.types = t;
		this.names = n;		
		this.name = na;
		this.attribute_size = new int[t.length];
		for(int i=0;i<t.length;i++) this.attribute_size[i] = this.names[i].length();
		
	}
	/**
	 * get total number of attributes
	 * @return a integer number
	 */
	public int getAttributeSize(){
		return this.attribute_size.length;
	}
	/**
	 * get the name of table
	 * @return name
	 */
	public String getName(){
		return this.name;
	}
	/**
	 * get the types of attributes
	 * @return the types
	 */
	public int[] getTypes(){
		return this.types;
	}
	/**
	 * get the names of attributes
	 * @return the names
	 */
	public String[] getNames(){
		return this.names;
	}
	/**
	 * add new tuple into the table
	 * @param t the new tuple
	 */
	public void addTuple(Tuple t){
		t.setNames(this.types, this.names);
		t.setName(this.name);
		this.list.add(t);
		for(int i=0;i<this.attribute_size.length;i++){
			if(t.getData()[i].toString().length()>this.attribute_size[i])
				this.attribute_size[i] = t.getData()[i].toString().length();
		}
	}
	/**
	 * add new tuple into the table, this method used by compiler only
	 * @param t the new tuple
	 * @param ty types
	 */
	public int addTuple(Tuple t,int[] ty){
		if(t.getSize()!=this.types.length)return 0;
		for(int i=0;i<this.getSize();i++){
			if(this.types[i]!=ty[i])return 0;
			//Functions.output(""+this.types[i]+" "+ty[i]);
		}
		
		t.setNames(this.types, this.names);
		t.setName(this.name);
		this.list.add(t);
		for(int i=0;i<this.attribute_size.length;i++){
			if(t.getData()[i].toString().length()>this.attribute_size[i])
				this.attribute_size[i] = t.getData()[i].toString().length();
		}
		return 1;
	}
	/**
	 * remove a tuple from table
	 * @param t the tuple being removed
	 */
	public void removeTuple(Tuple t){
		this.list.remove(t);
	}
	/**
	 * get the size of table
	 * @return size
	 */
	public int getSize(){
		return this.list.getSize();
	}
	/**
	 * get the iterator
	 * @return all tuples
	 */
	public Iterable<Tuple> getAll(){
		return this.list.getAll();
	}
	/**
	 * toString method
	 */
	public String toString(){
		String t = "";
		int s = 1;
		for(int i=0;i<this.attribute_size.length;i++){
			s+=3+this.attribute_size[i];
		}
		for(int i=0;i<s;i++){
			t+="*";
		}
		t+='\n';
		
		t+="* ";
		for(int i=0;i<this.attribute_size.length;i++){
			t+=this.names[i];
			int ts = this.attribute_size[i]-this.names[i].length();
			for(int j=0;j<ts;j++) t+=" ";
			t+=" * ";
		}
		t+='\n';
		for(int i=0;i<s;i++){
			t+="*";
		}
		t+='\n';
		
		for(Tuple tu : this.list.getAll()){
			t+="* ";
			for(int i=0;i<this.attribute_size.length;i++){
				t+=tu.getData()[i].toString();
				int ts = this.attribute_size[i]-tu.getData()[i].toString().length();
				for(int j=0;j<ts;j++) t+=" ";
				t+=" * ";
			}
			t+='\n';
			for(int i=0;i<s;i++){
				t+="*";
			}
			t+='\n';
		}
		
		/*for(Tuple tp : this.getAll()){
			t+=tp.toString()+'\n';
		}*/
		return t;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] types = {1,2,3,4};
		String[] names = {"a","a","q","a"};
		Table t = new Table("abc",types,names);
		String[] data = {"as","qwertyad","asdf","qwer"};
		Tuple tu = new Tuple(4,data);
		t.addTuple(tu);
		System.out.println(t);
	}

}
