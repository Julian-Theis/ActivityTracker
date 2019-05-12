package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Shell Link2 IDispatch interface
 */
@IID("{317EE249-F12E-11D2-B1E4-00C04F8EEB3E}")
public interface IShellLinkDual2 extends uic.prominent.ScreenLogging.wsh.IShellLinkDual {
  // Methods:
  /**
   * <p>
   * Get the target of a link object
   * </p>
   * <p>
   * Getter method for the COM property "Target"
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItem
   */

  @DISPID(1610809344) //= 0x60030000. The runtime will prefer the VTID if present
  @VTID(23)
  uic.prominent.ScreenLogging.wsh.FolderItem target();


  // Properties:
}
