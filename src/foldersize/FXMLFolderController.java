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

/**
 *
 * @author Bösche
 */

public class FXMLFolderController implements Initializable {
    @FXML
    private TreeTableView<String> tableview;
    @FXML
    private TreeTableColumn<String,String> col_ordner;
    @FXML
    private TreeTableColumn<Double,Double> col_groesse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Folder FolderList = new Folder();
        TreeItem<String> root = new TreeItem<>("root");
        root.setExpanded(true);
        col_ordner.setCellValueFactory((CellDataFeatures<String,String> p) -> 
            new ReadOnlyStringWrapper(p.getValue().getValue())); 
        tableview.setShowRoot(true);
        FolderList.scan_all(root);
        tableview.setRoot(root);
    }    
    public class Folder {
    
    public void scan_all(TreeItem root)
    {
        File f = new File("C:/");
        File[] fileArray = f.listFiles();
        for (File s:fileArray)
        {
            if (s.isDirectory())
                    {
                       TreeItem<String> Temp = new TreeItem<>(s.getName());
                       root.getChildren().add(Temp);
                    }
        }
    }
    private long getFolderSize(File folder) {
    long length = 0;
    File[] files = folder.listFiles();
 
    int count = files.length;
 
    for (int i = 0; i < count; i++) {
        if (files[i].isFile()) {
            length += files[i].length();
        }
        else {
            length += getFolderSize(files[i]);
        }
    }
    return length;
}
    
}
}
