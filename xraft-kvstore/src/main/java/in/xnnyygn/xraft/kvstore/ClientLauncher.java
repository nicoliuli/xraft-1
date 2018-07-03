package in.xnnyygn.xraft.kvstore;

import in.xnnyygn.xraft.core.node.NodeId;
import in.xnnyygn.xraft.core.service.ServerRouter;

public class ClientLauncher {

    public static void main(String[] args) throws Exception {
        ServerRouter serverRouter = new ServerRouter();
        serverRouter.add(new NodeId("A"), new SocketChannel("127.0.0.1", 3333));
        serverRouter.add(new NodeId("B"), new SocketChannel("127.0.0.1", 3334));
        serverRouter.add(new NodeId("C"), new SocketChannel("127.0.0.1", 3335));
        Client client = new Client(serverRouter);
        System.out.println("x = [" + asString(client.get("x")) + ']');
        System.out.println("y = [" + asString(client.get("y")) + ']');
        byte[] bytesX = String.valueOf(System.currentTimeMillis()).getBytes();
//        System.out.println("set x to " + Arrays.toString(bytesX));
        client.set("x", bytesX);
        byte[] bytesY = String.valueOf(System.currentTimeMillis()).getBytes();
//        System.out.println("set y to " + Arrays.toString(bytesY));
        client.set("y", bytesY);
        System.out.println("x = [" + asString(client.get("x")) + ']');
        System.out.println("y = [" + asString(client.get("y")) + ']');
    }

    private static String asString(byte[] bytes) {
        return bytes != null ? new String(bytes) : null;
    }
}