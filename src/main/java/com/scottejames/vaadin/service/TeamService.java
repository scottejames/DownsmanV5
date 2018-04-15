package com.scottejames.vaadin.service;

import com.scottejames.vaadin.model.TeamModel;

public class TeamService extends Service<TeamModel> {

    public int id = 0;

    public void setCurrentTeamModel(TeamModel m){
        this.id = m.getId();
    }
    public TeamModel getCurrentTeamModel(){
        return this.getById(this.id);
    }
}
