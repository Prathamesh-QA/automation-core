package utility;

import io.restassured.specification.MultiPartSpecification;
import io.restassured.specification.RequestSpecification;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestAssuredUtil {

    private Map<String,?> response;

    public void sendRestAssuredRequest(String endpoint, String body, Method method, Map<String,String> queryParam,
                                       Map<String,String> header, List<MultiPartSpecification> multiPartSpecs,Map<String,String> pathParam){
        RequestSpecification requestSpecs;
        header = checkHeaderNotNullElseInstantiateHeader(header);

    }

    private Map<String,String> checkHeaderNotNullElseInstantiateHeader(Map<String,String> header){
        return header != null || header.isEmpty() ? new HashMap<String,String>() : header;
    }

}
