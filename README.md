# Spedran

Spedran (past tense of speedrun) is a simple library to interact with Speedrun.com's REST API.
It uses [Optionals](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html) for optional fields and [CompletableFutures](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CompletableFuture.html) for asynchronous requests.

For readability and brevity, Speedrun.com will be abbreviated as SRC in the documentation.

## Quick Start

Here's a very simple example on how to use Spedran to get the name of a user by ID.

```java
public class GetUserName {
    
    public static void main(String[] args) {
        // Get a user with an ID
        User user = Spedran.getUser("zx721w08").join();

        // Print the user's name
        System.out.println(user.getNames().getInternationalName());
        
        // Shut down the library to allow the application to exit
        Spedran.shutDown();
    }
  
}
```

## Installation

### Maven

```xml
<dependency>
    <groupId>com.treescrub</groupId>
    <artifactId>spedran</artifactId>
    <version>0.30.1</version>
</dependency>
```

### Gradle

```groovy
repositories {
    mavenCentral()
}

dependencies {
    implementation 'com.treescrub:spedran:0.30.1'
}
```

## Usage

See the [examples](examples) directory for example programs.

## Documentation

See the [Javadocs](https://treescrub.github.io/Spedran/javadoc/) for documentation.

## Development

### Requirements

* Maven 3.0 or greater
* JDK 11

### Setup

1. Clone the repo
    ```
    git clone https://github.com/Treescrub/Spedran.git
    ```
2. Make changes in your preferred editor.
3. Use `mvn test` in the project root to compile and test the library. 

## License

Distributed under the MIT license, see [`LICENSE.txt`](LICENSE.txt) for more details.

## Resources

* [SRC API official documentation](https://github.com/speedruncomorg/api/) - Mostly up to date, missing pronoun info for users and supporter boost info for games. See issues for API quirks.
