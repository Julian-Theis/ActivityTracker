package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Definition of interface FolderItemVerbs
 */
@IID("{1F8352C0-50B0-11CF-960C-0080C7F4EE85}")
public interface FolderItemVerbs extends Com4jObject,Iterable<Com4jObject> {
  // Methods:
  /**
   * <p>
   * Get count of open folder windows
   * </p>
   * <p>
   * Getter method for the COM property "Count"
   * </p>
   * @return  Returns a value of type int
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  int count();


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
   * Return the specified verb
   * </p>
   * @param index Optional parameter. Default value is com4j.Variant.getMissing()
   * @return  Returns a value of type uic.prominent.ScreenLogging.wsh.FolderItemVerb
   */

  @DISPID(1610743811) //= 0x60020003. The runtime will prefer the VTID if present
  @VTID(10)
  uic.prominent.ScreenLogging.wsh.FolderItemVerb item(
    @Optional @MarshalAs(NativeType.VARIANT) java.lang.Object index);


  /**
   * <p>
   * Enumerates the figures
   * </p>
   */

  @DISPID(-4) //= 0xfffffffc. The runtime will prefer the VTID if present
  @VTID(11)
  java.util.Iterator<Com4jObject> iterator();

  // Properties:
}
