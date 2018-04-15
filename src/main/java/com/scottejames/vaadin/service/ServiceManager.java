package com.scottejames.vaadin.service;

import com.scottejames.vaadin.model.TeamModel;

public class ServiceManager {

    private static ServiceManager instance = null;

    public static synchronized ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManager();
            // Create some sample data
            instance.createTestData();
        }
        return instance;
    }
    private TeamService teamService = new TeamService();

    public TeamService getTeamService() {
        return teamService;
    }

    public void createTestData() {

        TeamModel one = new TeamModel("teamOne","Open","Submitted");
        TeamModel two = new TeamModel("teamTwo","Open","Draft");
        teamService.add(one);
        teamService.add(two);




    }
}