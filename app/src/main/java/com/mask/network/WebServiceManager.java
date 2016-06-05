package com.mask.network;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by mukeshyadav on 05/06/16.
 */
public class WebServiceManager {
    Context context;
    int i;

    public WebServiceManager(Context context){
        this.context = context;
    }

    public JSONObject sendHttpRequest(String urlstr, String param){
        JSONObject json=null;
        String jsonString = "";
        HttpURLConnection connection = null;
        try {
            URL url = new URL(urlstr);
            connection = (HttpURLConnection)url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setFixedLengthStreamingMode(param.getBytes().length);
            connection.setConnectTimeout(10000);
            connection.setReadTimeout(15000);
            connection.setUseCaches(false);
            PrintWriter out = new PrintWriter(connection.getOutputStream());
            out.print(param);
            out.close();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder builder = new StringBuilder();
            while((line = br.readLine()) != null){
                builder.append(line+"\n");
            }
            br.close();
            jsonString = builder.toString();
            Log.d("result",jsonString);
            json = new JSONObject(jsonString);

        }catch(JSONException e){
            Log.d("NetworkHandler","Error in Json");
        }catch(Exception e){
            Log.d("server","backing off");
            //Toast.makeText(context, "Connection Error try Again", Toast.LENGTH_LONG).show();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e1) {
            }
            i++;
            if(i<4)
                return sendHttpRequest(urlstr, param);
        }finally{
            if(connection != null){
                connection.disconnect();
            }
        }
        return json;
    }
}
