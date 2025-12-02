import io.grpc.stub.StreamObserver;

public class WarehouseServiceImpl extends WarehouseServiceGrpc.WarehouseServiceImplBase {

    @Override
    public void getWarehouseData(Hello.WarehouseRequest request,
                                 StreamObserver<Hello.WarehouseData> responseObserver) {

        System.out.println("warehouseID = " + request.getWarehouseID());
        System.out.println("warehouseName: " + request.getWarehouseName());
        System.out.println("timestamp: " + request.getTimestamp());
        System.out.println("warehouseCountry: " + request.getWarehouseCountry());
        System.out.println("warehouseCity: " + request.getWarehouseCity());
        System.out.println("address: " + request.getAddress());

        for (Hello.ProductData p : request.getProductDataList()) {
            System.out.println("productId: " + p.getProductId());
            System.out.println("productName: " + p.getProductName());
            System.out.println("productCategory: " + p.getProductCategory());
            System.out.println("productAmount: " + p.getProductAmount());
            System.out.println("productUnit: " + p.getProductUnit());
        }

        Hello.WarehouseData data = Hello.WarehouseData.newBuilder()
                .setWarehouseID(request.getWarehouseID())
                .setWarehouseName(request.getWarehouseName())
                .setTimestamp(request.getTimestamp())
                .setWarehouseCountry(request.getWarehouseCountry())
                .setWarehouseCity(request.getWarehouseCity())
                .setAddress(request.getAddress())
                .addAllProductData(request.getProductDataList())
                .build();

        responseObserver.onNext(data);
        responseObserver.onCompleted();
    }

}
