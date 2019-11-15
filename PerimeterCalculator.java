
/**
 * This is a Perimeter calculator for multiple shapes.
 * It can get the largest side or perimeter of multiple shapes
 * 
 * @author (Mohammed aroui) 
 * @version (15/11/2019)
 */
    import edu.duke.*;
import java.io.File;
public class PerimeterCalculator {



    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        
        for(Point p : s.getPoints()){
            count++;
        }
        return count;
     
    }

    public double getAverageLength(Shape s) {
        double avg = getPerimeter(s)/getNumPoints(s);
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        double largest =0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            
            prevPt = currPt;
            if (currDist>largest){largest=currDist;}
        
        }return largest;
    }

    public double getLargestX(Shape s) {
        double X;
        //System.out.printf("X=%.1f",X);
        
        double largestX= s.getLastPoint().getX();
        for (Point p : s.getPoints()){
            X = p.getX();if( X> largestX){largestX=X;}}
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
         DirectoryResource dr = new DirectoryResource();
         double largestPer = 0;
 for (File f : dr.selectedFiles()) {
      FileResource fr = new FileResource(f);
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        
        if(length>largestPer){largestPer= length;}
 }
        //System.out.printf("largest=%.1f",largestPer);
        return largestPer;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        String temp = null; 
        DirectoryResource dr = new DirectoryResource();
         double largestPer = 0;
 for (File f : dr.selectedFiles()) {
      FileResource fr = new FileResource(f);
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        
        if(length>largestPer){largestPer= length;temp=f.getName();}
 }
        
        return temp;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
      
        int count = getNumPoints(s);
        double avg = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);
        
        System.out.printf("Perimeter = %.1f\nCount = %d\nAvg = %.1f\nLargestSide = %.1f\nLargestX = %.1f\n",length, count, avg, largestSide, largestX);
        //System.out.printf("perimeter = %.3f ",largestSide);
        //System.out.println("avg = " + avg);
    }
    
    public void testPerimeterMultipleFiles() {
        double large =getLargestPerimeterMultipleFiles();
        System.out.printf("largest = %.3f",large);
       
        
    }

    public void testFileWithLargestPerimeter() {
        
        String large = getFileWithLargestPerimeter();
        System.out.printf("file name = %s",large);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter2 = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterCalculator pr = new PerimeterCalculator();
        pr.testPerimeter();
    }
}



