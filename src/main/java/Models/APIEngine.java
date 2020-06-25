package Models;

import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class APIEngine {

    ResponseHandler<String> responseHandler = response -> {
        int status = response.getStatusLine().getStatusCode();
        if(status >= 200 && status <= 300) {
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        }else{
            return "";
        }
    };

    public JSONArray GetRequestObjects(String url, String endpoint, String APIKey, String params){
        try {
            CloseableHttpClient httpClient = HttpClients.createMinimal();

            HttpGet httpGet = new HttpGet(url + endpoint + params);
            httpGet.setHeader("Authorization", APIKey);

            String reponseBody = httpClient.execute(httpGet, responseHandler);
            httpClient.close();

            return new JSONArray(reponseBody);
        }catch (Exception e){
            return null;
        }

    }

    //TODO:
    public JSONObject GetRequestObject(){
        return null;
    }
}
