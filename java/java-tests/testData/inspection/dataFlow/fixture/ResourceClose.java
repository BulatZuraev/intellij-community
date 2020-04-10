import java.io.Reader;
import java.io.BufferedInputStream;

class ResourceClose {

  native void unknown();

  void testTryWithResourcesClose(BufferedInputStream c) throws Exception {
    try (<error descr="Resource references are not supported at language level '8'">c</error>) {
      c.read();
    }
    c.<warning descr="The call to 'read' always fails as resource is closed">read</warning>();
  }

  void testPlainClose(Reader c) throws Exception {
    c.close();
    unknown();
    c.<warning descr="The call to 'read' always fails as resource is closed">read</warning>();
  }
}