# Chapter 4. The Spring context: Using abstractions


-  In Java, the interface is an abstract structure you use to declare a specific responsibility. 
- An object implementing the same interface can define this responsibility declared by that interface in different ways.
-  The interface specifies the “what needs to happen,” while every object implementing the interface specifies the “how it should happen.”
-  Decoupling implementations through abstractions is a good practice in implementing a class design. Decoupling objects makes implementations easy to change without affecting too many parts of the application. This aspect makes your application more easily extended and maintained.

Interface: can have more objects implementing the same initerface. This allows to change the implementatiion (the how) without affecting the object that consumes the implementation.

- When using abstraction with dependency injection, Spring knows to search for a bean created with an implementation of the requested abstraction.
- You use stereotype annotations on classes for which Spring needs to create instances and add these instances as beans to its context. You never use stereo-type annotations on interfaces.
- When the Spring context has more beans created with multiple implementations of the same abstraction, to instruct Spring which bean to inject, you can 
  - – use the @Primary annotation to mark one of them as default, or 
  - – use the @Qualifier annotation to name the bean and then instruct Spring to  inject that bean by name.

- When we have service responsibility components, we use the @Service stereo-type annotation instead of @Component. Likewise, when a component has repository responsibility, we use the @Repository stereotype annotation instead of @Component. This way, we mark the component’s responsibility explicitly, and we make the class design more comfortable to read and understand.

- Objects whose responsibility is to establish communication with something outside the app, we name these objects proxies.

Example: CommentRepository is a interface because you can have multiple implementations to implement the logic. So in the future you can change to other implementation without changing any logic in the classes that use the interface.
  - In the end, the commentRepository might now use a database to store the comments. But in the future, maybe this needs to be changedti use some other technology or an external service.

  - A POJO is a simple object without dependencies, only described by its attributes and methods.

  Not all objects need to be added to the Spring context, the main reason to add an object to the Spring context is to allow Spring to control it and further augment it with functionalites.

  - It doesn't make sense to add stereotype annotations on interfaces or abstract classes because these cannot be instatiated.

  - Fields are no longer final, and there marked with @Autowires. Spring uses the default constructor to create the instance ot the class and then injects the two dependencies from its context.

  - If more than one bean of the same type exists in the Spring context, you need to tell Spring which of these beans to inject.
    . Using the @Primary annotation.
    . Using the @Qualifier annotation.

Using @Component is generic and gives you no detail about the responsability of the object you're implementing.
The servicees are the objects with the responsibility of implementing the use cases, while repositories are the objects managing the data persistence. A distinctive way of marking them helps the developer better understand the app design.
  - We use the @Service annotation to define CommentService as component and also explicitly mark its responsability.

  Summary: 
  - Decoupling implementations through abstractions is a good practice in implementing a class design. Decoupling objects makes implementations easy to change without affecting too many parts of the application. 

- In Java, we use interfaces to decouple implementations. We also say that we define contracts between implementation through interfaces.