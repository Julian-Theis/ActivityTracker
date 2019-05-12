package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface IShellDispatch
 */
@IID("{D8F015C0-C278-11CE-A49E-444553540000}")
public interface IShellDispatch extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Get Application object
   * </p>
   * <p>
   * Getter method for the COM property "Application"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject application();


  /**
   * <p>
   * Get Parent object
   * </p>
   * <p>
   * Getter method for the COM property "Parent"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743809) //= 0x60020001. The runtime will prefer the VTID if present
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject parent();


  /**
   * <p>
   * Get special folder from ShellSpecialFolderConstants
   * </p>
   * @param vDir Mandatory java.lang.Object parameter.
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.Folder
   */

  @DISPID(1610743810) //= 0x60020002. The runtime will prefer the VTID if present
  @VTID(9)
  uic.prominent.ScreenLogging.wsh.Folder nameSpace(
    @MarshalAs(NativeType.VARIANT) java.lang.Object vDir);


  /**
   * <p>
   * Browse the name space for a Folder
   * </p>
   * @param hwnd Mandatory int parameter.
   * @param title Mandatory java.lang.String parameter.
   * @param options Mandatory int parameter.
   * @param rootFolder Optional parameter. Default value is com4j.Variant.getMissing()
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.Folder
   */

  @DISPID(1610743811) //= 0x60020003. The runtime will prefer the VTID if present
  @VTID(10)
  uic.prominent.ScreenLogging.wsh.Folder browseForFolder(
    int hwnd,
    java.lang.String title,
    int options,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object rootFolder);


  /**
   * <p>
   * The collection of open folder windows
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743812) //= 0x60020004. The runtime will prefer the VTID if present
  @VTID(11)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject windows();


  /**
   * <p>
   * Open a folder
   * </p>
   * @param vDir Mandatory java.lang.Object parameter.
   */

  @DISPID(1610743813) //= 0x60020005. The runtime will prefer the VTID if present
  @VTID(12)
  void open(
    @MarshalAs(NativeType.VARIANT) java.lang.Object vDir);


  /**
   * <p>
   * Explore a folder
   * </p>
   * @param vDir Mandatory java.lang.Object parameter.
   */

  @DISPID(1610743814) //= 0x60020006. The runtime will prefer the VTID if present
  @VTID(13)
  void explore(
    @MarshalAs(NativeType.VARIANT) java.lang.Object vDir);


  /**
   * <p>
   * Minimize all windows
   * </p>
   */

  @DISPID(1610743815) //= 0x60020007. The runtime will prefer the VTID if present
  @VTID(14)
  void minimizeAll();


  /**
   * <p>
   * Undo Minimize All
   * </p>
   */

  @DISPID(1610743816) //= 0x60020008. The runtime will prefer the VTID if present
  @VTID(15)
  void undoMinimizeALL();


  /**
   * <p>
   * Bring up the file run
   * </p>
   */

  @DISPID(1610743817) //= 0x60020009. The runtime will prefer the VTID if present
  @VTID(16)
  void fileRun();


  /**
   * <p>
   * Cascade Windows
   * </p>
   */

  @DISPID(1610743818) //= 0x6002000a. The runtime will prefer the VTID if present
  @VTID(17)
  void cascadeWindows();


  /**
   * <p>
   * Tile windows vertically
   * </p>
   */

  @DISPID(1610743819) //= 0x6002000b. The runtime will prefer the VTID if present
  @VTID(18)
  void tileVertically();


  /**
   * <p>
   * Tile windows horizontally
   * </p>
   */

  @DISPID(1610743820) //= 0x6002000c. The runtime will prefer the VTID if present
  @VTID(19)
  void tileHorizontally();


  /**
   * <p>
   * Exit Windows
   * </p>
   */

  @DISPID(1610743821) //= 0x6002000d. The runtime will prefer the VTID if present
  @VTID(20)
  void shutdownWindows();


  /**
   * <p>
   * Suspend the pc
   * </p>
   */

  @DISPID(1610743822) //= 0x6002000e. The runtime will prefer the VTID if present
  @VTID(21)
  void suspend();


  /**
   * <p>
   * Eject the pc
   * </p>
   */

  @DISPID(1610743823) //= 0x6002000f. The runtime will prefer the VTID if present
  @VTID(22)
  void ejectPC();


  /**
   * <p>
   * Bring up the Set time dialog
   * </p>
   */

  @DISPID(1610743824) //= 0x60020010. The runtime will prefer the VTID if present
  @VTID(23)
  void setTime();


  /**
   * <p>
   * Handle Tray properties
   * </p>
   */

  @DISPID(1610743825) //= 0x60020011. The runtime will prefer the VTID if present
  @VTID(24)
  void trayProperties();


  /**
   * <p>
   * Display shell help
   * </p>
   */

  @DISPID(1610743826) //= 0x60020012. The runtime will prefer the VTID if present
  @VTID(25)
  void help();


  /**
   * <p>
   * Find Files
   * </p>
   */

  @DISPID(1610743827) //= 0x60020013. The runtime will prefer the VTID if present
  @VTID(26)
  void findFiles();


  /**
   * <p>
   * Find a computer
   * </p>
   */

  @DISPID(1610743828) //= 0x60020014. The runtime will prefer the VTID if present
  @VTID(27)
  void findComputer();


  /**
   * <p>
   * Refresh the menu
   * </p>
   */

  @DISPID(1610743829) //= 0x60020015. The runtime will prefer the VTID if present
  @VTID(28)
  void refreshMenu();


  /**
   * <p>
   * Run a Control Panel Item
   * </p>
   * @param bstrDir Mandatory java.lang.String parameter.
   */

  @DISPID(1610743830) //= 0x60020016. The runtime will prefer the VTID if present
  @VTID(29)
  void controlPanelItem(
    java.lang.String bstrDir);


  // Properties:
}
