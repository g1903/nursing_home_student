package controller;

import datastorage.DAOFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.sql.SQLException;

public class AllCaregiverController {

    @FXML
    private TableView<Caregiver> tableView;
    @FXML
    private TableColumn<Caregiver, Integer> colID;
    @FXML
    private TableColumn<Caregiver, Integer> ColSurname;
    @FXML
    private TableColumn<Caregiver, Integer> ColFirstName;
    @FXML
    private TableColumn<Caregiver, Integer> colTelephone;
    @FXML
    private Button btnadd;
    @FXML
    private Button btnDelete;

    private ObservableList<Caregiver> TableViewContent= FXCollections.observableArrayList();
    private Caregiver dao;
    public void initialize(){
        readAllAndShowInTableView();

        this.colID.setCellValueFactory(new PropertyValueFactory<Caregiver, String>("pid"));
        this.ColSurname.setCellValueFactory(new PropertyValueFactory<Caregiver, String>("firstName"));
        this.ColSurname.setCellValueFactory(TextFieldTableCell.forTableColumn());
        this.ColSurname.setCellValueFactory();
    }

    public void readAllAndShowInTableView() {
        this.TableViewContent.clear();
        this.dao = DAOFactory.getDAOFactory().createTreatmentDAO();
        list<Caregiver> allCaregiver;
        try {
            allCaregiver = dao.readAll();
            for (Caregiver C : allCaregiver) {
                this.tableViewContent.add(C);
            }
            } catch (SQLException e){
            e.printStackTrace();
        }
    }


}





