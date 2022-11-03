package utils.services;

import com.fasterxml.jackson.databind.JsonNode;
import models.Software;
import play.libs.ws.*;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

public class CallApiUtils implements WSBodyReadables, WSBodyWritables {
    private final WSClient ws;

    @Inject
    public CallApiUtils(WSClient ws) {
        this.ws = ws;
    }

}
