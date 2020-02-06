// 1. Add a new Computer
// 2. Display all computers
// 3. Search for a computer : By Name, Color, HDDSize, RamSize, ID
// 4. Delete a computer : By ID
// 5. UPdate Computer Details: Name, Color, HDDSize, RamSize

import java.util.*;

class CustomClassCollectionAPI{
    public static void main(String[] args) {
        String brand, color;
        int id, hdd, option1, ram, option2, n = 0;
        boolean flag = false;
        ArrayList<Computer> list = new ArrayList<Computer>();
 
        // list.add(new Computer(1, "HP", "black", 500, 8));
        // list.add(new Computer(2, "HP", "black", 256, 4));
        // list.add(new Computer(3, "Sony", "blue", 1024, 16));
        while(true){
        System.out.println("\n1. Add a Computer\n2. Display all Computers\n3. Search for a Computer\n4. Delete a Computer\n5. Update Computer Details\nEnter the Option: ");
        Scanner sc = new Scanner(System.in);
        option1 = sc.nextInt();
        
        switch(option1){
            case 1:
                System.out.println("Enter brand: ");
                brand = sc.nextLine();
                sc.nextLine();
                System.out.println("Enter Color: ");
                color = sc.nextLine();
                System.out.println("Enter HDD: ");
                hdd = sc.nextInt();
                System.out.println("Enter RAM: ");
                ram = sc.nextInt();
                n++;
                list.add(new Computer(n, brand, color, hdd, ram));
                System.out.println("Added Successfully!!!");
                break;
            case 2:
                if(list.size() == 0)
                    System.out.println("No Computers in Database!!!");
                else
                    System.out.println("Computers are: " + list);
                break;
            case 3:
                System.out.println("\n1. By Brand\n2. By Color\n3. By HDD\n4. By RAM\n5. By ID\nEnter the Option: ");
                option2 = sc.nextInt();
                switch(option2){
                    case 1:
                        flag = false;
                        System.out.println("Enter the brand: ");
                        brand = sc.nextLine();
                        brand = sc.nextLine();
                        for(int i = 0; i < list.size(); i++){
                            if((list.get(i)).getBrand().equals(brand)){
                                System.out.println(list.get(i));
                                flag = true;
                            }
                        }
                        if(flag == false){
                            System.out.println("Not Found!!!");
                        }
                        break;
                    case 2:
                        flag = false;
                        System.out.println("Enter the color: ");
                        color = sc.nextLine();
                        color = sc.nextLine();
                        for(int i = 0; i < list.size(); i++){
                            if(list.get(i).getColor().equals(color)){
                                System.out.println(list.get(i));
                                flag = true;
                            }
                        }
                        if(flag == false){
                            System.out.println("Not Found!!!");
                        }
                        break;
                    case 3:
                        flag = false;
                        System.out.println("Enter HDD size: ");
                        hdd = sc.nextInt();
                        for(int i = 0; i < list.size(); i++){
                            if(list.get(i).getHddSize() == hdd){
                                System.out.println(list.get(i));
                                flag = true;
                            }
                        }
                        if(flag == false){
                            System.out.println("Not Found!!!");
                        }
                        break;
                    case 4:
                        flag = false;
                        System.out.println("Enter RAM size: ");
                        ram = sc.nextInt();
                        for(int i = 0; i < list.size(); i++){
                            if(list.get(i).getRamSize() == ram){
                                System.out.println(list.get(i));
                                flag = true;
                            }
                        }
                        if(flag == false){
                            System.out.println("Not Found!!!");
                        }
                        break;
                    case 5:
                        flag = false;
                        System.out.println("Enter ID: ");
                        id = sc.nextInt();
                        for(int i = 0; i < list.size(); i++){
                            if(list.get(i).getId() == id){
                                System.out.println(list.get(i));
                                flag = true;
                            }
                        }
                        if(flag == false){
                            System.out.println("Not Found!!!");
                        }
                        break;
                }
                break;
            case 4:
                flag = false;
                System.out.println("Enter the ID to be removed: ");
                id = sc.nextInt();
                for(int i = 0; i < list.size(); i++){
                    if(list.get(i).getId() == id){
                        list.remove(i);
                        flag = true;
                    }
                }
                if(flag == false){
                    System.out.println("ID does not exist!!!");
                }
                break;
            case 5:
                flag = false;
                System.out.println("Enter the ID of the computer to be updated: ");
                id = sc.nextInt();
                Computer comp = null;
                for(int i = 0; i < list.size(); i++){
                    if(list.get(i).getId() == id){
                        comp = list.get(i); 
                        flag = true;
                    }
                }
                if(flag == false){
                    System.out.println("ID does not exist!!!");
                    break;
                }
                System.out.println("\nUpdate:\n1. Brand\n2. Color\n3. HDD\n4. RAM\nEnter the Option: ");
                option2 = sc.nextInt();
                switch(option2){
                    case 1:
                        System.out.println("Enter the brand: ");
                        brand = sc.nextLine();
                        brand = sc.nextLine();
                        comp.brand = brand;
                        break;
                    case 2:
                        System.out.println("Enter the color: ");
                        color = sc.nextLine();
                        color = sc.nextLine();
                        comp.color = color;
                        break;
                    case 3:
                        System.out.println("Enter HDD size: ");
                        hdd = sc.nextInt();
                        comp.hddSize = hdd;
                        break;
                    case 4:
                        System.out.println("Enter RAM size: ");
                        ram = sc.nextInt();
                        comp.ramSize = ram;
                        break;
                }
                break;
                default:
                    System.out.println("Enter the correct option!!!");
                    break;
        }
    }

    }
}
 
 
class Computer{
    String brand, color;
    int hddSize, ramSize, id;
 
    Computer(int id, String brand, String color, int hddSize, int ramSize){
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.hddSize = hddSize;
        this.ramSize = ramSize;
    }
 
    public String getColor(){
        return this.color;
    }
 
    public String getBrand(){
        return this.brand;
    }
 
    public Integer getHddSize(){
        return this.hddSize;
    }
     
    public Integer getRamSize(){
        return this.ramSize;
    }

    public Integer getId(){
        return this.id;
    }
 
    @Override
    public String toString(){
        return "Computer : (" + this.getId()
            + ", " + this.getBrand()
            + ", " + this.getColor()
            + ", " + this.getHddSize()
            + ", " + this.getRamSize()
            + ")";
    }
 
 
}