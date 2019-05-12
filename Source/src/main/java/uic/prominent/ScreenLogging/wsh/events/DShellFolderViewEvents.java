package uic.prominent.ScreenLogging.wsh.events;

import com4j.*;

/**
 * Event interface for ShellFolderView
 */
@IID("{62112AA2-EBE4-11CF-A5FB-0020AFE7292D}")
public abstract class DShellFolderViewEvents {
  // Methods:
  /**
   * <p>
   * The Selection in the view changed.
   * </p>
   */

  @DISPID(200)
  public void selectionChanged() {
        throw new UnsupportedOperationException();
  }


  /**
   * <p>
   * The folder has finished enumerating (flashlight is gone).
   * </p>
   */

  @DISPID(201)
  public void enumDone() {
        throw new UnsupportedOperationException();
  }


  /**
   * <p>
   * A verb was invoked on an items in the view (return false to cancel).
   * </p>
   */

  @DISPID(202)
  public boolean verbInvoked() {
        throw new UnsupportedOperationException();
  }


  /**
   * <p>
   * the default verb (double click) was invoked on an items in the view (return false to cancel).
   * </p>
   */

  @DISPID(203)
  public boolean defaultVerbInvoked() {
        throw new UnsupportedOperationException();
  }


  /**
   * <p>
   * user started to drag an item (return false to cancel).
   * </p>
   */

  @DISPID(204)
  public boolean beginDrag() {
        throw new UnsupportedOperationException();
  }


  // Properties:
}
