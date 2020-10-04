
package Graph.GraphCodes2017;


/**
 * Created by rajkamal on 12/18/16.
 */


import java.awt.geom.Point2D;

@SuppressWarnings("serial")
public class GeographicPoint extends Point2D.Double {

    public String Name;

    public GeographicPoint(double latitude, double longitude, String Name)
    {
        super(latitude, longitude);
        this.Name = Name;
    }
}
