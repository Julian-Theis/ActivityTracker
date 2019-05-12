package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface FolderItems Version 3
 */
@IID("{EAA7C309-BBEC-49D5-821D-64D966CB667F}")
public interface FolderItems3 extends uic.prominent.ScreenLogging.wsh.FolderItems2 {
  // Methods:
  /**
   * <p>
   * Set a wildcard filter to apply to the items returned
   * </p>
   * @param grfFlags Mandatory int parameter.
   * @param bstrFileSpec Mandatory java.lang.String parameter.
   */

  @DISPID(1610874880) //= 0x60040000. The runtime will prefer the VTID if present
  @VTID(13)
  void filter(
    int grfFlags,
    java.lang.String bstrFileSpec);


  /**
   * <p>
   * Get the list of verbs common to all the items
   * </p>
   * <p>
   * Getter method for the COM property "Verbs"
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItemVerbs
   */

  @DISPID(0) //= 0x0. The runtime will prefer the VTID if present
  @VTID(14)
  @DefaultMethod
  uic.prominent.ScreenLogging.wsh.FolderItemVerbs verbs();


  // Properties:
}
