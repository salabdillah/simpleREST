package com.example.service;

import com.example.model.TvProgram;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by faisalabdillah on 24/11/15.
 */
public class TvProgramManager {

    List<TvProgram> tvProgramList = new ArrayList<TvProgram>();

    public List getTvProgramList() {
        tvProgramList.add(new TvProgram("Game of Thrones", "2011", true));
        tvProgramList.add(new TvProgram("Walking Dead", "2010", false));
        tvProgramList.add(new TvProgram("Firefly", "2002", true));
        tvProgramList.add(new TvProgram("Banshee", "2013", false));
        tvProgramList.add(new TvProgram("Greys Anatomy", "2005", true));
        return tvProgramList;
    }


    public List saveRecord(String json){
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            JsonNode jsonNode = objectMapper.readValue(json, JsonNode.class);
            boolean fav = false;
            System.out.println("JSON -> "+jsonNode.get("favorite")+", asText -> "+jsonNode.get("favorite").asText());
            if(jsonNode.get("favorite").asText().equals("true")) fav = true;
            tvProgramList.add(new TvProgram(jsonNode.get("title").asText(), jsonNode.get("year").asText(), fav));
        }catch (IOException e){
            e.printStackTrace();
        }
        return tvProgramList;
    }

}
