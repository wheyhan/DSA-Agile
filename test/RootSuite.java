/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author USER
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({domain.DomainSuite.class, catalogorder.CatalogorderSuite.class, da.DaSuite.class})
public class RootSuite {

    @Before
    public void setUp() throws Exception {
    }
    
}
