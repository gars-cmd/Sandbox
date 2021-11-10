
public class SymbolTable {

    private Symbol[] symbolArr;
    private int size = 0;

    public SymbolTable(int size) {
        symbolArr = new Symbol[size];
    }

    public SymbolTable(SymbolTable other) {
        this.symbolArr = new Symbol[other.symbolArr.length];
        for (int i = 0; i < other.symbolArr.length; i++) {
            this.symbolArr[i] = other.symbolArr[i];
        }
        this.size = other.size ;
    }

    public void add(Symbol a) throws Exception {
        boolean check = true;
        if (this.size == 0) {
            symbolArr[0]=a;
            size++;
        }
        for (int i = 0; i < this.size; i++) {
            if (this.symbolArr[i].equals(a)) {
                check = false;
            }
        }
        if (check == true) {
            for (int i = 0; i < symbolArr.length; i++) {
                if (symbolArr[i] == null) {
                    symbolArr[i] = a;
                    this.size++;
                    break;
                } else {
                    try {
                        symbolArr[size] = a;
                        this.size++;
                        break;

                    } catch (Exception e) {
                        throw new Exception("Try to add to full array");
                    }
                }
            }
        }
    }

    public void remove(String name) throws Exception {
if (this.size==0) {
    throw new Exception("Try to remove from empty array");
}

        for (int i = 0; i < symbolArr.length; i++) {
            if (symbolArr[i]==null) {
                continue;
            }else{
                symbolArr[i] = null;
                this.size--;
                break;
            }
        }
    }


    public void set(String name , int new_val) throws Exception{
        boolean check = false;
        for (int i = 0; i < symbolArr.length; i++) {
            if (symbolArr[i].getName()== name) {
                check = true;
                symbolArr[i].setValue(new_val);
            }
        }
        if (check==false) {
            
                Symbol newOne = new Symbol(name, new_val);
                add(newOne);
                this.size++;
            }
        }

    public static void main(String[] args) throws Exception {
        Symbol test1 = new Symbol("first", 0);
        Symbol test2 = new Symbol("second", 1);
        Symbol test3 = new Symbol("third", 2);
        Symbol test4 = new Symbol("fourth", 3);
        SymbolTable table = new SymbolTable(3);
        table.add(test1);
         System.out.println(table.size);
        table.add(test2);
        table.add(test3);
        System.out.println(table.symbolArr[2].getValue());
        table.set("third", 12);
         System.out.println(table.symbolArr[2].getValue());
    }

}
