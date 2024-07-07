Feature: VMTracker Dashboards options

  @Dashboard
  Scenario: List of Options in VMTracks
    Given login
    When get all  8 options in webpage
    Then validate options
       | Dashboard |
       | Live Tracking |
       | Gps Devices |
       | Groups |
       | Timeline |
       | Geo Fencing |
       | Alerts  |
       | Reports |

  @Dashboard
  Scenario: validate Live tracking options
    Given login
    When click see more and inputs Engine On and signal status Online and group filter
    Then adjective map and take screenshot




