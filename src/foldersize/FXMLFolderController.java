/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foldersize;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import scan.scan_disc;
import java.util.*;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.*;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import scan.Utility;
import scan.Folder;

/**
 *
 * @author Bösche
 */

public class FXMLFolderController implements Initializable {
    @FXML
    private TreeTableView<String> tableview;
    @FXML
    private TreeTableColumn<Folder,String> col_ordner;
    @FXML
    private TreeTableColumn<Folder,Number> col_groesse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Utility UT = new Utility();
        TreeItem<String> root = new TreeItem<>("root");
        root.setExpanded(true);
        col_ordner.setCellValueFactory((CellDataFeatures<Folder,String> p) -> 
            new ReadOnlyStringWrapper(p.getValue().getValue().getName())); 
        col_groesse.setCellValueFactory((CellDataFeatures<Folder,Number> p) -> 
            new SimpleDoubleProperty(p.getValue().getValue().getGroesse())); 
        tableview.setShowRoot(true);
        UT.scan_all(root);
        tableview.setRoot(root);
    }
}
