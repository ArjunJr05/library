
import java.util.*;
public class library {
    public static void holder(HashMap<String,String> clients) {
        if(clients.size()==0)
            {
                System.out.println("No books have been rented");
                System.out.println();
            }
        for(HashMap.Entry<String,String> it : clients.entrySet()){
                System.out.println(it.getKey()+" - "+it.getValue());
        }

    }
    public static void re(String name, String book_name, HashMap<String, Integer> available, HashMap<String, Integer> history, HashMap<String, String> clients)
    {
        int n = 0;
        for(HashMap.Entry<String,Integer> it : available.entrySet()){
            if(it.getKey().equals(book_name))
            {
                if(it.getValue() >= 0)
                {
                    if(clients.containsKey(name))
                    {
                        n = it.getValue()+1;
                        available.put(it.getKey(),n);
                        clients.remove(name);
                        System.out.println("Updated!.. you can get the book now!..");
                        System.out.println();
                    }
                    else{
                        System.out.println(name+" has not bought this book check twice!...");
                    }
                    
                }
                else if(it.getValue() != 0) {
                    System.out.println(book_name+" is currently available");
                    System.out.println();
                }
            }
        }
    }
    public static void rent(String name, String book_name, HashMap<String, Integer> available, HashMap<String, Integer> history, HashMap<String, String> clients)
    {
        int n = 0;
        if(clients.containsKey(name)){
            System.out.println("Already Book taken by "+name+" kindly tell to return the book!..");
            return;
        }
        for(HashMap.Entry<String,Integer> it : available.entrySet()){
            
            if(it.getKey().equals(book_name))
            {
                if(it.getValue() != 0)
                {
                    n = it.getValue()-1;
                    available.put(it.getKey(),n);
                    clients.put(name,book_name);
                    System.out.println("Updated!.. you can rent that book now!..");
                }
                else if(it.getValue() == 0) {
                    System.out.println(book_name+" is currently not available");
                    System.out.println();
                }
            }
            else{
                System.out.println(book_name+" book is not available");
                System.out.println();
                break;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<String, Integer> history = new HashMap<>();
        HashMap<String, Integer> available = new HashMap<>();
        HashMap<String, String> clients = new HashMap<>();
        history.put("avengers", 1);
        history.put("harry_potter", 2);
        history.put("wings_of_fire", 3);
        history.put("buffer_love", 4);
        available.put("avengers", 1);
        available.put("harry_potter", 1);
        available.put("wings_of_fire", 1);
        available.put("buffer_love", 1);
        int flag = 0;
        while(true)
        {
            System.out.println("*******LIBRARY*******");
            System.out.println("1) List the Book");
            System.out.println("2) Rent a book");
            System.out.println("3) Return a book");
            System.out.println("4) View books holder's name");
            System.out.print("Enter the Query: ");
            int ch = scan.nextInt();
            int n = 0;
            switch (ch){
                case 1: 
                {
                    System.out.println();
                    System.out.println("LIST OF BOOKS:");
                    flag = 0;
                    for(HashMap.Entry<String,Integer> it : available.entrySet()){
                        if(it.getValue() != 0)
                        {
                            System.out.println(it.getKey());
                            flag = 1;
                        }
                    }
                    if(flag == 0)
                    {
                        System.out.println("No books currently available!...");
                    }
                    System.out.println();
                    break;
                }
                case 2: {
                    System.out.println("Enter Client Name: ");
                    String name = scan.next();
                    System.out.println("Rent Book Name: ");
                    String book_name = scan.next();
                    rent(name, book_name, available, history, clients);
                    break;
                }
                case 3: {
                    System.out.println("Enter Client Name: ");
                    String name = scan.next();
                    System.out.println("Return Book Name: ");
                    String book_name = scan.next();
                    re(name, book_name, available, history, clients);
                    break;
                }
                case 4: {
                    System.out.println("Current book holder's Name: ");
                    holder(clients);
                    break;
                }
            }
        }
    }
}
