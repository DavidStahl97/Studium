/**
 * generated by Xtext 2.18.0
 */
package inf.thm.de.entities;

import inf.thm.de.entities.EntitiesStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class EntitiesStandaloneSetup extends EntitiesStandaloneSetupGenerated {
  public static void doSetup() {
    new EntitiesStandaloneSetup().createInjectorAndDoEMFRegistration();
  }
}
