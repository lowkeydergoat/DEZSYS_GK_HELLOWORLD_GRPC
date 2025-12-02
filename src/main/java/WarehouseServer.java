import io.grpc.Server;
import io.grpc.ServerBuilder;

public class WarehouseServer {
    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50051)
                .addService(new WarehouseServiceImpl())
                .build();
        server.start();
        System.out.println("Warehouse Service running");
        server.awaitTermination();
    }
}
