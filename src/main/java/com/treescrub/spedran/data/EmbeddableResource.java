package com.treescrub.spedran.data;

import java.util.Objects;
import java.util.Optional;

/**
 * A field representing a resource that can be embedded, i.e. can contain the full resource instead of just an ID.
 *
 * @param <T> the type of resource that can be embedded
 */
public class EmbeddableResource<T extends IdentifiableResource> {
    private final String id;
    private final T embeddedResource;

    public EmbeddableResource(String id) {
        this.id = id;
        this.embeddedResource = null;
    }

    public EmbeddableResource(T embeddedResource) {
        this.id = embeddedResource.getId();
        this.embeddedResource = embeddedResource;
    }

    /**
     * Gets the ID for this embeddable resource.
     *
     * @return the resource ID
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the embedded resource if it was specified.
     *
     * @return an {@link Optional} with the embedded resource
     */
    public Optional<T> getEmbeddedResource() {
        return Optional.ofNullable(embeddedResource);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof EmbeddableResource)) return false;
        EmbeddableResource<?> that = (EmbeddableResource<?>) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
