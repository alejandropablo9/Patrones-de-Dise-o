/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itoaxaca.citaspacientes.modelo;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alejandro
 */
public class CitasTest {
    
    public CitasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getIdcitas method, of class Citas.
     */
    @Test
    public void testGetIdcitas() {
        System.out.println("getIdcitas");
        Citas instance = new Citas();
        Integer expResult = null;
        Integer result = instance.getIdcitas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdcitas method, of class Citas.
     */
    @Test
    public void testSetIdcitas() {
        System.out.println("setIdcitas");
        Integer idcitas = null;
        Citas instance = new Citas();
        instance.setIdcitas(idcitas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFecha method, of class Citas.
     */
    @Test
    public void testGetFecha() {
        System.out.println("getFecha");
        Citas instance = new Citas();
        String expResult = "";
        String result = instance.getFecha();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaD method, of class Citas.
     */
    @Test
    public void testGetFechaD() {
        System.out.println("getFechaD");
        Citas instance = new Citas();
        Date expResult = null;
        Date result = instance.getFechaD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFecha method, of class Citas.
     */
    @Test
    public void testSetFecha() {
        System.out.println("setFecha");
        Date fecha = null;
        Citas instance = new Citas();
        instance.setFecha(fecha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHora method, of class Citas.
     */
    @Test
    public void testGetHora() {
        System.out.println("getHora");
        Citas instance = new Citas();
        String expResult = "";
        String result = instance.getHora();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHoraD method, of class Citas.
     */
    @Test
    public void testGetHoraD() {
        System.out.println("getHoraD");
        Citas instance = new Citas();
        Date expResult = null;
        Date result = instance.getHoraD();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHora method, of class Citas.
     */
    @Test
    public void testSetHora() {
        System.out.println("setHora");
        Date hora = null;
        Citas instance = new Citas();
        instance.setHora(hora);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaciente method, of class Citas.
     */
    @Test
    public void testGetPaciente() {
        System.out.println("getPaciente");
        Citas instance = new Citas();
        Paciente expResult = null;
        Paciente result = instance.getPaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPaciente method, of class Citas.
     */
    @Test
    public void testSetPaciente() {
        System.out.println("setPaciente");
        Paciente paciente = null;
        Citas instance = new Citas();
        instance.setPaciente(paciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Citas.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Citas instance = new Citas();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Citas.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Citas instance = new Citas();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Citas.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Citas instance = new Citas();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
