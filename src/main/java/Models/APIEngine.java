package Models;

import org.apache.http.HttpEntity;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
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

    private String GetRequest(String url, String endpoint, String APIKey, String params){
        try {
            CloseableHttpClient httpClient = HttpClients.createMinimal();

            HttpGet httpGet = new HttpGet(url + endpoint + params);
            httpGet.setHeader("Authorization", APIKey);

            String responseBody = httpClient.execute(httpGet, responseHandler);
            httpClient.close();

            return responseBody;
        }catch (Exception e){
            return null;
        }
    }
    private String PostRequest(String url, String endpoint, String APIKey, String params){try {
        CloseableHttpClient httpClient = HttpClients.createMinimal();

        HttpPost httpPost = new HttpPost(url + endpoint);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("Authorization", APIKey);

        StringEntity stringEntity = new StringEntity(params);
        httpPost.setEntity(stringEntity);

        String responseBody = httpClient.execute(httpPost, responseHandler);
        httpClient.close();

        return responseBody;
    }catch (Exception e){
        return null;
    }}

    public JSONArray GetRequestObjects(String url, String endpoint, String APIKey, String params){
        String response = GetRequest(url, endpoint,APIKey,params);
        return (response == null) ? null : new JSONArray(response);
    }

    public JSONObject GetRequestObject(String url, String endpoint, String APIKey, String params){
        String response = GetRequest(url, endpoint,APIKey,params);
        return (response == null) ? null : new JSONObject(response);
    }

    public JSONObject PostRequestObject(String url, String endpoint, String APIKey, String params){
        String response = PostRequest(url, endpoint,APIKey,params);
        return (response == null) ? null : new JSONObject(response);
    }


    public JSONArray PostRequestObjects(String url, String endpoint, String APIKey, String params){
        String response = PostRequest(url, endpoint,APIKey,params);
        return (response == null) ? null : new JSONArray(response);
    }
}
