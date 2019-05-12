package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface Folder
 */
@IID("{BBCBDE60-C3FF-11CE-8350-444553540000}")
public interface Folder extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Get the display name for the window
   * </p>
   * <p>
   * Getter method for the COM property "Title"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(0) //= 0x0. The runtime will prefer the VTID if present
  @VTID(7)
  @DefaultMethod
  java.lang.String title();


  /**
   * <p>
   * Get Application object
   * </p>
   * <p>
   * Getter method for the COM property "Application"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743809) //= 0x60020001. The runtime will prefer the VTID if present
  @VTID(8)
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

  @DISPID(1610743810) //= 0x60020002. The runtime will prefer the VTID if present
  @VTID(9)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject parent();


  /**
   * <p>
   * Get Parent object
   * </p>
   * <p>
   * Getter method for the COM property "ParentFolder"
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.Folder
   */

  @DISPID(1610743811) //= 0x60020003. The runtime will prefer the VTID if present
  @VTID(10)
  uic.prominent.ScreenLogging.wsh.Folder parentFolder();


  /**
   * <p>
   * The collection of Items in folder
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItems
   */

  @DISPID(1610743812) //= 0x60020004. The runtime will prefer the VTID if present
  @VTID(11)
  uic.prominent.ScreenLogging.wsh.FolderItems items();


  /**
   * <p>
   * Parse the name to get an item.
   * </p>
   * @param bName Mandatory java.lang.String parameter.
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItem
   */

  @DISPID(1610743813) //= 0x60020005. The runtime will prefer the VTID if present
  @VTID(12)
  uic.prominent.ScreenLogging.wsh.FolderItem parseName(
    java.lang.String bName);


  /**
   * <p>
   * Create a new sub folder in this folder.
   * </p>
   * @param bName Mandatory java.lang.String parameter.
   * @param vOptions Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(1610743814) //= 0x60020006. The runtime will prefer the VTID if present
  @VTID(13)
  void newFolder(
    java.lang.String bName,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vOptions);


  /**
   * <p>
   * Move Items to this folder.
   * </p>
   * @param vItem Mandatory java.lang.Object parameter.
   * @param vOptions Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(1610743815) //= 0x60020007. The runtime will prefer the VTID if present
  @VTID(14)
  void moveHere(
    @MarshalAs(NativeType.VARIANT) java.lang.Object vItem,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vOptions);


  /**
   * <p>
   * Copy Items to this folder.
   * </p>
   * @param vItem Mandatory java.lang.Object parameter.
   * @param vOptions Optional parameter. Default value is com4j.Variant.getMissing()
   */

  @DISPID(1610743816) //= 0x60020008. The runtime will prefer the VTID if present
  @VTID(15)
  void copyHere(
    @MarshalAs(NativeType.VARIANT) java.lang.Object vItem,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vOptions);


  /**
   * <p>
   * Get the details about an item.
   * </p>
   * @param vItem Mandatory java.lang.Object parameter.
   * @param iColumn Mandatory int parameter.
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743817) //= 0x60020009. The runtime will prefer the VTID if present
  @VTID(16)
  java.lang.String getDetailsOf(
    @MarshalAs(NativeType.VARIANT) java.lang.Object vItem,
    int iColumn);


  // Properties:
}
