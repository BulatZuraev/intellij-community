import java.io.Reader;

class ResourceClose {

  native void unknown();

  void test(Reader c) throws Exception {
    c.close();
    unknown();
    c.<warning descr="The call to 'read' always fails as resource is closed">read</warning>();
  }
}