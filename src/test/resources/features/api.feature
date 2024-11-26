Feature: API Automation

  @api
  Scenario: Success Get List Users
    Given prepare url valid for "get_list_users"
    And hit api get list users
    Then validation status code 200
    Then validation response list users
    Then validation response json with JSONSchema "get_list_users.json"

  @api
  Scenario: Success Create New User
    Given prepare url valid for "create_new_user"
    And hit api create new user
    When user send a POST request with user data
    Then validation status code 201
    Then validation response create user "Prio Rumpun"
    Then validation response json with JSONSchema "post_list_users.json"

  @api
  Scenario: Success Update User
    Given prepare url valid for "update_user"
    And hit api update user
    When user send a UPDATE request with user data
    Then validation status code 200
    Then validation response update user "Update User Latest"

  @api
  Scenario: Success Delete User
    Given prepare url valid for "delete_user"
    And hit api delete user
    When user send a DELETE request with user id
    Then validation status code 204

  @api
  Scenario: Fail Create User Missing Name Field
    Given prepare url valid for "create_new_user"
    And hit api create new user
    When user send a POST request with missing name field
    Then validation status code 422
    Then validation response error message "can't be blank"

  @api
  Scenario: Fail Create User Invalid URL
    Given prepare url valid for "invalid_create_new_user"
    And hit api create new user
    Then validation status code 404
    Then validation response error message "Not Found"

  @api
  Scenario: Fail Update User - Resource Not Found
    Given prepare url valid for "update_user"
    And hit api update user
    When user send a UPDATE request with wrong ID
    Then validation status code 404
    Then validation response error message "Resource not found"

  @api
  Scenario: Fail Delete User - ReDelete user
    Given prepare url valid for "delete_user"
    And hit api delete user
    When user send a DELETE request with user id - ReDelete
    Then validation status code 404
    Then validation response error message "Resource not found"