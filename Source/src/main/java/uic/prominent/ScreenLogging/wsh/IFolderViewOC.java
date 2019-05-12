package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Folder View Events Forwarder Object
 */
@IID("{9BA05970-F6A8-11CF-A442-00A0C90A8F39}")
public interface IFolderViewOC extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Set the ShellFolderView object to monitor events of.
   * </p>
   * @param pdisp Mandatory com4j.Com4jObject parameter.
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  void setFolderView(
    @MarshalAs(NativeType.Dispatch) com4j.Com4jObject pdisp);


  // Properties:
}
