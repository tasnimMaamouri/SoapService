/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws;

/**
 *
 * @author tassm
 */
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@WebService(serviceName = "EmissionService")
public class EmissionService {
     private List<Emission> emissions;

    public EmissionService() {
        emissions = new ArrayList<>();
        loadEmissionsFromCSV("E:/Users/tassm/Downloads/ProjetSoap/SoapService/src/main/java/data/dataset.csv");
    }

    private void loadEmissionsFromCSV(String filePath) {
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean isFirstLine = true;

        while ((line = br.readLine()) != null) {
            if (isFirstLine) {
                isFirstLine = false;
                continue; // Ignorer l'en-tête
            }

            String[] values = line.split(",");
            if (values.length >= 4) {
                try {
                    Emission emission = new Emission();
                    
                    emission.setSector(values[2].trim().replace("\"", ""));
                    emission.setRegion(values[0].trim().replace("\"", ""));
                    // Supprimer les guillemets avant de convertir en double
                    String cleanedValue = values[3].trim().replace("\"", "");
                    emission.setCo2Emissions(Double.parseDouble(cleanedValue));
                    emissions.add(emission);
                } catch (NumberFormatException e) {
                    System.err.println("Valeur invalide pour CO2 : " + values[3]);
                }
            } else {
                System.err.println("Ligne mal formatée ignorée : " + line);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}



    @WebMethod
    public List<Emission> getEmissionsByRegion(@WebParam(name = "region")String region) {
        List<Emission> result = new ArrayList<>();
        for (Emission emission : emissions) {
            if (emission.getRegion().equalsIgnoreCase(region)) {
                result.add(emission);
            }
        }
        return result;
    }

    @WebMethod
    public List<Emission> getEmissionsBySector(@WebParam(name = "sector")String sector) {
        System.out.println("Received sector: " + sector);
        List<Emission> result = new ArrayList<>();
        for (Emission emission : emissions) {
            System.out.println("Checking emission: " + emission.getSector());

            if (emission.getSector().equalsIgnoreCase(sector)) {
                System.out.println("Matched: " + emission);

                result.add(emission);
            }
        }
        return result;
    }

    @WebMethod
    public List<Emission> getAllEmissions() {
        return emissions;
    }
    
}
