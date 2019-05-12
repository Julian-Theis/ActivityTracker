package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface Folder2
 */
@IID("{F0D2D8EF-3890-11D2-BF8B-00C04FB93661}")
public interface Folder2 extends uic.prominent.ScreenLogging.wsh.Folder {
  // Methods:
  /**
   * <p>
   * Folder's FolderItem interface
   * </p>
   * <p>
   * Getter method for the COM property "Self"
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItem
   */

  @DISPID(1610809344) //= 0x60030000. The runtime will prefer the VTID if present
  @VTID(17)
  uic.prominent.ScreenLogging.wsh.FolderItem self();


  /**
   * <p>
   * Offline status of the server?
   * </p>
   * <p>
   * Getter method for the COM property "OfflineStatus"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610809345) //= 0x60030001. The runtime will prefer the VTID if present
  @VTID(18)
  int offlineStatus();


  /**
   * <p>
   * Synchronize all offline files
   * </p>
   */

  @DISPID(1610809346) //= 0x60030002. The runtime will prefer the VTID if present
  @VTID(19)
  void synchronize();


  /**
   * <p>
   * Should the WebView barricade be shown?
   * </p>
   * <p>
   * Getter method for the COM property "HaveToShowWebViewBarricade"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(20)
  boolean haveToShowWebViewBarricade();


  /**
   * <p>
   * Call this after the WebView barricade is dismissed by the user
   * </p>
   */

  @DISPID(1610809348) //= 0x60030004. The runtime will prefer the VTID if present
  @VTID(21)
  void dismissedWebViewBarricade();


  // Properties:
}
