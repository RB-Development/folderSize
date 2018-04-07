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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.SortType;
import javafx.scene.control.TreeTableColumn.CellDataFeatures;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.util.Callback;
import scan.Utility;
import scan.Folder;

/**
 *
 * @author Bösche
 */

public class FXMLFolderController implements Initializable {
    @FXML
    private TreeTableView<Folder> tableview;
    @FXML
    private TreeTableColumn<Folder,String> col_ordner;
    @FXML
    private TreeTableColumn<Folder,Number> col_groesse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        double size;
        File[] paths;
        paths = File.listRoots();
        Utility UT = new Utility();
        TreeItem<Folder> root = new TreeItem<>();
        for (File Disc:paths)
        {
            if (Disc.isDirectory())
            {
                Folder Laufwerk = new Folder();
                Laufwerk.setName(Disc.getAbsolutePath());
                TreeItem<Folder> root_disc = new TreeItem<>(Laufwerk);
                size=0;
                size=UT.scan_all(root_disc,Disc,size);
                Laufwerk.setGroesse(Math.floor((size/1024/1024) *100)/100);
                root.getChildren().add(root_disc);
            }
        }
            
        root.setExpanded(true);
        
        //col_ordner.setCellValueFactory(cell -> {
            //return new SimpleStringProperty(cell.getValue().getValue().getName());
            col_ordner.setCellValueFactory(new TreeItemPropertyValueFactory<>("name"));
        //});
        //col_ordner.setCellValueFactory((CellDataFeatures<Folder,String> p) -> 
        //    return p.getValue().getValue().getName(); 
        //col_groesse.setCellValueFactory((CellDataFeatures<Folder,Number> p) -> 
            //new SimpleDoubleProperty(p.getValue().getValue().getGroesse()));
            col_groesse.setCellValueFactory(new TreeItemPropertyValueFactory<>("groesse"));
        tableview.setShowRoot(true);
        
        tableview.setRoot(root);
        col_ordner.setSortType(null);
    }
}
