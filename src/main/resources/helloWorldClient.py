import grpc
import hello_pb2
import hello_pb2_grpc


def main():
    channel = grpc.insecure_channel("localhost:50051")
    stub = hello_pb2_grpc.WarehouseServiceStub(channel)

    req = hello_pb2.WarehouseRequest(
        warehouseID="1001",
        warehouseName="stefan kordov",
        timestamp="2025-12-02",
        warehouseCountry="AT",
        warehouseCity="Vienna",
        address="wexstrasse 19",
        productData=[
            hello_pb2.ProductData(
                productId="1",
                productName="mario",
                productCategory="human",
                productAmount="999",
                productUnit="kg"
            )
        ]
    )

    # RPC call
    try:
        data = stub.GetWarehouseData(req)
        print(data)

    except grpc.RpcError as e:
        print("error")

    channel.close()


if __name__ == "__main__":
    main()
