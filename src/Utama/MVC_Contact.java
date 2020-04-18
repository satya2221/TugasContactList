/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utama;

/**
 *
 * @author Satya
 */
public class MVC_Contact {
    ViewContact viewnya = new ViewContact();
    ModelContact modelnya= new ModelContact();
    ControllerContact controllernya = new ControllerContact(modelnya, viewnya);
}
