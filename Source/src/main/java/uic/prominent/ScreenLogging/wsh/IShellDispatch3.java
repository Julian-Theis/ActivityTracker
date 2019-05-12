package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Updated IShellDispatch
 */
@IID("{177160CA-BB5A-411C-841D-BD38FACDEAA0}")
public interface IShellDispatch3 extends uic.prominent.ScreenLogging.wsh.IShellDispatch2 {
  // Methods:
  /**
   * <p>
   * Add an object to the Recent Docuements
   * </p>
   * @param varFile Mandatory java.lang.Object parameter.
   * @param bstrCategory Optional parameter. Default value is ""
   */

  @DISPID(1610874880) //= 0x60040000. The runtime will prefer the VTID if present
  @VTID(39)
  void addToRecent(
    @MarshalAs(NativeType.VARIANT) java.lang.Object varFile,
    @Optional java.lang.String bstrCategory);


  // Properties:
}
