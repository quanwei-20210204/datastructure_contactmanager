package com.datastructure.vicjens.command;

public enum Commands {
        ADD("add"),
        REMOVE("remove"),
        QUIT("quit");

        private final String value;

        Commands(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
}
