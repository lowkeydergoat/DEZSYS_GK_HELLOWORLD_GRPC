import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class WarehouseClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        WarehouseServiceGrpc.WarehouseServiceBlockingStub stub =
                WarehouseServiceGrpc.newBlockingStub(channel);

        Hello.WarehouseRequest req = Hello.WarehouseRequest.newBuilder()
                .setWarehouseID("1001")
                .setWarehouseName("stefan kordov")
                .setTimestamp("2025-12-02")
                .setWarehouseCountry("AT")
                .setWarehouseCity("Vienna")
                .setAddress("wexstrasse 19")
                .addProductData(
                        Hello.ProductData.newBuilder()
                                .setProductId("1")
                                .setProductName("mario")
                                .setProductCategory("human")
                                .setProductAmount("65")
                                .setProductUnit("kg")
                )
                .build();


        Hello.WarehouseData data = stub.getWarehouseData(req);

        System.out.println(data);

        channel.shutdown();
    }
}
