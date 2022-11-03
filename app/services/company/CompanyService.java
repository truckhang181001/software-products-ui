package services.company;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import play.Logger;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import play.libs.ws.WSRequest;
import utils.Constants;
import utils.DataConverterUtils;

import javax.inject.Inject;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class CompanyService implements WSBodyReadables, WSBodyWritables {

    private final WSClient wsClient;

    @Inject
    public CompanyService(WSClient wsClient) {
        this.wsClient = wsClient;
    }

    public Map<String, String> getCompanyOptions() {
        try{
            CompletableFuture<JsonNode> promise = wsClient.url(Constants.API.URL + Constants.API_COMPANY.GET_ALL_COMPANY_OPTION)
                    .setMethod("GET")
                    .execute()
                    .thenApply(res -> res.getBody(json()))
                    .toCompletableFuture();
            Map<String, String> result = DataConverterUtils.jsonToList(promise.get().toString(), new TypeReference<Map<String, String>>() {});
            return result;
        } catch (Exception exception){
            Logger.of("application").error("Fail to execute getCompanyOptions: ", exception);
            return null;
        }
    }
}
