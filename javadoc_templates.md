# Javadoc Templates

Simple templates to keep Javadoc language consistent for Spedran.

Preferably most Javadoc comments will generally follow one of these templates.
Important information can be added in addition to the templates.
You need not follow a template if none of them fit the situation.

Uppercase text in angle brackets (`<` and `>`) indicate required text that is unique to the specific method.
Text in square brackets (`[` and `]`) are optional text that is recommended if applicable.

## Resources

### Member getters

```java
/**
 * Gets the <MEMBER> of this <THIS_LOWERCASE>.
 *
 * @return <MEMBER>
 */
```

### Optional member getters

```java
/**
 * Gets <ITEM> for this <THIS_LOWERCASE>, if it exists.
 *
 * @return an {@link Optional} with <ITEM>
 */
```

### Embedded resource getters

```java
/**
 * Returns an {@link EmbeddableResource} containing this <THIS_LOWERCASE>'s <OTHER_RESOURCE_LOWERCASE>.
 *
 * @return the resource of the <OTHER_RESOURCE_LOWERCASE> this <THIS_LOWERCASE> belongs to. only an ID if not embedded, otherwise the full resource
 *
 * @see <OTHER_RESOURCE>
 * @see Spedran#get<OTHER_RESOURCE>(String)
 */
```

### Embedded resource list getters

```java
/**
 * Gets a {@code List} of {@link EmbeddableResource} <OTHER_RESOURCE_LOWERCASE_PLURAL> that this <THIS_LOWERCASE> is <PART_OF/IN/INCLUDES>.
 *
 * @return an unmodifiable {@code List} of <OTHER_RESOURCE_LOWERCASE_PLURAL>
 *
 * @see <OTHER_RESOURCE>
 * @see Spedran#get<OTHER_RESOURCE>(String)
 */
```

### Optional embedded resource getters

```java
/**
 * Gets the <OTHER_RESOURCE_LOWERCASE> for this <THIS_LOWERCASE> as an {@link Optional}.
 * The {@code Optional} is empty if the <OTHER_RESOURCE_LOWERCASE> was not embedded.
 *
 * @return an {@link Optional} containing the <OTHER_RESOURCE_LOWERCASE>
 *
 * @see <OTHER_RESOURCE>
 */
```

### External resource fetch methods

```java
/**
 * Gets a new {@link <RETURN>} builder object to request <OTHER_RESOURCE_LOWERCASE> for this <THIS_LOWERCASE>.
 *
 * @return a {@code <RETURN>} builder
 */
```

### Modify methods

```java
/**
 * Gets a new {@link <RETURN>} builder to <ACTION>.
 * <br>
 * Requires a set API key with sufficient permissions to <ACTIONS>.
 *
 * @return a {@code <RETURN>} builder to <ACTION>
 *
 * @see Spedran#setApiKey(String)
 */
```

### ID getters

```java
/**
 * Returns a String containing the ID of this <THIS_LOWERCASE>'s <OTHER_RESOURCE_LOWERCASE>.
 *
 * @return the id of the <OTHER_RESOURCE_LOWERCASE> this <THIS_LOWERCASE> belongs to
 *
 * @see <OTHER_RESOURCE>
 * @see Spedran#get<OTHER_RESOURCE>(String)
 */
```

### Optional ID getters

```java
/**
 * Returns an {@link Optional} String containing the ID of this <THIS_LOWERCASE>'s <OTHER_RESOURCE_LOWERCASE>.
 * If this run has no associated <OTHER_RESOURCE_LOWERCASE>, returns an empty Optional.
 *
 * @return an {@code Optional} with the ID of this <THIS_LOWERCASE>'s <OTHER_RESOURCE_LOWERCASE>
 *
 * @see <OTHER_RESOURCE>
 * @see Spedran#get<OTHER_RESOURCE>(String)
 */
```

## Request builders

### Sort* methods

```java
/**
 * Sorts the returned <RESOURCE_LOWERCASE_PLURAL> [alphanumerically] by <FIELD>.
 *
 * @return this object
 */
```

### Sort direction methods

```java
/**
 * Sets the direction to sort the returned <RESOURCE_LOWERCASE_PLURAL>.
 *
 * @param direction the direction to sort, either ascending or descending
 * @return this object
 */
```

### Filter methods

#### By resource object

```java
/**
 * Sets the <THING> to filter by.
 *
 * @param <RESOURCE_LOWERCASE> the <RESOURCE_LOWERCASE> to filter by
 * @return this object
 */
```

#### By ID

```java
/**
 * Sets the <THING> to filter by.
 *
 * @param id the <RESOURCE_LOWERCASE> ID
 * @return this object
 */
```

## Main Spedran API

### Single resource request

```java
/**
 * Gets the {@link <RESOURCE>} that corresponds to the provided {@code id} asynchronously.
 *
 * @param id the ID of the <RESOURCE_LOWERCASE> to get
 *
 * @return a {@link CompletableFuture} of a {@code <RESOURCE>}
 */
```

### All of a resource request

```java
/**
 * Gets a {@link <BUILDER_NAME>} builder to request all {@link <RESOURCE>}s.
 *
 * @return a {@code <BUILDER_NAME>} builder
 */
```

### All of applicable resource request

```java
/**
 * Gets a {@link <BUILDER_NAME>} builder to request the <OTHER_RESOURCE_LOWERCASE> for the specified {@link <RESOURCE>}.
 *
 * @param <RESOURCE_LOWERCASE>Id the ID of the <RESOURCE_LOWERCASE> to get the {@link <OTHER_RESOURCE>}s for
 *
 * @return a {@code <BUILDER_NAME>} builder
 */
```