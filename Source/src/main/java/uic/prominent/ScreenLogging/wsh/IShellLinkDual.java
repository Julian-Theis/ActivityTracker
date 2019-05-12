package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of Shell Link IDispatch interface
 */
@IID("{88A05C00-F000-11CE-8350-444553540000}")
public interface IShellLinkDual extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Get the path of the link
   * </p>
   * <p>
   * Getter method for the COM property "Path"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  java.lang.String path();


  /**
   * <p>
   * Get the path of the link
   * </p>
   * <p>
   * Setter method for the COM property "Path"
   * </p>
   * @param pbs Mandatory java.lang.String parameter.
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(8)
  void path(
    java.lang.String pbs);


  /**
   * <p>
   * Get the description for the link
   * </p>
   * <p>
   * Getter method for the COM property "Description"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743810) //= 0x60020002. The runtime will prefer the VTID if present
  @VTID(9)
  java.lang.String description();


  /**
   * <p>
   * Get the description for the link
   * </p>
   * <p>
   * Setter method for the COM property "Description"
   * </p>
   * @param pbs Mandatory java.lang.String parameter.
   */

  @DISPID(1610743810) //= 0x60020002. The runtime will prefer the VTID if present
  @VTID(10)
  void description(
    java.lang.String pbs);


  /**
   * <p>
   * Get the working directory for the link
   * </p>
   * <p>
   * Getter method for the COM property "WorkingDirectory"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743812) //= 0x60020004. The runtime will prefer the VTID if present
  @VTID(11)
  java.lang.String workingDirectory();


  /**
   * <p>
   * Get the working directory for the link
   * </p>
   * <p>
   * Setter method for the COM property "WorkingDirectory"
   * </p>
   * @param pbs Mandatory java.lang.String parameter.
   */

  @DISPID(1610743812) //= 0x60020004. The runtime will prefer the VTID if present
  @VTID(12)
  void workingDirectory(
    java.lang.String pbs);


  /**
   * <p>
   * Get the arguments for the link
   * </p>
   * <p>
   * Getter method for the COM property "Arguments"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743814) //= 0x60020006. The runtime will prefer the VTID if present
  @VTID(13)
  java.lang.String arguments();


  /**
   * <p>
   * Get the arguments for the link
   * </p>
   * <p>
   * Setter method for the COM property "Arguments"
   * </p>
   * @param pbs Mandatory java.lang.String parameter.
   */

  @DISPID(1610743814) //= 0x60020006. The runtime will prefer the VTID if present
  @VTID(14)
  void arguments(
    java.lang.String pbs);


  /**
   * <p>
   * Get the Hotkey for the link
   * </p>
   * <p>
   * Getter method for the COM property "Hotkey"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743816) //= 0x60020008. The runtime will prefer the VTID if present
  @VTID(15)
  int hotkey();


  /**
   * <p>
   * Get the Hotkey for the link
   * </p>
   * <p>
   * Setter method for the COM property "Hotkey"
   * </p>
   * @param piHK Mandatory int parameter.
   */

  @DISPID(1610743816) //= 0x60020008. The runtime will prefer the VTID if present
  @VTID(16)
  void hotkey(
    int piHK);


  /**
   * <p>
   * Get the Show Command for the link
   * </p>
   * <p>
   * Getter method for the COM property "ShowCommand"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743818) //= 0x6002000a. The runtime will prefer the VTID if present
  @VTID(17)
  int showCommand();


  /**
   * <p>
   * Get the Show Command for the link
   * </p>
   * <p>
   * Setter method for the COM property "ShowCommand"
   * </p>
   * @param piShowCommand Mandatory int parameter.
   */

  @DISPID(1610743818) //= 0x6002000a. The runtime will prefer the VTID if present
  @VTID(18)
  void showCommand(
    int piShowCommand);


  /**
   * <p>
   * Tell the link to resolve itself
   * </p>
   * @param fFlags Mandatory int parameter.
   */

  @DISPID(1610743820) //= 0x6002000c. The runtime will prefer the VTID if present
  @VTID(19)
  void resolve(
    int fFlags);


  /**
   * <p>
   * Get the IconLocation for the link
   * </p>
   * @param pbs Mandatory Holder<java.lang.String> parameter.
   * @return  Returns a value of type int
   */

  @DISPID(1610743821) //= 0x6002000d. The runtime will prefer the VTID if present
  @VTID(20)
  int getIconLocation(
    Holder<java.lang.String> pbs);


  /**
   * <p>
   * Set the IconLocation for the link
   * </p>
   * @param bs Mandatory java.lang.String parameter.
   * @param iIcon Mandatory int parameter.
   */

  @DISPID(1610743822) //= 0x6002000e. The runtime will prefer the VTID if present
  @VTID(21)
  void setIconLocation(
    java.lang.String bs,
    int iIcon);


  /**
   * <p>
   * Tell the link to save the changes
   * </p>
   * @param vWhere Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(1610743823) //= 0x6002000f. The runtime will prefer the VTID if present
  @VTID(22)
  void save(
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vWhere);


  // Properties:
}
