package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * <p>
 * Constants for ViewOptions
 * </p>
 */
public enum ShellFolderViewOptions implements ComEnum {
  /**
   * <p>
   * Show All Objects
   * </p>
   * <p>
   * The value of this constant is 1
   * </p>
   */
  SFVVO_SHOWALLOBJECTS(1),
  /**
   * <p>
   * Show File Extensions
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  SFVVO_SHOWEXTENSIONS(2),
  /**
   * <p>
   * Color encode Compressed files
   * </p>
   * <p>
   * The value of this constant is 8
   * </p>
   */
  SFVVO_SHOWCOMPCOLOR(8),
  /**
   * <p>
   * Show System Files
   * </p>
   * <p>
   * The value of this constant is 32
   * </p>
   */
  SFVVO_SHOWSYSFILES(32),
  /**
   * <p>
   * Use Windows 95 UI settings
   * </p>
   * <p>
   * The value of this constant is 64
   * </p>
   */
  SFVVO_WIN95CLASSIC(64),
  /**
   * <p>
   * User needs to double click in web View
   * </p>
   * <p>
   * The value of this constant is 128
   * </p>
   */
  SFVVO_DOUBLECLICKINWEBVIEW(128),
  /**
   * <p>
   * Is Desktop HTML enabled
   * </p>
   * <p>
   * The value of this constant is 512
   * </p>
   */
  SFVVO_DESKTOPHTML(512),
  ;

  private final int value;
  ShellFolderViewOptions(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
