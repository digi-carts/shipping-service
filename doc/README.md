# shipping-service

Shipments, return shipments, shipper/provider config, and pincode fallbacks. Port **3007**, schema **`shipping_svc`**.

Platform design: [System design](https://github.com/digi-carts/doc/blob/main/architecture/system-design.md)

## Domain

One shipment per `order_id` (unique). Tracks provider, AWB, label URL, tracking status/URL, and lifecycle `status` (default `CREATED`). Return shipments mirror outbound shipments. Store-level `ShipperConfig` and `ShippingProviderConfig` hold courier credentials (Shiprocket, Delhivery, etc. as planned). `PincodeFallback` maps pincodes when a provider cannot serve a pin.

Provider API calls are intended to be driven by store config, not only env vars.

## Tech stack

Java 21, Spring Boot 3.3.0, Web, JPA, Liquibase, PostgreSQL.

## Data model

| Entity | Table | Notes |
|--------|--------|--------|
| `Shipment` | `shipment` | Unique `order_id` |
| `ReturnShipment` | return shipments | By store / order |
| `ShipperConfig` | shipper config | Per store |
| `ShippingProviderConfig` | provider config | Per store |
| `PincodeFallback` | pincode fallback | Per store |

## HTTP API

Gateway prefix: `/api/shipping/**`. Native prefixes below.

### Shipments — `/api/shipments`

| Method | Path |
|--------|------|
| GET | `/api/shipments` |
| GET | `/api/shipments/{id}` |
| GET | `/api/shipments/store/{storeId}` |
| GET | `/api/shipments/order/{orderId}` |
| POST | `/api/shipments` |
| PUT | `/api/shipments/{id}` |
| DELETE | `/api/shipments/{id}` |

### Return shipments — `/api/return-shipments`

Same shape as shipments (store/order lookups).

### Config — `/api/shipper-config`, `/api/provider-config`

CRUD plus `GET .../store/{storeId}`.

### Pincode — `/api/pincode-fallback`

CRUD plus `GET .../store/{storeId}`.

### Health

`GET /health`

## Configuration

| Variable | Required | Default |
|----------|----------|---------|
| `DATABASE_URL` | yes | schema `shipping_svc` |
| `PORT` | no | `3007` |

## Local run

```bash
export DATABASE_URL="jdbc:postgresql://localhost:5432/digicarts?currentSchema=shipping_svc"
mvn spring-boot:run
```

## CI/CD

`digi-cart-shipping-service-dev` / `digi-cart-shipping-service`.

## Related

- [order-service](https://github.com/digi-carts/order-service/blob/stage/doc/README.md)
- [merchant-ui](https://github.com/digi-carts/merchant-ui/blob/stage/doc/README.md) settings/shipping

## REST API reference

See [api.md](api.md) for every HTTP endpoint generated from Spring controllers.
