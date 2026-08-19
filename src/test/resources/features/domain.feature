Feature: Shipment component
  Scenario: list shipments
    When I GET "/api/shipments"
    Then the response status is 200
