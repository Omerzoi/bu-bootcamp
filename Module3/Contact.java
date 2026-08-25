public class Contact { 
    private String name;
    private String phone;
    
    //Constructor
    public Contact(String name, String phone){
        this.name = name;
        this.phone = phone;        
    }

    //Getters
    public String getName() {return name;};
    public String getPhone(){return phone;};

    //ToString
    @Override
    public String toString(){
        return name + " | " + phone;
    }
}
