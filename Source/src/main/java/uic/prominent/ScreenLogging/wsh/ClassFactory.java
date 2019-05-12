package uic.prominent.ScreenLogging.wsh  ;

import com4j.*;

/**
 * Defines methods to create COM objects
 */
public abstract class ClassFactory {
  private ClassFactory() {} // instanciation is not allowed


  /**
   * Shell Folder View Events Router.
   */
  public static uic.prominent.ScreenLogging.wsh.IFolderViewOC createShellFolderViewOC() {
    return COM4J.createInstance( uic.prominent.ScreenLogging.wsh.IFolderViewOC.class, "{9BA05971-F6A8-11CF-A442-00A0C90A8F39}" );
  }

  /**
   * Shell Folder View Object
   */
  public static uic.prominent.ScreenLogging.wsh.IShellFolderViewDual3 createShellFolderView() {
    return COM4J.createInstance( uic.prominent.ScreenLogging.wsh.IShellFolderViewDual3.class, "{62112AA1-EBE4-11CF-A5FB-0020AFE7292D}" );
  }

  /**
   * Shell Object Type Information
   */
  public static uic.prominent.ScreenLogging.wsh.IShellDispatch6 createShell() {
    return COM4J.createInstance( uic.prominent.ScreenLogging.wsh.IShellDispatch6.class, "{13709620-C279-11CE-A49E-444553540000}" );
  }

  /**
   * ShellDispatch Load in Shell Context
   */
  public static Com4jObject createShellDispatchInproc() {
    return COM4J.createInstance( Com4jObject.class, "{0A89A860-D7B1-11CE-8350-444553540000}" );
  }

  /**
   * FileSearchBand Class
   */
  public static uic.prominent.ScreenLogging.wsh.IFileSearchBand createFileSearchBand() {
    return COM4J.createInstance( uic.prominent.ScreenLogging.wsh.IFileSearchBand.class, "{C4EE31F3-4768-11D2-BE5C-00A0C9A83DA1}" );
  }
}
