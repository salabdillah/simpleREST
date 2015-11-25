package com.example.rest;

import com.example.service.TvProgramManager;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

/**
 * Created by faisalabdillah on 24/11/15.
 */
@Path("/listener")
@Stateless
public class TestRest {

    @Inject
    Logger log;

    @Inject
    TvProgramManager tvProgramManager;

    @GET
    @Path("/getRecordByRequest")
    public Response getRecordByRequest(){
        log.info("You are in");
        return Response.ok().entity(tvProgramManager.getTvProgramList()).type(MediaType.APPLICATION_JSON_TYPE)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build();
    }
}
