package com.scottejames.vaadin;

import com.scottejames.vaadin.model.TeamModel;
import com.scottejames.vaadin.service.Service;
import com.scottejames.vaadin.service.ServiceManager;
import com.scottejames.vaadin.service.TeamService;
import com.vaadin.flow.component.HasClickListeners;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.QueryParameters;
import com.vaadin.flow.router.Route;

import java.util.HashMap;
import java.util.Map;


/**
 * The main view contains a button and a template element.
 */
@HtmlImport("styles/shared-styles.html")
@Route("TeamView")
public class TeamView extends VerticalLayout{
    Button deleteTeam = null;
    Button addTeam = null;
    Button editTeam = null;

    private TeamService service = ServiceManager.getInstance().getTeamService();
    Grid<TeamModel> teamGrid = new Grid<>();

    TeamModel selectedTeam = null;
    public void updateList(){
        teamGrid.setItems(service.getAll());
        if (service.getAll().size() == 0){
            deleteTeam.setEnabled(false);
        } else {
            deleteTeam.setEnabled(true);
        }
        editTeam.setEnabled(false);

    }




    public TeamView() {


        teamGrid.addColumn(TeamModel::getTeamName).setHeader("TeamName");
        teamGrid.addColumn(TeamModel::getHikeClass).setHeader("HikeClass");
        teamGrid.addColumn(TeamModel::getStatus).setHeader("Status");

        teamGrid.setHeightByRows(true);

        add(teamGrid);

        HorizontalLayout horiz = new HorizontalLayout();
        deleteTeam = new Button("Delete Team");
        deleteTeam.addClickListener(e-> deleteTeam(e));
        editTeam = new Button("Edit Team");
        editTeam.addClickListener(e->editTeam());
        addTeam = new Button("Add Team");
        addTeam.addClickListener(e->addTeam());

        horiz.add(deleteTeam,editTeam,addTeam);
        add(horiz);
        updateList();
        setClassName("main-layout");

        teamGrid.asSingleSelect().addValueChangeListener(event -> {
            System.out.println("VAlue " + event.getValue());
            editTeam.setEnabled(true);
            selectedTeam = event.getValue();
        });

    }

    private void deleteTeam(HasClickListeners.ClickEvent<Button> e) {
        if (selectedTeam != null) {
            service.remove(selectedTeam);
            updateList();
        }
    }

    private void addTeam() {
        System.out.println("ADD TEAM");
        service.add(new TeamModel("New Team","S-Class","Draft"));
        updateList();
    }

    private void editTeam() {
        service.setCurrentTeamModel(selectedTeam);
        editTeam.getUI().ifPresent(ui -> ui.navigate("TeamDetails"));
    }

}