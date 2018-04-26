# Common problem when using the default spring boot scopes

This repository demonstrates a common problem when using the default spring boot scopes when using fields to store request-level state.

To show problem:

Clone and run `ExampleSpringScopeApplication`

Using either 2 browser windows, or 2 curl commands, send the following requests:

`http://localhost:8080/scope/incorrect?requestId=1`

`http://localhost:8080/scope/incorrect?requestId=2`

If you look at the code, the bean is supposed to wait 5 seconds and return the requestId.
But when doing the previous requests, they both return `2`. This is because we save the requestId to a field in the `IncorrectScopeBean` class.
By default, the class instance is shared by all requests, which includes class level fields. To correct this 
we can use the `@Scope` annotation to specify that a bean be instantiated per request, as in the `CorrectScopeBean` class.

A best practice would be to only use fields in spring boot components to declare spring boot dependencies. Any other variables
should be passed method to method, or encapsulated in a dedicated class. If a non spring boot dependency is needed on a
spring boot class, then the `@Scope(scopeName="request")` must be used.