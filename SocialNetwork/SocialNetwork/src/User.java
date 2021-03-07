/* Name: BURAK ASLAN
   Id:   180135068
   Comp. Engineering
*/




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;



 
public class User {
    private static  Scanner s= new Scanner(System.in);
    
    private  String name;
    private  String email;
    private  String birth;
    private  String place;
    private int id;

   
   
    private ArrayList<String> postList = new ArrayList<String>();
    private static ArrayList<String> timeLine = new ArrayList<String>();
    private ArrayList<String> favPost = new ArrayList<String>();
    private ArrayList<User> followed_user = new ArrayList<User>();
    private ArrayList<String> inbox = new ArrayList<String>();
    private ArrayList<String> outbox = new ArrayList<String>();
    private ArrayList<String> notBox = new ArrayList<String>();
    


    
     public User(String name, String email, String birth, String place, int id) {
        this.name = name;
        this.email = email;
        this.birth = birth;
        this.place = place;
        this.id = id;
    }
    
    
        
    // Func.
    
    public void showInbox(){
        Message mesaj = new Message();
        mesaj.showInbox();
        
    }
    
    public void showOutbox(){
        
        Message mesaj = new Message();
        mesaj.showOutbox();
        
    }
    
    public void sendPost(){
        Post post = new Post(name);
        post.sendPost();
     
}
    
    public void showTimeline(){
        Post post = new Post(name);
        post.showTime();
        
    }
    
    public void sendMessage(User user1, User user2){
        
        Message mesaj = new Message();
        mesaj.messageSend(user1,user2);
    }
    
    public void notAdd(){
            notBox.add("Happy Birtday to you...");
        
    }
    
    public void notBox(){
        
        System.out.println("Welcome to NoticeBox");
         if(notBox.size()==0){
            
            System.out.println("Your NotBox is empty...");
            
        }
        
        for(String s: notBox){
            
            System.out.println(s);
            
        }
        
        
    }
    
    
    public void followed_show(){
        
        System.out.println("Contact list: "+ followed_user.size());
        
            for(int i=0;i<followed_user.size();i++){
                
                System.out.println(followed_user.get(i).id+ "."+ followed_user.get(i).name);
                
                
            }
        
        
    }
    
    
    
    public void follow(User user){
        
       
        
        followed_user.add(user);
        System.out.println(user.name+ " was followed...");
        
        
     
    }

    public void follow1(User user){
        
       
        
        followed_user.add(user);
        
        
        
     
    }

    
    //-----------------------------------------------
    
    
    
    
    
    
    //        İnner  Classes
    
   
    public class Message {
      
     Administrator ad = new Administrator();
    public  void messageSend (User user1, User user2){
       
        String date = ad.date();
        
        
        if((user1.followed_user.contains(user2))&& (user2.followed_user.contains(user1))){
            
            System.out.println("Your Message: ");
            
            String mesaj= s.nextLine();
            
            user1.outbox.add(mesaj+ "\tSent: "+ user2.getName() + "\t"+ date);
            
            user2.inbox.add(mesaj+"\tFrom Person: "+ user1.getName()+"\t"+ date);
            
            user2.notBox.add("You have a message");
            
            System.out.println("Your message was successfully sent.");
            
        }
        else System.out.println("You are not follow with this person.");
        
        
        
    }
    
    public void showInbox(){
        
        System.out.println("Welcome to İnbox");
        if(inbox.size()==0){
            
            System.out.println("Your inbox is empty...");
            
        }
        
        for(String s: inbox){
            
            System.out.println(s+"\n");
          
        }
        
        
    }
    
    public void showOutbox(){
        
        System.out.println("Welcome to Outbox");
        
         if(outbox.size()==0){
            
            System.out.println("Outbox is empty...");
            
        }
        
        for(String s: outbox){
            
            System.out.println(s+"\n");
        
    }
    
}
    
        
    }
    
    
    
    
    public  class Post {
        
    private String postSahibi;
    private String post;
    private ArrayList<String> likes = new ArrayList<String>();
    Administrator ad = new Administrator();

        public Post(String postSahibi) {
            this.postSahibi = postSahibi;
        }
    
    
        
    public void sendPost(){
        
        String date = ad.date();
        System.out.println("Your post: ");
        post = s.nextLine();
        timeLine.add(postSahibi+": "+ post+"\t"+"\t Date: "+date);
        postList.add(post+"\t Date: "+ date);
        System.out.println(postSahibi+": "+ post+"\t"+"\t Date: "+date);
        
        
    }
    
   
    public void like(String like){
        
        likes.add(postSahibi);
        favPost.add(like);
        
    }
    
    
   public void showTime(){
       
       for(String s: timeLine){
           
           System.out.println(s+"\n");
       }
       
   }
        
    
    
    
    }
    

    
    
    
  //-------------------------------------
  
    
    
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

   
   
    
    
}
