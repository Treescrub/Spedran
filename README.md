# Spedran

Spedran (past tense of speedrun) is a simple library to interact with Speedrun.com's REST API.
It uses Optionals for optional fields and CompletableFutures for asynchronous retrieval of data.

For readability and brevity, Speedrun.com will be abbreviated as SRC.

Almost entirely limited to only reading data with only a few exceptions related to run moderation/verification.

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

## License

Distributed under the MIT license, see `LICENSE.txt`.

## Resources

* [SRC API official documentation](https://github.com/speedruncomorg/api/) - Mostly up to date, missing pronoun info for users and supporter boost info for games. See issues for API quirks.
