/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverregisterapp;

import com.sun.javafx.image.impl.IntArgb;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author Ivan
 */
public class ServerData {
    public String SERVER_NAME;
    public String SERVER_IP;
    public String DOCKER_STATUS;
    
    public static ServerData EXTRACT_DATA(String getRequest){
        String getParams = getRequest.replace("GET /", "");
        getParams = getParams.replace(" HTTP/1.1", "");
        
        String[] splitedParams = getParams.split("&");
        HashMap<String, String> params = new HashMap<>();
        for (String s: splitedParams) {                       
            String[] temp = s.split("=");
            params.put(temp[0], temp[1]);
        }
        
        ServerData data = new ServerData();
        data.SERVER_NAME = params.get("serverName");
        data.SERVER_IP = params.get("ip");
        data.DOCKER_STATUS = params.get("dockerStatus");
        
        return data;
    }
}
