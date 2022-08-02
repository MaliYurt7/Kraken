@webSocket
Feature: Subscribe verification

  @wssApiPositiveTest
  Scenario Outline: "<name>" subscription verify information about
    Given the user enter the data "<wss>","<timeOut>"
    And the user connects the api sending json payload info "<event>" "<pair>" "<interval>" "<name>"
    Then The user should be able to see initial connection payload scheme's keys and values "<expectConnectionID>", "<expectEvent>", "<expectStatus>", "<expectVersion>"
    Examples:
      | wss                      | timeOut | expectConnectionID  | expectEvent  | expectStatus | expectVersion | event     | pair    | interval | name   |
      | wss://beta-ws.kraken.com | 10      | 6915171515192744703 | systemStatus | online       | 1.9.0         | subscribe | XBT/USD | 5        | ohlc   |
      | wss://beta-ws.kraken.com | 10      | 6915171515192744704 | systemStatus | online       | 1.9.0         | subscribe | XBT/EUR | 15       | ticker |
      | wss://beta-ws.kraken.com | 10      | 6915171515192744705 | systemStatus | online       | 1.9.0         | subscribe | XBT/GBP | 15       | trade  |
      | wss://beta-ws.kraken.com | 10      | 6915171515192744706 | systemStatus | online       | 1.9.0         | subscribe | XBT/AUD | 15       | spread |
      | wss://beta-ws.kraken.com | 10      | 6915171515192744707 | systemStatus | online       | 1.9.0         | subscribe | XBT/JPY | 15       | book   |

  @wssApiPositiveChannelIDTest
  Scenario Outline: "<name>" channelID validation
    Given the user enter the data "<wss>","<timeOut>"
    And the user connects the api sending json payload info "<event>" "<pair>" "<interval>" "<name>"
    Then the user should see the <channelID>
    Examples:
      | wss                      | timeOut | event     | pair    | interval | name   | channelID |
      | wss://beta-ws.kraken.com | 10      | subscribe | XBT/USD | 5        | ohlc   | 344       |
      | wss://beta-ws.kraken.com | 10      | subscribe | XBT/EUR | 15       | ticker | 356       |
      | wss://beta-ws.kraken.com | 10      | subscribe | XBT/GBP | 15       | trade  | 369       |
      | wss://beta-ws.kraken.com | 10      | subscribe | XBT/AUD | 15       | spread | 389       |
      | wss://beta-ws.kraken.com | 10      | subscribe | XBT/JPY | 15       | book   | 416       |

  @wssApiNegativeTest
  Scenario Outline: "<name>" interval negative validation
    Given the user enter the data "<wss>","<timeOut>"
    And the user connects the api sending json payload info "<event>" "<pair>" "<interval>" "<name>"
    Then the user should not see the "<errorMessage>" in Json
    Examples:
      | wss                      | timeOut | event     | pair    | interval | name | errorMessage                             |
      | wss://beta-ws.kraken.com | 10      | subscribe | XBT/USD | 10       | ohlc | Subscription ohlc interval not supported |
      | wss://beta-ws.kraken.com | 10      | subscribe | XBT/EUR | 5        | ohlc | Subscription ohlc interval not supported |
