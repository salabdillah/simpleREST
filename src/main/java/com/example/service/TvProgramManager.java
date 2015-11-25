package com.example.service;

import com.example.model.TvProgram;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by faisalabdillah on 24/11/15.
 */
public class TvProgramManager {

    public List getTvProgramList() {
        List<TvProgram> tvProgramList = new ArrayList<TvProgram>();
        tvProgramList.add(new TvProgram("Game of Thrones", "2011", true));
        tvProgramList.add(new TvProgram("Walking Dead", "2010", false));
        tvProgramList.add(new TvProgram("Firefly", "2002", true));
        tvProgramList.add(new TvProgram("Banshee", "2013", false));
        tvProgramList.add(new TvProgram("Greys Anatomy", "2005", true));
        return tvProgramList;
    }

}
