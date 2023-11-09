
# Spring Boot kickstart GraphQL CRUD Demo Project

Learning kickstart GraphQL with Java Spring Boot 3.1.5 CRUD Application


## Features

- GraphQL stands for GraphQL query language and developed by Facebook.
- Like SQL here we use query to fetch the data. You have flexibility which data to fetch.
- Query to fetch the data (like GET) and Mutation to alter the data(like POST, PUT, DELETE).

## GraphQL vs REST
- Rest is having fixed response while GraphQL provides flexibilityto consumers.
- Over and under fetching with REST API. You don't need to perform two request to fetch the data from the server, you can combine into 1 request.
- In GraphQL we don't have REST Controller, we just have query and mutation. We don't need to provide mappings, we just have 1 endpoint in our application.
- GraphQL needs schema files.

## GraphQL Schema
- Schema provides flexibility to consumers that which attitudes they want in response. (It has .graphqls file extension and located at resources.graphql)
- Define which attitudes are there in your class with type.
- Contract between consumer and provider on how to get and alter the data for the application. Because if you don't provide the schema for a field, then that field will not be visible to your customers.

Example of query in schema:

```bash
type Query {
    getStudents : [StudentResponse] 
    getStudentById(id : Int) : StudentResponse
}

type Mutation{
    newStudent(studentRequest:StudentRequest) : StudentResponse
    deleteStudentById(id : Int) : StudentResponse
    updateStudent(studentRequest: StudentRequest) : StudentResponse
}

input StudentRequest {
    id : Int
    firstName : String!
    lastName : String!
    email : String!
    address: AddressRequest!
    learningSubjects: [LearningSubjectRequest]!
}

input AddressRequest{
    id: Int
    city : String!
    street : String!
}

input LearningSubjectRequest{
    id: Int
    subjectName : String!
    marksObtained: Float!
}

type StudentResponse{
    id : Int
    firstName : String
    lastName : String
    email : String
    address : AddressResponse
    learningSubjects : [SubjectResponse]
}

type AddressResponse{
    id : Int
    city : String
    street : String
}

type SubjectResponse {
    id : Int
    subjectName : String
    marksObtained : Float
}
```
In GraphQL, the [] notation is used to indicate an array or list type and ! is used to forbid absence of the field. Additionally, "type" serves for response and "input" for request. 


## GraphiQL

GraphiQL is an interactive, web-based graphical user interface (GUI) for exploring and querying GraphQL APIs. It serves as a development tool that allows developers to interact with GraphQL endpoints, construct queries, and visualize the responses. 

- Interactive Query Builder: GraphiQL provides an interactive and user-friendly interface for building GraphQL queries and mutations. It offers auto-completion and syntax highlighting to make it easier for developers to construct and edit their queries.

- Schema Exploration: GraphiQL automatically introspects the GraphQL schema exposed by the API, allowing users to explore available types, queries, mutations, and their associated fields. This is helpful for understanding the API's capabilities.

- Documentation: GraphQL APIs often include descriptions for types, fields, and arguments. GraphiQL leverages this documentation, making it easy for developers to access helpful information and tooltips while constructing queries.

- Real-Time Validation: As you type your GraphQL queries and mutations in GraphiQL, it provides real-time validation and error feedback. This helps catch syntax errors and provides hints on how to correct them.

- History and Presets: GraphiQL usually includes a history feature, allowing you to save and reuse previous queries. It also lets you create and save presets for commonly used queries and mutations.

- Header Support: You can add custom headers to your GraphQL requests in GraphiQL, which is useful for scenarios where authentication or authorization headers are required.

- Easy Access: Many GraphQL services provide a GraphiQL interface that can be accessed via a web URL, simplifying the process of exploring the API.

To enable GraphiQL you need to open the application.properties and write:
```bash
  graphql.graphiql.enabled=true
```
To change graphiQL url: 
```bash
  graphql.graphiql.mapping=/graphiql
```

To change base url to perform requests: 
```bash
graphql.servlet.mapping=/student-service
```
And if you did this, you need to change base graphql url for graphiQL:
```bash
graphql.graphiql.endpoint.graphql=/student-service
```

## Resolver
We should use graphQL Resolver to increase our performance, because user may not want to load some data, but our database will do it. 

- All methods in resolver must be public
- We have not to invoke the method manually
- Entity types of variables must have lazy loading.
- One resolver for one response
 
```bash
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {
    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse){
        List<SubjectResponse> learningSubjects = new ArrayList<>();

        if (studentResponse.getStudent().getLearningSubjects() != null) {
            for (Subject subject: studentResponse.getStudent().getLearningSubjects()) {
                learningSubjects.add(new SubjectResponse(subject));
            }
        }

        return learningSubjects;
    }
    public AddressResponse getAddress(StudentResponse studentResponse){
        return new AddressResponse(studentResponse.getStudent().getAddress());
    }

}
```
## Dependencies that are needed
```bash
        <dependency>
			<groupId>com.graphql-java-kickstart</groupId>
			<artifactId>graphql-spring-boot-starter</artifactId>
			<version>15.0.0</version>
		</dependency>

		<dependency>
			<groupId>com.graphql-java-kickstart</groupId>
			<artifactId>graphql-kickstart-spring-webflux</artifactId>
			<version>15.0.0</version>
		</dependency>
		<dependency>
			<groupId>com.graphql-java-kickstart</groupId>
			<artifactId>graphql-spring-boot-starter-test</artifactId>
			<version>15.0.0</version>
			<scope>test</scope>
		</dependency>
```

## Controller
We just need to annotate the class as a component, extend GraphQLQueryResolver or GraphQLMutationResolver and name methods like name of query or mutation requests defined in schema.

It looks like:
```bash
@Component
@AllArgsConstructor
public class StudentMutation implements GraphQLMutationResolver {
    private final StudentService studentService;

    public StudentResponse newStudent(StudentRequest studentRequest){
        return studentService.save(studentRequest);
    }
    public StudentResponse deleteStudentById(Long id){
        return studentService.deleteStudentById(id);
    }
    public StudentResponse updateStudent(StudentRequest studentRequest){
        return studentService.updateStudent(studentRequest);
    }
}
```
