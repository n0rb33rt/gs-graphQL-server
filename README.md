# Spring Boot kickstart GraphQL CRUD Demo Project

## Features

- GraphQL stands for GraphQL query language and developed by Facebook.
- Like SQL here we use query to fetch the data. You have flexibility which data to fetch.
- Query to fetch the data(like GET) and Mutation to alter the data(like POST, PUT, DELETE).


## GraphQL Schema
- Schema provides flexibility to consumers that which attitudes they want in response. (It has .graphls file extension)
- Define which attitudes are there in your class with type.
- Contract between consumer and provider on how to get and alter the data for the application. Because if you don't provide the schema for a field, then that field will not be visible to your customers.


## GraphQL vs REST
- Rest is having fixed response while GraphQL provides flexibilityto consumers.
- Over and under fetching with REST API. You don't need to perform two request to fetch the data from the server, you can combine into 1 request.
- In GraphQL we don't have REST Controller, we just have query and mutation. We don't need to provide mappings, we just have 1 endpoint in our application.
- GraphQL needs schema files.


## GraphiQL

GraphiQL is an interactive, web-based graphical user interface (GUI) for exploring and querying GraphQL APIs. It serves as a development tool that allows developers to interact with GraphQL endpoints, construct queries, and visualize the responses. 

- Interactive Query Builder: GraphiQL provides an interactive and user-friendly interface for building GraphQL queries and mutations. It offers auto-completion and syntax highlighting to make it easier for developers to construct and edit their queries.

- Schema Exploration: GraphiQL automatically introspects the GraphQL schema exposed by the API, allowing users to explore available types, queries, mutations, and their associated fields. This is helpful for understanding the API's capabilities.

- Documentation: GraphQL APIs often include descriptions for types, fields, and arguments. GraphiQL leverages this documentation, making it easy for developers to access helpful information and tooltips while constructing queries.

- Real-Time Validation: As you type your GraphQL queries and mutations in GraphiQL, it provides real-time validation and error feedback. This helps catch syntax errors and provides hints on how to correct them.

- History and Presets: GraphiQL usually includes a history feature, allowing you to save and reuse previous queries. It also lets you create and save presets for commonly used queries and mutations.

- Header Support: You can add custom headers to your GraphQL requests in GraphiQL, which is useful for scenarios where authentication or authorization headers are required.

- Easy Access: Many GraphQL services provide a GraphiQL interface that can be accessed via a web URL, simplifying the process of exploring the API.


