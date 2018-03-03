/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scan;
/**
 *
 * @author Bösche
 */
 import java.io.File;
public class scan_disc {
    
    public void scan_all()
    {
        File f = new File("C:/");
        File[] fileArray = f.listFiles();
        for (File s:fileArray)
        {
            
        }
    }
    
}
