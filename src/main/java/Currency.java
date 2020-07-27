import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.lang.*;
public class Currency {
    public static String getCurrency(String message, Model model) throws IOException {
        URL url= new URL("https://free.currconv.com/api/v7/convert?q="+message+"_KZT&compact=ultra&apiKey=ffff96bbe6ea80d8a97a");
        Scanner in=new Scanner((InputStream) url.getContent());
        String result= "";
        while(in.hasNext()){
            result +=in.nextLine();
        }
        JSONObject object=new JSONObject(result);
        model.setCurrency(object.getDouble(message+"_KZT"));
        return message+":"+model.getCurrency();
    }
}

