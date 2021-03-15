
import java.text.SimpleDateFormat;
import java.util.Date;

public class Administrator {
    
   
    
    Date now = new Date();
    
    SimpleDateFormat ft = new SimpleDateFormat("dd/MM");
    
    public String date(){
        
        return now.toLocaleString();
       
    }
    
    public String birtDay(){
        
        return ft.format(now);
        
        
    }
    
    
    
   
}
