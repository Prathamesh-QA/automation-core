package utility;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.LibraryConstatnts;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/***
 * Created : 25/05/2024
 * Author : Prathamesh D Dhamanaskar (Prathamesh-QA)
 * Description: Wrapper class containing method which can be used by
 *              the user to Test any API
 */
public class RestAssuredUtil {

    private Map<String, Object> response;

    /*
        This is a top over wrapper method of the Rest Assured Client to process the API request
         depending on the method selected by the user
     */
    public void sendRestAssuredRequest(String endpoint, String body, Method method, Map<String,String> queryParam,
                                       Map<String,String> header, List<MultiPartSpecification> multiPartSpecs,Map<String,String> pathParam){
        RequestSpecification requestSpecs;
        header = checkHeaderNotNullElseInstantiateHeader(header);

    }

    private Map<String,String> checkHeaderNotNullElseInstantiateHeader(Map<String,String> header){
        return header != null || !header.isEmpty() ? new HashMap<String,String>() : header;
    }

    private void updateResponseMap(int responseCode,String responseMessage){
        response = new HashMap<>();
        response.putIfAbsent(LibraryConstatnts.RESPONSE_STATUSCODE_KEY,responseCode);
        response.putIfAbsent(LibraryConstatnts.RESPONSE_STATUSMESSAGE_KEY,responseMessage);

    }

    @NotNull
    private String urlBuilder(String baseUrl, String resourcePath, String tenantInformation){
        String formulatingUrl = baseUrl.concat(resourcePath);
        formulatingUrl = tenantInformation != null || !tenantInformation.isEmpty() ? formulatingUrl.concat(tenantInformation) : "";
        return formulatingUrl;
    }

    private String convertJsonObjectToString(Object responseObject){
        try {
            return new ObjectMapper().writeValueAsString(responseObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    private Object convertJsonStringToObject(String response, Object responseObject){
        try {
            return new ObjectMapper().readValue(response,responseObject.getClass());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }





}
