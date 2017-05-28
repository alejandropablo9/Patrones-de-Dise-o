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
public class PacienteTest {
    
    public PacienteTest() {
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
     * Test of getIdpaciente method, of class Paciente.
     */
    @Test
    public void testGetIdpaciente() {
        System.out.println("getIdpaciente");
        Paciente instance = new Paciente();
        Integer expResult = null;
        Integer result = instance.getIdpaciente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdpaciente method, of class Paciente.
     */
    @Test
    public void testSetIdpaciente() {
        System.out.println("setIdpaciente");
        Integer idpaciente = null;
        Paciente instance = new Paciente();
        instance.setIdpaciente(idpaciente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Paciente.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Paciente.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Paciente instance = new Paciente();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechanac method, of class Paciente.
     */
    @Test
    public void testGetFechanac() {
        System.out.println("getFechanac");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.getFechanac();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechanac method, of class Paciente.
     */
    @Test
    public void testSetFechanac() {
        System.out.println("setFechanac");
        Date fechanac = null;
        Paciente instance = new Paciente();
        instance.setFechanac(fechanac);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstatura method, of class Paciente.
     */
    @Test
    public void testGetEstatura() {
        System.out.println("getEstatura");
        Paciente instance = new Paciente();
        Integer expResult = null;
        Integer result = instance.getEstatura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstatura method, of class Paciente.
     */
    @Test
    public void testSetEstatura() {
        System.out.println("setEstatura");
        Integer estatura = null;
        Paciente instance = new Paciente();
        instance.setEstatura(estatura);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSexo method, of class Paciente.
     */
    @Test
    public void testGetSexo() {
        System.out.println("getSexo");
        Paciente instance = new Paciente();
        Character expResult = null;
        Character result = instance.getSexo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSexo method, of class Paciente.
     */
    @Test
    public void testSetSexo() {
        System.out.println("setSexo");
        Character sexo = null;
        Paciente instance = new Paciente();
        instance.setSexo(sexo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Paciente.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Paciente instance = new Paciente();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Paciente.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        Paciente instance = new Paciente();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Paciente.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Paciente instance = new Paciente();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
