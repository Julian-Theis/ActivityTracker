package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface FolderItem Version 2
 */
@IID("{EDC817AA-92B8-11D1-B075-00C04FC33AA5}")
public interface FolderItem2 extends uic.prominent.ScreenLogging.wsh.FolderItem {
  // Methods:
  /**
   * <p>
   * Extended version of InvokeVerb
   * </p>
   * @param vVerb Optional parameter. Default value is com4j.Variant.getMissing()
   * @param vArgs Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(1610809344) //= 0x60030000. The runtime will prefer the VTID if present
  @VTID(24)
  void invokeVerbEx(
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vVerb,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vArgs);


  /**
   * <p>
   * Access an extended property
   * </p>
   * @param bstrPropName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610809345) //= 0x60030001. The runtime will prefer the VTID if present
  @VTID(25)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object extendedProperty(
    java.lang.String bstrPropName);


  // Properties:
}
