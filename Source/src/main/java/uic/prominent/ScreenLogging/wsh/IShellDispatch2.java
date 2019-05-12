package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Updated IShellDispatch
 */
@IID("{A4C6892C-3BA9-11D2-9DEA-00C04FB16162}")
public interface IShellDispatch2 extends uic.prominent.ScreenLogging.wsh.IShellDispatch {
  // Methods:
  /**
   * <p>
   * get restriction settings
   * </p>
   * @param group Mandatory java.lang.String parameter.
   * @param restriction Mandatory java.lang.String parameter.
   * @return  Returns a value of type int
   */

  @DISPID(1610809344) //= 0x60030000. The runtime will prefer the VTID if present
  @VTID(30)
  int isRestricted(
    java.lang.String group,
    java.lang.String restriction);


  /**
   * <p>
   * Execute generic command
   * </p>
   * @param file Mandatory java.lang.String parameter.
   * @param vArgs Optional parameter. Default value is com4j.Variant.getMissing()
   * @param vDir Optional parameter. Default value is com4j.Variant.getMissing()
   * @param vOperation Optional parameter. Default value is com4j.Variant.getMissing()
   * @param vShow Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(1610809345) //= 0x60030001. The runtime will prefer the VTID if present
  @VTID(31)
  void shellExecute(
    java.lang.String file,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vArgs,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vDir,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vOperation,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vShow);


  /**
   * <p>
   * Find a Printer in the Directory Service
   * </p>
   * @param name Optional parameter. Default value is ""
   * @param location Optional parameter. Default value is ""
   * @param model Optional parameter. Default value is ""
   */

  @DISPID(1610809346) //= 0x60030002. The runtime will prefer the VTID if present
  @VTID(32)
  void findPrinter(
    @Optional java.lang.String name,
    @Optional java.lang.String location,
    @Optional java.lang.String model);


  /**
   * <p>
   * Retrieve info about the user's system
   * </p>
   * @param name Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610809347) //= 0x60030003. The runtime will prefer the VTID if present
  @VTID(33)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object getSystemInformation(
    java.lang.String name);


  /**
   * <p>
   * Start a service by name, and optionally set it to autostart.
   * </p>
   * @param serviceName Mandatory java.lang.String parameter.
   * @param persistent Mandatory java.lang.Object parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610809348) //= 0x60030004. The runtime will prefer the VTID if present
  @VTID(34)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object serviceStart(
    java.lang.String serviceName,
    @MarshalAs(NativeType.VARIANT) java.lang.Object persistent);


  /**
   * <p>
   * Stop a service by name, and optionally disable autostart.
   * </p>
   * @param serviceName Mandatory java.lang.String parameter.
   * @param persistent Mandatory java.lang.Object parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610809349) //= 0x60030005. The runtime will prefer the VTID if present
  @VTID(35)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object serviceStop(
    java.lang.String serviceName,
    @MarshalAs(NativeType.VARIANT) java.lang.Object persistent);


  /**
   * <p>
   * Determine if a service is running by name.
   * </p>
   * @param serviceName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610809350) //= 0x60030006. The runtime will prefer the VTID if present
  @VTID(36)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object isServiceRunning(
    java.lang.String serviceName);


  /**
   * <p>
   * Determine if the current user can start/stop the named service.
   * </p>
   * @param serviceName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610809351) //= 0x60030007. The runtime will prefer the VTID if present
  @VTID(37)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object canStartStopService(
    java.lang.String serviceName);


  /**
   * <p>
   * Show/Hide browser bar.
   * </p>
   * @param bstrClsid Mandatory java.lang.String parameter.
   * @param bShow Mandatory java.lang.Object parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610809352) //= 0x60030008. The runtime will prefer the VTID if present
  @VTID(38)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object showBrowserBar(
    java.lang.String bstrClsid,
    @MarshalAs(NativeType.VARIANT) java.lang.Object bShow);


  // Properties:
}
