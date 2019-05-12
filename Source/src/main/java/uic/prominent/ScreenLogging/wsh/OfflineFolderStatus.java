package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * <p>
 * Constants for Folder2.OfflineStatus
 * </p>
 */
public enum OfflineFolderStatus implements ComEnum {
  /**
   * <p>
   * Offline caching not available for this folder
   * </p>
   * <p>
   * The value of this constant is -1
   * </p>
   */
  OFS_INACTIVE(-1),
  /**
   * <p>
   * Server is online
   * </p>
   * <p>
   * The value of this constant is 0
   * </p>
   */
  OFS_ONLINE(0),
  /**
   * <p>
   * Server is offline
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  OFS_OFFLINE(1),
  /**
   * <p>
   * Server is offline but is reachable
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  OFS_SERVERBACK(2),
  /**
   * <p>
   * Server is online with unmerged changes
   * </p>
   * <p>
   * The value of this constant is 3
   * </p>
   */
  OFS_DIRTYCACHE(3),
  ;

  private final int value;
  OfflineFolderStatus(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
