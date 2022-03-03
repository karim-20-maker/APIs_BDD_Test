package apiConfig;
import java.util.HashMap;
import java.util.Map;


public class HeaderConfg {


    public Map<String, String> defaultHeaders(){
        Map<String, String> defalutHeaders = new HashMap<String, String>();
        defalutHeaders.put("Connection", "keep-alive");
        defalutHeaders.put("User-Agent" ,"PostmanRuntime/7.29.0");
        defalutHeaders.put("Accept" ,"*/*");


        return defalutHeaders;

    }




}