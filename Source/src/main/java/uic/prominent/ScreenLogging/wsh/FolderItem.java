package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface FolderItem
 */
@IID("{FAC32C80-CBE4-11CE-8350-444553540000}")
public interface FolderItem extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Get Application object
   * </p>
   * <p>
   * Getter method for the COM property "Application"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject application();


  /**
   * <p>
   * Get Parent object
   * </p>
   * <p>
   * Getter method for the COM property "Parent"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743809) //= 0x60020001. The runtime will prefer the VTID if present
  @VTID(8)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject parent();


  /**
   * <p>
   * Get display name for item
   * </p>
   * <p>
   * Getter method for the COM property "Name"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(0) //= 0x0. The runtime will prefer the VTID if present
  @VTID(9)
  @DefaultMethod
  java.lang.String name();


  /**
   * <p>
   * Get display name for item
   * </p>
   * <p>
   * Setter method for the COM property "Name"
   * </p>
   * @param pbs Mandatory java.lang.String parameter.
   */

  @DISPID(0) //= 0x0. The runtime will prefer the VTID if present
  @VTID(10)
  @DefaultMethod
  void name(
    java.lang.String pbs);


  /**
   * <p>
   * Get the pathname to the item
   * </p>
   * <p>
   * Getter method for the COM property "Path"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743812) //= 0x60020004. The runtime will prefer the VTID if present
  @VTID(11)
  java.lang.String path();


  /**
   * <p>
   * If item is link return link object
   * </p>
   * <p>
   * Getter method for the COM property "GetLink"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743813) //= 0x60020005. The runtime will prefer the VTID if present
  @VTID(12)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject getLink();


  /**
   * <p>
   * If item is a folder return folder object
   * </p>
   * <p>
   * Getter method for the COM property "GetFolder"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743814) //= 0x60020006. The runtime will prefer the VTID if present
  @VTID(13)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject getFolder();


  /**
   * <p>
   * Is the item a link?
   * </p>
   * <p>
   * Getter method for the COM property "IsLink"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1610743815) //= 0x60020007. The runtime will prefer the VTID if present
  @VTID(14)
  boolean isLink();


  /**
   * <p>
   * Is the item a Folder?
   * </p>
   * <p>
   * Getter method for the COM property "IsFolder"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1610743816) //= 0x60020008. The runtime will prefer the VTID if present
  @VTID(15)
  boolean isFolder();


  /**
   * <p>
   * Is the item a file system object?
   * </p>
   * <p>
   * Getter method for the COM property "IsFileSystem"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1610743817) //= 0x60020009. The runtime will prefer the VTID if present
  @VTID(16)
  boolean isFileSystem();


  /**
   * <p>
   * Is the item browsable?
   * </p>
   * <p>
   * Getter method for the COM property "IsBrowsable"
   * </p>
   * @return  Returns a value of type boolean
   */

  @DISPID(1610743818) //= 0x6002000a. The runtime will prefer the VTID if present
  @VTID(17)
  boolean isBrowsable();


  /**
   * <p>
   * Modification Date?
   * </p>
   * <p>
   * Getter method for the COM property "ModifyDate"
   * </p>
   * @return  Returns a value of type java.util.Date
   */

  @DISPID(1610743819) //= 0x6002000b. The runtime will prefer the VTID if present
  @VTID(18)
  java.util.Date modifyDate();


  /**
   * <p>
   * Modification Date?
   * </p>
   * <p>
   * Setter method for the COM property "ModifyDate"
   * </p>
   * @param pdt Mandatory java.util.Date parameter.
   */

  @DISPID(1610743819) //= 0x6002000b. The runtime will prefer the VTID if present
  @VTID(19)
  void modifyDate(
    java.util.Date pdt);


  /**
   * <p>
   * Size
   * </p>
   * <p>
   * Getter method for the COM property "Size"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743821) //= 0x6002000d. The runtime will prefer the VTID if present
  @VTID(20)
  int size();


  /**
   * <p>
   * Type
   * </p>
   * <p>
   * Getter method for the COM property "Type"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743822) //= 0x6002000e. The runtime will prefer the VTID if present
  @VTID(21)
  java.lang.String type();


  /**
   * <p>
   * Get the list of verbs for the object
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItemVerbs
   */

  @DISPID(1610743823) //= 0x6002000f. The runtime will prefer the VTID if present
  @VTID(22)
  uic.prominent.ScreenLogging.wsh.FolderItemVerbs verbs();


  /**
   * <p>
   * Execute a command on the item
   * </p>
   * @param vVerb Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(1610743824) //= 0x60020010. The runtime will prefer the VTID if present
  @VTID(23)
  void invokeVerb(
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vVerb);


  // Properties:
}
