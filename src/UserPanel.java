

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class UserPanel {
private static Scanner s = new Scanner(System.in);
    
    
    private static ArrayList<User> users = new ArrayList<User>();
    
    
    public static void main(String[]args) {
        
        
        
        users.add(new User("Burak", "Burak@hotmail.com","26/05/1990", "İzmir",1));
        users.add(new User("Damla", "Damla@hotmail.com", "26/05/1990", "İzmir",2));
        users.add(new User("Mustafa", "Mustafa@hotmail.com", "24/04/1990", "İzmir",3));
        users.add(new User("Mert", "Mert@hotmail.com","18/1/1990", "İzmir",4));
        users.add(new User("Meltem", "Meltem@hotmail.com", "26/05/1990", "İzmir",5));
        users.add(new User("Utku", "Utku@hotmail.com", "11/10/1990", "İzmir",6));
        users.add(new User("Gökhan", "Gökhan@hotmail.com","26/05/1990", "İzmir",7));
        users.add(new User("Tugce", "Tugce@hotmail.com", "26/05/1990", "İzmir",8));

        
       
        
        
        
        users.get(1).follow1(users.get(0));
        users.get(2).follow1(users.get(0));
        run(users.get(0));
        run(users.get(1));
        run(users.get(2));
       
    }
    
    
    
    public static void run(User user) {
        Administrator ad = new Administrator();
        String date = ad.birtDay();
        
        if(user.getBirth().equals(date)){
            
            user.notAdd();
            
        }
        
       
        System.out.println("Wellcome "+ user.getName()+ ", please choose a operation which you want; ");
        System.out.println("1. Show Inbox\n"
                + "2. Show Outbox\n"
                + "3. Send Message\n"
                + "4. Share Post\n"
                + "5. Show Timeline\n"
                + "6. Show Contact list\n"
                + "7. Show Notifications\n"
                + "8. Follow People\n"
                + "9. Exit");
        
     
        
        
        boolean dongu = false;
        while (!dongu) {
            
        
        System.out.print(" Your Choise: ");
        int choise = s.nextInt();
        
        s.nextLine();
        
            switch (choise) {
                case 1:
                    
                  user.showInbox();
                    
                    break;
                    
                case 2:
                  
                  user.showOutbox();
                  
                    break;
                        
                case 3:
                    
                    System.out.println("Your Contact List");
                    user.followed_show();
                    System.out.println("Select the person's number you want to send the message to.");
                    
                    int i =s.nextInt();
                    
                    for(int j=0;j<users.size();j++){
                        if(i==users.get(j).getId()){
                        user.sendMessage(user, users.get(j));
                    }
                    
                    }
                    
                   
                    break;
                    
                 case 4:
                    
                    user.sendPost();
                    
                    break;
                    
                case 5:
                    
                   user.showTimeline();
                   
                    break;
                        
                case 6:
                    
                  user.followed_show();
                    break;
                    
                case 7:
                    
                   user.notBox();
                    break;
                        
                case 8:
                    
                   System.out.println("Choose what you want to follow.");
                   
                   for(int j=0;j<users.size();j++){
                       
                       if(user.getName()!= users.get(j).getName()){
                       
                       
                       System.out.println(users.get(j).getId()+"."+users.get(j).getName());
                       }
                   }
                       System.out.println("Follow that ıd:");
                       int id = s.nextInt();
                       for(int k=0;k<users.size();k++){
                           
                           if(id==users.get(k).getId()){
                               
                               user.follow(users.get(k));
                              
                           }
                           
                       }
                 break;
                    
                case 9:
                    System.out.println("Logout...");
                    dongu = true;
                
            }
        
        
        }
        
        
        
    }
    
    
    

    
    
    
}
