package com.fraunhoferproject.event;

import java.util.UUID;

/**
 * A Model representing an event and implementing a Builder pattern. 
 * Once a Event is generate and build with the builder pattern, it becomes immutable
 */
public class EventModel {
    private String name;
    /**
     * Unique ID of the event
     */
    private UUID id;
    private long unixTime;
    private String description;
    private int prediction;

    /**
     * A private constructor only use by the builder pattern
     * @param name the name of the event
     * @param id hte unique id of the event
     * @param unixTime the current unix time
     * @param description the description of the event
     * @param prediction the prediction generated for this event
     */
    private EventModel(String name, UUID id, long unixTime, String description, int prediction) {
        this.name = name;
        this.id = id;
        this.unixTime = unixTime;
        this.description = description;
        this.prediction = prediction;
    }

    /**
     * The only way to construct an EventModel.
     * @return An event
     */
    public static EventModelBuilder builder() {
        return new EventModelBuilder();
    }

    /**
     * All the getters of the model
     */
    public String getName() {
        return this.name;
    }

    public UUID getId() {
        return this.id;
    }

    public long getUnixTime() {
        return this.unixTime;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrediction() {
        return this.prediction;
    }

    /**
     * The implementation of the builder pattern on a private class
     */
    public static class EventModelBuilder {
        private String name;
        private UUID id;
        private long unixTime;
        private String description;
        private int prediction;

        EventModelBuilder() {
        }

        public EventModelBuilder name(String name) {
            this.name = name;
            return this;
        }

        public EventModelBuilder id(UUID id) {
            this.id = id;
            return this;
        }

        public EventModelBuilder unixTime(long unixTime) {
            this.unixTime = unixTime;
            return this;
        }

        public EventModelBuilder description(String description) {
            this.description = description;
            return this;
        }

        public EventModelBuilder prediction(int prediction) {
            this.prediction = prediction;
            return this;
        }

        /**
         * The methode which build the event and return it
         * @return a newly immutable builded event
         */
        public EventModel build() {
            return new EventModel(name, id, unixTime, description, prediction);
        }

        public String toString() {
            return "EventModel.EventModelBuilder(name=" + this.name + ", id=" + this.id + ", unixTime=" + this.unixTime + ", description=" + this.description + ", prediction=" + this.prediction + ")";
        }
    }
}
