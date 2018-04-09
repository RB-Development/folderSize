/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scan;

import java.io.File;
import javafx.event.EventType;
import javafx.scene.Node;
import javafx.scene.control.TreeItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import scan.Folder;


/**
 *
 * @author RB_Development
 */
public class Utility {
    public double scan_all(TreeItem root, File Disc, double size)
    {
        double dTemp;
        String sTemp;
        File f = new File(Disc.getAbsolutePath());
        File[] fileArray = f.listFiles();
        for (File s:fileArray)
        {
            sTemp = s.getName();
            //&& !sTemp.contains(".Bin")
            if (s.isDirectory())
                    {
                       Node folderIcon = new ImageView (new Image(getClass().getResourceAsStream("folder.jpg")));
                       Folder Fo = new Folder();
                       Fo.setName(s.getName());
                       TreeItem<Folder> Temp = new TreeItem<>(Fo,folderIcon);
                       //Temp.setGraphic(folderIcon);
                       root.getChildren().add(Temp);
                       dTemp = this.getFolderSize(s,Temp);
                       Fo.setGroesse(Math.floor((dTemp/1024/1024) *100)/100.0);
                       
                       size+=dTemp;   
                    }
        }
        return size;
    }
    protected double getFolderSize(File folder, TreeItem root) {
    double dTemp;
    double length = 0;
    File[] files;
    files = folder.listFiles();
    int count;
    if (files!= null)
    {
        count = files.length;
    }
    else
    {
        count=0;
    }
 
    for (int i = 0; i < count; i++) {
        if (files[i].isFile()) {
            length += files[i].length();
        }
        else 
        {
            Node folderIcon = new ImageView (new Image(getClass().getResourceAsStream("folder.jpg")));
            dTemp=0;
            Folder fTemp = new Folder();
            fTemp.setName(files[i].getName());
            TreeItem<Folder> Tree_Temp = new TreeItem(fTemp,folderIcon);
            //Tree_Temp.setGraphic(folderIcon);
            root.getChildren().add(Tree_Temp);
            dTemp=getFolderSize(files[i],Tree_Temp);
            fTemp.setGroesse(Math.floor((dTemp/1024/1024) *100)/100.0);
            length += dTemp;
        }
    }
    return length;
}
    
}
