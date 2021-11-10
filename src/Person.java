public class Person {
    private String id;
    private String name;
    private int birth_year;


public Person(String id , String name , int birth_year ) throws Exception{
    if (id.length()<9) {
        throw new Exception("you'r id have minimum 9 numbers");
    }
    try {
        Integer.parseInt(id);
        this.id = id;
    } catch (Exception e) {
        throw new Exception("you'r id isn't composed only of numbers");
    }

    if (name.length()==0) {
        throw new Exception("name canno't be null string ");
    }else{
        this.name = name;
    }

    if (birth_year>2013) {
        throw new Exception("you can't register if you borned after 2013");
    }else{
        this.birth_year=birth_year;
    }

}



}
