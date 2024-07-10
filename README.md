# Spedran

Spedran (past tense of speedrun) is a simple library to interact with Speedrun.com's REST API.
It uses [Optionals](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Optional.html) for optional fields and [CompletableFutures](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/concurrent/CompletableFuture.html) for asynchronous requests.

For readability and brevity, Speedrun.com will be abbreviated as SRC in the documentation.

## Quick Start

```java
public class GetUserName {
  public static void main(String[] args) {
    // Get a user with an ID
    User user = Spedran.getUser("zx721w08").join();

    // Print the user's name
    System.out.println(user.getNames().getInternationalName());
  }
}
```

## Usage

See the [examples](examples) for some simple example usage.

## Documentation

See the [Javadocs](https://treescrub.github.io/Spedran/javadoc/).

## Development

### Dependencies

* Maven
* JDK 11

### Quick Start

1. Clone the repo.
2. Make changes.
3. Use `mvn test` to compile and test the library. 

## License

Distributed under the MIT license, see [`LICENSE.txt`](LICENSE.txt).

## Resources

* [SRC API official documentation](https://github.com/speedruncomorg/api/) - Mostly up to date, missing pronoun info for users and supporter boost info for games. See issues for API quirks.
