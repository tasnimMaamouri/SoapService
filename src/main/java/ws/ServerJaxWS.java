/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

import jakarta.xml.ws.Endpoint;

/**
 *
 * @author User
 */
public class ServerJaxWS {
    
     public static void main(String[] args) {
         EmissionService service = new EmissionService();
         String url ="http://0.0.0.0:8281/EmissionService";
         Endpoint.publish(url, service);
         System.out.println("Service SOAP publié à : " + url);
     }
}
