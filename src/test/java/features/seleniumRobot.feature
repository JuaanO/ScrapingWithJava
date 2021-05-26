Feature: Purchase of a playstation 5 in e-commerce pages
  Buy a products in gameStop, amazon or target.

  @BaseTest @GameStop
  Scenario Outline: Purchase of a playstation 5 on GameStop
    Given a user correctly logged to gameStop
    When I searches for a <Product> to buy
    And add the product to the cart
    When I enter all the necessary data
    Then can I buy the product

    Examples:
      | Product        |
#      | PlayStation 5  |
      | Cyberpunk 2077 |
