package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * INewWDEvents interface
 */
@IID("{0751C551-7568-41C9-8E5B-E22E38919236}")
public interface INewWDEvents extends uic.prominent.ScreenLogging.wsh.IWebWizardHost {
  // Methods:
  /**
   * @param bstrSignInUrl Mandatory java.lang.String parameter.
   * @return  Returns a value of type boolean
   */

  @DISPID(7) //= 0x7. The runtime will prefer the VTID if present
  @VTID(16)
  boolean passportAuthenticate(
    java.lang.String bstrSignInUrl);


  // Properties:
}
