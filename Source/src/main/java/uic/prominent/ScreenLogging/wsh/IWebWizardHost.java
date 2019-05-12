package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * IWebWizardHost interface
 */
@IID("{18BCC359-4990-4BFB-B951-3C83702BE5F9}")
public interface IWebWizardHost extends Com4jObject {
  // Methods:
  /**
   */

  @DISPID(0) //= 0x0. The runtime will prefer the VTID if present
  @VTID(7)
  @DefaultMethod
  void finalBack();


  /**
   */

  @DISPID(1) //= 0x1. The runtime will prefer the VTID if present
  @VTID(8)
  void finalNext();


  /**
   */

  @DISPID(2) //= 0x2. The runtime will prefer the VTID if present
  @VTID(9)
  void cancel();


  /**
   * <p>
   * Setter method for the COM property "Caption"
   * </p>
   * @param pbstrCaption Mandatory java.lang.String parameter.
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(10)
  void caption(
    java.lang.String pbstrCaption);


  /**
   * <p>
   * Getter method for the COM property "Caption"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(3) //= 0x3. The runtime will prefer the VTID if present
  @VTID(11)
  java.lang.String caption();


  /**
   * <p>
   * Setter method for the COM property "Property"
   * </p>
   * @param bstrPropertyName Mandatory java.lang.String parameter.
   * @param pvProperty Mandatory java.lang.Object parameter.
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(12)
  void property(
    java.lang.String bstrPropertyName,
    java.lang.Object pvProperty);


  /**
   * <p>
   * Getter method for the COM property "Property"
   * </p>
   * @param bstrPropertyName Mandatory java.lang.String parameter.
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(4) //= 0x4. The runtime will prefer the VTID if present
  @VTID(13)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object property(
    java.lang.String bstrPropertyName);


  /**
   * @param vfEnableBack Mandatory boolean parameter.
   * @param vfEnableNext Mandatory boolean parameter.
   * @param vfLastPage Mandatory boolean parameter.
   */

  @DISPID(5) //= 0x5. The runtime will prefer the VTID if present
  @VTID(14)
  void setWizardButtons(
    boolean vfEnableBack,
    boolean vfEnableNext,
    boolean vfLastPage);


  /**
   * @param bstrHeaderTitle Mandatory java.lang.String parameter.
   * @param bstrHeaderSubtitle Mandatory java.lang.String parameter.
   */

  @DISPID(6) //= 0x6. The runtime will prefer the VTID if present
  @VTID(15)
  void setHeaderText(
    java.lang.String bstrHeaderTitle,
    java.lang.String bstrHeaderSubtitle);


  // Properties:
}
