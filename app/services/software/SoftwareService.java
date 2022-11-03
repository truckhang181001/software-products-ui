package services.software;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import models.Software;
import models.responses.CommonListResponse;
import play.Logger;
import play.libs.Json;
import play.libs.ws.WSBodyReadables;
import play.libs.ws.WSBodyWritables;
import play.libs.ws.WSClient;
import utils.Constants;
import utils.DataConverterUtils;
import utils.models.ObjectReference;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class SoftwareService implements WSBodyReadables, WSBodyWritables {

    private final WSClient wsClient;

    @Inject
    public SoftwareService(WSClient wsClient) {
        this.wsClient = wsClient;
    }

    public CommonListResponse<Software> getListSoftware(int page, String sortBy, String order, String filter) {
        try {
            //Handle call API
            CompletableFuture<JsonNode> promise = wsClient.url(Constants.API.URL + Constants.API_SOFTWARE.GET_LIST_SOFTWARE)
                    .addQueryParameter("page", String.valueOf(page))
                    .addQueryParameter("pageSize", String.valueOf(10))
                    .addQueryParameter("sortBy", sortBy)
                    .addQueryParameter("orderBy", order)
                    .addQueryParameter("filter", filter)
                    .addHeader("software-products-api", "software-products-api")
                    .setMethod("GET")
                    .execute()
                    .thenApply(res -> res.getBody(json()))
                    .toCompletableFuture();

            CommonListResponse<Software> result = DataConverterUtils.jsonToList(promise.get().toString(), new TypeReference<CommonListResponse<Software>>() {
            });
            return result;
        } catch (Exception exception) {
            Logger.of("application").error("Fail to execute getListSoftware: ", exception);
            return null;
        }
    }

    public Software getSoftware(Long id) {
        try {
            CompletableFuture<JsonNode> promise = wsClient.url(Constants.API.URL + Constants.API_SOFTWARE.GET_DETAIL_SOFTWARE)
                    .addQueryParameter("id", String.valueOf(id))
                    .setMethod("GET")
                    .execute()
                    .thenApply(res -> res.getBody(json()))
                    .toCompletableFuture();

            return Json.fromJson(promise.get(), Software.class);
        } catch (Exception exception) {
            Logger.of("application").error("Fail to execute getSoftware:", exception);
            return null;
        }
    }

    public ObjectReference updateSoftware(Software request) {
        try {
            CompletableFuture<JsonNode> updateSoftware = wsClient.url(Constants.API.URL + Constants.API_SOFTWARE.UPDATE_SOFTWARE)
                    .setBody(Json.toJson(request))
                    .setMethod("PUT")
                    .execute()
                    .thenApply(res -> res.getBody(json()))
                    .toCompletableFuture();
            ObjectReference result = Json.fromJson(updateSoftware.get(), ObjectReference.class);
            return result;
        } catch (Exception exception) {
            Logger.of("application").error("Fail to execute updateSoftware:", exception);
            return null;
        }
    }

    public ObjectReference saveSoftware(Software request) {
        try {
            CompletableFuture<JsonNode> promise = wsClient.url(Constants.API.URL + Constants.API_SOFTWARE.CREATE_SOFTWARE)
                    .setBody(Json.toJson(request))
                    .setMethod("POST")
                    .execute()
                    .thenApply(res -> res.getBody(json()))
                    .toCompletableFuture();
            return Json.fromJson(promise.get(), ObjectReference.class);
        } catch (Exception exception) {
            Logger.of("application").error("Fail to execute saveSoftware: ", exception);
            return null;
        }
    }

    public ObjectReference deleteSoftware(Long id) {
        try {
            Software software = new Software();
            software.setId(id);

            CompletableFuture<JsonNode> promise = wsClient.url(Constants.API.URL + Constants.API_SOFTWARE.DELETE_SOFTWARE)
                    .setBody(Json.toJson(software))
                    .setMethod("DELETE")
                    .execute()
                    .thenApply(res -> res.getBody(json()))
                    .toCompletableFuture();

            return Json.fromJson(promise.get(), ObjectReference.class);
        } catch (Exception exception){
            Logger.of("application").error("Fail to execute deleteSoftware: ", exception);
            return null;
        }
    }

}
