package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * definition of interface IShellFolderViewDual2
 */
@IID("{31C147B6-0ADE-4A3C-B514-DDF932EF6D17}")
public interface IShellFolderViewDual2 extends uic.prominent.ScreenLogging.wsh.IShellFolderViewDual {
  // Methods:
  /**
   * <p>
   * Get Current View Mode
   * </p>
   * <p>
   * Getter method for the COM property "CurrentViewMode"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610809344) //= 0x60030000. The runtime will prefer the VTID if present
  @VTID(16)
  int currentViewMode();


  /**
   * <p>
   * Get Current View Mode
   * </p>
   * <p>
   * Setter method for the COM property "CurrentViewMode"
   * </p>
   * @param pViewMode Mandatory int parameter.
   */

  @DISPID(1610809344) //= 0x60030000. The runtime will prefer the VTID if present
  @VTID(17)
  void currentViewMode(
    int pViewMode);


  /**
   * <p>
   * Select Item relative to the Current Item
   * </p>
   * @param iRelative Mandatory int parameter.
   */

  @DISPID(1610809346) //= 0x60030002. The runtime will prefer the VTID if present
  @VTID(18)
  void selectItemRelative(
    int iRelative);


  // Properties:
}
