/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package catalogorder;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author USER
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({catalogorder.OrderInterfaceTest.class, catalogorder.OrderMainProgrameTest.class, catalogorder.CatalogOrderTest.class})
public class CatalogorderSuite {

    @Before
    public void setUp() throws Exception {
    }
    
}
