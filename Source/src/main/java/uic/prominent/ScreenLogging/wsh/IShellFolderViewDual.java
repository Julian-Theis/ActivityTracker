package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * definition of interface IShellFolderViewDual
 */
@IID("{E7A1AF80-4D96-11CF-960C-0080C7F4EE85}")
public interface IShellFolderViewDual extends Com4jObject {
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
   * Get the folder being viewed
   * </p>
   * <p>
   * Getter method for the COM property "Folder"
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.Folder
   */

  @DISPID(1610743810) //= 0x60020002. The runtime will prefer the VTID if present
  @VTID(9)
  uic.prominent.ScreenLogging.wsh.Folder folder();


  /**
   * <p>
   * The collection of Selected Items in folder
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItems
   */

  @DISPID(1610743811) //= 0x60020003. The runtime will prefer the VTID if present
  @VTID(10)
  uic.prominent.ScreenLogging.wsh.FolderItems selectedItems();


  /**
   * <p>
   * The currently focused item in the folder
   * </p>
   * <p>
   * Getter method for the COM property "FocusedItem"
   * </p>
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItem
   */

  @DISPID(1610743812) //= 0x60020004. The runtime will prefer the VTID if present
  @VTID(11)
  uic.prominent.ScreenLogging.wsh.FolderItem focusedItem();


  /**
   * <p>
   * Select the item
   * </p>
   * @param pvfi Mandatory java.lang.Object parameter.
   * @param dwFlags Mandatory int parameter.
   */

  @DISPID(1610743813) //= 0x60020005. The runtime will prefer the VTID if present
  @VTID(12)
  void selectItem(
    java.lang.Object pvfi,
    int dwFlags);


  /**
   * <p>
   * Show items menu and return command selected
   * </p>
   * @param pfi Mandatory uic.prominent.ScreenLogging.wsh.FolderItem parameter.
   * @param vx Optional parameter. Default value is com4j.Variant.getMissing()
   * @param vy Optional parameter. Default value is com4j.Variant.getMissing()
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743814) //= 0x60020006. The runtime will prefer the VTID if present
  @VTID(13)
  java.lang.String popupItemMenu(
    uic.prominent.ScreenLogging.wsh.FolderItem pfi,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vx,
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object vy);


  /**
   * <p>
   * Returns the scripting automation model.
   * </p>
   * <p>
   * Getter method for the COM property "Script"
   * </p>
   * @return  Returns a value of type com4j.Com4jObject
   */

  @DISPID(1610743815) //= 0x60020007. The runtime will prefer the VTID if present
  @VTID(14)
  @ReturnValue(type=NativeType.Dispatch)
  com4j.Com4jObject script();


  /**
   * <p>
   * Returns the view options for showing a folder.
   * </p>
   * <p>
   * Getter method for the COM property "ViewOptions"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743816) //= 0x60020008. The runtime will prefer the VTID if present
  @VTID(15)
  int viewOptions();


  // Properties:
}
