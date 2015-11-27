package com.example.rest;

import com.example.model.TvProgram;
import com.example.service.TvProgramManager;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.Reader;
import java.io.StringReader;
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

    @Path("/save")
    @GET
    public Response save(String obj)   {
        //
        // Code processing the input parameters
        //
        System.out.println("JSON: "+obj);
        log.info("You are here");
        return Response.ok().entity(tvProgramManager.getTvProgramList()).type(MediaType.APPLICATION_JSON_TYPE)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .build();
    }

    @Path("/save_")
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response save_(String obj)   {

        tvProgramManager.saveRecord(obj);
        return Response.ok().entity(tvProgramManager.getTvProgramList()).type(MediaType.APPLICATION_JSON_TYPE)
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
                .allow("OPTIONS").build();
    }
}
