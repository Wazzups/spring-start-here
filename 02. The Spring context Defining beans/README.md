# Chapter 2. The Spring context: Defining beans

## 2 Spring context

- By default, Spring doesn't know any of the objects you define in your application. To enable Spring to see your objects, you need to add them to the context.
- The context is a complex mechanism that enables Spring to control instances you define.
- Beans: Object instances in the context.

## 2.1 Creating a Maven project

- Maven is a tool you use to easily manage an app’s build process regardless of the framework you use.
- A build tool is software we use to build apps more easily. You configure a build tool to do the tasks that are part of building the app instead of manually doing them.
- Some examples of tasks that are often part of building the app are as follows:
  - Downloading the dependencies needed by your app
  - Running tests
  - Validating that the syntax follows rules that you define
  - Checking for security vulnerabilities
  - Compiling the app
  - Packaging the app in an executable archive

## 2.2 Adding new beans to the Spring context

- You can add beans in the Spring context in the following ways:
  - Using the @Bean annotation:  enables you to add any kind of object instance as a bean and even multiple instances of the same kind to the Spring context.
  - Using stereotype annotations: This configuration approach requires writing less code, which makes your configuration more comfortable to read.
  - Programmatically: Using the registerBean() method enables you to implement custom logic for adding beans to the Spring context.

- By adding the instance to the Spring context, you make the framework aware of the object, enabling it to manage the instance. Any object type could be added to the context.

- A configuration class is annotated with the @Configuration annotation.

A critical thing to observe is that Spring is designed to be modular. 

- We use unit and integration tests to validate that our implementations work as desired.

- By default, Spring uses the names of the methods annotated with @Bean as the beans names themselves.

- When are multiple beans of the same type in the Spring context you can make one of them primary by using @Primary annotation.

- With stereotype annotations, you add the annotation above the class for which you need to have an instance in the Spring context. 

- Mark the class.

1- Using the @Component annotation, mark the classes for which you want Spring to add an instance to its context.
2- Using @ComponentScan annotation over the configuration class, instruct Spring on where to find the classes you marked.

# Using the @Bean annotation
1- You have full control over the instance creation you add to the Spring context. It is your responsibility to create and configure the instance in the body of the method annotated with @Bean. Spring only takes that instance and adds it to the context as-is.
2- You can use this method to add more instances of the same type to the context.
3- The class that defines the instance doesn't need to be defined in your app.
4- You need to weite a separate method for each bean you create, which adds boilerplate code o your app.

# Using stereotype annotations
1- You only have control over the instance after the framework creates it.
2- This way, you can only add one instance of the class to the context.
3- You can use stereotype annotations only to create beans of the classes your application owns.
4- Using stereotype annotations to add beans doesn't add boilerplate code.


# Summary

- Imagine the Spring context as a bucket in which you add the instances you expect Spring to be able to manage.
- Spring can see only the instances you add to its context.
- You can add beans to the Spring context in three ways: using the @Bean annotation, using stereotype annotations, and doing it programmatically.

