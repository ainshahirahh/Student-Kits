package com.example.studentkits;

public class uploadd {

        public String name;
        public String url;

        // Default constructor required for calls to
        // DataSnapshot.getValue(User.class)
        public uploadd() {
        }

        public uploadd(String name, String url) {
            this.name = name;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

