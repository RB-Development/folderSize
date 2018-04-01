/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scan;

/**
 *
 * @author RB_Development
 */
//Klasse um Ordernamen und Größe zu speichern
    public class Folder {
    String name;
    double Groesse;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getGroesse() {
            return Groesse;
        }

        public void setGroesse(double Groesse) {
            this.Groesse = Groesse;
        }   
}
