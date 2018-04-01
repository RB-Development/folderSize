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
    public void scan_all(TreeItem root)
    {
        String sTemp;
        File f = new File("C:/");
        File[] fileArray = f.listFiles();
        for (File s:fileArray)
        {
            sTemp = s.getName();
            if (s.isDirectory()&& !sTemp.contains(".Bin"))
                    {
                       Folder Fo = new Folder();
                       Fo.setName(s.getName());
                       Fo.setGroesse(this.getFolderSize(s));
                       TreeItem<Folder> Temp = new TreeItem<>(Fo);
                       root.getChildren().add(Temp);
                    }
        }
    }
    protected double getFolderSize(File folder) {
    double length = 0;
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
