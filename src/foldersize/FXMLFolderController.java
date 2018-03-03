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
import javafx.scene.control.TreeTableView;
import javafx.scene.control.TreeTableColumn;

/**
 *
 * @author Bösche
 */

public class FXMLFolderController implements Initializable {
    @FXML
    private TreeTableView<String> tableview;
    @FXML
    private TreeTableColumn<File,String> col_ordner;
    @FXML
    private TreeTableColumn<File,Number> col_groesse;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        scan_disc FolderList = new scan_disc();
        FolderList.scan_all();
    }    
    public class scan_disc {
    
    public void scan_all()
    {
        File f = new File("C:/");
        ArrayList<File> folderL = new ArrayList();
        File[] fileArray = f.listFiles();
        for (File s:fileArray)
        {
            if (s.isDirectory())
                    {
                       folderL.add(s);
                    }
        }
    }
    
}
}
