package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface Folder version 3
 */
@IID("{A7AE5F64-C4D7-4D7F-9307-4D24EE54B841}")
public interface Folder3 extends uic.prominent.ScreenLogging.wsh.Folder2 {
  // Methods:
  /**
   * <p>
   * Ask if the WebView barricade should be shown or not
   * </p>
   * <p>
   * Getter method for the COM property "ShowWebViewBarricade"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(22)
  boolean showWebViewBarricade();


  /**
   * <p>
   * Ask if the WebView barricade should be shown or not
   * </p>
   * <p>
   * Setter method for the COM property "ShowWebViewBarricade"
   * </p>
   * @param pbShowWebViewBarricade Mandatory boolean parameter.
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(23)
  void showWebViewBarricade(
    boolean pbShowWebViewBarricade);


  // Properties:
}
