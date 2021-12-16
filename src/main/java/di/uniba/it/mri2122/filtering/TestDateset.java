/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package di.uniba.it.mri2122.filtering;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pierpaolo
 */
public class TestDateset {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IFDataset dataset=new Movielens();
        try {
            dataset.load(new File("./resources/IF/ml-1m"));
            Map<String, List<Rating>> ratingsByItem = IFDatasetUtils.getRatingsByItem(dataset.getRatings());
            List<Rating> ratings = ratingsByItem.get("10");
            System.out.println(IFDatasetUtils.average(ratings));
        } catch (IOException ex) {
            Logger.getLogger(TestDateset.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
