public class Symbol {
    
    private String name ;
    private int value;

    public String getName(){return this.name;}
    public int getValue(){return this.value;}
    public void setName(String name ){ this.name = name;}
    public void setValue(int val){ this.value = val;}

    public Symbol (String name , int value){
        this.name = name;
        this.value = value;
    }
    
public boolean equals(Symbol other){
    if (other.name == this.name && other.value == this.value) {
        return true ;
    }
return false;
}


}
