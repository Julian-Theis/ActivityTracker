package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Updated IShellDispatch
 */
@IID("{EFD84B2D-4BCF-4298-BE25-EB542A59FBDA}")
public interface IShellDispatch4 extends uic.prominent.ScreenLogging.wsh.IShellDispatch3 {
  // Methods:
  /**
   * <p>
   * Windows Security
   * </p>
   */

  @DISPID(1610940416) //= 0x60050000. The runtime will prefer the VTID if present
  @VTID(40)
  void windowsSecurity();


  /**
   * <p>
   * Raise/lower the desktop
   * </p>
   */

  @DISPID(1610940417) //= 0x60050001. The runtime will prefer the VTID if present
  @VTID(41)
  void toggleDesktop();


  /**
   * <p>
   * Return explorer policy value
   * </p>
   * @param bstrPolicyName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610940418) //= 0x60050002. The runtime will prefer the VTID if present
  @VTID(42)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object explorerPolicy(
    java.lang.String bstrPolicyName);


  /**
   * <p>
   * Return shell global setting
   * </p>
   * @param lSetting Mandatory int parameter.
   * @return  Returns a value of type boolean
   */

  @DISPID(1610940419) //= 0x60050003. The runtime will prefer the VTID if present
  @VTID(43)
  boolean getSetting(
    int lSetting);


  // Properties:
}
