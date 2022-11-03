package controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Software;
import models.responses.CommonListResponse;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.i18n.MessagesApi;
import play.libs.Json;
import play.libs.concurrent.HttpExecutionContext;
import play.libs.ws.*;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import services.company.CompanyService;
import services.software.SoftwareService;
import utils.Constants;
import utils.DataConverterUtils;
import utils.models.ObjectReference;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Manage a database of computers
 */
public class HomeController extends Controller implements WSBodyReadables, WSBodyWritables {

    private SoftwareService softwareService;
    private CompanyService companyService;
    private final FormFactory formFactory;
    private final MessagesApi messagesApi;
    private final WSClient wsClient;

    @Inject
    public HomeController(SoftwareService softwareService, CompanyService companyService,
                          FormFactory formFactory, MessagesApi messagesApi,
                          WSClient wsClient) {
        this.softwareService = softwareService;
        this.companyService = companyService;
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
        this.wsClient = wsClient;
    }

    /**
     * This result directly redirect to application home.
     */
    private Result GO_HOME = Results.redirect(
            routes.HomeController.list(0, "name", "asc", "")
    );

    /**
     * Handle default path requests, redirect to computers list
     */
    public Result index() {
        return GO_HOME;
    }

    /**
     * Display the paginated list of computers.
     *
     * @param page   Current page number (starts from 0)
     * @param sortBy Column to be sorted
     * @param order  Sort order (either asc or desc)
     * @param filter Filter applied on computer names
     */
    public Result list(Http.Request request, int page, String sortBy, String order, String filter) throws Exception {
        CommonListResponse<Software> softwareCommonListResponse = softwareService.getListSoftware(page, sortBy, order, filter);
        return ok(views.html.list.render(softwareCommonListResponse, softwareCommonListResponse.getItems(),
                sortBy, order, filter, request, messagesApi.preferred(request)));
    }

    /**
     * Display the 'edit form' of a existing Computer.
     *
     * @param id Id of the computer to edit
     */
    public Result edit(Http.Request request, Long id) throws Exception {
        Software software = softwareService.getSoftware(id);
        Map<String, String> companies = companyService.getCompanyOptions();
        Form<Software> softwareForm = formFactory.form(Software.class).fill(software);

        return ok(views.html.editForm.render(id, softwareForm, companies,
                request, messagesApi.preferred(request)));
    }

    /**
     * Handle the 'edit form' submission
     *
     * @param id Id of the computer to edit
     */
    public Result update(Http.Request request, Long id) throws Exception {
        Form<Software> softwareForm = formFactory.form(Software.class).bindFromRequest(request);

        if (softwareForm.hasErrors()) {
            Map<String, String> companies = companyService.getCompanyOptions();
            return badRequest(views.html.editForm.render(id, softwareForm, companies, request, messagesApi.preferred(request)));
        }

        Software newSoftwareData = softwareForm.get();
        newSoftwareData.setId(id);
        ObjectReference result = softwareService.updateSoftware(newSoftwareData);

        if (result.getStatus() == false) {
            return GO_HOME
                    .flashing("Fail", "Software " + newSoftwareData.getName() + " hasn't been updated");
        }
        return GO_HOME
                .flashing("success", "Software " + newSoftwareData.getName() + " has been updated");
    }

    /**
     * Display the 'new computer form'.
     */
    public Result create(Http.Request request) throws Exception {
        Form<Software> softwareForm = formFactory.form(Software.class);
        Map<String, String> companies = companyService.getCompanyOptions();
        return ok(views.html.createForm.render(softwareForm, companies, request, messagesApi.preferred(request)));
    }

    /**
     * Handle the 'new computer form' submission
     */
    public Result save(Http.Request request) throws Exception {
        Form<Software> softwareForm = formFactory.form(Software.class).bindFromRequest(request);

        if (softwareForm.hasErrors()) {
            Map<String, String> companies = companyService.getCompanyOptions();
            return badRequest(views.html.createForm.render(softwareForm, companies, request, messagesApi.preferred(request)));
        }

        Software newSoftware = softwareForm.get();
        ObjectReference result = softwareService.saveSoftware(newSoftware);
        if(result.getStatus() == false){
            return GO_HOME
                    .flashing("fail", "Software " + newSoftware.getName() + " hasn't been created");
        }
        return GO_HOME
                .flashing("success", "Software " + newSoftware.getName() + " has been created");
    }

    /**
     * Handle software deletion
     */
    public Result delete(Long id) throws Exception {
        ObjectReference result = softwareService.deleteSoftware(id);
        if (result.getStatus() == false) {
            return GO_HOME
                    .flashing("fail", "Software hasn't been deleted");
        }
        return GO_HOME
                .flashing("success", "Software has been deleted");
    }

}
            
