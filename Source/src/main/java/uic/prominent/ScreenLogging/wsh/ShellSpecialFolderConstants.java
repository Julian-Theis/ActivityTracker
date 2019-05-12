package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * <p>
 * Constants for Special Folders for open/Explore
 * </p>
 */
public enum ShellSpecialFolderConstants implements ComEnum {
  /**
   * <p>
   * Special Folder DESKTOP
   * </p>
   * <p>
   * The value of this constant is 0
   * </p>
   */
  ssfDESKTOP(0),
  /**
   * <p>
   * Special Folder PROGRAMS
   * </p>
   * <p>
   * The value of this constant is 2
   * </p>
   */
  ssfPROGRAMS(2),
  /**
   * <p>
   * Special Folder CONTROLS
   * </p>
   * <p>
   * The value of this constant is 3
   * </p>
   */
  ssfCONTROLS(3),
  /**
   * <p>
   * Special Folder PRINTERS
   * </p>
   * <p>
   * The value of this constant is 4
   * </p>
   */
  ssfPRINTERS(4),
  /**
   * <p>
   * Special Folder PERSONAL
   * </p>
   * <p>
   * The value of this constant is 5
   * </p>
   */
  ssfPERSONAL(5),
  /**
   * <p>
   * Special Folder FAVORITES
   * </p>
   * <p>
   * The value of this constant is 6
   * </p>
   */
  ssfFAVORITES(6),
  /**
   * <p>
   * Special Folder STARTUP
   * </p>
   * <p>
   * The value of this constant is 7
   * </p>
   */
  ssfSTARTUP(7),
  /**
   * <p>
   * Special Folder RECENT
   * </p>
   * <p>
   * The value of this constant is 8
   * </p>
   */
  ssfRECENT(8),
  /**
   * <p>
   * Special Folder SENDTO
   * </p>
   * <p>
   * The value of this constant is 9
   * </p>
   */
  ssfSENDTO(9),
  /**
   * <p>
   * Special Folder BITBUCKET
   * </p>
   * <p>
   * The value of this constant is 10
   * </p>
   */
  ssfBITBUCKET(10),
  /**
   * <p>
   * Special Folder STARTMENU
   * </p>
   * <p>
   * The value of this constant is 11
   * </p>
   */
  ssfSTARTMENU(11),
  /**
   * <p>
   * Special Folder DESKTOPDIRECTORY
   * </p>
   * <p>
   * The value of this constant is 16
   * </p>
   */
  ssfDESKTOPDIRECTORY(16),
  /**
   * <p>
   * Special Folder DRIVES
   * </p>
   * <p>
   * The value of this constant is 17
   * </p>
   */
  ssfDRIVES(17),
  /**
   * <p>
   * Special Folder NETWORK
   * </p>
   * <p>
   * The value of this constant is 18
   * </p>
   */
  ssfNETWORK(18),
  /**
   * <p>
   * Special Folder NETHOOD
   * </p>
   * <p>
   * The value of this constant is 19
   * </p>
   */
  ssfNETHOOD(19),
  /**
   * <p>
   * Special Folder FONTS
   * </p>
   * <p>
   * The value of this constant is 20
   * </p>
   */
  ssfFONTS(20),
  /**
   * <p>
   * Special Folder TEMPLATES
   * </p>
   * <p>
   * The value of this constant is 21
   * </p>
   */
  ssfTEMPLATES(21),
  /**
   * <p>
   * Special Folder COMMON STARTMENU
   * </p>
   * <p>
   * The value of this constant is 22
   * </p>
   */
  ssfCOMMONSTARTMENU(22),
  /**
   * <p>
   * Special Folder COMMON PROGRAMS
   * </p>
   * <p>
   * The value of this constant is 23
   * </p>
   */
  ssfCOMMONPROGRAMS(23),
  /**
   * <p>
   * Special Folder COMMON STARTUP
   * </p>
   * <p>
   * The value of this constant is 24
   * </p>
   */
  ssfCOMMONSTARTUP(24),
  /**
   * <p>
   * Special Folder COMMON DESKTOPDIR
   * </p>
   * <p>
   * The value of this constant is 25
   * </p>
   */
  ssfCOMMONDESKTOPDIR(25),
  /**
   * <p>
   * Special Folder APPDATA
   * </p>
   * <p>
   * The value of this constant is 26
   * </p>
   */
  ssfAPPDATA(26),
  /**
   * <p>
   * Special Folder PRINTHOOD
   * </p>
   * <p>
   * The value of this constant is 27
   * </p>
   */
  ssfPRINTHOOD(27),
  /**
   * <p>
   * Special Folder LOCAL APPDATA
   * </p>
   * <p>
   * The value of this constant is 28
   * </p>
   */
  ssfLOCALAPPDATA(28),
  /**
   * <p>
   * Special Folder ALTSTARTUP
   * </p>
   * <p>
   * The value of this constant is 29
   * </p>
   */
  ssfALTSTARTUP(29),
  /**
   * <p>
   * Special Folder COMMON ALTSTARTUP
   * </p>
   * <p>
   * The value of this constant is 30
   * </p>
   */
  ssfCOMMONALTSTARTUP(30),
  /**
   * <p>
   * Special Folder COMMON FAVORITES
   * </p>
   * <p>
   * The value of this constant is 31
   * </p>
   */
  ssfCOMMONFAVORITES(31),
  /**
   * <p>
   * Special Folder INTERNET CACHE
   * </p>
   * <p>
   * The value of this constant is 32
   * </p>
   */
  ssfINTERNETCACHE(32),
  /**
   * <p>
   * Special Folder COOKIES
   * </p>
   * <p>
   * The value of this constant is 33
   * </p>
   */
  ssfCOOKIES(33),
  /**
   * <p>
   * Special Folder HISTORY
   * </p>
   * <p>
   * The value of this constant is 34
   * </p>
   */
  ssfHISTORY(34),
  /**
   * <p>
   * Special Folder COMMON APPDATA
   * </p>
   * <p>
   * The value of this constant is 35
   * </p>
   */
  ssfCOMMONAPPDATA(35),
  /**
   * <p>
   * Special Folder WINDOWS
   * </p>
   * <p>
   * The value of this constant is 36
   * </p>
   */
  ssfWINDOWS(36),
  /**
   * <p>
   * Special Folder SYSTEM
   * </p>
   * <p>
   * The value of this constant is 37
   * </p>
   */
  ssfSYSTEM(37),
  /**
   * <p>
   * Special Folder PROGRAM FILES
   * </p>
   * <p>
   * The value of this constant is 38
   * </p>
   */
  ssfPROGRAMFILES(38),
  /**
   * <p>
   * Special Folder MYPICTURES
   * </p>
   * <p>
   * The value of this constant is 39
   * </p>
   */
  ssfMYPICTURES(39),
  /**
   * <p>
   * Special Folder PROFILE
   * </p>
   * <p>
   * The value of this constant is 40
   * </p>
   */
  ssfPROFILE(40),
  /**
   * <p>
   * Special Folder SYSTEMx86
   * </p>
   * <p>
   * The value of this constant is 41
   * </p>
   */
  ssfSYSTEMx86(41),
  /**
   * <p>
   * Special Folder PROGRAM FILESx86
   * </p>
   * <p>
   * The value of this constant is 48
   * </p>
   */
  ssfPROGRAMFILESx86(48),
  ;

  private final int value;
  ShellSpecialFolderConstants(int value) { this.value=value; }
  public int comEnumValue() { return value; }
}
