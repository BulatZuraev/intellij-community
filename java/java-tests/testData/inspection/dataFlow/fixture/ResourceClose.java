import java.io.*;

class ResourceClose {

  native void unknown();

  void testTryWithResourcesCloseVar(InputStream c) throws Exception {
    try (InputStream v = new FileInputStream("file")) {
      c = v;
    }
    c.<warning descr="The call to 'read' always fails as resource is closed">read</warning>();
  }

  void testTryWithResourcesCloseExpr(InputStream c) throws Exception {
    try (<error descr="Resource references are not supported at language level '7'">c</error>) {
      c.read();
    }
    c.<warning descr="The call to 'read' always fails as resource is closed">read</warning>();
  }

  void testPlainClose(Reader c) throws Exception {
    c.close();
    unknown();
    c.<warning descr="The call to 'read' always fails as resource is closed">read</warning>();
  }

  void testUnsoundWarning(Reader c, boolean flag) throws Exception {
    c.read();
    if (flag) c.close();
    c.<warning descr="The call to 'read' may fail as resource is closed">read</warning>();
  }
}