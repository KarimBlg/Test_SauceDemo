@ddt
Feature: Login DDT
# Ceci est un test quidé par des donnees, Data Driven test
# http://badge.dev.com

  Scenario Outline:
    Given je suis sur l environnement "<env>"
    When je saisi mon username "<username>"
    Then c est ok
    @env1
    Examples:
      | env                  | username |
      | http://badge.dev.com | lotfi    |
      | http://badge.dev.com | abcd     |
    @env2
    Examples:
      | env                  | username |
      | http://badge.ppd.com | karim    |
      | http://badge.ppd.com | efg      |
