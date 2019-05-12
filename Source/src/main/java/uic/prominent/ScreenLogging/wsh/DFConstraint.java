package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Constraint used in search command
 */
@IID("{4A3DF050-23BD-11D2-939F-00A0C91EEDBA}")
public interface DFConstraint extends Com4jObject {
  // Methods:
  /**
   * <p>
   * Get the constraint name
   * </p>
   * <p>
   * Getter method for the COM property "Name"
   * </p>
   * @return  Returns a value of type java.lang.String
   */

  @DISPID(1610743808) //= 0x60020000. The runtime will prefer the VTID if present
  @VTID(7)
  java.lang.String name();


  /**
   * <p>
   * Get the constraint Value
   * </p>
   * <p>
   * Getter method for the COM property "Value"
   * </p>
   * @return  Returns a value of type java.lang.Object
   */

  @DISPID(1610743809) //= 0x60020001. The runtime will prefer the VTID if present
  @VTID(8)
  @ReturnValue(type=NativeType.VARIANT)
  java.lang.Object value();


  // Properties:
}
