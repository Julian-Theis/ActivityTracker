package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * IFileSearchBand Interface
 */
@IID("{2D91EEA1-9932-11D2-BE86-00A0C9A83DA1}")
public interface IFileSearchBand extends Com4jObject {
  // Methods:
  /**
   * <p>
   * method SetFocus
   * </p>
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(7)
  void setFocus();


  /**
   * <p>
   * method SetSearchParameters
   * </p>
   * @param pbstrSearchID Mandatory Holder<java.lang.String> parameter.
   * @param bNavToResults Mandatory boolean parameter.
   * @param pvarScope Optional parameter. Default value is com4j.Variant.getMissing()
   * @param pvarQueryFile Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(8)
  void setSearchParameters(
    Holder<java.lang.String> pbstrSearchID,
    boolean bNavToResults,
    @Optional java.lang.Object pvarScope,
    @Optional java.lang.Object pvarQueryFile);


  /**
   * <p>
   * Retrieve the guid of the currently active search.
   * </p>
   * <p>
   * Getter method for the COM property "SearchID"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(9)
  java.lang.String searchID();


  /**
   * <p>
   * Get the search scope
   * </p>
   * <p>
   * Getter method for the COM property "Scope"
   * </p>
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(10)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object scope();


  /**
   * <p>
   * Retrieve the file from which the search was restored.
   * </p>
   * <p>
   * Getter method for the COM property "QueryFile"
   * </p>
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(11)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object queryFile();


  // Properties:
}
