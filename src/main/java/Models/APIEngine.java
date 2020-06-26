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
import java.util.concurrent.Callable;

public class APIEngine<T> implements Callable<T>{
    private final String url, APIKey, parameters;
    private final int APIMethod, returnType;

    public APIEngine(String url, String APIKey, String parameters, int APIMethod, int returnType) {
        this.url = url;
        this.APIKey = APIKey;
        this.parameters = parameters;
        this.APIMethod = APIMethod;
        this.returnType = returnType;
    }


    @Override
    public T call() throws Exception {
        if(APIMethod == 0)
            return (returnType==0)? (T) GetRequestObject() : (T)GetRequestObjects();
        else
            return (returnType == 0) ? (T) PostRequestObject() : (T) PostRequestObjects();
    }

    private ResponseHandler<String> responseHandler = response -> {
        int status = response.getStatusLine().getStatusCode();
        if(status >= 200 && status <= 300) {
            HttpEntity entity = response.getEntity();
            return entity != null ? EntityUtils.toString(entity) : null;
        }else{
            return "";
        }
    };

    private String GetRequest(){
        try {
            CloseableHttpClient httpClient = HttpClients.createMinimal();

            HttpGet httpGet = new HttpGet(url + parameters);
            httpGet.setHeader("Authorization", APIKey);

            String responseBody = httpClient.execute(httpGet, responseHandler);
            httpClient.close();

            return responseBody;
        }catch (Exception e){
            return null;
        }
    }
    private String PostRequest(){
        try {
        CloseableHttpClient httpClient = HttpClients.createMinimal();

        HttpPost httpPost = new HttpPost(url );
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        httpPost.setHeader("Authorization", APIKey);

        StringEntity stringEntity = new StringEntity(parameters);
        httpPost.setEntity(stringEntity);

        String responseBody = httpClient.execute(httpPost, responseHandler);
        httpClient.close();

        return responseBody;
    }catch (Exception e){
        return null;
    }}

    private JSONArray GetRequestObjects(){
        String response = GetRequest();
        return (response == null) ? null : new JSONArray(response);
    }

    private JSONObject GetRequestObject(){
        String response = GetRequest();
        return (response == null) ? null : new JSONObject(response);
    }

    private JSONObject PostRequestObject(){
        String response = PostRequest();
        return (response == null) ? null : new JSONObject(response);
    }


    private JSONArray PostRequestObjects(){
        String response = PostRequest();
        return (response == null) ? null : new JSONArray(response);
    }
}
