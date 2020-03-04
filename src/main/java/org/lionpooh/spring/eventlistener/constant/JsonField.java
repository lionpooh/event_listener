package org.lionpooh.spring.eventlistener.constant;

public class JsonField {

    public enum OpenstackCommon {
        EVENT_TYPE("event_type"),
        PUBLISHER_ID("publisher_id");
        private String field;
        OpenstackCommon(String field) {
            this.field = field;
        }
        public String getField() {
            return field;
        }
    }

    public enum NovaInstance {
        DISPLAY_NAME("display_name"),
        UUID("uuid"),
        STATE("state"),
        TASK_STATE("task_state"),
        POWER_STATE("power_state");
        private String field;

        NovaInstance(String field) {
            this.field = field;
        }

        public String getField() {
            return field;
        }
    }

}
