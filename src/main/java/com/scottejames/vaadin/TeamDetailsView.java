package com.scottejames.vaadin;

import com.scottejames.vaadin.model.ScoutModel;
import com.scottejames.vaadin.model.SupportModel;
import com.scottejames.vaadin.model.TeamModel;
import com.scottejames.vaadin.service.ServiceManager;
import com.scottejames.vaadin.service.TeamService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.HtmlImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@HtmlImport("styles/shared-styles.html")
@Route("TeamDetails")
public class TeamDetailsView extends VerticalLayout {

    private int modelID = 0;

    private TeamService service = ServiceManager.getInstance().getTeamService();
    private TeamModel model = null;
    Binder<TeamModel> binder = new Binder<>(TeamModel.class);

    private Grid<ScoutModel>    teamMembers = new Grid<>();
    private Grid<SupportModel>  supportMembers = new Grid<>();
    private FormLayout          teamDetailsForm = new FormLayout();
    private Button              addTeamMemberButton = null;
    private Button              addSupportMember = null;
    private FormLayout          teamPhoneForm = new FormLayout();
    private FormLayout          emergencyContactForm = new FormLayout();
    private Button              saveForm;
    private Button              cancelForm;


    public void addTextField(FormLayout form,String label){
      addTextField(form, label,null);

    }
    public void addTextField(FormLayout form, String label, String bindValue){

        TextField teamName = new TextField();
        form.addFormItem(teamName,label);
        if (bindValue != null)
            binder.bind(teamName,bindValue);


    }

    public void setupScoutGrid(){
        teamMembers.addColumn(ScoutModel::getFullName).setHeader("Full Name");
        teamMembers.addColumn(ScoutModel::getDob).setHeader("DOB");
        teamMembers.addColumn(ScoutModel::getGender).setHeader("Gender");
        updateScoutGrid();
    }
    public void updateScoutGrid(){

        List<ScoutModel> data = new ArrayList<>();
        data.add(new ScoutModel("SCott","17-11-73","male"));
        data.add(new ScoutModel("Anna","17-11-73","male"));
        data.add(new ScoutModel("Tom","17-11-73","male"));

        teamMembers.setItems(data);
        teamMembers.setHeightByRows(true);
    }
    public void setupSupportGrid(){
        supportMembers.addColumn(SupportModel::getFullName).setHeader("Full Name");
        supportMembers.addColumn(SupportModel::getPhoneNumber).setHeader("Phone");
        supportMembers.addColumn(SupportModel::getFrom).setHeader("From");
        supportMembers.addColumn(SupportModel::getTo).setHeader("To");

        updateSupportGrid();
    }
    public void updateSupportGrid(){

        List<SupportModel> data = new ArrayList<>();
        data.add(new SupportModel("SCott","17-11-73","start","finish"));
        data.add(new SupportModel("Anna","17-11-73","start","finish"));

        supportMembers.setItems(data);
        supportMembers.setHeightByRows(true);
    }
    private void saveForm(){
        System.out.println("SAVE FORM:");
        try {
            binder.writeBean(model);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
        service.update(model);
        this.getUI().ifPresent(ui -> ui.navigate("TeamView"));



    }
    private void cancelForm(){
        System.out.println("CANCEL FORM:");

    }
    private void addSupportMember(){
        System.out.println("ADD SUPPORT FORM:");

    }
    private void addTeamMember(){
        System.out.println("ADD TEAM FORM:");


    }
    public TeamDetailsView(){
        System.out.println("Starting with model : " + service.getCurrentTeamModel().getId());
        model = service.getCurrentTeamModel();

        setupScoutGrid();
        setupSupportGrid();

        addTextField(teamDetailsForm,"Team Name", "teamName");
        addTextField(teamDetailsForm,"Section", "section");
        addTextField(teamDetailsForm,"District", "district");
        addTextField(teamDetailsForm,"County", "county");
        addTextField(teamDetailsForm,"Start Time","prefStart");
        addTextField(teamDetailsForm,"Hike Class", "hikeClass");
        add(teamDetailsForm);

        add(teamMembers);

        addTeamMemberButton = new Button("Add Team Member");
        addTeamMemberButton.addClickListener(e-> this.addTeamMember());
        add(addTeamMemberButton);

        addTextField(teamPhoneForm,"Active Phone","activeMobile");
        addTextField(teamPhoneForm,"Backup Phone","backupMobile");
        add(teamPhoneForm);

        add(supportMembers);

        addSupportMember = new Button("Add Support Member");
        addTeamMemberButton.addClickListener(e->this.addSupportMember());
        add(addSupportMember);

        emergencyContactForm.setResponsiveSteps(new FormLayout.ResponsiveStep("max-content",12));
        addTextField(emergencyContactForm,"Emergency Contact Name", "emergencyContactName" );
        addTextField(emergencyContactForm,"Emergency Contact Email", "emergencyContactEmail" );
        addTextField(emergencyContactForm,"Emergency Contact Mobile", "emergencyContactMobile");
        addTextField(emergencyContactForm,"Emergency Contact Landline","emergencyContactLandline" );

        add(emergencyContactForm);

        saveForm = new Button("Save");
        saveForm.addClickListener(e -> this.saveForm());

        cancelForm = new Button("Cancel");
        cancelForm.addClickListener(e -> this.cancelForm());
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(saveForm,cancelForm);
        add(horizontalLayout);
        binder.readBean(model);

    }
 }
