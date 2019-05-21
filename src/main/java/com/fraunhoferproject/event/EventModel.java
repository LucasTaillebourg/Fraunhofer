package com.fraunhoferproject.event;

import java.util.UUID;

public class EventModel {
    private String name;
    private UUID id;
    private long unixTime;
    private String description;
    private int prediction;

    private EventModel(String name, UUID id, long unixTime, String description, int prediction) {
        this.name = name;
        this.id = id;
        this.unixTime = unixTime;
        this.description = description;
        this.prediction = prediction;
    }

    public static EventModelBuilder builder() {
        return new EventModelBuilder();
    }

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

        public EventModel build() {
            return new EventModel(name, id, unixTime, description, prediction);
        }

        public String toString() {
            return "EventModel.EventModelBuilder(name=" + this.name + ", id=" + this.id + ", unixTime=" + this.unixTime + ", description=" + this.description + ", prediction=" + this.prediction + ")";
        }
    }
}
