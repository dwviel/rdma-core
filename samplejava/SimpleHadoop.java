// Build with  (avoid IPV6) _JAVA_OPTIONS=-Djava.net.preferIPv4Stack=true
// makes use of org.apache.hadoop.ipc.Client{.java,.class}

import org.apache.hadoop.ipc.TestIPC;
public class SimpleHadoop {

  public static void main(String[] args) throws Exception {
    TestIPC tipc = new TestIPC();
    tipc.setupConf();
    //tipc.testStandAloneClient();
    //tipc.testIpcTimeout();
    tipc.testIpcWithServiceClass();
  }
}
