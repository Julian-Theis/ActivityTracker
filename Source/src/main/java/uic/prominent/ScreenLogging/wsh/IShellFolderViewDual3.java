package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * definition of interface IShellFolderViewDual3
 */
@IID("{29EC8E6C-46D3-411F-BAAA-611A6C9CAC66}")
public interface IShellFolderViewDual3 extends uic.prominent.ScreenLogging.wsh.IShellFolderViewDual2 {
  // Methods:
  /**
   * <p>
   * Get Group By Column
   * </p>
   * <p>
   * Getter method for the COM property "GroupBy"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610874880) //= 0x60040000. The runtime will prefer the VTID if present
  @VTID(19)
  java.lang.String groupBy();


  /**
   * <p>
   * Get Group By Column
   * </p>
   * <p>
   * Setter method for the COM property "GroupBy"
   * </p>
   * @param pbstrGroupBy Mandatory java.lang.String parameter.
   */

  @DISPID(1610874880) //= 0x60040000. The runtime will prefer the VTID if present
  @VTID(20)
  void groupBy(
    java.lang.String pbstrGroupBy);


  /**
   * <p>
   * Get Folder Flags
   * </p>
   * <p>
   * Getter method for the COM property "FolderFlags"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610874882) //= 0x60040002. The runtime will prefer the VTID if present
  @VTID(21)
  int folderFlags();


  /**
   * <p>
   * Get Folder Flags
   * </p>
   * <p>
   * Setter method for the COM property "FolderFlags"
   * </p>
   * @param pdwFlags Mandatory int parameter.
   */

  @DISPID(1610874882) //= 0x60040002. The runtime will prefer the VTID if present
  @VTID(22)
  void folderFlags(
    int pdwFlags);


  /**
   * <p>
   * Get Sorting Columns
   * </p>
   * <p>
   * Getter method for the COM property "SortColumns"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610874884) //= 0x60040004. The runtime will prefer the VTID if present
  @VTID(23)
  java.lang.String sortColumns();


  /**
   * <p>
   * Get Sorting Columns
   * </p>
   * <p>
   * Setter method for the COM property "SortColumns"
   * </p>
   * @param pbstrSortColumns Mandatory java.lang.String parameter.
   */

  @DISPID(1610874884) //= 0x60040004. The runtime will prefer the VTID if present
  @VTID(24)
  void sortColumns(
    java.lang.String pbstrSortColumns);


  /**
   * <p>
   * Set Icon Size
   * </p>
   * <p>
   * Setter method for the COM property "IconSize"
   * </p>
   * @param piIconSize Mandatory int parameter.
   */

  @DISPID(1610874886) //= 0x60040006. The runtime will prefer the VTID if present
  @VTID(25)
  void iconSize(
    int piIconSize);


  /**
   * <p>
   * Set Icon Size
   * </p>
   * <p>
   * Getter method for the COM property "IconSize"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610874886) //= 0x60040006. The runtime will prefer the VTID if present
  @VTID(26)
  int iconSize();


  /**
   * <p>
   * Filter View
   * </p>
   * @param bstrFilterText Mandatory java.lang.String parameter.
   */

  @DISPID(1610874888) //= 0x60040008. The runtime will prefer the VTID if present
  @VTID(27)
  void filterView(
    java.lang.String bstrFilterText);


  // Properties:
}
