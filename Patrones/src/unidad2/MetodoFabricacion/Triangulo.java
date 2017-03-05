package unidad2.MetodoFabricacion;

import java.awt.Polygon;

/**
 *
 * @author Alejandro
 */
public class Triangulo extends Polygon {
    
    /**
     *  (x1,y1)     p2
     *     |---------*---------|
     *              * *
     *             *   *
     *            *     *
     *           *       *
     *          *         *
     *         *           *
     *        *             *
     *       *               *
     *     |*-----------------*|p3
     *     p1               (x2,y2)
     */
    Triangulo(int x1, int y1, int x2, int y2)
    {
        addPoint(x1,y2);
        addPoint((x1+x2)/2,y1);
        addPoint(x2,y2);
    }
    
}