package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface FolderItems Version 2
 */
@IID("{C94F0AD0-F363-11D2-A327-00C04F8EEC7F}")
public interface FolderItems2 extends uic.prominent.ScreenLogging.wsh.FolderItems {
  // Methods:
  /**
   * <p>
   * Extended version of InvokeVerb for a collection of Folder Items
   * </p>
   * @param vVerb Optional parameter. Default value is com4j.Variant.getMissing()
   * @param vArgs Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(1610809344) //= 0x60030000. The runtime will prefer the VTID if present
  @VTID(12)
  void invokeVerbEx(
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vVerb,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vArgs);


  // Properties:
}
