package Models;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class APIEngine {
    private static ExecutorService servicePool = Executors.newScheduledThreadPool(10);

    private static String APIKey ="";

    public static <T> Future<T> SubmitAPICall(String url, String parameters, int APIMethod, int returnType){
        HTTPRequest<T> requestTask = new HTTPRequest<>(url, APIKey, parameters, APIMethod, returnType);
        return servicePool.submit(requestTask);
    }
}
