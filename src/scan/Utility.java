/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scan;

import java.io.File;
import javafx.scene.control.TreeItem;
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
                       Folder Fo = new Folder();
                       Fo.setName(s.getName());
                       dTemp = this.getFolderSize(s);
                       Fo.setGroesse(Math.floor((dTemp/1024/1024) *100)/100.0);
                       TreeItem<Folder> Temp = new TreeItem<>(Fo);
                       root.getChildren().add(Temp);
                       size+=dTemp;   
                    }
        }
        return size;
    }
    protected double getFolderSize(File folder) {
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
        else {
            length += getFolderSize(files[i]);
        }
    }
    return length;
}
    
}
